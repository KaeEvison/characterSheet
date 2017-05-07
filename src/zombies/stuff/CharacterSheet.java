package zombies.stuff;

import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

public class CharacterSheet extends javax.swing.JFrame
{
    CharacterSheetOptions options;
    Character currentCharacter = new Character();
    
    public boolean basicEditable = false;
    public boolean levelEditable = false;
    public boolean statsEditable = false;
    public boolean skillsEditable = false;
    int holder = 0;
    
    ArrayList<String> skillNames = new ArrayList();
    ArrayList<String> traitNames = new ArrayList();
    ArrayList<String> noteNames = new ArrayList();
    String sHolder;
    
    public CharacterSheet()
    {
        initComponents();
        
        //Creates and displays an options panel linked to the character sheet
        options = new CharacterSheetOptions();
        options.setVisible(true);
    }
    
    //Method to update the UI elements for the character sheet using the values provided by the current character
    public void updateAll()
    {
        lblName.setText(currentCharacter.getName());
        lblClass.setText(currentCharacter.getPlayerClass());
        lblRace.setText(currentCharacter.getRace());
        lblGender.setText(currentCharacter.getGender());
        
        lblLevel.setText(currentCharacter.getLevel()+"");
        lblExperience.setText(currentCharacter.getExp() + "/" + currentCharacter.getNextExp());
        
        lblSTR.setText(currentCharacter.getSTR()+"");
        lblCON.setText(currentCharacter.getCON()+"");
        lblDEX.setText(currentCharacter.getDEX()+"");
        lblAGI.setText(currentCharacter.getAGI()+"");
        lblINT.setText(currentCharacter.getINT()+"");
        lblWIS.setText(currentCharacter.getWIS()+"");
        lblCHA.setText(currentCharacter.getCHA()+"");
        lblPER.setText(currentCharacter.getPER()+"");
        //Check whether stas are positive, if so add a "+" before the value
        if (currentCharacter.getSTRMod() >= 0)
            lblSTRMod.setText("+" + currentCharacter.getSTRMod());
        else
            lblSTRMod.setText(currentCharacter.getSTRMod()+"");
        if (currentCharacter.getCONMod() >= 0)
            lblCONMod.setText("+" + currentCharacter.getCONMod());
        else
            lblCONMod.setText(currentCharacter.getCONMod()+"");
        if (currentCharacter.getDEXMod() >= 0)
            lblDEXMod.setText("+" + currentCharacter.getDEXMod());
        else
            lblDEXMod.setText(currentCharacter.getDEXMod()+"");
        if (currentCharacter.getAGIMod() >= 0)
            lblAGIMod.setText("+" + currentCharacter.getAGIMod());
        else
            lblAGIMod.setText(currentCharacter.getAGIMod()+"");
        if (currentCharacter.getINTMod() >= 0)
            lblINTMod.setText("+" + currentCharacter.getINTMod());
        else
            lblINTMod.setText(currentCharacter.getINTMod()+"");
        if (currentCharacter.getWISMod() >= 0)
            lblWISMod.setText("+" + currentCharacter.getWISMod());
        else
            lblWISMod.setText(currentCharacter.getWISMod()+"");
        if (currentCharacter.getCHAMod() >= 0)
            lblCHAMod.setText("+" + currentCharacter.getCHAMod());
        else
            lblCHAMod.setText(currentCharacter.getCHAMod()+"");
        if (currentCharacter.getPERMod() >= 0)
            lblPERMod.setText("+" + currentCharacter.getPERMod());
        else
            lblPERMod.setText(currentCharacter.getPERMod()+"");
        
        //Retrieve and display names of skills
        skillNames.clear();
        for (int i = 0; i < currentCharacter.getSkills().size(); i++)
        {
            skillNames.add(currentCharacter.getSkills().get(i).getName());
        }
        lstSkills.setListData((String[]) skillNames.toArray(new String[0]));
        
        //Retrieve and display names of traits
        traitNames.clear();
        for (int i = 0; i < currentCharacter.getTraits().size(); i++)
        {
            traitNames.add(currentCharacter.getTraits().get(i).getName());
        }
        lstTraits.setListData((String[]) traitNames.toArray(new String[0]));
        
        //Retrieve and display names of notes
        noteNames.clear();
        for (int i = 0; i < currentCharacter.getNotes().size(); i++)
        {
            noteNames.add(currentCharacter.getNotes().get(i).getName());
        }
        cmbNotes.setModel(new DefaultComboBoxModel<String>(noteNames.toArray(new String[0])));
    }
    
    //Method to receieve a set of stats and record them for the current character
    public void receiveStats(int[] statHolder)
    {
        currentCharacter.setSTR(statHolder[0]);
        currentCharacter.setCON(statHolder[1]);
        currentCharacter.setDEX(statHolder[2]);
        currentCharacter.setAGI(statHolder[3]);
        currentCharacter.setINT(statHolder[4]);
        currentCharacter.setWIS(statHolder[5]);
        currentCharacter.setCHA(statHolder[6]);
        currentCharacter.setPER(statHolder[7]);
        currentCharacter.updateValues();
        updateAll();
    }
    
