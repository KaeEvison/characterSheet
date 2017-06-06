package zombies.stuff;

import javax.swing.JOptionPane;

public class CharacterSheetOptions extends javax.swing.JFrame
{
    CharacterManager cManager;
    SkillManager sManager;
    TraitManager tManager;
    EquipmentManager eManager;
    Roller roller;
    
    public CharacterSheetOptions()
    {
        initComponents();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnOpenRoller = new javax.swing.JButton();
        btnManageCharacters = new javax.swing.JButton();
        chkBasicInfo = new javax.swing.JCheckBox();
        btnEditBasic = new javax.swing.JToggleButton();
        chkLevel = new javax.swing.JCheckBox();
        btnEditLevel = new javax.swing.JToggleButton();
        chkStats = new javax.swing.JCheckBox();
        jPanel1 = new javax.swing.JPanel();
        btnEditStats = new javax.swing.JToggleButton();
        btnPortStats = new javax.swing.JButton();
        chkSkills = new javax.swing.JCheckBox();
        btnEditSkills = new javax.swing.JButton();
        chkTraits = new javax.swing.JCheckBox();
        btnEditTraits = new javax.swing.JButton();
        chkNotes = new javax.swing.JCheckBox();
        jPanel2 = new javax.swing.JPanel();
        chkEquipment = new javax.swing.JCheckBox();
        btnEditEquipment = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setLocation(new java.awt.Point(920, 0));
        getContentPane().setLayout(new java.awt.GridLayout(8, 2));

        btnOpenRoller.setText("Dice roller");
        btnOpenRoller.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOpenRollerActionPerformed(evt);
            }
        });
        getContentPane().add(btnOpenRoller);

        btnManageCharacters.setText("Manage Characters");
        btnManageCharacters.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnManageCharactersActionPerformed(evt);
            }
        });
        getContentPane().add(btnManageCharacters);

        chkBasicInfo.setSelected(true);
        chkBasicInfo.setText("Basic information visible");
        chkBasicInfo.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                chkBasicInfoStateChanged(evt);
            }
        });
        getContentPane().add(chkBasicInfo);

        btnEditBasic.setText("Edit basic information");
        btnEditBasic.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                btnEditBasicStateChanged(evt);
            }
        });
        getContentPane().add(btnEditBasic);

        chkLevel.setSelected(true);
        chkLevel.setText("Level and experience visible");
        chkLevel.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                chkLevelStateChanged(evt);
            }
        });
        getContentPane().add(chkLevel);

        btnEditLevel.setText("Edit level and experience");
        btnEditLevel.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                btnEditLevelStateChanged(evt);
            }
        });
        getContentPane().add(btnEditLevel);

        chkStats.setSelected(true);
        chkStats.setText("Stats visible");
        chkStats.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                chkStatsStateChanged(evt);
            }
        });
        getContentPane().add(chkStats);

        jPanel1.setLayout(new java.awt.GridLayout(2, 1));

        btnEditStats.setText("Edit stats");
        btnEditStats.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                btnEditStatsStateChanged(evt);
            }
        });
        jPanel1.add(btnEditStats);

        btnPortStats.setText("Port stats");
        btnPortStats.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPortStatsActionPerformed(evt);
            }
        });
        jPanel1.add(btnPortStats);

        getContentPane().add(jPanel1);

        chkSkills.setSelected(true);
        chkSkills.setText("Skills visible");
        chkSkills.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                chkSkillsStateChanged(evt);
            }
        });
        getContentPane().add(chkSkills);

        btnEditSkills.setText("Manage skills");
        btnEditSkills.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditSkillsActionPerformed(evt);
            }
        });
        getContentPane().add(btnEditSkills);

        chkTraits.setSelected(true);
        chkTraits.setText("Traits visible");
        chkTraits.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                chkTraitsStateChanged(evt);
            }
        });
        getContentPane().add(chkTraits);

        btnEditTraits.setText("Manage traits");
        btnEditTraits.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditTraitsActionPerformed(evt);
            }
        });
        getContentPane().add(btnEditTraits);

        chkNotes.setSelected(true);
        chkNotes.setText("Notes visible");
        chkNotes.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                chkNotesStateChanged(evt);
            }
        });
        getContentPane().add(chkNotes);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 159, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 46, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel2);

        chkEquipment.setSelected(true);
        chkEquipment.setText("Equipment visible");
        chkEquipment.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                chkEquipmentStateChanged(evt);
            }
        });
        getContentPane().add(chkEquipment);

        btnEditEquipment.setText("Manage equipment");
        btnEditEquipment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditEquipmentActionPerformed(evt);
            }
        });
        getContentPane().add(btnEditEquipment);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void chkBasicInfoStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_chkBasicInfoStateChanged
        //Detects whether tick box is ticked and makes basic information visible or invisible
        if (chkBasicInfo.isSelected())
            ZombiesStuff.cSheet.pnlBasicInfo.setVisible(true);
        else
            ZombiesStuff.cSheet.pnlBasicInfo.setVisible(false);
    }//GEN-LAST:event_chkBasicInfoStateChanged

    private void chkLevelStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_chkLevelStateChanged
        //Detects whether tick box is ticked and makes level and experience visible or invisible
        if (chkLevel.isSelected())
            ZombiesStuff.cSheet.pnlLevel.setVisible(true);
        else
            ZombiesStuff.cSheet.pnlLevel.setVisible(false);
    }//GEN-LAST:event_chkLevelStateChanged

    private void chkStatsStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_chkStatsStateChanged
        //Detects whether tick box is ticked and makes stats visible or invisible
        if (chkStats.isSelected())
            ZombiesStuff.cSheet.pnlStats.setVisible(true);
        else
            ZombiesStuff.cSheet.pnlStats.setVisible(false);
    }//GEN-LAST:event_chkStatsStateChanged

    private void chkSkillsStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_chkSkillsStateChanged
        //Detects whether tick box is ticked and makes skills visible or invisible
        if (chkSkills.isSelected())
            ZombiesStuff.cSheet.pnlSkills.setVisible(true);
        else
            ZombiesStuff.cSheet.pnlSkills.setVisible(false);
    }//GEN-LAST:event_chkSkillsStateChanged

    private void btnEditBasicStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_btnEditBasicStateChanged
        //Detects whether toggle button is on or off and enables or disables basic information
        if (btnEditBasic.isSelected())
            ZombiesStuff.cSheet.basicEditable = true;
        else
            ZombiesStuff.cSheet.basicEditable = false;
    }//GEN-LAST:event_btnEditBasicStateChanged

    private void btnEditLevelStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_btnEditLevelStateChanged
        //Detects whether toggle button is on or off and enables or disables level and experience
        if (btnEditLevel.isSelected())
            ZombiesStuff.cSheet.levelEditable = true;
        else
            ZombiesStuff.cSheet.levelEditable = false;
    }//GEN-LAST:event_btnEditLevelStateChanged

    private void btnEditStatsStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_btnEditStatsStateChanged
        //Detects whether toggle button is on or off and enables or disables stats
        if (btnEditStats.isSelected())
            ZombiesStuff.cSheet.statsEditable = true;
        else
            ZombiesStuff.cSheet.statsEditable = false;
    }//GEN-LAST:event_btnEditStatsStateChanged

    private void btnPortStatsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPortStatsActionPerformed
        //Gets confirmation and then sets character's stats to those rolled in the dice/power roller
        if (JOptionPane.showConfirmDialog(null, "Port stats from stat roller?") == 0)
            ZombiesStuff.cSheet.receiveStats(ZombiesStuff.ui.getStats());
    }//GEN-LAST:event_btnPortStatsActionPerformed

    private void btnManageCharactersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnManageCharactersActionPerformed
        //Creates and displays an instance of the character management panel
        cManager = new CharacterManager();
        cManager.setVisible(true);
    }//GEN-LAST:event_btnManageCharactersActionPerformed

    private void btnEditSkillsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditSkillsActionPerformed
        //Creates and displays an instance of the skill management panel
        sManager = new SkillManager();
        sManager.setVisible(true);
    }//GEN-LAST:event_btnEditSkillsActionPerformed

    private void chkTraitsStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_chkTraitsStateChanged
        //Detects whether tick box is ticked and makes traits visible or invisible
        if (chkTraits.isSelected())
            ZombiesStuff.cSheet.pnlTraits.setVisible(true);
        else
            ZombiesStuff.cSheet.pnlTraits.setVisible(false);
    }//GEN-LAST:event_chkTraitsStateChanged

    private void btnEditTraitsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditTraitsActionPerformed
        //Creates and displays an instance of the trait management panel
        tManager = new TraitManager();
        tManager.setVisible(true);
    }//GEN-LAST:event_btnEditTraitsActionPerformed

    private void chkNotesStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_chkNotesStateChanged
        //Detects whether tick box is ticked and makes notes visible or invisible
        if (chkNotes.isSelected())
        {
            ZombiesStuff.cSheet.pnlNoteOptions.setVisible(true);
            ZombiesStuff.cSheet.pnlNoteContent.setVisible(true);
        }
        else
        {
            ZombiesStuff.cSheet.pnlNoteOptions.setVisible(false);
            ZombiesStuff.cSheet.pnlNoteContent.setVisible(false);
        }
    }//GEN-LAST:event_chkNotesStateChanged

    private void chkEquipmentStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_chkEquipmentStateChanged
        if (chkEquipment.isSelected())
            ZombiesStuff.cSheet.pnlEquipment.setVisible(true);
        else
            ZombiesStuff.cSheet.pnlEquipment.setVisible(false);
    }//GEN-LAST:event_chkEquipmentStateChanged

    private void btnEditEquipmentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditEquipmentActionPerformed
        eManager = new EquipmentManager();
        eManager.setVisible(true);
    }//GEN-LAST:event_btnEditEquipmentActionPerformed

    private void btnOpenRollerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOpenRollerActionPerformed
        roller = new Roller();
        roller.setVisible(true);
    }//GEN-LAST:event_btnOpenRollerActionPerformed

    
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
            java.util.logging.Logger.getLogger(CharacterSheetOptions.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CharacterSheetOptions.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CharacterSheetOptions.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CharacterSheetOptions.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CharacterSheetOptions().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton btnEditBasic;
    private javax.swing.JButton btnEditEquipment;
    private javax.swing.JToggleButton btnEditLevel;
    private javax.swing.JButton btnEditSkills;
    private javax.swing.JToggleButton btnEditStats;
    private javax.swing.JButton btnEditTraits;
    private javax.swing.JButton btnManageCharacters;
    private javax.swing.JButton btnOpenRoller;
    private javax.swing.JButton btnPortStats;
    private javax.swing.JCheckBox chkBasicInfo;
    private javax.swing.JCheckBox chkEquipment;
    private javax.swing.JCheckBox chkLevel;
    private javax.swing.JCheckBox chkNotes;
    private javax.swing.JCheckBox chkSkills;
    private javax.swing.JCheckBox chkStats;
    private javax.swing.JCheckBox chkTraits;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}
