package zombies.stuff;

import java.util.ArrayList;
import javax.swing.JOptionPane;

public class SkillManager extends javax.swing.JFrame
{
    CharacterSheet cSheet;
    ArrayList<Skill> skillList;
    ArrayList<String> names = new ArrayList();
    
    public SkillManager()
    {
        initComponents();
        
        //Sets access to character sheet and skill list for currently loaded character
        cSheet = ZombiesStuff.cSheet;
        skillList = cSheet.currentCharacter.getSkills();
        
        updateAll();
    }
    
    //Method to update UI elements
    private void updateAll()
    {
        getNames();
        lstManageSkills.setListData(names.toArray(new String[0]));
    }
    
    //Method to retrieve names from the skill list
    private void getNames()
    {
        //clear list
        names.clear();
        //For each skill, retrieve the name and add it to list
        for (int i = 0; i < skillList.size(); i++)
        {
            names.add(skillList.get(i).getName());
        }
    }

    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        lstManageSkills = new javax.swing.JList<>();
        btnSkillAdd = new javax.swing.JButton();
        btnSkillRemove = new javax.swing.JButton();
        btnSkillRankUp = new javax.swing.JButton();
        lblSkillRank = new javax.swing.JLabel();
        btnSkillRankDown = new javax.swing.JButton();
        lblSkillRanksTag = new javax.swing.JLabel();
        lblSkillOtherTag = new javax.swing.JLabel();
        lblSkillOtherUp = new javax.swing.JButton();
        lblSkillOther = new javax.swing.JLabel();
        lblSkillOtherDown = new javax.swing.JButton();
        lblStat = new javax.swing.JLabel();
        cmbStat = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setLocation(new java.awt.Point(250, 400));

        lstManageSkills.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        lstManageSkills.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                lstManageSkillsValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(lstManageSkills);