    //Method to update the UI with details of a specific skill when selected from the list
    private void skillDetails()
    {
        lblSkillStatTag.setText(currentCharacter.getSkills().get(lstSkills.getSelectedIndex()).getStat());
        //retrieve relevant modifier and check whether a '+' character is required
        switch (currentCharacter.getSkills().get(lstSkills.getSelectedIndex()).getStat())
        {
            case "STR":
                if (currentCharacter.getSTRMod() >= 0)
                    lblSkillStatBonus.setText("+" + currentCharacter.getSTRMod());
                else
                    lblSkillStatBonus.setText(currentCharacter.getSTRMod()+"");
                break;
            case "CON":
                if (currentCharacter.getCONMod() >= 0)
                    lblSkillStatBonus.setText("+" + currentCharacter.getCONMod());
                else
                    lblSkillStatBonus.setText(currentCharacter.getCONMod()+"");
                break;
            case "DEX":
                if (currentCharacter.getDEXMod() >= 0)
                    lblSkillStatBonus.setText("+" + currentCharacter.getDEXMod());
                else
                    lblSkillStatBonus.setText(currentCharacter.getDEXMod()+"");
                break;
            case "AGI":
                if (currentCharacter.getAGIMod() >= 0)
                    lblSkillStatBonus.setText("+" + currentCharacter.getAGIMod());
                else
                    lblSkillStatBonus.setText(currentCharacter.getAGIMod()+"");
                break;
            case "INT":
                if (currentCharacter.getINTMod() >= 0)
                    lblSkillStatBonus.setText("+" + currentCharacter.getINTMod());
                else
                    lblSkillStatBonus.setText(currentCharacter.getINTMod()+"");
                break;
            case "WIS":
                if (currentCharacter.getWISMod() >= 0)
                    lblSkillStatBonus.setText("+" + currentCharacter.getWISMod());
                else
                    lblSkillStatBonus.setText(currentCharacter.getWISMod()+"");
                break;
            case "CHA":
                if (currentCharacter.getCHAMod() >= 0)
                    lblSkillStatBonus.setText("+" + currentCharacter.getCHAMod());
                else
                    lblSkillStatBonus.setText(currentCharacter.getCHAMod()+"");
                break;
            case "PER":
                if (currentCharacter.getPERMod() >= 0)
                    lblSkillStatBonus.setText("+" + currentCharacter.getPERMod());
                else
                    lblSkillStatBonus.setText(currentCharacter.getPERMod()+"");
                break;
            default:
                lblSkillStatBonus.setText("");
        }
        lblSkillRanks.setText("+" + currentCharacter.getSkills().get(lstSkills.getSelectedIndex()).getRanks());
        //Check if a '+' character is required
        holder = currentCharacter.getSkills().get(lstSkills.getSelectedIndex()).getOtherBonus();
        if (holder >= 0)
            lblSkillOtherBonus.setText("+" + holder);
        else
            lblSkillOtherBonus.setText(holder+"");
        //Calculate and display total bonus
        try
        {
            holder = currentCharacter.getSkills().get(lstSkills.getSelectedIndex()).getRanks()
                     + currentCharacter.getSkills().get(lstSkills.getSelectedIndex()).getOtherBonus()
                     + Integer.parseInt(lblSkillStatBonus.getText());
            if (holder >= 0)
                lblSkillTotal.setText("+" + holder);
            else
                lblSkillTotal.setText(holder+"");
        } catch (NumberFormatException e)
        {
            //If an invalid or empty dependant stat was entered for the skill, exclude the value
            holder = currentCharacter.getSkills().get(lstSkills.getSelectedIndex()).getRanks()
                     + currentCharacter.getSkills().get(lstSkills.getSelectedIndex()).getOtherBonus();
            if (holder >= 0)
                lblSkillTotal.setText("+" + holder);
            else
                lblSkillTotal.setText(holder+"");
        }
    }
    
    //Method to update the UI with details of a specific trait when selected from the list
    private void traitDetails()
    {
        txtTraitDescription.setText(currentCharacter.getTraits().get(lstTraits.getSelectedIndex()).getDescription());
    }
    
