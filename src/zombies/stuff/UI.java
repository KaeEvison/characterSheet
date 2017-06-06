package zombies.stuff;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JOptionPane;

public class UI extends javax.swing.JFrame {

    Dice dice = new Dice();
    WormPowerGenerator power = new WormPowerGenerator();
    PowerManager pManager = new PowerManager();
    Serial serial = new Serial();
    
    public ArrayList<CharacterGroup> allGroups;
    ArrayList<String> currentPowerset;
    String powerString;
    int[] statHolder = new int[8];
    boolean loadSuccessful = false;
    
    public UI()
    {
        initComponents();
        
        currentPowerset = new ArrayList();
        
        loadData();
    }
    
    private void loadData()
    {
        //Loading character data from a file
        try
        {
            //Reads in the data from default file
            System.out.println("ATTEMPTING TO LOAD");
            allGroups = (ArrayList<CharacterGroup>)serial.Deserialize("All-Groups.dat");
            System.out.println("LOADED");
            loadSuccessful = true;
            
            //If read is successful, save backup file in case of corruption
            try
            {
                System.out.println("SAVING BACKUP");
                serial.Serialize(allGroups, "All-Groups-backup.dat");
                System.out.println("BACKUP SAVED");
            } catch (IOException e)
            {
                System.out.println("FAILED TO WRITE BACKUP DATA");
            }
        } catch (IOException e)
        {
            //If loading from default file fails, first try loading from backup file
            System.out.println("READING FROM DEFAULT FAILED");
            try
            {
                System.out.println("ATTEMPTING TO READ FROM BACKUP");
                allGroups = (ArrayList<CharacterGroup>)serial.Deserialize("All-Groups-backup");
                System.out.println("READING FROM BACKUP SUCCESSFUL");
                loadSuccessful = true;
            } catch (IOException ex)
            {
                //If reading from backup fails aswell generate default data
                System.out.println("READING FROM BACKUP FAILED");
                allGroups = new ArrayList();
            } catch (ClassNotFoundException ex){}
        } catch (ClassNotFoundException e){}
    }
    
    //Retrieves an arraylist of powers and converts it to a string to display
    private void displayPowers()
    {
        //Fetch powers
        currentPowerset = power.getPowerSet();
        //Clear output
        txtPowerDisplay.setText("");
        powerString = "";
        //For each item in the list, fetch its name and append with a next line
        for (int i = 0; i < currentPowerset.size(); i++)
        {
            powerString += currentPowerset.get(i);
            powerString += "\n";
        }
        //Display the generated string to the user
        txtPowerDisplay.setText(powerString);
    }
    
    //Method for roll button being clicked, displays result of roll with specified parameters
    private void rollButtonClicked()
    {
        try
        {
            //Retrieve the user's values from the input areas and use them to roll dice
                //then display the result to the user
            lblRollResult.setText(dice.roll(Integer.parseInt(txtNumber.getText()), Integer.parseInt(txtDie.getText()), Integer.parseInt(txtBonus.getText()))+"");
        }
        catch (NumberFormatException e)
        {
            //If any of the user's input aren't a number display "ERROR" where the result would be
            lblRollResult.setText("ERROR");
        }
    }
    
    //Method for stat button being clicked, generates and displays stats
    private void statButtonClicked()
    {
        lblSTRValue.setText(dice.statRoll() + "");
        lblCONValue.setText(dice.statRoll() + "");
        lblDEXValue.setText(dice.statRoll() + "");
        lblAGIValue.setText(dice.statRoll() + "");
        lblINTValue.setText(dice.statRoll() + "");
        lblWISValue.setText(dice.statRoll() + "");
        lblCHAValue.setText(dice.statRoll() + "");
        lblPERValue.setText(dice.statRoll() + "");
        displayPowers();
    }
    
    //Method for fetching and returning the rolled stat values
    public int[] getStats()
    {
        try
        {
            statHolder[0] = Integer.parseInt(lblSTRValue.getText());
            statHolder[1] = Integer.parseInt(lblCONValue.getText());
            statHolder[2] = Integer.parseInt(lblDEXValue.getText());
            statHolder[3] = Integer.parseInt(lblAGIValue.getText());
            statHolder[4] = Integer.parseInt(lblINTValue.getText());
            statHolder[5] = Integer.parseInt(lblWISValue.getText());
            statHolder[6] = Integer.parseInt(lblCHAValue.getText());
            statHolder[7] = Integer.parseInt(lblPERValue.getText());
        } catch (NumberFormatException e)
        {
            statHolder[0] = 10;
            statHolder[1] = 10;
            statHolder[2] = 10;
            statHolder[3] = 10;
            statHolder[4] = 10;
            statHolder[5] = 10;
            statHolder[6] = 10;
            statHolder[7] = 10;
            JOptionPane.showMessageDialog(null, "No stats rolled");
        }
        return statHolder;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtDie = new javax.swing.JTextField();
        txtNumber = new javax.swing.JTextField();
        lblD = new javax.swing.JLabel();
        lblPlus = new javax.swing.JLabel();
        txtBonus = new javax.swing.JTextField();
        lblRollResult = new javax.swing.JLabel();
        lblSTR = new javax.swing.JLabel();
        lblSTRValue = new javax.swing.JLabel();
        lblINT = new javax.swing.JLabel();
        lblINTValue = new javax.swing.JLabel();
        lblCON = new javax.swing.JLabel();
        lblWIS = new javax.swing.JLabel();
        lblCONValue = new javax.swing.JLabel();
        lblWISValue = new javax.swing.JLabel();
        lblDex = new javax.swing.JLabel();
        lblCHA = new javax.swing.JLabel();
        lblDEXValue = new javax.swing.JLabel();
        lblCHAValue = new javax.swing.JLabel();
        lblPER = new javax.swing.JLabel();
        lblAGI = new javax.swing.JLabel();
        lblAGIValue = new javax.swing.JLabel();
        lblPERValue = new javax.swing.JLabel();
        btnRollStats = new javax.swing.JButton();
        lblPowerTitle = new javax.swing.JLabel();
        scrlPower = new javax.swing.JScrollPane();
        txtPowerDisplay = new javax.swing.JTextArea();
        btnManagePowers = new javax.swing.JButton();
        btnRoll = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(450, 400));
        setMinimumSize(new java.awt.Dimension(450, 400));
        setPreferredSize(new java.awt.Dimension(450, 400));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        txtDie.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtDie.setText("6");

