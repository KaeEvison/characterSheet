package zombies.stuff;

import java.io.Serializable;

public class Note implements Serializable
{
    private String name;
    private String content;
    
    public Note(String pName){name = pName;}
    
    public String getName(){return name;}
    public void setName(String pName){name = pName;}
    
    public String getContent(){return content;}
    public void setContent(String pContent){content = pContent;}
}
