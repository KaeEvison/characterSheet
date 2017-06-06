
package zombies.stuff;

import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

public class Roller extends javax.swing.JFrame
{
    private Dice dice = new Dice();
    private RollManager rManager;
    
    Character currentCharacter;
    private ArrayList<Skill> skills;
    private ArrayList<CustomRoll> customRolls;
    private Skill currentSkill = new Skill();
    private CustomRoll currentRoll = new CustomRoll();
    
    private ArrayList<String> skillNames = new ArrayList();
    private ArrayList<String> customNames = new ArrayList();
    
    private int holder;
    
    public Roller()
    {
        initComponents();
        currentCharacter = ZombiesStuff.cSheet.currentCharacter;
        skills = currentCharacter.getSkills();
        customRolls = currentCharacter.getRolls();
        updateAll();
    }
    
    public void updateAll()
    {
        skillNames.clear();
        for (int i = 0; i < skills.size(); i++)
        {
            skillNames.add(skills.get(i).getName());
        }
        cmbSelectSkill.setModel(new DefaultComboBoxModel<String>(skillNames.toArray(new String[0])));
        
        customNames.clear();
        for (int i = 0; i < customRolls.size(); i++)
        {
            customNames.add(customRolls.get(i).getName());
        }
        cmbSelectCustom1.setModel(new DefaultComboBoxModel<String>(customNames.toArray(new String[0])));
        cmbSelectCustom2.setModel(new DefaultComboBoxModel<String>(customNames.toArray(new String[0])));
        cmbSelectCustom3.setModel(new DefaultComboBoxModel<String>(customNames.toArray(new String[0])));
        
        lblDieResult.setText("");
        lblStatResult.setText("");
        lblSkillResult.setText("");
        lblCustomResult1.setText("");
        lblCustomResult2.setText("");
        lblCustomResult3.setText("");
    }
    
    private void rollStat()
    {
        switch (cmbSelectStat.getSelectedIndex())
        {
            case 0:
                holder = dice.roll(20);
                if (holder == 20)
                {
                    lblStatResult.setText((holder + currentCharacter.getSTRMod()) + " (Critical)");
                } else if (holder == 1)
                {
                    lblStatResult.setText((holder + currentCharacter.getSTRMod()) + " (Crit fail)");
                } else
                {
                    lblStatResult.setText((holder + currentCharacter.getSTRMod()) + "");
                }
                break;
            case 1:
                holder = dice.roll(20);
                if (holder == 20)
                {
                    lblStatResult.setText((holder + currentCharacter.getCONMod()) + " (Critical)");
                } else if (holder == 1)
                {
                    lblStatResult.setText((holder + currentCharacter.getCONMod()) + " (Crit fail)");
                } else
                {
                    lblStatResult.setText((holder + currentCharacter.getCONMod()) + "");
                }
                break;
            case 2:
                holder = dice.roll(20);
                if (holder == 20)
                {
                    lblStatResult.setText((holder + currentCharacter.getDEXMod()) + " (Critical)");
                } else if (holder == 1)
                {
                    lblStatResult.setText((holder + currentCharacter.getDEXMod()) + " (Crit fail)");
                } else
                {
                    lblStatResult.setText((holder + currentCharacter.getDEXMod()) + "");
                }
                break;
            case 3:
                holder = dice.roll(20);
                if (holder == 20)
                {
                    lblStatResult.setText((holder + currentCharacter.getAGIMod()) + " (Critical)");
                } else if (holder == 1)
                {
                    lblStatResult.setText((holder + currentCharacter.getAGIMod()) + " (Crit fail)");
                } else
                {
                    lblStatResult.setText((holder + currentCharacter.getAGIMod()) + "");
                }
                break;
            case 4:
                holder = dice.roll(20);
                if (holder == 20)
                {
                    lblStatResult.setText((holder + currentCharacter.getINTMod()) + " (Critical)");
                } else if (holder == 1)
                {
                    lblStatResult.setText((holder + currentCharacter.getINTMod()) + " (Crit fail)");
                } else
                {
                    lblStatResult.setText((holder + currentCharacter.getINTMod()) + "");
                }
                break;
            case 5:
                holder = dice.roll(20);
                if (holder == 20)
                {
                    lblStatResult.setText((holder + currentCharacter.getWISMod()) + " (Critical)");
                } else if (holder == 1)
                {
                    lblStatResult.setText((holder + currentCharacter.getWISMod()) + " (Crit fail)");
                } else
                {
                    lblStatResult.setText((holder + currentCharacter.getWISMod()) + "");
                }
                break;
            case 6:
                holder = dice.roll(20);
                if (holder == 20)
                {
                    lblStatResult.setText((holder + currentCharacter.getCHAMod()) + " (Critical)");
                } else if (holder == 1)
                {
                    lblStatResult.setText((holder + currentCharacter.getCHAMod()) + " (Crit fail)");
                } else
                {
                    lblStatResult.setText((holder + currentCharacter.getCHAMod()) + "");
                }
                break;
            case 7:
                holder = dice.roll(20);
                if (holder == 20)
                {
                    lblStatResult.setText((holder + currentCharacter.getPERMod()) + " (Critical)");
                } else if (holder == 1)
                {
                    lblStatResult.setText((holder + currentCharacter.getPERMod()) + " (Crit fail)");
                } else
                {
                    lblStatResult.setText((holder + currentCharacter.getPERMod()) + "");
                }
                break;
        }
    }
    
