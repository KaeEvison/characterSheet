package zombies.stuff;

import java.io.Serializable;
import java.util.ArrayList;

public class CharacterGroup extends ArrayList<Character> implements Serializable
{
    private static final long serialVersionUID = 1L;
    
    private String name;
    
    public CharacterGroup(){}
    public CharacterGroup(String pName){name = pName;}
    
    public String getName(){return name;}
    public void setName(String pName){name = pName;}
}