        btnSkillAdd.setText("Add");
        btnSkillAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSkillAddActionPerformed(evt);
            }
        });

        btnSkillRemove.setText("Remove");
        btnSkillRemove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSkillRemoveActionPerformed(evt);
            }
        });

        btnSkillRankUp.setText("+");
        btnSkillRankUp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSkillRankUpActionPerformed(evt);
            }
        });

        lblSkillRank.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        btnSkillRankDown.setText("-");
        btnSkillRankDown.setMaximumSize(new java.awt.Dimension(41, 23));
        btnSkillRankDown.setMinimumSize(new java.awt.Dimension(41, 23));
        btnSkillRankDown.setPreferredSize(new java.awt.Dimension(41, 23));
        btnSkillRankDown.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSkillRankDownActionPerformed(evt);
            }
        });

        lblSkillRanksTag.setText("Ranks:");

        lblSkillOtherTag.setText("Other bonuses:");

        lblSkillOtherUp.setText("+");
        lblSkillOtherUp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lblSkillOtherUpActionPerformed(evt);
            }
        });

        lblSkillOther.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        lblSkillOtherDown.setText("-");
        lblSkillOtherDown.setMaximumSize(new java.awt.Dimension(41, 23));
        lblSkillOtherDown.setMinimumSize(new java.awt.Dimension(41, 23));
        lblSkillOtherDown.setPreferredSize(new java.awt.Dimension(41, 23));
        lblSkillOtherDown.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lblSkillOtherDownActionPerformed(evt);
            }
        });

        lblStat.setText("Stat:");

        cmbStat.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "---", "STR", "CON", "DEX", "AGI", "INT", "WIS", "CHA", "PER" }));
        cmbStat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbStatActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnSkillAdd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnSkillRemove, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblSkillRanksTag)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblSkillRank, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblSkillOtherDown, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblSkillOtherUp))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblSkillOtherTag)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                        .addComponent(lblSkillOther, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnSkillRankDown, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(25, 25, 25)
                                .addComponent(lblStat)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnSkillRankUp, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(cmbStat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(20, 20, 20)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnSkillAdd)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSkillRemove)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cmbStat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblStat))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblSkillRank, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblSkillRanksTag, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnSkillRankDown, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnSkillRankUp))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblSkillOther, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblSkillOtherTag, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblSkillOtherDown, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblSkillOtherUp)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 195, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSkillAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSkillAddActionPerformed
        //Asks for skill name and dependant stat then creates a new skill with that data
        skillList.add(new Skill(JOptionPane.showInputDialog("Enter skill name"),
                                JOptionPane.showInputDialog("Enter dependant stat")));
        updateAll();
        cSheet.updateAll();
    }//GEN-LAST:event_btnSkillAddActionPerformed

    private void btnSkillRemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSkillRemoveActionPerformed
        //Checks that a skill is selected then asks for confirmation before deleting the selected skill
        if (lstManageSkills.getSelectedIndex() >= 0)
        {
            if (JOptionPane.showConfirmDialog(null, "Delete this skill?") == 0)
            {
                skillList.remove(lstManageSkills.getSelectedIndex());
                updateAll();
                cSheet.updateAll();
            }
        } else
        {
            JOptionPane.showMessageDialog(null, "No skill selected");
        }
    }//GEN-LAST:event_btnSkillRemoveActionPerformed

    private void lstManageSkillsValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_lstManageSkillsValueChanged
        //As long as a skill is selected, display that skills details
        try
        {
            if (lstManageSkills.getSelectedIndex() >= 0)
                lblSkillRank.setText(skillList.get(lstManageSkills.getSelectedIndex()).getRanks()+"");
                lblSkillOther.setText(skillList.get(lstManageSkills.getSelectedIndex()).getOtherBonus()+"");
                //Switch statement chooses correct stat for selected skill
                switch (skillList.get(lstManageSkills.getSelectedIndex()).getStat())
                {
                    case "STR":
                        cmbStat.setSelectedIndex(1);
                        break;
                    case "CON":
                        cmbStat.setSelectedIndex(2);
                        break;
                    case "DEX":
                        cmbStat.setSelectedIndex(3);
                        break;
                    case "AGI":
                        cmbStat.setSelectedIndex(4);
                        break;
                    case "INT":
                        cmbStat.setSelectedIndex(5);
                        break;
                    case "WIS":
                        cmbStat.setSelectedIndex(6);
                        break;
                    case "CHA":
                        cmbStat.setSelectedIndex(7);
                        break;
                    case "PER":
                        cmbStat.setSelectedIndex(8);
                        break;
                    default:
                        cmbStat.setSelectedIndex(0);
                        break;
                }
        } catch (ArrayIndexOutOfBoundsException e){}
    }//GEN-LAST:event_lstManageSkillsValueChanged

    private void btnSkillRankUpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSkillRankUpActionPerformed
        //As long as a skill is selected, increases that skill's rank by one and updates the label
        if (lstManageSkills.getSelectedIndex() >= 0)
        {
            skillList.get(lstManageSkills.getSelectedIndex()).ranksPlus();
            lblSkillRank.setText(skillList.get(lstManageSkills.getSelectedIndex()).getRanks()+"");
        } else
        {
            JOptionPane.showMessageDialog(null, "No skill selected");
        }
    }//GEN-LAST:event_btnSkillRankUpActionPerformed

    private void btnSkillRankDownActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSkillRankDownActionPerformed
        //As long as a skill is selected and has a rank higher than 0, decreases its rank and updates the label
        if (lstManageSkills.getSelectedIndex() >= 0)
        {
            if (skillList.get(lstManageSkills.getSelectedIndex()).getRanks() > 0)
                skillList.get(lstManageSkills.getSelectedIndex()).ranksMinus();
                lblSkillRank.setText(skillList.get(lstManageSkills.getSelectedIndex()).getRanks()+"");
        } else
        {
            JOptionPane.showMessageDialog(null, "No skill selected");
        }
    }//GEN-LAST:event_btnSkillRankDownActionPerformed

    private void lblSkillOtherUpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lblSkillOtherUpActionPerformed
        //As long as a skill is selected, increases the skill's "other bonuses" value and updates the label
        if (lstManageSkills.getSelectedIndex() >= 0)
        {
            skillList.get(lstManageSkills.getSelectedIndex()).otherPlus();
            lblSkillOther.setText(skillList.get(lstManageSkills.getSelectedIndex()).getOtherBonus()+"");
        } else
        {
            JOptionPane.showMessageDialog(null, "No skill selected");
        }
    }//GEN-LAST:event_lblSkillOtherUpActionPerformed

    private void lblSkillOtherDownActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lblSkillOtherDownActionPerformed
        //As long as a skill is selected, decreases its "other bonuses" value and updates the label
        if (lstManageSkills.getSelectedIndex() >= 0)
        {
            skillList.get(lstManageSkills.getSelectedIndex()).otherMinus();
            lblSkillOther.setText(skillList.get(lstManageSkills.getSelectedIndex()).getOtherBonus()+"");
        } else
        {
            JOptionPane.showMessageDialog(null, "No skill selected");
        }
    }//GEN-LAST:event_lblSkillOtherDownActionPerformed

    private void cmbStatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbStatActionPerformed
        if (lstManageSkills.getSelectedIndex() >= 0)
        {
            skillList.get(lstManageSkills.getSelectedIndex()).setStat(cmbStat.getSelectedItem().toString());
        }
    }//GEN-LAST:event_cmbStatActionPerformed

    
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
            java.util.logging.Logger.getLogger(SkillManager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SkillManager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SkillManager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SkillManager.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SkillManager().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSkillAdd;
    private javax.swing.JButton btnSkillRankDown;
    private javax.swing.JButton btnSkillRankUp;
    private javax.swing.JButton btnSkillRemove;
    private javax.swing.JComboBox<String> cmbStat;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblSkillOther;
    private javax.swing.JButton lblSkillOtherDown;
    private javax.swing.JLabel lblSkillOtherTag;
    private javax.swing.JButton lblSkillOtherUp;
    private javax.swing.JLabel lblSkillRank;
    private javax.swing.JLabel lblSkillRanksTag;
    private javax.swing.JLabel lblStat;
    private javax.swing.JList<String> lstManageSkills;
    // End of variables declaration//GEN-END:variables
}
