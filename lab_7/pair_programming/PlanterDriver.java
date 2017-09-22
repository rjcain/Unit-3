package lab_7.pair_programming;

import kareltherobot.*;
import java.awt.Color;

public class PlanterDriver implements Directions
{
    public static void main(String args[])  {
        int[][] beeperField = new int[][]{{1,0,3,4},{0,0,5,1}, {2,2,2,2},{1,4,7,0}};
        
        Planter billy = new Planter(2,2,East,0);
        billy.setField(beeperField);
        billy.printField(); //check that parameter is passed correctly
        billy.plantField();
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