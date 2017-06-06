package zombies.stuff;

import java.io.Serializable;

public class Trait implements Serializable
{
    private static final long serialVersionUID = 4L;
    
    private String name;
    private String description;
    
    public Trait(){}
    public Trait(String pName){name = pName;}
    
    public Trait(Trait toCopy)
    {
        name = toCopy.getName();
        description = toCopy.getDescription();
    }
    
    public String getName(){return name;}
    public void setName(String pName){name = pName;}
    
    public String getDescription(){return description;}
    public void setDescription(String pDesc){description = pDesc;}
}
