package zombies.stuff;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;


public class Serial
{
    public Serial(){}
    
    //Serializes the object passed to it under the filename passed
    public void Serialize(Object obj, String filename) throws IOException
    {
        FileOutputStream out = new FileOutputStream(filename);
        ObjectOutputStream oos = new ObjectOutputStream(out);
        
        oos.writeObject(obj);
        
        oos.close();
        out.close();
    }
     
    //Reads an object from the filename passed and returns it
    public Object Deserialize(String filename) throws IOException, ClassNotFoundException
    {
        FileInputStream in = new FileInputStream(filename);
        ObjectInputStream ois = new ObjectInputStream(in);
        
        Object obj = ois.readObject();
        
        ois.close();
        in.close();

        return obj;
    }
}
