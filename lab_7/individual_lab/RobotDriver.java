package lab_7.individual_lab;

import kareltherobot.*;
import java.awt.Color;

public class RobotDriver implements Directions
{
    public static void main(String args[])  {
        Harvester billy = new Harvester(2,2,East,0);
        billy.harvest();
        billy.printField();
        billy.turnOff();
    } 

    static {
        World.reset(); 
        World.readWorld("worlds/fig5-1.kwld");
        World.setBeeperColor(Color.magenta);
        World.setStreetColor(Color.blue);
        World.setNeutroniumColor(Color.green.darker());
        World.setDelay(3);  
        World.setVisible(true);
    }
}