    private void rollSkill()
    {
        switch (currentSkill.getStat())
        {
            case "STR":
                holder = dice.roll(20);
                if (holder == 20)
                {
                    lblSkillResult.setText((holder + currentSkill.getRanks() + currentCharacter.getSTRMod() + currentSkill.getOtherBonus()) + " (Critical)");
                } else if (holder == 1)
                {
                    lblSkillResult.setText((holder + currentSkill.getRanks() + currentCharacter.getSTRMod() + currentSkill.getOtherBonus()) + " (Crit fail)");
                } else
                {
                    lblSkillResult.setText((holder + currentSkill.getRanks() + currentCharacter.getSTRMod() + currentSkill.getOtherBonus()) + "");
                }
                break;
            case "CON":
                holder = dice.roll(20);
                if (holder == 20)
                {
                    lblSkillResult.setText((holder + currentSkill.getRanks() + currentCharacter.getCONMod() + currentSkill.getOtherBonus()) + " (Critical)");
                } else if (holder == 1)
                {
                    lblSkillResult.setText((holder + currentSkill.getRanks() + currentCharacter.getCONMod() + currentSkill.getOtherBonus()) + " (Crit fail)");
                } else
                {
                    lblSkillResult.setText((holder + currentSkill.getRanks() + currentCharacter.getCONMod() + currentSkill.getOtherBonus()) + "");
                }
                break;
            case "DEX":
                holder = dice.roll(20);
                if (holder == 20)
                {
                    lblSkillResult.setText((holder + currentSkill.getRanks() + currentCharacter.getDEXMod() + currentSkill.getOtherBonus()) + " (Critical)");
                } else if (holder == 1)
                {
                    lblSkillResult.setText((holder + currentSkill.getRanks() + currentCharacter.getDEXMod() + currentSkill.getOtherBonus()) + " (Crit fail)");
                } else
                {
                    lblSkillResult.setText((holder + currentSkill.getRanks() + currentCharacter.getDEXMod() + currentSkill.getOtherBonus()) + "");
                }
                break;
            case "AGI":
                holder = dice.roll(20);
                if (holder == 20)
                {
                    lblSkillResult.setText((holder + currentSkill.getRanks() + currentCharacter.getAGIMod() + currentSkill.getOtherBonus()) + " (Critical)");
                } else if (holder == 1)
                {
                    lblSkillResult.setText((holder + currentSkill.getRanks() + currentCharacter.getAGIMod() + currentSkill.getOtherBonus()) + " (Crit fail)");
                } else
                {
                    lblSkillResult.setText((holder + currentSkill.getRanks() + currentCharacter.getAGIMod() + currentSkill.getOtherBonus()) + "");
                }
                break;
            case "INT":
                holder = dice.roll(20);
                if (holder == 20)
                {
                    lblSkillResult.setText((holder + currentSkill.getRanks() + currentCharacter.getINTMod() + currentSkill.getOtherBonus()) + " (Critical)");
                } else if (holder == 1)
                {
                    lblSkillResult.setText((holder + currentSkill.getRanks() + currentCharacter.getINTMod() + currentSkill.getOtherBonus()) + " (Crit fail)");
                } else
                {
                    lblSkillResult.setText((holder + currentSkill.getRanks() + currentCharacter.getINTMod() + currentSkill.getOtherBonus()) + "");
                }
                break;
            case "WIS":
                holder = dice.roll(20);
                if (holder == 20)
                {
                    lblSkillResult.setText((holder + currentSkill.getRanks() + currentCharacter.getWISMod() + currentSkill.getOtherBonus()) + " (Critical)");
                } else if (holder == 1)
                {
                    lblSkillResult.setText((holder + currentSkill.getRanks() + currentCharacter.getWISMod() + currentSkill.getOtherBonus()) + " (Crit fail)");
                } else
                {
                    lblSkillResult.setText((holder + currentSkill.getRanks() + currentCharacter.getWISMod() + currentSkill.getOtherBonus()) + "");
                }
                break;
            case "CHA":
                holder = dice.roll(20);
                if (holder == 20)
                {
                    lblSkillResult.setText((holder + currentSkill.getRanks() + currentCharacter.getCHAMod() + currentSkill.getOtherBonus()) + " (Critical)");
                } else if (holder == 1)
                {
                    lblSkillResult.setText((holder + currentSkill.getRanks() + currentCharacter.getCHAMod() + currentSkill.getOtherBonus()) + " (Crit fail)");
                } else
                {
                    lblSkillResult.setText((holder + currentSkill.getRanks() + currentCharacter.getCHAMod() + currentSkill.getOtherBonus()) + "");
                }
                break;
            case "PER":
                holder = dice.roll(20);
                if (holder == 20)
                {
                    lblSkillResult.setText((holder + currentSkill.getRanks() + currentCharacter.getPERMod() + currentSkill.getOtherBonus()) + " (Critical)");
                } else if (holder == 1)
                {
                    lblSkillResult.setText((holder + currentSkill.getRanks() + currentCharacter.getPERMod() + currentSkill.getOtherBonus()) + " (Crit fail)");
                } else
                {
                    lblSkillResult.setText((holder + currentSkill.getRanks() + currentCharacter.getPERMod() + currentSkill.getOtherBonus()) + "");
                }
                break;
        }
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        cmbSelectDie = new javax.swing.JComboBox<>();
        btnRollDie = new javax.swing.JButton();
        lblDieResult = new javax.swing.JLabel();
        cmbSelectStat = new javax.swing.JComboBox<>();
        btnRollStat = new javax.swing.JButton();
        lblStatResult = new javax.swing.JLabel();
        cmbSelectSkill = new javax.swing.JComboBox<>();
        bntnRollSkill = new javax.swing.JButton();
        lblSkillResult = new javax.swing.JLabel();
        cmbSelectCustom1 = new javax.swing.JComboBox<>();
        btnRollCustom1 = new javax.swing.JButton();
        lblCustomResult1 = new javax.swing.JLabel();
        cmbSelectCustom2 = new javax.swing.JComboBox<>();
        btnRollCustom2 = new javax.swing.JButton();
        lblCustomResult2 = new javax.swing.JLabel();
        cmbSelectCustom3 = new javax.swing.JComboBox<>();
        btnRollCustom3 = new javax.swing.JButton();
        lblCustomResult3 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        btnManageRolls = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new javax.swing.BoxLayout(getContentPane(), javax.swing.BoxLayout.Y_AXIS));

