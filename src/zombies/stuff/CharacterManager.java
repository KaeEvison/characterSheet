package zombies.stuff;

import java.util.ArrayList;
import javax.swing.JOptionPane;

public class CharacterManager extends javax.swing.JFrame
{
    ArrayList<CharacterGroup> allGroups;
    CharacterSheet cSheet;
    ArrayList<String> groupNames = new ArrayList();
    ArrayList<String> characterNames = new ArrayList();
    CharacterGroup currentGroup;
    Character copyCharacter;
    String sHolder;
    
    public CharacterManager()
    {
        initComponents();
        
        //Sets access to main character array and character sheet
        allGroups = ZombiesStuff.ui.allGroups;
        cSheet = ZombiesStuff.cSheet;
        
        updateGroups();
    }
    
    //Method for setting the list UI element to display the names off all character groups 
    private void updateGroups()
    {
        getGroupNames();
        lstCharacterGroups.setListData(groupNames.toArray(new String[0]));
    }
    
    //Method for setting the list UI element to display the names off all characters 
    private void updateCharacters()
    {
        getCharacterNames();
        lstCharacters.setListData(characterNames.toArray(new String[0]));
    }
    
    //Method to retrieve names of all groups
    private void getGroupNames()
    {
        //Clear the array
        groupNames.clear();
        //For each group in the array, retrieve the name
        for (int i = 0; i < allGroups.size(); i++)
        {
            groupNames.add(allGroups.get(i).getName());
        }
    }
    
