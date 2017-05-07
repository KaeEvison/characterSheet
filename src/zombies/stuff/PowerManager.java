package zombies.stuff;

import java.util.ArrayList;
import javax.swing.JOptionPane;

public class PowerManager extends javax.swing.JFrame
{
    WormPowerGenerator powers;
    
    int currentList = 0;

    public PowerManager()
    {
        initComponents();
        
        powers = new WormPowerGenerator();
        
        update();
    }
    
    private void update()
    {
        lstPower.setListData((String[])powers.listHolder.get(currentList).toArray(new String[0]));
        switch (currentList)
        {
            case 0:
                lblListTitle.setText("All powers");
                break;
            case 1:
                lblListTitle.setText("Sight subtable");
                break;
            case 2:
                lblListTitle.setText("Hearing subtable");
                break;
            case 3:
                lblListTitle.setText("Speech subtable");
                break;
            case 4:
                lblListTitle.setText("Jack of all trades");
                break;
        }
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        lstPower = new javax.swing.JList<>();
        lblSelectedIndex = new javax.swing.JLabel();
        btnAddPower = new javax.swing.JButton();
        btnRemovePower = new javax.swing.JButton();
        btnCycle = new javax.swing.JButton();
        lblListTitle = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        lstPower.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        lstPower.setSelectedIndex(0);
        lstPower.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                lstPowerValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(lstPower);

        lblSelectedIndex.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        btnAddPower.setText("Add");
        btnAddPower.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddPowerActionPerformed(evt);
            }
        });

        btnRemovePower.setText("Remove");
        btnRemovePower.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemovePowerActionPerformed(evt);
            }
        });

        btnCycle.setText("Cycle");
        btnCycle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCycleActionPerformed(evt);
            }
        });

        lblListTitle.setText("jLabel1");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnRemovePower, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE)
                    .addComponent(btnAddPower, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnCycle, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblSelectedIndex, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35))
            .addGroup(layout.createSequentialGroup()
                .addGap(186, 186, 186)
                .addComponent(lblListTitle)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblListTitle)
                .addGap(13, 13, 13)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblSelectedIndex, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnAddPower)
                        .addGap(18, 18, 18)
                        .addComponent(btnRemovePower)
                        .addGap(18, 18, 18)
                        .addComponent(btnCycle)
                        .addGap(0, 103, Short.MAX_VALUE))
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        //Save power list upon closing
        powers.save();
    }//GEN-LAST:event_formWindowClosing

    private void lstPowerValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_lstPowerValueChanged
        //Show list position for selected power
        lblSelectedIndex.setText((lstPower.getSelectedIndex() + 1) + "");
    }//GEN-LAST:event_lstPowerValueChanged

    private void btnAddPowerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddPowerActionPerformed
        //Fetches the current list (i.e. allpowers or a subtable) then prompts the user for a name
        //Inserts new power under that name imediately after the currently selected power
        powers.listHolder.get(currentList).add(lstPower.getSelectedIndex() + 1, JOptionPane.showInputDialog("Enter new power name"));
        update();
    }//GEN-LAST:event_btnAddPowerActionPerformed

    private void btnRemovePowerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemovePowerActionPerformed
        //Confirms a power is selected, then requests confirmation before deleting the selected power
        if (lstPower.getSelectedIndex() >= 0)
        {
            if (JOptionPane.showConfirmDialog(null, "Are you sure you want to delete " + lstPower.getSelectedValue()) == 0)
            {
                powers.listHolder.get(currentList).remove(lstPower.getSelectedIndex());
            }
            update();
        } else
            JOptionPane.showMessageDialog(null, "No power selected");
    }//GEN-LAST:event_btnRemovePowerActionPerformed

    private void btnCycleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCycleActionPerformed
        //Cycles through the different lists (allpowers and subtables)
        if (currentList == powers.listHolder.size() - 1)
            currentList = 0;
        else
            currentList++;
        update();
    }//GEN-LAST:event_btnCycleActionPerformed

    
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
            java.util.logging.Logger.getLogger(PowerManager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PowerManager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PowerManager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PowerManager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PowerManager().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddPower;
    private javax.swing.JButton btnCycle;
    private javax.swing.JButton btnRemovePower;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblListTitle;
    private javax.swing.JLabel lblSelectedIndex;
    private javax.swing.JList<String> lstPower;
    // End of variables declaration//GEN-END:variables
}
