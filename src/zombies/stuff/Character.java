package zombies.stuff;

import java.io.Serializable;
import java.util.ArrayList;

public class Character implements Serializable
{
    private static final long serialVersionUID = 2L;
    
    private String name;
    private String playerClass;
    private String race;
    private String gender;
    
    private int level;
    private int currentExperience;
    private int toNextLevel;
    
    private int STR, CON, DEX, AGI, INT, WIS, CHA, PER;
    private int STRMod, CONMod, DEXMod, AGIMod, INTMod, WISMod, CHAMod, PERMod;
    
    private ArrayList<Skill> skills = new ArrayList();
    private ArrayList<Skill> skillHolder = new ArrayList();
    
    private ArrayList<Trait> traits = new ArrayList();
    private ArrayList<Trait> traitHolder = new ArrayList();
    
    private ArrayList<Note> notes = new ArrayList();
    private ArrayList<Note> noteHolder = new ArrayList();
    
    private ArrayList<Equipment> equipment = new ArrayList();
    private ArrayList<Equipment> equipmentHolder = new ArrayList();
    
    private ArrayList<CustomRoll> rolls = new ArrayList();
    private ArrayList<CustomRoll> rollsHolder = new ArrayList();
    
    
    
    public Character(){name = "New character";}
    //Constructor for making a copy of an existing character
    public Character(Character toCopy)
    {
        name = toCopy.getName();
        playerClass = toCopy.getPlayerClass();
        race = toCopy.getRace();
        gender = toCopy.getGender();
        
        level = toCopy.getLevel();
        currentExperience = toCopy.getExp();
        toNextLevel = toCopy.getNextExp();
        
        STR = toCopy.getSTR();
        CON = toCopy.getCON();
        DEX = toCopy.getDEX();
        AGI = toCopy.getAGI();
        INT = toCopy.getINT();
        WIS = toCopy.getWIS();
        CHA = toCopy.getCHA();
        PER = toCopy.getPER();
        
        skills = copySkills(toCopy.getSkills());
        traits = copyTraits(toCopy.getTraits());
        notes = copyNotes(toCopy.getNotes());
        //Catches older character saves that dont have equipment, allowing those characters to be 'updated' by copy/pasting them
        if (toCopy.getEquipment() != null)
            equipment = copyEquipment(toCopy.getEquipment());
        else
            equipment = new ArrayList();
        //As above
        if (toCopy.getRolls() != null)
            rolls = copyRolls(toCopy.getRolls());
        else
            rolls = new ArrayList();
    }
    
    
    
    //GETTERS AND SETTERS
    
    //Basic info
    public String getName(){return name;}
    public void setName(String newName){name = newName;}
    
    public String getPlayerClass(){return playerClass;}
    public void setPlayerClass(String newPlayerClass){playerClass = newPlayerClass;}
    
    public String getRace(){return race;}
    public void setRace(String newRace){race = newRace;}
    
    public String getGender(){return gender;}
    public void setGender(String newGender){gender = newGender;}
    
    
    //Level and EXP
    public int getLevel(){return level;}
    public void setLevel(int newLevel){level = newLevel;}
    
    public int getExp(){return currentExperience;}
    public void setExp(int newExp){currentExperience = newExp;}
    
    public int getNextExp(){return toNextLevel;}
    public void setNextExp(int newNextExp){toNextLevel = newNextExp;}
    
    
    //Stats
    public int getSTR(){return STR;}
    public void setSTR(int newSTR){STR = newSTR;}
    
    public int getCON(){return CON;}
    public void setCON(int newCON){CON = newCON;}
    
    public int getDEX(){return DEX;}
    public void setDEX(int newDEX){DEX = newDEX;}
    
    public int getAGI(){return AGI;}
    public void setAGI(int newAGI){AGI = newAGI;}
    
    public int getINT(){return INT;}
    public void setINT(int newINT){INT = newINT;}
    
    public int getWIS(){return WIS;}
    public void setWIS(int newWIS){WIS = newWIS;}
    
    public int getCHA(){return CHA;}
    public void setCHA(int newCHA){CHA = newCHA;}
    
    public int getPER(){return PER;}
    public void setPER(int newPER){PER = newPER;}
    
    public int getSTRMod(){return STRMod;}
    public void setSTRMod(int newSTRMod){STRMod = newSTRMod;}
    
    public int getCONMod(){return CONMod;}
    public void setCONMod(int newCONMod){CONMod = newCONMod;}
    
