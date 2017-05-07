package zombies.stuff;

import java.util.Random;

public class Dice
{
    Random ranNum;
    
    public Dice()
    {
        ranNum = new Random();
    }
    
    //Takes one parameter for number of sides (i.e. pass 6 to roll a D6)
    public double roll(double die)
    {
        return Math.round((ranNum.nextDouble()*(die-1))+1);
    }
    
    //Takes two parameters for number of dice rolled and number of sides on those dice respectively
    //(i.e. pass '4, 6' to roll 4D6
    public double roll(double number, double die)
    {
        double total = 0;
        for (int i = 0; i < number; i++)
        {
            total += Math.round((ranNum.nextDouble()*(die-1))+1);
        }
        return total;
    }
    
    //As previous but additional third parameter applies bonus to roll
    //(i.e. pass '4, 6, 5' to roll 4D6+5
    public double roll(double number, double die, double bonus)
    {
        double total = 0;
        for (int i = 0; i < number; i++)
        {
            total += Math.round((ranNum.nextDouble()*(die-1))+1);
        }
        return total + bonus;
    }
    
    //Performs a standard 4D6D1 roll for stats
    public double statRoll()
    {
        //Prepare variables to hold the rolls, smallest value and total
        double result = 0;
        double[] rolls = new double[] {0, 0, 0, 0};
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
