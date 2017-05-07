package zombies.stuff;

import static com.sun.java.accessibility.util.AWTEventMonitor.addWindowListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

public class ZombiesStuff
{
    public static UI ui;
    public static CharacterSheet cSheet;
    
    public static void main(String[] args)
    {
        //Creates and shows the stat and power roller
        ui = new UI();
        ui.setVisible(true);
        
        //Creates and shows a blank characetr sheet
        cSheet = new CharacterSheet();
        cSheet.setVisible(true);
    }
}
