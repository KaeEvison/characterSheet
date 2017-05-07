package zombies.stuff;

import java.util.ArrayList;
import javax.swing.JOptionPane;

public class TraitManager extends javax.swing.JFrame
{
    CharacterSheet cSheet;
    ArrayList<Trait> traitList;
    ArrayList<String> names = new ArrayList();
    
    String sHolder;
    
    public TraitManager()
    {
        initComponents();
        
        //Sets access to the character sheet and the current character's list of traits
        cSheet = ZombiesStuff.cSheet;
        traitList = cSheet.currentCharacter.getTraits();
        
        updateAll();
    }
    
    //Method to update the UI
    private void updateAll()
    {
        getNames();
        lstManageTraits.setListData(names.toArray(new String[0]));
    }
    
    //Method to retrieve trait names
    private void getNames()
    {
        //Clear list
        names.clear();
        //For each trait, retrieve its name and add it to the list
        for (int i = 0; i < traitList.size(); i++)
        {
            names.add(traitList.get(i).getName());
        }
    }

    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        lstManageTraits = new javax.swing.JList<>();
        btnAddTrait = new javax.swing.JButton();
        btnRemoveTrait = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtTraitDesc = new javax.swing.JTextArea();
        btnUpdateTrait = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        lstManageTraits.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        lstManageTraits.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                lstManageTraitsValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(lstManageTraits);

        btnAddTrait.setText("Add");
        btnAddTrait.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddTraitActionPerformed(evt);
            }
        });

        btnRemoveTrait.setText("Remove");
        btnRemoveTrait.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveTraitActionPerformed(evt);
            }
        });

        txtTraitDesc.setColumns(20);
        txtTraitDesc.setLineWrap(true);
        txtTraitDesc.setRows(5);
        txtTraitDesc.setWrapStyleWord(true);
        jScrollPane2.setViewportView(txtTraitDesc);

        btnUpdateTrait.setText("Update");
        btnUpdateTrait.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateTraitActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnRemoveTrait, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnAddTrait, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnUpdateTrait, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 173, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane2)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(btnAddTrait)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnRemoveTrait)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnUpdateTrait)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddTraitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddTraitActionPerformed
        //Requests a trait name
        sHolder = JOptionPane.showInputDialog("Enter trait name");
        //Ensures the user didnt cancel or enter an empty string
        if (sHolder != null && !sHolder.equals(""))
        {
            traitList.add(new Trait(sHolder));
            updateAll();
            cSheet.updateAll();
        }
    }//GEN-LAST:event_btnAddTraitActionPerformed

    private void btnRemoveTraitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveTraitActionPerformed
        //As long as a trait is selected, requests confirmation then deletes said trait
        if (lstManageTraits.getSelectedIndex() >= 0)
        {
            if (JOptionPane.showConfirmDialog(null, "Delete this trait?") == 0)
            {
                traitList.remove(lstManageTraits.getSelectedIndex());
                updateAll();
                cSheet.updateAll();
            }
        } else
        {
            JOptionPane.showMessageDialog(null, "No trait selected");
        }
    }//GEN-LAST:event_btnRemoveTraitActionPerformed

    private void lstManageTraitsValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_lstManageTraitsValueChanged
        //As long as a trait is selected, displays its description
        if (lstManageTraits.getSelectedIndex() >= 0)
            txtTraitDesc.setText(traitList.get(lstManageTraits.getSelectedIndex()).getDescription());
    }//GEN-LAST:event_lstManageTraitsValueChanged

    private void btnUpdateTraitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateTraitActionPerformed
        //As long as a trait is selected, updates its description with any modifications by the user
        if (lstManageTraits.getSelectedIndex() >= 0)
            traitList.get(lstManageTraits.getSelectedIndex()).setDescription(txtTraitDesc.getText());
        else
            JOptionPane.showMessageDialog(null, "No trait selected");
    }//GEN-LAST:event_btnUpdateTraitActionPerformed

    
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
            java.util.logging.Logger.getLogger(TraitManager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TraitManager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TraitManager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TraitManager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TraitManager().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddTrait;
    private javax.swing.JButton btnRemoveTrait;
    private javax.swing.JButton btnUpdateTrait;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JList<String> lstManageTraits;
    private javax.swing.JTextArea txtTraitDesc;
    // End of variables declaration//GEN-END:variables
}
