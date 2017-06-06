package zombies.stuff;

import java.io.Serializable;
import java.util.ArrayList;

public class Equipment extends ArrayList<Attribute> implements Serializable
{
    private static final long serialVersionUID = 7L;
    
    String name;
    String holder = "";
    
    public Equipment(){}
    public Equipment(String pName){name = pName;}
    public Equipment(Equipment toCopy)
    {
        name = toCopy.getName();
    }
    
    public String getName(){return name;}
    public void setName(String pName){name = pName;}
    
    //Function to return a usable string for outputting to the UI
    public String toString()
    {
        holder = "";
        for (int i = 0; i < this.size(); i++)
        {
            holder += this.get(i).toString();
        }
        return holder;
    }
}