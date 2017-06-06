package zombies.stuff;

import java.io.Serializable;

public class CustomRoll implements Serializable
{
    private static final long serialVersionUID = 8L;
    
    private String name;
    private int amount;
    private int sides;
    private int bonus;
    private boolean crit = false;
    private boolean critFail = false;
    private int holder;
    private Dice dice = new Dice();
    
    public CustomRoll(){}
    
    public CustomRoll(String pName, int pAmount, int pSides, int pBonus)
    {
        name = pName;
        amount = pAmount;
        sides = pSides;
        bonus = pBonus;
    }
    
    public CustomRoll(CustomRoll toCopy)
    {
        name = toCopy.getName();
        amount = toCopy.getAmount();
        sides = toCopy.getSides();
        bonus = toCopy.getBonus();
    }
    
    public String getName(){return name;}
    public void setName(String pName){name = pName;}
    
    public int getAmount(){return amount;}
    public void setAmount(int pAmount){amount = pAmount;}
    
    public int getSides(){return sides;}
    public void setSides(int pSides){sides = pSides;}
    
    public int getBonus(){return bonus;}
    public void setBonus(int pBonus){bonus = pBonus;}
    
    public boolean getCrit(){return crit;}
    public boolean getCritFail(){return critFail;}
    //Resets the critical flags so that criticals are not incorrectly declared
    public void reset(){crit = false; critFail = false;}
    
    //Rolls a value based on the custom roll's attributes
    public int roll()
    {
        //Reset critical flags
        crit = false;
        critFail = false;
        
        holder =  dice.roll(amount, sides, bonus);
        //Checks for criticals
        if (amount == 1)
            if (holder - bonus == sides)
                crit = true;
            else if (holder - bonus == 1)
                critFail = true;
        return holder;
    }
}