    public int getDEXMod(){return DEXMod;}
    public void setDEXMod(int newDEXMod){DEXMod = newDEXMod;}
    
    public int getAGIMod(){return AGIMod;}
    public void setAGIMod(int newAGIMod){AGIMod = newAGIMod;}
    
    public int getINTMod(){return INTMod;}
    public void setINTMod(int newINTMod){INTMod = newINTMod;}
    
    public int getWISMod(){return WISMod;}
    public void setWISMod(int newWISMod){WISMod = newWISMod;}
    
    public int getCHAMod(){return CHAMod;}
    public void setCHAMod(int newCHAMod){CHAMod = newCHAMod;}
    
    public int getPERMod(){return PERMod;}
    public void setPERMod(int newPERMod){PERMod = newPERMod;}
    
    
    //Skills
    public ArrayList<Skill> getSkills(){return skills;}
    public void addSkill(String skillName, String skillStat){skills.add(new Skill(skillName, skillStat));}
    public void removeSkill(int index){skills.remove(index);}
    
    
    //Traits
    public ArrayList<Trait> getTraits(){return traits;}
    public void addTrait(String traitName){traits.add(new Trait(traitName));}
    public void removeTrait(int index){traits.remove(index);}
    
    
    //Notes
    public ArrayList<Note> getNotes(){return notes;}
    public void addNote(String noteName){notes.add(new Note(noteName));}
    public void removeNote(int index){notes.remove(index);}
    
    
    //Equipment
    public ArrayList<Equipment> getEquipment(){return equipment;}
    public void addEquipment(String equipmentName){equipment.add(new Equipment(equipmentName));}
    public void removeEquipment(int index){equipment.remove(index);}
    
    
    //Rolls
    public ArrayList<CustomRoll> getRolls(){return rolls;}
    public void addRoll(String name, int amount, int sides, int bonus){rolls.add(new CustomRoll(name, amount, sides, bonus));}
    public void removeRoll(int index){rolls.remove(index);}
    
    
    
    //Updates any autogenerated values based on current input values
    public void updateValues()
    {
        calculateModifiers();
    }
    
    //Calculates the characters stat modifiers based on current stat values
    private void calculateModifiers()
    {
        STRMod = (int)Math.floor((STR/2)-5);
        CONMod = (int)Math.floor((CON/2)-5);
        DEXMod = (int)Math.floor((DEX/2)-5);
        AGIMod = (int)Math.floor((AGI/2)-5);
        INTMod = (int)Math.floor((INT/2)-5);
        WISMod = (int)Math.floor((WIS/2)-5);
        CHAMod = (int)Math.floor((CHA/2)-5);
        PERMod = (int)Math.floor((PER/2)-5);
    }
    
    //Method to create a copy of the characters skills so that copy characters dont reference the same skillset
    private ArrayList<Skill> copySkills(ArrayList<Skill> toCopy)
    {
        for (int i = 0; i < toCopy.size(); i++)
        {
            skillHolder.add(new Skill(toCopy.get(i)));
        }
        return skillHolder;
    }
    
    //Method to create a copy of the characters traits so that copy characters dont reference the same traits
    private ArrayList<Trait> copyTraits(ArrayList<Trait> toCopy)
    {
        for (int i = 0; i < toCopy.size(); i++)
        {
            traitHolder.add(new Trait(toCopy.get(i)));
        }
        return traitHolder;
    }
    
    //Method to create a copy of the characters notes so that copy characters dont reference the same notes
    private ArrayList<Note> copyNotes(ArrayList<Note> toCopy)
    {
        for (int i = 0; i < toCopy.size(); i++)
        {
            noteHolder.add(new Note(toCopy.get(i)));
        }
        return noteHolder;
    }
    
    //Method to create a copy of the characters notes so that copy characters dont reference the same notes
    private ArrayList<Equipment> copyEquipment(ArrayList<Equipment> toCopy)
    {
        for (int i = 0; i < toCopy.size(); i++)
        {
            equipmentHolder.add(new Equipment(toCopy.get(i)));
        }
        return equipmentHolder;
    }
    
    //Method to create a copy of the characters notes so that copy characters dont reference the same notes
    private ArrayList<CustomRoll> copyRolls(ArrayList<CustomRoll> toCopy)
    {
        for (int i = 0; i < toCopy.size(); i++)
        {
            rollsHolder.add(new CustomRoll(toCopy.get(i)));
        }
        return rollsHolder;
    }
}
