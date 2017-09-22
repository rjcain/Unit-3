package lab_7.pair_programming;

import kareltherobot.*;
import java.awt.Color;

public class PlanterDriver implements Directions
{
    public static void main(String args[])  {
        Planter billy = new Planter(2,2,East,0);
        billy.findAllBeepers();
        billy.turnOff();
    } 

    static {
        World.reset(); 
        //World.readWorld("worlds/lab-1-pair.kwld");
        World.setBeeperColor(Color.magenta);
        World.setStreetColor(Color.blue);
        World.setNeutroniumColor(Color.green.darker());
        World.setDelay(3);  
        World.setVisible(true);
    }
}