        txtNumber.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtNumber.setText("1");

        lblD.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblD.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblD.setText("D");

        lblPlus.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPlus.setText("+");
        lblPlus.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        txtBonus.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtBonus.setText("0");

        lblSTR.setText("STR:");

        lblINT.setText("INT:");

        lblCON.setText("CON:");

        lblWIS.setText("WIS:");

        lblDex.setText("DEX:");

        lblCHA.setText("CHA:");

        lblPER.setText("PER:");

        lblAGI.setText("AGI:");

        btnRollStats.setText("roll stats");
        btnRollStats.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRollStatsActionPerformed(evt);
            }
        });

        lblPowerTitle.setText("Powers:");

        txtPowerDisplay.setColumns(20);
        txtPowerDisplay.setRows(5);
        scrlPower.setViewportView(txtPowerDisplay);

        btnManagePowers.setText("Manage powers");
        btnManagePowers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnManagePowersActionPerformed(evt);
            }
        });

        btnRoll.setText("Roll");
        btnRoll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRollActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(13, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(scrlPower)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblINT)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblINTValue, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lblWIS)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblWISValue, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(132, 132, 132)
                                        .addComponent(lblRollResult, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(lblDex)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(lblDEXValue, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(lblAGI))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(lblCHA)
                                                .addGap(10, 10, 10)
                                                .addComponent(lblCHAValue, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(lblPER)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lblPERValue, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(lblAGIValue, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(26, 26, 26)
                                        .addComponent(btnRollStats))))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblPowerTitle)
                                .addGap(225, 225, 225)
                                .addComponent(btnManagePowers)))
                        .addGap(91, 91, 91))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(lblSTR, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblD, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtDie, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblPlus, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtBonus, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnRoll)
                                .addGap(7, 7, 7))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addComponent(lblSTRValue, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lblCON)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblCONValue, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(114, 114, 114)))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblD, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtDie, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblPlus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtBonus, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnRoll))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(lblRollResult, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(lblSTRValue, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblSTR)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblCON)
                                    .addComponent(lblCONValue, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblDex)
                                    .addComponent(lblDEXValue, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(lblAGIValue, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblAGI))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(lblINT)
                                        .addComponent(lblINTValue, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(lblWISValue, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lblWIS)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblCHAValue, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblCHA)))
                            .addComponent(lblPER)
                            .addComponent(lblPERValue, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(btnRollStats, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnManagePowers)
                    .addComponent(lblPowerTitle))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(scrlPower, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRollStatsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRollStatsActionPerformed
        statButtonClicked();
    }//GEN-LAST:event_btnRollStatsActionPerformed

    private void btnManagePowersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnManagePowersActionPerformed
        //Displays the power management screen
        pManager.setVisible(true);
    }//GEN-LAST:event_btnManagePowersActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        try
        {
            //Write to file when the program is closed
            System.out.println("WRITING TO FILE");
            serial.Serialize(allGroups, "All-Groups.dat");
            System.out.println("WRITE SUCCESSFUL");
        } catch (IOException e){System.out.println("WRITE FAILED");System.out.println(e);}
    }//GEN-LAST:event_formWindowClosing

    private void btnRollActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRollActionPerformed
        rollButtonClicked();
    }//GEN-LAST:event_btnRollActionPerformed

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(UI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnManagePowers;
    private javax.swing.JButton btnRoll;
    private javax.swing.JButton btnRollStats;
    private javax.swing.JLabel lblAGI;
    private javax.swing.JLabel lblAGIValue;
    private javax.swing.JLabel lblCHA;
    private javax.swing.JLabel lblCHAValue;
    private javax.swing.JLabel lblCON;
    private javax.swing.JLabel lblCONValue;
    private javax.swing.JLabel lblD;
    private javax.swing.JLabel lblDEXValue;
    private javax.swing.JLabel lblDex;
    private javax.swing.JLabel lblINT;
    private javax.swing.JLabel lblINTValue;
    private javax.swing.JLabel lblPER;
    private javax.swing.JLabel lblPERValue;
    private javax.swing.JLabel lblPlus;
    private javax.swing.JLabel lblPowerTitle;
    private javax.swing.JLabel lblRollResult;
    private javax.swing.JLabel lblSTR;
    private javax.swing.JLabel lblSTRValue;
    private javax.swing.JLabel lblWIS;
    private javax.swing.JLabel lblWISValue;
    private javax.swing.JScrollPane scrlPower;
    private javax.swing.JTextField txtBonus;
    private javax.swing.JTextField txtDie;
    private javax.swing.JTextField txtNumber;
    private javax.swing.JTextArea txtPowerDisplay;
    // End of variables declaration//GEN-END:variables
}