    //Method to update the UI with details of a specific note when selected from the list
    private void noteDetails()
    {
        //Check that a note is currently selected
        if (cmbNotes.getSelectedIndex() >= 0)
        {
            //If a note is selected, display details and make the name and description areas editable
            txtNoteContent.setEditable(true);
            txtNoteName.setEditable(true);
            txtNoteName.setText(currentCharacter.getNotes().get(cmbNotes.getSelectedIndex()).getName());
            txtNoteContent.setText(currentCharacter.getNotes().get(cmbNotes.getSelectedIndex()).getContent());
        } else
        {
            //If a note is not selected (e.g. all have been deleted) disable editing on the name and description areas
            txtNoteContent.setEditable(false);
            txtNoteName.setEditable(false);
        }
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        pnlBasicInfo = new javax.swing.JPanel();
        lblNameTag = new javax.swing.JLabel();
        lblName = new javax.swing.JLabel();
        lblClassTag = new javax.swing.JLabel();
        lblClass = new javax.swing.JLabel();
        lblRaceTag = new javax.swing.JLabel();
        lblRace = new javax.swing.JLabel();
        lblGenderTag = new javax.swing.JLabel();
        lblGender = new javax.swing.JLabel();
        pnlLevel = new javax.swing.JPanel();
        lblLevelTag = new javax.swing.JLabel();
        lblExperienceTag = new javax.swing.JLabel();
        lblLevel = new javax.swing.JLabel();
        lblExperience = new javax.swing.JLabel();
        pnlStats = new javax.swing.JPanel();
        lblSTRTag = new javax.swing.JLabel();
        lblSTR = new javax.swing.JLabel();
        lblSTRMod = new javax.swing.JLabel();
        lblIINTTag = new javax.swing.JLabel();
        lblINT = new javax.swing.JLabel();
        lblINTMod = new javax.swing.JLabel();
        lblCONTag = new javax.swing.JLabel();
        lblCON = new javax.swing.JLabel();
        lblCONMod = new javax.swing.JLabel();
        lblWISTag = new javax.swing.JLabel();
        lblWIS = new javax.swing.JLabel();
        lblWISMod = new javax.swing.JLabel();
        lblDEXTag = new javax.swing.JLabel();
        lblDEX = new javax.swing.JLabel();
        lblDEXMod = new javax.swing.JLabel();
        lblCHATag = new javax.swing.JLabel();
        lblCHA = new javax.swing.JLabel();
        lblCHAMod = new javax.swing.JLabel();
        lblAGITag = new javax.swing.JLabel();
        lblAGI = new javax.swing.JLabel();
        lblAGIMod = new javax.swing.JLabel();
        lblPERTag = new javax.swing.JLabel();
        lblPER = new javax.swing.JLabel();
        lblPERMod = new javax.swing.JLabel();
        pnlSkills = new javax.swing.JPanel();
        pnlSkillsList = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        lstSkills = new javax.swing.JList<>();
        pnlSkillsDetails = new javax.swing.JPanel();
        lblSkillStatTag = new javax.swing.JLabel();
        lblSkillStatBonus = new javax.swing.JLabel();
        lblSkillRanksTag = new javax.swing.JLabel();
        lblSkillRanks = new javax.swing.JLabel();
        lblSkillOtherTag = new javax.swing.JLabel();
        lblSkillOtherBonus = new javax.swing.JLabel();
        lblSkillTotalTag = new javax.swing.JLabel();
        lblSkillTotal = new javax.swing.JLabel();
        pnlTraits = new javax.swing.JPanel();
        pnlTraitList = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        lstTraits = new javax.swing.JList<>();
        pnlTraitDescription = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        txtTraitDescription = new javax.swing.JTextArea();
        pnlNoteOptions = new javax.swing.JPanel();
        cmbNotes = new javax.swing.JComboBox<>();
        btnAddNote = new javax.swing.JButton();
        btnDeleteNote = new javax.swing.JButton();
        txtNoteName = new javax.swing.JTextField();
        pnlNoteContent = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        txtNoteContent = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setLocation(new java.awt.Point(475, 0));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        getContentPane().setLayout(new java.awt.GridLayout(1, 0));

        jPanel1.setLayout(new javax.swing.BoxLayout(jPanel1, javax.swing.BoxLayout.Y_AXIS));

        pnlBasicInfo.setBackground(new java.awt.Color(255, 255, 255));
        pnlBasicInfo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        pnlBasicInfo.setMaximumSize(new java.awt.Dimension(400, 75));
        pnlBasicInfo.setMinimumSize(new java.awt.Dimension(400, 75));
        pnlBasicInfo.setPreferredSize(new java.awt.Dimension(400, 75));
        pnlBasicInfo.setLayout(new java.awt.GridLayout(4, 2));

        lblNameTag.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNameTag.setText("Name:");
        pnlBasicInfo.add(lblNameTag);

        lblName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblName.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblNameMouseClicked(evt);
            }
        });
        pnlBasicInfo.add(lblName);

        lblClassTag.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblClassTag.setText("Class:");
        pnlBasicInfo.add(lblClassTag);

        lblClass.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblClass.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblClassMouseClicked(evt);
            }
        });
        pnlBasicInfo.add(lblClass);

        lblRaceTag.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblRaceTag.setText("Race:");
        pnlBasicInfo.add(lblRaceTag);

        lblRace.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblRace.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblRaceMouseClicked(evt);
            }
        });
        pnlBasicInfo.add(lblRace);

        lblGenderTag.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblGenderTag.setText("Gender:");
        pnlBasicInfo.add(lblGenderTag);

        lblGender.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblGender.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblGenderMouseClicked(evt);
            }
        });
        pnlBasicInfo.add(lblGender);

        jPanel1.add(pnlBasicInfo);

        pnlLevel.setBackground(new java.awt.Color(255, 255, 255));
        pnlLevel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        pnlLevel.setMaximumSize(new java.awt.Dimension(400, 35));
        pnlLevel.setMinimumSize(new java.awt.Dimension(400, 35));
        pnlLevel.setPreferredSize(new java.awt.Dimension(400, 35));
        pnlLevel.setLayout(new java.awt.GridLayout(2, 2));

        lblLevelTag.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblLevelTag.setText("Level");
        pnlLevel.add(lblLevelTag);

        lblExperienceTag.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblExperienceTag.setText("Experience");
        pnlLevel.add(lblExperienceTag);

        lblLevel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblLevel.setText("1");
        lblLevel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblLevelMouseClicked(evt);
            }
        });
        pnlLevel.add(lblLevel);

        lblExperience.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblExperience.setText("0/1000");
        lblExperience.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblExperienceMouseClicked(evt);
            }
        });
        pnlLevel.add(lblExperience);

        jPanel1.add(pnlLevel);

        pnlStats.setBackground(new java.awt.Color(255, 255, 255));
        pnlStats.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        pnlStats.setMaximumSize(new java.awt.Dimension(400, 75));
        pnlStats.setMinimumSize(new java.awt.Dimension(400, 75));
        pnlStats.setPreferredSize(new java.awt.Dimension(400, 75));
        pnlStats.setLayout(new java.awt.GridLayout(4, 6));

        lblSTRTag.setText("STR:");
        pnlStats.add(lblSTRTag);

        lblSTR.setText("10");
        lblSTR.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblSTRMouseClicked(evt);
            }
        });
        pnlStats.add(lblSTR);

        lblSTRMod.setText("+0");
        pnlStats.add(lblSTRMod);

        lblIINTTag.setText("INT:");
        pnlStats.add(lblIINTTag);

        lblINT.setText("10");
        lblINT.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblINTMouseClicked(evt);
            }
        });
        pnlStats.add(lblINT);

        lblINTMod.setText("+0");
        pnlStats.add(lblINTMod);

        lblCONTag.setText("CON:");
        pnlStats.add(lblCONTag);

        lblCON.setText("10");
        lblCON.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblCONMouseClicked(evt);
            }
        });
        pnlStats.add(lblCON);

        lblCONMod.setText("+0");
        pnlStats.add(lblCONMod);

        lblWISTag.setText("WIS:");
        pnlStats.add(lblWISTag);

        lblWIS.setText("10");
        lblWIS.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblWISMouseClicked(evt);
            }
        });
        pnlStats.add(lblWIS);

        lblWISMod.setText("+0");
        pnlStats.add(lblWISMod);

        lblDEXTag.setText("DEX:");
        pnlStats.add(lblDEXTag);

        lblDEX.setText("10");
        lblDEX.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblDEXMouseClicked(evt);
            }
        });
        pnlStats.add(lblDEX);

        lblDEXMod.setText("+0");
        pnlStats.add(lblDEXMod);

        lblCHATag.setText("CHA:");
        pnlStats.add(lblCHATag);

        lblCHA.setText("10");
        lblCHA.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblCHAMouseClicked(evt);
            }
        });
        pnlStats.add(lblCHA);

        lblCHAMod.setText("+0");
        pnlStats.add(lblCHAMod);

        lblAGITag.setText("AGI:");
        pnlStats.add(lblAGITag);

        lblAGI.setText("10");
        lblAGI.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblAGIMouseClicked(evt);
            }
        });
        pnlStats.add(lblAGI);

        lblAGIMod.setText("+0");
        pnlStats.add(lblAGIMod);

        lblPERTag.setText("PER:");
        pnlStats.add(lblPERTag);

        lblPER.setText("10");
        lblPER.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblPERMouseClicked(evt);
            }
        });
        pnlStats.add(lblPER);

        lblPERMod.setText("+0");
        pnlStats.add(lblPERMod);

        jPanel1.add(pnlStats);

        pnlSkills.setBackground(new java.awt.Color(255, 255, 255));
        pnlSkills.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        pnlSkills.setMaximumSize(new java.awt.Dimension(400, 75));
        pnlSkills.setMinimumSize(new java.awt.Dimension(400, 75));
        pnlSkills.setPreferredSize(new java.awt.Dimension(400, 75));
        pnlSkills.setLayout(new javax.swing.BoxLayout(pnlSkills, javax.swing.BoxLayout.LINE_AXIS));

        pnlSkillsList.setMaximumSize(new java.awt.Dimension(200, 125));
        pnlSkillsList.setMinimumSize(new java.awt.Dimension(200, 125));
        pnlSkillsList.setPreferredSize(new java.awt.Dimension(200, 125));
        pnlSkillsList.setLayout(new java.awt.GridLayout(1, 0));

        lstSkills.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                lstSkillsValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(lstSkills);

        pnlSkillsList.add(jScrollPane1);

        pnlSkills.add(pnlSkillsList);

        pnlSkillsDetails.setMaximumSize(new java.awt.Dimension(200, 125));
        pnlSkillsDetails.setMinimumSize(new java.awt.Dimension(200, 125));
        pnlSkillsDetails.setLayout(new java.awt.GridLayout(4, 2));

        lblSkillStatTag.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblSkillStatTag.setText("STR");
        pnlSkillsDetails.add(lblSkillStatTag);

        lblSkillStatBonus.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblSkillStatBonus.setText("+0");
        pnlSkillsDetails.add(lblSkillStatBonus);

        lblSkillRanksTag.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblSkillRanksTag.setText("Ranks");
        pnlSkillsDetails.add(lblSkillRanksTag);

        lblSkillRanks.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblSkillRanks.setText("0");
        pnlSkillsDetails.add(lblSkillRanks);

        lblSkillOtherTag.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblSkillOtherTag.setText("Other bonuses");
        pnlSkillsDetails.add(lblSkillOtherTag);

        lblSkillOtherBonus.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblSkillOtherBonus.setText("+0");
        pnlSkillsDetails.add(lblSkillOtherBonus);

        lblSkillTotalTag.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblSkillTotalTag.setText("Total modifier");
        pnlSkillsDetails.add(lblSkillTotalTag);

        lblSkillTotal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblSkillTotal.setText("+0");
        pnlSkillsDetails.add(lblSkillTotal);

        pnlSkills.add(pnlSkillsDetails);

        jPanel1.add(pnlSkills);

        pnlTraits.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        pnlTraits.setMaximumSize(new java.awt.Dimension(400, 75));
        pnlTraits.setMinimumSize(new java.awt.Dimension(400, 75));
        pnlTraits.setPreferredSize(new java.awt.Dimension(400, 75));
        pnlTraits.setLayout(new javax.swing.BoxLayout(pnlTraits, javax.swing.BoxLayout.LINE_AXIS));

        pnlTraitList.setMaximumSize(new java.awt.Dimension(200, 75));
        pnlTraitList.setMinimumSize(new java.awt.Dimension(200, 75));
        pnlTraitList.setLayout(new java.awt.GridLayout(1, 0));

        lstTraits.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                lstTraitsValueChanged(evt);
            }
        });
        jScrollPane3.setViewportView(lstTraits);

        pnlTraitList.add(jScrollPane3);

        pnlTraits.add(pnlTraitList);

        pnlTraitDescription.setMaximumSize(new java.awt.Dimension(200, 75));
        pnlTraitDescription.setMinimumSize(new java.awt.Dimension(200, 75));
        pnlTraitDescription.setPreferredSize(new java.awt.Dimension(200, 75));
        pnlTraitDescription.setLayout(new java.awt.GridLayout(1, 0));

        jScrollPane4.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        txtTraitDescription.setEditable(false);
        txtTraitDescription.setColumns(20);
        txtTraitDescription.setLineWrap(true);
        txtTraitDescription.setRows(5);
        txtTraitDescription.setToolTipText("");
        txtTraitDescription.setWrapStyleWord(true);
        jScrollPane4.setViewportView(txtTraitDescription);

        pnlTraitDescription.add(jScrollPane4);

        pnlTraits.add(pnlTraitDescription);

        jPanel1.add(pnlTraits);

        pnlNoteOptions.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        pnlNoteOptions.setMaximumSize(new java.awt.Dimension(400, 25));
        pnlNoteOptions.setMinimumSize(new java.awt.Dimension(400, 25));
        pnlNoteOptions.setPreferredSize(new java.awt.Dimension(400, 25));
        pnlNoteOptions.setLayout(new java.awt.GridLayout(1, 4));

        cmbNotes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbNotesActionPerformed(evt);
            }
        });
        pnlNoteOptions.add(cmbNotes);

        btnAddNote.setText("New note");
        btnAddNote.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddNoteActionPerformed(evt);
            }
        });
        pnlNoteOptions.add(btnAddNote);

        btnDeleteNote.setText("Delete");
        btnDeleteNote.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteNoteActionPerformed(evt);
            }
        });
        pnlNoteOptions.add(btnDeleteNote);

        txtNoteName.setEditable(false);
        txtNoteName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNoteNameKeyReleased(evt);
            }
        });
        pnlNoteOptions.add(txtNoteName);

        jPanel1.add(pnlNoteOptions);

        pnlNoteContent.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        pnlNoteContent.setMaximumSize(new java.awt.Dimension(400, 75));
        pnlNoteContent.setMinimumSize(new java.awt.Dimension(400, 75));
        pnlNoteContent.setPreferredSize(new java.awt.Dimension(400, 75));
        pnlNoteContent.setLayout(new java.awt.GridLayout(1, 0));

        txtNoteContent.setEditable(false);
        txtNoteContent.setColumns(20);
        txtNoteContent.setLineWrap(true);
        txtNoteContent.setRows(5);
        txtNoteContent.setWrapStyleWord(true);
        txtNoteContent.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNoteContentKeyReleased(evt);
            }
        });
        jScrollPane5.setViewportView(txtNoteContent);

        pnlNoteContent.add(jScrollPane5);

        jPanel1.add(pnlNoteContent);

        jScrollPane2.setViewportView(jPanel1);

        getContentPane().add(jScrollPane2);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        //close only this panel rather than the program as a whole
        options.dispose();
    }//GEN-LAST:event_formWindowClosing

    private void lblNameMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblNameMouseClicked
        //Check editing is currently allowed
        if (basicEditable)
        {
            //request new input and update character
            currentCharacter.setName(JOptionPane.showInputDialog("Enter new name:"));
            updateAll();
        }
    }//GEN-LAST:event_lblNameMouseClicked

    private void lblClassMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblClassMouseClicked
        //Check editing is currently allowed
        if (basicEditable)
        {
            //request new input and update character
            currentCharacter.setPlayerClass(JOptionPane.showInputDialog("Enter new class:"));
            updateAll();
        }
    }//GEN-LAST:event_lblClassMouseClicked

    private void lblRaceMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblRaceMouseClicked
        //Check editing is currently allowed
        if (basicEditable)
        {
            //request new input and update character
            currentCharacter.setRace(JOptionPane.showInputDialog("Enter new race:"));
            updateAll();
        }
    }//GEN-LAST:event_lblRaceMouseClicked

    private void lblGenderMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblGenderMouseClicked
        //Check editing is currently allowed
        if (basicEditable)
        {
            //request new input and update character
            currentCharacter.setGender(JOptionPane.showInputDialog("Enter new gender:"));
            updateAll();
        }
    }//GEN-LAST:event_lblGenderMouseClicked

    private void lblLevelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblLevelMouseClicked
        //Check editing is currently allowed
        if (levelEditable)
        {
            //Request new value
            sHolder = JOptionPane.showInputDialog("Enter new level:");
            //Check that the user hasn't pressed cancel
            if (sHolder != null)
            {
                try
                {
                    //Update value and redisplay
                    currentCharacter.setLevel(Integer.parseInt(sHolder));
                    updateAll();
                } catch (NumberFormatException e)
                {
                    //If the entered value was not a valid number
                    JOptionPane.showMessageDialog(null, "Invalid entry");
                }
            }
        }
    }//GEN-LAST:event_lblLevelMouseClicked

    private void lblExperienceMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblExperienceMouseClicked
        //Check editing is currently allowed
        if (levelEditable)
        {
            //request new input for first value
            sHolder = JOptionPane.showInputDialog("Enter new experience amount:");
            //Check that the user didn't cancel
            if (sHolder != null)
            {
                try
                {
                    //Update value and UI
                    currentCharacter.setExp(Integer.parseInt(sHolder));
                    updateAll();
                } catch (NumberFormatException e)
                {
                    //Inform user if input was invalid
                    JOptionPane.showMessageDialog(null, "Invalid input");
                }
            }
            //As above for second value
            sHolder = JOptionPane.showInputDialog("Enter new experience target:");
            if (sHolder != null)
            {
                try
                {
                    currentCharacter.setNextExp(Integer.parseInt(sHolder));
                    updateAll();
                } catch (NumberFormatException ex)
                {
                    JOptionPane.showMessageDialog(null, "Invalid input");
                }
            } else {updateAll();}
        }
    }//GEN-LAST:event_lblExperienceMouseClicked

    private void lblSTRMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblSTRMouseClicked
        //Check editing is currently allowed
        if (statsEditable)
        {
            //request new input
            sHolder = JOptionPane.showInputDialog("Enter new STR:");
            //Check that user didn't cancel
            if (sHolder != null)
            {
                try
                {
                    //Update values and UI
                    currentCharacter.setSTR(Integer.parseInt(sHolder));
                    currentCharacter.updateValues();
                    updateAll();
                } catch (NumberFormatException e)
                {
                    //Inform user if input was invalid
                    JOptionPane.showMessageDialog(null, "Invalid input");
                }
            }
        }
    }//GEN-LAST:event_lblSTRMouseClicked

    private void lblCONMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCONMouseClicked
        //Check editing is currently allowed
        if (statsEditable)
        {
            //request new input
            sHolder = JOptionPane.showInputDialog("Enter new CON:");
            //Check that user didn't cancel
            if (sHolder != null)
            {
                try
                {
                    //Update values and UI
                    currentCharacter.setCON(Integer.parseInt(sHolder));
                    currentCharacter.updateValues();
                    updateAll();
                } catch (NumberFormatException e)
                {
                    //Inform user if input was invalid
                    JOptionPane.showMessageDialog(null, "Invalid input");
                }
            }
        }
    }//GEN-LAST:event_lblCONMouseClicked

    private void lblDEXMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblDEXMouseClicked
        //Check editing is currently allowed
        if (statsEditable)
        {
            //request new input
            sHolder = JOptionPane.showInputDialog("Enter new DEX:");
            //Check that user didn't cancel
            if (sHolder != null)
            {
                try
                {
                    //Update values and UI
                    currentCharacter.setDEX(Integer.parseInt(sHolder));
                    currentCharacter.updateValues();
                    updateAll();
                } catch (NumberFormatException e)
                {
                    //Inform user if input was invalid
                    JOptionPane.showMessageDialog(null, "Invalid input");
                }
            }
        }
    }//GEN-LAST:event_lblDEXMouseClicked

    private void lblAGIMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblAGIMouseClicked
        //Check editing is currently allowed
        if (statsEditable)
        {
            //request new input
            sHolder = JOptionPane.showInputDialog("Enter new AGI:");
            //Check that user didn't cancel
            if (sHolder != null)
            {
                try
                {
                    //Update values and UI
                    currentCharacter.setAGI(Integer.parseInt(sHolder));
                    currentCharacter.updateValues();
                    updateAll();
                } catch (NumberFormatException e)
                {
                    //Inform user if input was invalid
                    JOptionPane.showMessageDialog(null, "Invalid input");
                }
            }
        }
    }//GEN-LAST:event_lblAGIMouseClicked

    private void lblINTMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblINTMouseClicked
        //Check editing is currently allowed
        if (statsEditable)
        {
            //request new input
            sHolder = JOptionPane.showInputDialog("Enter new INT:");
            //Check that user didn't cancel
            if (sHolder != null)
            {
                try
                {
                    //Update values and UI
                    currentCharacter.setINT(Integer.parseInt(sHolder));
                    currentCharacter.updateValues();
                    updateAll();
                } catch (NumberFormatException e)
                {
                    //Inform user if input was invalid
                    JOptionPane.showMessageDialog(null, "Invalid input");
                }
            }
        }
    }//GEN-LAST:event_lblINTMouseClicked

    private void lblWISMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblWISMouseClicked
        //Check editing is currently allowed
        if (statsEditable)
        {
            //request new input
            sHolder = JOptionPane.showInputDialog("Enter new WIS:");
            //Check that user didn't cancel
            if (sHolder != null)
            {
                try
                {
                    //Update values and UI
                    currentCharacter.setWIS(Integer.parseInt(sHolder));
                    currentCharacter.updateValues();
                    updateAll();
                } catch (NumberFormatException e)
                {
                    //Inform user if input was invalid
                    JOptionPane.showMessageDialog(null, "Invalid input");
                }
            }
        }
    }//GEN-LAST:event_lblWISMouseClicked

    private void lblCHAMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblCHAMouseClicked
        //Check editing is currently allowed
        if (statsEditable)
        {
            //request new input
            sHolder = JOptionPane.showInputDialog("Enter new CHA:");
            //Check that user didn't cancel
            if (sHolder != null)
            {
                try
                {
                    //Update values and UI
                    currentCharacter.setCHA(Integer.parseInt(sHolder));
                    currentCharacter.updateValues();
                    updateAll();
                } catch (NumberFormatException e)
                {
                    //Inform user if input was invalid
                    JOptionPane.showMessageDialog(null, "Invalid input");
                }
            }
        }
    }//GEN-LAST:event_lblCHAMouseClicked

    private void lblPERMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblPERMouseClicked
        //Check editing is currently allowed
        if (statsEditable)
        {
            //request new input
            sHolder = JOptionPane.showInputDialog("Enter new PER:");
            //Check that user didn't cancel
            if (sHolder != null)
            {
                try
                {
                    //Update values and UI
                    currentCharacter.setPER(Integer.parseInt(sHolder));
                    currentCharacter.updateValues();
                    updateAll();
                } catch (NumberFormatException e)
                {
                    //Inform user if input was invalid
                    JOptionPane.showMessageDialog(null, "Invalid input");
                }
            }
        }
    }//GEN-LAST:event_lblPERMouseClicked

    private void lstSkillsValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_lstSkillsValueChanged
        //Update when a skill is selected from the list
        if (lstSkills.getSelectedIndex() >= 0)
            skillDetails();
    }//GEN-LAST:event_lstSkillsValueChanged

    private void lstTraitsValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_lstTraitsValueChanged
        //Update when a trait is selected from the list
        if (lstTraits.getSelectedIndex() >= 0)
            traitDetails();
        else
            txtTraitDescription.setText("");
    }//GEN-LAST:event_lstTraitsValueChanged

    private void btnAddNoteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddNoteActionPerformed
        //Request name for new note
        sHolder = JOptionPane.showInputDialog("Enter note name");
        //Check that the user didn't select cancel
        if (sHolder != null)
        {
            //Create new note
            currentCharacter.addNote(sHolder);
            updateAll();
        }
    }//GEN-LAST:event_btnAddNoteActionPerformed

    private void btnDeleteNoteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteNoteActionPerformed
        //Check that a note is selected
        if (cmbNotes.getSelectedIndex() >= 0)
        {
            //Request confirmation from the user
            if (JOptionPane.showConfirmDialog(null, "Delete this note?") == 0)
            {
                //Delete note
                currentCharacter.removeNote(cmbNotes.getSelectedIndex());
                 //Clear details
                txtNoteContent.setText("");
                txtNoteName.setText("");
                cmbNotes.setSelectedIndex(-1);
            }
        } else
        {
            JOptionPane.showMessageDialog(null, "No note selected");
        }
        updateAll();
    }//GEN-LAST:event_btnDeleteNoteActionPerformed

    private void cmbNotesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbNotesActionPerformed
        //Update when a note is selected from the list
        noteDetails();
    }//GEN-LAST:event_cmbNotesActionPerformed

    private void txtNoteContentKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNoteContentKeyReleased
        //Update note content whenever the user makes modifications
        currentCharacter.getNotes().get(cmbNotes.getSelectedIndex()).setContent(txtNoteContent.getText());
    }//GEN-LAST:event_txtNoteContentKeyReleased

    private void txtNoteNameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNoteNameKeyReleased
        //Update note name whenever the user makes modifications
        //Since the list will be updated, the index of the note being renamed is stored and retrieved
        holder = cmbNotes.getSelectedIndex();
        currentCharacter.getNotes().get(cmbNotes.getSelectedIndex()).setName(txtNoteName.getText());
        updateAll();
        cmbNotes.setSelectedIndex(holder);
    }//GEN-LAST:event_txtNoteNameKeyReleased

    
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
            java.util.logging.Logger.getLogger(CharacterSheet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CharacterSheet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CharacterSheet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CharacterSheet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CharacterSheet().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddNote;
    private javax.swing.JButton btnDeleteNote;
    private javax.swing.JComboBox<String> cmbNotes;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JLabel lblAGI;
    private javax.swing.JLabel lblAGIMod;
    private javax.swing.JLabel lblAGITag;
    private javax.swing.JLabel lblCHA;
    private javax.swing.JLabel lblCHAMod;
    private javax.swing.JLabel lblCHATag;
    private javax.swing.JLabel lblCON;
    private javax.swing.JLabel lblCONMod;
    private javax.swing.JLabel lblCONTag;
    public javax.swing.JLabel lblClass;
    private javax.swing.JLabel lblClassTag;
    private javax.swing.JLabel lblDEX;
    private javax.swing.JLabel lblDEXMod;
    private javax.swing.JLabel lblDEXTag;
    private javax.swing.JLabel lblExperience;
    private javax.swing.JLabel lblExperienceTag;
    public javax.swing.JLabel lblGender;
    private javax.swing.JLabel lblGenderTag;
    private javax.swing.JLabel lblIINTTag;
    private javax.swing.JLabel lblINT;
    private javax.swing.JLabel lblINTMod;
    private javax.swing.JLabel lblLevel;
    private javax.swing.JLabel lblLevelTag;
    public javax.swing.JLabel lblName;
    private javax.swing.JLabel lblNameTag;
    private javax.swing.JLabel lblPER;
    private javax.swing.JLabel lblPERMod;
    private javax.swing.JLabel lblPERTag;
    public javax.swing.JLabel lblRace;
    private javax.swing.JLabel lblRaceTag;
    private javax.swing.JLabel lblSTR;
    private javax.swing.JLabel lblSTRMod;
    private javax.swing.JLabel lblSTRTag;
    private javax.swing.JLabel lblSkillOtherBonus;
    private javax.swing.JLabel lblSkillOtherTag;
    private javax.swing.JLabel lblSkillRanks;
    private javax.swing.JLabel lblSkillRanksTag;
    private javax.swing.JLabel lblSkillStatBonus;
    private javax.swing.JLabel lblSkillStatTag;
    private javax.swing.JLabel lblSkillTotal;
    private javax.swing.JLabel lblSkillTotalTag;
    private javax.swing.JLabel lblWIS;
    private javax.swing.JLabel lblWISMod;
    private javax.swing.JLabel lblWISTag;
    private javax.swing.JList<String> lstSkills;
    private javax.swing.JList<String> lstTraits;
    public javax.swing.JPanel pnlBasicInfo;
    public javax.swing.JPanel pnlLevel;
    public javax.swing.JPanel pnlNoteContent;
    public javax.swing.JPanel pnlNoteOptions;
    public javax.swing.JPanel pnlSkills;
    private javax.swing.JPanel pnlSkillsDetails;
    private javax.swing.JPanel pnlSkillsList;
    public javax.swing.JPanel pnlStats;
    private javax.swing.JPanel pnlTraitDescription;
    private javax.swing.JPanel pnlTraitList;
    public javax.swing.JPanel pnlTraits;
    private javax.swing.JTextArea txtNoteContent;
    private javax.swing.JTextField txtNoteName;
    private javax.swing.JTextArea txtTraitDescription;
    // End of variables declaration//GEN-END:variables
}
