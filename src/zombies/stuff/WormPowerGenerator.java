package zombies.stuff;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class WormPowerGenerator
{
    Dice dice;
    Serial serial;
    
    ArrayList<ArrayList> listHolder;
    ArrayList<String> allPowers;
    ArrayList<String> sightSubtable;
    ArrayList<String> hearingSubtable;
    ArrayList<String> speechSubtable;
    ArrayList<String> jackSubtable;
    ArrayList<String> currentSelection;
    
    double powerRoll;
    double currentValue;
    double currentTotal;
    double remainingPoints;
    double miscValue;
    double jackLoop;
    double jackRoll;
    double jackHolder;
    boolean rollingPowers;
    boolean duplicatePower;
    //String for maintaining nicer formatting for one of the powers, is usually empty
    String jackTab = "";
    
    public WormPowerGenerator()
    {
        //Initialise objects and lists
        dice = new Dice();
        serial = new Serial();
        
        listHolder = new ArrayList();
        allPowers = new ArrayList();
        sightSubtable = new ArrayList();
        hearingSubtable = new ArrayList();
        speechSubtable = new ArrayList();
        jackSubtable = new ArrayList();
        currentSelection = new ArrayList();
        
        addPowers();
    }
    
    //Method to write the power lists to file
    public void save()
    {
        try
        {
            serial.Serialize(listHolder, "Power-Lists.dat");
        } catch (IOException e){};
    }
    
    //Method to read powers from file
    private void addPowers()
    {
        try
        {
            //Deserializes the main conglomerate object then assigns each list element
            listHolder = (ArrayList)serial.Deserialize("Power-Lists.dat");
            allPowers = listHolder.get(0);
            sightSubtable = listHolder.get(1);
            hearingSubtable = listHolder.get(2);
            speechSubtable = listHolder.get(3);
            jackSubtable = listHolder.get(4);
        } catch (IOException e)
        {
            System.out.println("Serialization failed IO");
        } catch (ClassNotFoundException e)
        {
            System.out.println("Serialization failed CLASS");
        }
    }
    
    //Method to create and return a powerset
    public ArrayList<String> getPowerSet()
    {
        //Reset variables
        currentSelection.clear();
        rollingPowers = true;
        currentTotal = 0;
        currentValue = 0;
        remainingPoints = 0;
        addPowers();
        
        //loop for multiple powers
        while (rollingPowers == true)
        {
            //Get value
            powerRoll = dice.roll(allPowers.size());
            //Subtract total to balance power selection
            currentValue = powerRoll - currentTotal;
            
            //Ouputs values for debugging
            //currentSelection.add(powerRoll + " / " + currentTotal + " / " + currentValue);
            
            //Check if roll is high enough to qualify for another power
            if ((currentValue) <= 0)
            {
                rollingPowers = false;
            } else
            {
                //Check if power is already on list
                duplicatePower = false;
                for (int i = 0; i < currentSelection.size(); i++)
                {
                    if ((allPowers.get((int)currentValue - 1)).equals(currentSelection.get(i)))
                    {
                        duplicatePower = true;
                    }
                }
                
                //If power isnt on list, add it
                if (duplicatePower == false)
                {
                    selectPower();
                }
            }
        }
        return currentSelection;
    }
    
    //Method for generating a single power
    private void selectPower()
    {
        //Value set for use with scaling subtables
        remainingPoints = allPowers.size() - currentTotal;

        //Switch statement catches powers that require additional rolls
        switch (allPowers.get((int)currentValue - 1))
        {
            case "Enhanced Strength":
                strengthSpecifics();
                break;
            case "Enhanced Dexterity":
                dexteritySpecifics();
                break;
            case "Enhanced Agility":
                agilitySpecifics();
                break;
            case "Enhanced Intelligence":
                intelligenceSpecifics();
                break;
            case "Enhanced Sight":
                sightSpecifics();
                break;
            case "Enhanced Hearing":
                hearingSpecifics();
                break;
            case "Enhanced Speech":
                speechSpecifics();
                break;
            case "Increased Luck":
                luckSpecifics();
                break;
            case "Passive Reactional Perception Modification":
                reactionSpecifics();
                break;
            case "Skitter Effect":
                skitterSpecifics();
                break;
            case "Bitch Effect":
                bitchSpecifics();
                break;
            case "Teleportation (Elemental)":
                teleportSpecifics();
                break;
            case "Dynakinesis":
                dynakinesisSpecifics();
                break;
            case "Empathy":
                empathySpecifics();
                break;
            case "Jack Of All Trades":
                jackSpecifics();
                break;
            case "One Man Team":
                oneManSpecifics();
                break;
            default:
                currentSelection.add(allPowers.get((int)currentValue - 1));
                break;
        }
        currentTotal += currentValue;
    }
    
    //Method performs additional calculations for "increased strength" power
    private void strengthSpecifics()
    {
        //Rolls a value based on the number of points remaining
        powerRoll = dice.roll(remainingPoints/5);
        currentSelection.add(jackTab + "Enhanced Strength");
        currentSelection.add(jackTab + "\t+ " + (2 * powerRoll));
        currentValue = powerRoll * 5;
    }
    
    //Method performs additional calculations for "increased dexterity" power
    private void dexteritySpecifics()
    {
        //Rolls a value based on the number of points remaining
        powerRoll = dice.roll(remainingPoints/5);
        currentSelection.add(jackTab + "Enhanced Dexterity");
        currentSelection.add(jackTab + "\t+ " + (2 * powerRoll));
        currentValue = powerRoll * 5;
    }
    
    //Method performs additional calculations for "increased agility" power
    private void agilitySpecifics()
    {
        //Rolls a value based on the number of points remaining
        powerRoll = dice.roll(remainingPoints/5);
        currentSelection.add(jackTab + "Enhanced Agility");
        currentSelection.add(jackTab + "\t+ " + (2 * powerRoll));
        currentValue = powerRoll * 5;
    }
    
    //Method performs additional calculations for "increased intelligence" power
    private void intelligenceSpecifics()
    {
        //Rolls a value based on the number of points remaining
        powerRoll = dice.roll(remainingPoints/5);
        currentSelection.add(jackTab + "Enhanced Intelligence");
        currentSelection.add(jackTab + "\t+ " + (2 * powerRoll));
        currentValue = powerRoll * 5;
    }
    
    //Method performs additional calculations for "enhanced sight" power
    private void sightSpecifics()
    {
        currentSelection.add(jackTab + "Enhanced Sight");
        //Determine number of aspects to power
        miscValue = dice.roll(4);
        //Determine each aspect
        for (int i = 0; i < miscValue; i++)
        {
            powerRoll = dice.roll(sightSubtable.size());
            currentSelection.add(jackTab + "\t- " + sightSubtable.get((int)powerRoll - 1));
            sightSubtable.remove((int)powerRoll - 1);
        }
        currentValue = miscValue * 15;
    }
    
    //Method performs additional calculations for "enhanced hearing" power
    private void hearingSpecifics()
    {
        currentSelection.add(jackTab + "Enhanced Hearing");
        //Determine number of aspects to power
        miscValue = dice.roll(3);
        //Determines each aspect
        for (int i = 0; i < miscValue; i++)
        {
            powerRoll = dice.roll(hearingSubtable.size());
            currentSelection.add(jackTab + "\t- " + hearingSubtable.get((int)powerRoll - 1));
            hearingSubtable.remove((int)powerRoll - 1);
        }
        currentValue = miscValue * 15;
    }
    
    //Method performs additional calculations for "enhanced speech" power
    private void speechSpecifics()
    {
        currentSelection.add(jackTab + "Enhanced Speech");
        //Determines number of aspects to power
        miscValue = dice.roll(4);
        //Determines each aspect
        for (int i = 0; i < miscValue; i++)
        {
            powerRoll = dice.roll(speechSubtable.size());
            currentSelection.add(jackTab + "\t- " + speechSubtable.get((int)powerRoll - 1));
            speechSubtable.remove((int)powerRoll - 1);
        }
        currentValue = miscValue * 15;
    }
    
    //Method performs additional calculations for "increased luck" power
    private void luckSpecifics()
    {
        //Rolls a value based on the number of points remaining
        powerRoll = dice.roll(remainingPoints/10);
        currentSelection.add(jackTab + "Increased Luck");
        currentSelection.add(jackTab + "\t+ " + powerRoll);
        currentValue = powerRoll * 10;
    }
    
    //Method performs additional calculations for "reactional modification" power
    private void reactionSpecifics()
    {
        //Picks from two options
        currentSelection.add("Passive Reactional Perception Modification");
        miscValue = dice.roll(2);
        if (miscValue == 1)
        {
            currentSelection.add("\t\t- Fame");
        } else
        {
            currentSelection.add("\t\t- Badass");
        }
    }
    
    //Method performs additional calculations for "skitter" power
    private void skitterSpecifics()
    {
        //Picks from several options
        currentSelection.add("Skitter Effect");
        switch ((int)dice.roll(3))
        {
            case 1:
                currentSelection.add("\t- Insects");
                break;
            case 2:
                currentSelection.add("\t- Rodents");
                break;
            case 3:
                currentSelection.add("\t- Birds");
                break;
        }
    }
    
    //Method performs additional calculations for "bitch" power
    private void bitchSpecifics()
    {
        //Picks from several options
        currentSelection.add("Bitch Effect");
        switch ((int)dice.roll(3))
        {
            case 1:
                currentSelection.add("\t- Dogs");
                break;
            case 2:
                currentSelection.add("\t- Cats");
                break;
            case 3:
                currentSelection.add("\t- Birds");
                break;
        }
    }
    
    //Method performs additional calculations for "elemental teleport" power
    private void teleportSpecifics()
    {
        //Picks from several options
        currentSelection.add("Teleportation (Elemental)");
        switch ((int)dice.roll(4))
        {
            case 1:
                currentSelection.add("\t- Fire");
                break;
            case 2:
                currentSelection.add("\t- Water");
                break;
            case 3:
                currentSelection.add("\t- Electricity");
                break;
            case 4:
                currentSelection.add("\t- Darkness");
                break;
        }
    }
    
    //Method performs additional calculations for "dynakinesis" power
    private void dynakinesisSpecifics()
    {
        //Picks from several options
        currentSelection.add("Dynakinesis");
        switch ((int)dice.roll(5))
        {
            case 1:
                currentSelection.add("\t- Pyrokinesis");
                break;
            case 2:
                currentSelection.add("\t- Cryokinesis");
                break;
            case 3:
                currentSelection.add("\t- Hydrokinesis");
                break;
            case 4:
                currentSelection.add("\t- Electrokinesis");
                break;
            case 5:
                currentSelection.add("\t- Aerokinesis");
                break;
        }
    }
    
    //Method performs additional calculations for "empathy" power
    private void empathySpecifics()
    {
        //Picks from two options
        currentSelection.add("Empathy");
        miscValue = dice.roll(2);
        if (miscValue == 1)
        {
            currentSelection.add("\t- Field");
        } else
        {
            currentSelection.add("\t- Imprint");
        }
    }
    
    //Method performs additional calculations for "jack of all trades" power
    private void jackSpecifics()
    {
        //Sets string value for clearer formatting
        jackTab = "\t";
        currentSelection.add("Jack Of All Trades");
        //Sets remaining points for the purpose of controlling levels of increased stats
        remainingPoints = 25;
        jackHolder = currentValue;
        //Determines number of aspects to the power
        jackLoop = dice.roll(13, 2);
        try
        {
            //Determines each aspect
            for (int i = 0; i < jackLoop; i++)
            {
                jackRoll = dice.roll(jackSubtable.size());
                //Switch statement catches powers with additional requirements
                switch (jackSubtable.get((int)jackRoll - 1))
                {
                    case "Enhanced Strength":
                        strengthSpecifics();
                        break;
                    case "Enhanced Dexterity":
                        dexteritySpecifics();
                        break;
                    case "Enhanced Agility":
                        agilitySpecifics();
                        break;
                    case "Enhanced Intelligence":
                        intelligenceSpecifics();
                        break;
                    case "Enhanced Sight":
                        sightSpecifics();
                        break;
                    case "Enhanced Hearing":
                        hearingSpecifics();
                        break;
                    case "Enhanced Speech":
                        speechSpecifics();
                        break;
                    case "Increased Luck":
                        luckSpecifics();
                        break;
                    default:
                        currentSelection.add("\t" + jackSubtable.get((int)jackRoll - 1));
                }
                jackSubtable.remove((int)jackRoll - 1);
            }
        } catch (IndexOutOfBoundsException e)
        {
            currentSelection.add("Jack selection failed");
        }
        jackTab = "";
        currentValue = jackHolder;
    }
    
    //Method performs additional calculations for "one man army" power
    private void oneManSpecifics()
    {
        currentSelection.add("One Man Team");
        //Determines number of aspects to the power
        currentSelection.add("\t- " + dice.roll(1, 3, 2) + " sets");
        rollingPowers = false;
    }
}
