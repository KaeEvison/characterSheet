package zombies.stuff;

import java.util.ArrayList;
import javax.swing.JOptionPane;

public class RollManager extends javax.swing.JFrame
{
    CharacterSheet cSheet;
    ArrayList<CustomRoll> rolls;
    Roller roller;
    CustomRoll currentRoll;
    ArrayList<String> names = new ArrayList();
    
    String nameHolder;
    int numberHolder;
    int sidesHolder;
    int bonusHolder;
    int iHolder;
    
    public RollManager()
    {
        initComponents();
        
        //Set access to objects
        cSheet = ZombiesStuff.cSheet;
        rolls = cSheet.currentCharacter.getRolls();
        roller = cSheet.options.roller;
        
        updateAll();
    }
    
    private void updateAll()
    {
        getNames();
        lstRolls.setListData(names.toArray(new String[0]));
        roller.updateAll();
    }
    
    private void getNames()
    {
        names.clear();
        for (int i = 0; i < rolls.size(); i++)
        {
            names.add(rolls.get(i).getName());
        }
    }

    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        lstRolls = new javax.swing.JList<>();
        tnAddRoll = new javax.swing.JButton();
        btnRemoveRoll = new javax.swing.JButton();
        btnToTop = new javax.swing.JButton();
        btnToBottom = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jScrollPane1.setViewportView(lstRolls);

        tnAddRoll.setText("Add");
        tnAddRoll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tnAddRollActionPerformed(evt);
            }
        });

        btnRemoveRoll.setText("Remove");
        btnRemoveRoll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveRollActionPerformed(evt);
            }
        });

        btnToTop.setText("Move to top");
        btnToTop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnToTopActionPerformed(evt);
            }
        });

        btnToBottom.setText("Move to bottom");
        btnToBottom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnToBottomActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tnAddRoll, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnRemoveRoll, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnToTop, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnToBottom, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(tnAddRoll)
                        .addGap(18, 18, 18)
                        .addComponent(btnRemoveRoll)
                        .addGap(18, 18, 18)
                        .addComponent(btnToTop)
                        .addGap(18, 18, 18)
                        .addComponent(btnToBottom)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tnAddRollActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tnAddRollActionPerformed
        nameHolder = JOptionPane.showInputDialog("Enter name");
        numberHolder = Integer.parseInt(JOptionPane.showInputDialog("Enter number of dice"));
        sidesHolder = Integer.parseInt(JOptionPane.showInputDialog("Enter number of sides per die"));
        bonusHolder = Integer.parseInt(JOptionPane.showInputDialog("Enter modifier"));
        rolls.add(new CustomRoll(nameHolder, numberHolder, sidesHolder, bonusHolder));
        updateAll();
    }//GEN-LAST:event_tnAddRollActionPerformed

    private void btnRemoveRollActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveRollActionPerformed
        if (lstRolls.getSelectedIndex() >= 0)
        {
            if (JOptionPane.showConfirmDialog(null, "Delete this roll?") == 0)
            {
                rolls.remove(lstRolls.getSelectedIndex());
            }
            updateAll();
        } else
            JOptionPane.showMessageDialog(null, "No roll selected");
    }//GEN-LAST:event_btnRemoveRollActionPerformed

    private void btnToTopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnToTopActionPerformed
        if (lstRolls.getSelectedIndex() >= 0)
        {
            //track position of original to remove it after copy is made, accomodating for the fact it will be shifted one position to the right
            iHolder = lstRolls.getSelectedIndex() + 1;
            //Insert a copy of the selected roll at the top of the list
            rolls.add(0, new CustomRoll(rolls.get(lstRolls.getSelectedIndex())));
            //Remove the original copy
            rolls.remove(iHolder);
            //Update UI
            updateAll();
        }
        else
            JOptionPane.showMessageDialog(null, "No roll selected");
    }//GEN-LAST:event_btnToTopActionPerformed

    private void btnToBottomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnToBottomActionPerformed
        if (lstRolls.getSelectedIndex() >= 0)
        {
            //track position of original to remove it after copy is made
            iHolder = lstRolls.getSelectedIndex();
            //Insert a copy of the selected roll at the end of the list
            rolls.add(new CustomRoll(rolls.get(lstRolls.getSelectedIndex())));
            //Remove the original copy
            rolls.remove(iHolder);
            //Update UI
            updateAll();
        }
        else
            JOptionPane.showMessageDialog(null, "No roll selected");
    }//GEN-LAST:event_btnToBottomActionPerformed

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(RollManager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RollManager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RollManager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RollManager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RollManager().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRemoveRoll;
    private javax.swing.JButton btnToBottom;
    private javax.swing.JButton btnToTop;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList<String> lstRolls;
    private javax.swing.JButton tnAddRoll;
    // End of variables declaration//GEN-END:variables
}
