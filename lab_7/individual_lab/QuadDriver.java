package lab_7.individual_lab;

import kareltherobot.*;
import java.awt.Color;

public class QuadDriver implements Directions
{
    public static void main(String args[])  {
        Quad billy = new Quad(1,1,East,-1);
        billy.fixQuad();
        billy.printFixes();
        billy.turnOff();
    } 

    static {
        World.reset(); 
        World.readWorld("worlds/quad.kwld");
        World.setBeeperColor(Color.magenta);
        World.setStreetColor(Color.blue);
        World.setNeutroniumColor(Color.green.darker());
        World.setDelay(3);  
        World.setVisible(true);
    }
}