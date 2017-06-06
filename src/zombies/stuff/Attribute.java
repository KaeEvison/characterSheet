package zombies.stuff;

import java.io.Serializable;

public class Attribute implements Serializable
{
    private static final long serialVersionUID = 6L;
    
    String name;
    String description;
    
    public Attribute(){}
    public Attribute(String pName){name = pName;description = "";}
    public Attribute(Attribute toCopy)
    {
        name = toCopy.getName();
        description = toCopy.getDescription();
    }
    
    public String getName(){return name;}
    public void setName(String pName){name = pName;}
    
    public String getDescription(){return description;}
    public void setDescription(String pDesc){description = pDesc;}
    
    //Function to return a usable string for outputting to the UI
    public String toString()
    {
        return new String(name + "\n" + description + "\n\n");
    }
}
