package zombies.stuff;

import java.io.Serializable;
import java.util.Random;

public class Dice implements Serializable
{
    private static final long serialVersionUID = 9L;
    
    Random ranNum;
    
    public Dice()
    {
        ranNum = new Random();
    }
    
    //Takes one parameter for number of sides (i.e. pass 6 to roll a D6)
    public int roll(double die)
    {
        return (int)Math.round((ranNum.nextDouble()*(die-1))+1);
    }
    
    //Takes two parameters for number of dice rolled and number of sides on those dice respectively
    //(i.e. pass '4, 6' to roll 4D6
    public int roll(int number, int die)
    {
        int total = 0;
        for (int i = 0; i < number; i++)
        {
            total += Math.round((ranNum.nextDouble()*(die-1))+1);
        }
        return total;
    }
    
    //As previous but additional third parameter applies bonus to roll
    //(i.e. pass '4, 6, 5' to roll 4D6+5
    public int roll(int number, int die, int bonus)
    {
        int total = 0;
        for (int i = 0; i < number; i++)
        {
            total += Math.round((ranNum.nextDouble()*(die-1))+1);
        }
        return total + bonus;
    }
    
    //Performs a standard 4D6D1 roll for stats
    public int statRoll()
    {
        //Prepare variables to hold the rolls, smallest value and total
        int result = 0;
        int[] rolls = new int[] {0, 0, 0, 0};
        int smallest = 0;
        
        //Roll each die
        for (int i = 0; i < 4; i++)
        {
            rolls[i] = roll(6);
        }
        
        //Determine lowest roll
        for (int i = 0; i < 4; i++)
        {
            if (rolls[i] < rolls[smallest])
            {
                smallest = i;
            }
        }
        
        //Add together all rolls that weren't the lowest
        for (int i = 0; i < 4; i++)
        {
            if (i != smallest)
            {
                result += rolls[i];
            }
        }
        return result;
    }
}