    //Method to retrieve names of all characters
    private void getCharacterNames()
    {
        //Clear the array
        characterNames.clear();
        //For each character in the group, retrieve the name
        for (int i = 0; i < currentGroup.size(); i++)
        {
            characterNames.add(currentGroup.get(i).getName());
        }
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        lstCharacters = new javax.swing.JList<>();
        btnAddCharacter = new javax.swing.JButton();
        btnRemoveCharacter = new javax.swing.JButton();
        btnLoadCharacter = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        lstCharacterGroups = new javax.swing.JList<>();
        btnAddGroup = new javax.swing.JButton();
        btnRemoveGroup = new javax.swing.JButton();
        btnRenameGroup = new javax.swing.JButton();
        btnCopyCharacter = new javax.swing.JButton();
        btnPasteCharacter = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setLocation(new java.awt.Point(0, 200));

        jScrollPane1.setViewportView(lstCharacters);

        btnAddCharacter.setText("Add");
        btnAddCharacter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddCharacterActionPerformed(evt);
            }
        });

        btnRemoveCharacter.setText("Remove");
        btnRemoveCharacter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveCharacterActionPerformed(evt);
            }
        });

        btnLoadCharacter.setText("Load");
        btnLoadCharacter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoadCharacterActionPerformed(evt);
            }
        });

        lstCharacterGroups.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                lstCharacterGroupsValueChanged(evt);
            }
        });
        jScrollPane2.setViewportView(lstCharacterGroups);

        btnAddGroup.setText("Add");
        btnAddGroup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddGroupActionPerformed(evt);
            }
        });

        btnRemoveGroup.setText("Remove");
        btnRemoveGroup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveGroupActionPerformed(evt);
            }
        });

        btnRenameGroup.setText("Rename");
        btnRenameGroup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRenameGroupActionPerformed(evt);
            }
        });

        btnCopyCharacter.setText("Copy");
        btnCopyCharacter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCopyCharacterActionPerformed(evt);
            }
        });

        btnPasteCharacter.setText("Paste");
        btnPasteCharacter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPasteCharacterActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnAddGroup, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnRemoveGroup, javax.swing.GroupLayout.DEFAULT_SIZE, 96, Short.MAX_VALUE)
                            .addComponent(btnRenameGroup, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnAddCharacter, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnLoadCharacter, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnRemoveCharacter, javax.swing.GroupLayout.DEFAULT_SIZE, 96, Short.MAX_VALUE)
                            .addComponent(btnCopyCharacter, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnPasteCharacter, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnAddGroup)
                        .addGap(18, 18, 18)
                        .addComponent(btnRenameGroup)
                        .addGap(18, 18, 18)
                        .addComponent(btnRemoveGroup)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnLoadCharacter)
                        .addGap(18, 18, 18)
                        .addComponent(btnAddCharacter)
                        .addGap(18, 18, 18)
                        .addComponent(btnRemoveCharacter)
                        .addGap(18, 18, 18)
                        .addComponent(btnCopyCharacter)
                        .addGap(18, 18, 18)
                        .addComponent(btnPasteCharacter)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLoadCharacterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoadCharacterActionPerformed
        //Checks that a character is selected
        if (lstCharacters.getSelectedIndex() >= 0)
        {
            //Loads the currently selected character from the list into the character sheet
            cSheet.currentCharacter = currentGroup.get(lstCharacters.getSelectedIndex());
            cSheet.updateAll();
            updateGroups();
        } else
        {
            JOptionPane.showMessageDialog(null, "No character selected");
        }
    }//GEN-LAST:event_btnLoadCharacterActionPerformed

    private void btnAddCharacterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddCharacterActionPerformed
        //requests confirmation then creates a new blank character
        if (lstCharacterGroups.getSelectedIndex() >= 0)
        {
            if (JOptionPane.showConfirmDialog(null, "Create a blank character?") == 0)
            {
                currentGroup.add(new Character());
                updateCharacters();
            }
        } else
            JOptionPane.showMessageDialog(null, "No group selected");
    }//GEN-LAST:event_btnAddCharacterActionPerformed

    private void btnRemoveCharacterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveCharacterActionPerformed
        //Ensures that a character is selected, then requests confirmation before deleting the selected character
        if (lstCharacters.getSelectedIndex() >= 0)
        {
            if (JOptionPane.showConfirmDialog(null, "Delete this character?") == 0)
            {
                currentGroup.remove(lstCharacters.getSelectedIndex());
                updateCharacters();
            }
        } else
        {
            JOptionPane.showMessageDialog(null, "No character selected");
        }
    }//GEN-LAST:event_btnRemoveCharacterActionPerformed

    private void btnAddGroupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddGroupActionPerformed
        //requests a name then creates a new character group
        sHolder = JOptionPane.showInputDialog("Enter group name");
        if (sHolder != null)
        {
            allGroups.add(new CharacterGroup(sHolder));
            updateGroups();
        }
    }//GEN-LAST:event_btnAddGroupActionPerformed

    private void btnRemoveGroupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveGroupActionPerformed
        //Checks a group is selected then requests confirmation before deleting it
        if (lstCharacterGroups.getSelectedIndex() >= 0)
        {
            if (JOptionPane.showConfirmDialog(null, "Delete this group?") == 0)
            {
                allGroups.remove(lstCharacterGroups.getSelectedIndex());
                updateGroups();
            }
        } else
        {
            JOptionPane.showMessageDialog(null, "No group selected");
        }
    }//GEN-LAST:event_btnRemoveGroupActionPerformed

    private void lstCharacterGroupsValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_lstCharacterGroupsValueChanged
        //Update character list whenever a group is selected
        if (lstCharacterGroups.getSelectedIndex() >= 0)
        {
            currentGroup = allGroups.get(lstCharacterGroups.getSelectedIndex());
            updateCharacters();
        }
    }//GEN-LAST:event_lstCharacterGroupsValueChanged

    private void btnRenameGroupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRenameGroupActionPerformed
        //Requests new name and applies it to the currently selected group
        if (lstCharacterGroups.getSelectedIndex() >= 0)
        {
            sHolder = JOptionPane.showInputDialog("Enter new name", allGroups.get(lstCharacterGroups.getSelectedIndex()).getName());
            if (sHolder != null)
            {
                currentGroup.setName(sHolder);
                updateGroups();
            }
        } else
        {
            JOptionPane.showMessageDialog(null, "No group selected");
        }
    }//GEN-LAST:event_btnRenameGroupActionPerformed

    private void btnCopyCharacterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCopyCharacterActionPerformed
        //Checks that a character is selected then stores it to be added to another group
        if (lstCharacters.getSelectedIndex() >= 0)
            copyCharacter = currentGroup.get(lstCharacters.getSelectedIndex());
        else
            JOptionPane.showMessageDialog(null, "No character selected");
    }//GEN-LAST:event_btnCopyCharacterActionPerformed

    private void btnPasteCharacterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPasteCharacterActionPerformed
        //Checks a group is selected and then adds a previously copied character to that group
        if (lstCharacterGroups.getSelectedIndex() >= 0 && copyCharacter != null)
        {
            currentGroup.add(new Character(copyCharacter));
            updateCharacters();
        } else if (lstCharacterGroups.getSelectedIndex() < 0)
            JOptionPane.showMessageDialog(null, "No group selecteed");
        else
            JOptionPane.showMessageDialog(null, "No character copied");
    }//GEN-LAST:event_btnPasteCharacterActionPerformed

    
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
            java.util.logging.Logger.getLogger(CharacterManager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CharacterManager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CharacterManager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CharacterManager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CharacterManager().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddCharacter;
    private javax.swing.JButton btnAddGroup;
    private javax.swing.JButton btnCopyCharacter;
    private javax.swing.JButton btnLoadCharacter;
    private javax.swing.JButton btnPasteCharacter;
    private javax.swing.JButton btnRemoveCharacter;
    private javax.swing.JButton btnRemoveGroup;
    private javax.swing.JButton btnRenameGroup;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JList<String> lstCharacterGroups;
    private javax.swing.JList<String> lstCharacters;
    // End of variables declaration//GEN-END:variables
}
