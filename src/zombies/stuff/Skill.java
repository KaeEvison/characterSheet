package zombies.stuff;

import java.io.Serializable;

public class Skill implements Serializable
{
    private String name;
    private String stat;
    private int ranks;
    private int otherBonus;
    
    public Skill(){}
    
    public Skill(String pName, String pStat)
    {
        name = pName;
        stat = pStat;
        ranks = 0;
        otherBonus = 0;
    }
    
    public String getName(){return name;}
    public void setName(String pName){name = pName;}
    
    public String getStat(){return stat;}
    public void setStat(String pStat){stat = pStat;}
    
    public int getRanks(){return ranks;}
    public void setRanks(int pRanks){ranks = pRanks;}
    public void ranksPlus(){ranks++;}
    public void ranksMinus(){ranks--;}
    
    public int getOtherBonus(){return otherBonus;}
    public void setOtherBonus(int pBonus){otherBonus = pBonus;}
    public void otherPlus(){otherBonus++;}
    public void otherMinus(){otherBonus--;}
}