        jPanel1.setLayout(new java.awt.GridLayout(6, 3));

        cmbSelectDie.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "4", "6", "8", "10", "12", "20", "100" }));
        cmbSelectDie.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbSelectDieActionPerformed(evt);
            }
        });
        jPanel1.add(cmbSelectDie);

        btnRollDie.setText("ROLL");
        btnRollDie.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRollDieActionPerformed(evt);
            }
        });
        jPanel1.add(btnRollDie);

        lblDieResult.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jPanel1.add(lblDieResult);

        cmbSelectStat.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "STR", "CON", "DEX", "AGI", "INT", "WIS", "CHA", "PER" }));
        cmbSelectStat.setMaximumSize(new java.awt.Dimension(150, 25));
        cmbSelectStat.setMinimumSize(new java.awt.Dimension(150, 25));
        cmbSelectStat.setPreferredSize(new java.awt.Dimension(150, 25));
        cmbSelectStat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbSelectStatActionPerformed(evt);
            }
        });
        jPanel1.add(cmbSelectStat);

        btnRollStat.setText("ROLL");
        btnRollStat.setMaximumSize(new java.awt.Dimension(50, 25));
        btnRollStat.setMinimumSize(new java.awt.Dimension(50, 25));
        btnRollStat.setPreferredSize(new java.awt.Dimension(50, 25));
        btnRollStat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRollStatActionPerformed(evt);
            }
        });
        jPanel1.add(btnRollStat);

        lblStatResult.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblStatResult.setMaximumSize(new java.awt.Dimension(50, 25));
        lblStatResult.setMinimumSize(new java.awt.Dimension(50, 25));
        lblStatResult.setPreferredSize(new java.awt.Dimension(50, 25));
        jPanel1.add(lblStatResult);

        cmbSelectSkill.setMaximumSize(new java.awt.Dimension(150, 25));
        cmbSelectSkill.setMinimumSize(new java.awt.Dimension(150, 25));
        cmbSelectSkill.setPreferredSize(new java.awt.Dimension(150, 25));
        cmbSelectSkill.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbSelectSkillActionPerformed(evt);
            }
        });
        jPanel1.add(cmbSelectSkill);

        bntnRollSkill.setText("ROLL");
        bntnRollSkill.setMaximumSize(new java.awt.Dimension(50, 25));
        bntnRollSkill.setMinimumSize(new java.awt.Dimension(50, 25));
        bntnRollSkill.setPreferredSize(new java.awt.Dimension(50, 25));
        bntnRollSkill.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntnRollSkillActionPerformed(evt);
            }
        });
        jPanel1.add(bntnRollSkill);

        lblSkillResult.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblSkillResult.setMaximumSize(new java.awt.Dimension(50, 25));
        lblSkillResult.setMinimumSize(new java.awt.Dimension(50, 25));
        lblSkillResult.setPreferredSize(new java.awt.Dimension(50, 25));
        jPanel1.add(lblSkillResult);

        cmbSelectCustom1.setMaximumSize(new java.awt.Dimension(150, 25));
        cmbSelectCustom1.setMinimumSize(new java.awt.Dimension(150, 25));
        cmbSelectCustom1.setPreferredSize(new java.awt.Dimension(150, 25));
        cmbSelectCustom1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbSelectCustom1ActionPerformed(evt);
            }
        });
        jPanel1.add(cmbSelectCustom1);

        btnRollCustom1.setText("ROLL");
        btnRollCustom1.setMaximumSize(new java.awt.Dimension(50, 25));
        btnRollCustom1.setMinimumSize(new java.awt.Dimension(50, 25));
        btnRollCustom1.setPreferredSize(new java.awt.Dimension(50, 25));
        btnRollCustom1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRollCustom1ActionPerformed(evt);
            }
        });
        jPanel1.add(btnRollCustom1);

        lblCustomResult1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCustomResult1.setMaximumSize(new java.awt.Dimension(50, 25));
        lblCustomResult1.setMinimumSize(new java.awt.Dimension(50, 25));
        lblCustomResult1.setPreferredSize(new java.awt.Dimension(50, 25));
        jPanel1.add(lblCustomResult1);

        cmbSelectCustom2.setMaximumSize(new java.awt.Dimension(150, 25));
        cmbSelectCustom2.setMinimumSize(new java.awt.Dimension(150, 25));
        cmbSelectCustom2.setPreferredSize(new java.awt.Dimension(150, 25));
        cmbSelectCustom2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbSelectCustom2ActionPerformed(evt);
            }
        });
        jPanel1.add(cmbSelectCustom2);

        btnRollCustom2.setText("ROLL");
        btnRollCustom2.setMaximumSize(new java.awt.Dimension(50, 25));
        btnRollCustom2.setMinimumSize(new java.awt.Dimension(50, 25));
        btnRollCustom2.setPreferredSize(new java.awt.Dimension(50, 25));
        btnRollCustom2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRollCustom2ActionPerformed(evt);
            }
        });
        jPanel1.add(btnRollCustom2);

        lblCustomResult2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCustomResult2.setMaximumSize(new java.awt.Dimension(50, 25));
        lblCustomResult2.setMinimumSize(new java.awt.Dimension(50, 25));
        lblCustomResult2.setPreferredSize(new java.awt.Dimension(50, 25));
        jPanel1.add(lblCustomResult2);

        cmbSelectCustom3.setMaximumSize(new java.awt.Dimension(150, 25));
        cmbSelectCustom3.setMinimumSize(new java.awt.Dimension(150, 25));
        cmbSelectCustom3.setPreferredSize(new java.awt.Dimension(150, 25));
        cmbSelectCustom3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbSelectCustom3ActionPerformed(evt);
            }
        });
        jPanel1.add(cmbSelectCustom3);

        btnRollCustom3.setText("ROLL");
        btnRollCustom3.setMaximumSize(new java.awt.Dimension(50, 25));
        btnRollCustom3.setMinimumSize(new java.awt.Dimension(50, 25));
        btnRollCustom3.setPreferredSize(new java.awt.Dimension(50, 25));
        btnRollCustom3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRollCustom3ActionPerformed(evt);
            }
        });
        jPanel1.add(btnRollCustom3);

        lblCustomResult3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblCustomResult3.setMaximumSize(new java.awt.Dimension(50, 25));
        lblCustomResult3.setMinimumSize(new java.awt.Dimension(50, 25));
        lblCustomResult3.setPreferredSize(new java.awt.Dimension(50, 25));
        jPanel1.add(lblCustomResult3);

        getContentPane().add(jPanel1);

        jPanel2.setLayout(new java.awt.GridLayout());

        btnManageRolls.setText("Manage custom rolls");
        btnManageRolls.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnManageRollsActionPerformed(evt);
            }
        });
        jPanel2.add(btnManageRolls);

        getContentPane().add(jPanel2);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cmbSelectStatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbSelectStatActionPerformed
        rollStat();
    }//GEN-LAST:event_cmbSelectStatActionPerformed

    private void btnRollStatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRollStatActionPerformed
        rollStat();
    }//GEN-LAST:event_btnRollStatActionPerformed

    private void cmbSelectSkillActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbSelectSkillActionPerformed
        if (cmbSelectSkill.getSelectedIndex() >= 0)
            currentSkill = skills.get(cmbSelectSkill.getSelectedIndex());
            rollSkill();
    }//GEN-LAST:event_cmbSelectSkillActionPerformed

    private void bntnRollSkillActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntnRollSkillActionPerformed
        if (cmbSelectSkill.getSelectedIndex() >= 0)
        {
            currentSkill = skills.get(cmbSelectSkill.getSelectedIndex());
            rollSkill();
        } else {JOptionPane.showMessageDialog(null, "No skill selected");}
    }//GEN-LAST:event_bntnRollSkillActionPerformed

    private void cmbSelectCustom1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbSelectCustom1ActionPerformed
        if (cmbSelectCustom1.getSelectedIndex() >= 0)
        {
            currentRoll = customRolls.get(cmbSelectCustom1.getSelectedIndex());
            holder = currentRoll.roll();
            if (currentRoll.getCrit())
            {
                lblCustomResult1.setText(holder + " (Critical)");
            } else if (currentRoll.getCritFail())
            {
                lblCustomResult1.setText(holder + " (Crit fail)");
            } else
            {
                lblCustomResult1.setText(holder + "");
            }
        }
    }//GEN-LAST:event_cmbSelectCustom1ActionPerformed

    private void btnRollCustom1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRollCustom1ActionPerformed
        if (cmbSelectCustom1.getSelectedIndex() >= 0)
        {
            currentRoll = customRolls.get(cmbSelectCustom1.getSelectedIndex());
            holder = currentRoll.roll();
            if (currentRoll.getCrit())
            {
                lblCustomResult1.setText(holder + " (Critical)");
            } else if (currentRoll.getCritFail())
            {
                lblCustomResult1.setText(holder + " (Crit fail)");
            } else
            {
                lblCustomResult1.setText(holder + "");
            }
        } else {JOptionPane.showMessageDialog(null, "No roll selected");}
    }//GEN-LAST:event_btnRollCustom1ActionPerformed

    private void cmbSelectCustom2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbSelectCustom2ActionPerformed
        if (cmbSelectCustom1.getSelectedIndex() >= 0)
        {
            currentRoll = customRolls.get(cmbSelectCustom2.getSelectedIndex());
            holder = currentRoll.roll();
            if (currentRoll.getCrit())
            {
                lblCustomResult2.setText(holder + " (Critical)");
            } else if (currentRoll.getCritFail())
            {
                lblCustomResult2.setText(holder + " (Crit fail)");
            } else
            {
                lblCustomResult2.setText(holder + "");
            }
        }
    }//GEN-LAST:event_cmbSelectCustom2ActionPerformed

    private void btnRollCustom2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRollCustom2ActionPerformed
        if (cmbSelectCustom1.getSelectedIndex() >= 0)
        {
            currentRoll = customRolls.get(cmbSelectCustom2.getSelectedIndex());
            holder = currentRoll.roll();
            if (currentRoll.getCrit())
            {
                lblCustomResult2.setText(holder + " (Critical)");
            } else if (currentRoll.getCritFail())
            {
                lblCustomResult2.setText(holder + " (Crit fail)");
            } else
            {
                lblCustomResult2.setText(holder + "");
            }
        } else {JOptionPane.showMessageDialog(null, "No roll selected");}
    }//GEN-LAST:event_btnRollCustom2ActionPerformed

    private void cmbSelectCustom3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbSelectCustom3ActionPerformed
        if (cmbSelectCustom1.getSelectedIndex() >= 0)
        {
            currentRoll = customRolls.get(cmbSelectCustom3.getSelectedIndex());
            holder = currentRoll.roll();
            if (currentRoll.getCrit())
            {
                lblCustomResult3.setText(holder + " (Critical)");
            } else if (currentRoll.getCritFail())
            {
                lblCustomResult3.setText(holder + " (Crit fail)");
            } else
            {
                lblCustomResult3.setText(holder + "");
            }
        }
    }//GEN-LAST:event_cmbSelectCustom3ActionPerformed

    private void btnRollCustom3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRollCustom3ActionPerformed
        if (cmbSelectCustom1.getSelectedIndex() >= 0)
        {
            currentRoll = customRolls.get(cmbSelectCustom3.getSelectedIndex());
            holder = currentRoll.roll();
            if (currentRoll.getCrit())
            {
                lblCustomResult3.setText(holder + " (Critical)");
            } else if (currentRoll.getCritFail())
            {
                lblCustomResult3.setText(holder + " (Crit fail)");
            } else
            {
                lblCustomResult3.setText(holder + "");
            }
        } else {JOptionPane.showMessageDialog(null, "No roll selected");}
    }//GEN-LAST:event_btnRollCustom3ActionPerformed

    private void cmbSelectDieActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbSelectDieActionPerformed
        switch (cmbSelectDie.getSelectedIndex())
        {
            case 0:
                lblDieResult.setText(dice.roll(4)+"");
                break;
            case 1:
                lblDieResult.setText(dice.roll(6)+"");
                break;
            case 2:
                lblDieResult.setText(dice.roll(8)+"");
                break;
            case 3:
                lblDieResult.setText(dice.roll(10)+"");
                break;
            case 4:
                lblDieResult.setText(dice.roll(12)+"");
                break;
            case 5:
                lblDieResult.setText(dice.roll(20)+"");
                break;
            case 6:
                lblDieResult.setText(dice.roll(100)+"");
                break;
        }
    }//GEN-LAST:event_cmbSelectDieActionPerformed

    private void btnRollDieActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRollDieActionPerformed
        switch (cmbSelectDie.getSelectedIndex())
        {
            case 0:
                lblDieResult.setText(dice.roll(4)+"");
                break;
            case 1:
                lblDieResult.setText(dice.roll(6)+"");
                break;
            case 2:
                lblDieResult.setText(dice.roll(8)+"");
                break;
            case 3:
                lblDieResult.setText(dice.roll(10)+"");
                break;
            case 4:
                lblDieResult.setText(dice.roll(12)+"");
                break;
            case 5:
                lblDieResult.setText(dice.roll(20)+"");
                break;
            case 6:
                lblDieResult.setText(dice.roll(100)+"");
                break;
        }
    }//GEN-LAST:event_btnRollDieActionPerformed

    private void btnManageRollsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnManageRollsActionPerformed
        rManager = new RollManager();
        rManager.setVisible(true);
    }//GEN-LAST:event_btnManageRollsActionPerformed

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
            java.util.logging.Logger.getLogger(Roller.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Roller.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Roller.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Roller.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Roller().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bntnRollSkill;
    private javax.swing.JButton btnManageRolls;
    private javax.swing.JButton btnRollCustom1;
    private javax.swing.JButton btnRollCustom2;
    private javax.swing.JButton btnRollCustom3;
    private javax.swing.JButton btnRollDie;
    private javax.swing.JButton btnRollStat;
    private javax.swing.JComboBox<String> cmbSelectCustom1;
    private javax.swing.JComboBox<String> cmbSelectCustom2;
    private javax.swing.JComboBox<String> cmbSelectCustom3;
    private javax.swing.JComboBox<String> cmbSelectDie;
    private javax.swing.JComboBox<String> cmbSelectSkill;
    private javax.swing.JComboBox<String> cmbSelectStat;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lblCustomResult1;
    private javax.swing.JLabel lblCustomResult2;
    private javax.swing.JLabel lblCustomResult3;
    private javax.swing.JLabel lblDieResult;
    private javax.swing.JLabel lblSkillResult;
    private javax.swing.JLabel lblStatResult;
    // End of variables declaration//GEN-END:variables
}
