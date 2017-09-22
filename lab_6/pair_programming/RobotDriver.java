package lab_6.pair_programming;

import kareltherobot.*;
import java.awt.Color;

public class RobotDriver implements Directions
{
    public static void main(String args[])  {
        BeeperBot billy = new BeeperBot(1,1,East,0);
        billy.findAndCountBeepers();
        
        //print the result of finding the beepers
        System.out.println("I found the following beepers at each avenue: ");
        System.out.print("[");
        for (int i =0; i < billy.getBeeperList().length; i++) {
               System.out.print(billy.getBeeperList()[i] + ", ");
        }
        System.out.println("]");
        
        billy.turnOff();
    } 

    static {
        World.reset(); 
        World.readWorld("worlds/beeper_steeple.kwld");
        World.setBeeperColor(Color.magenta);
        World.setStreetColor(Color.blue);
        World.setNeutroniumColor(Color.green.darker());
        World.setDelay(3);  
        World.setVisible(true);
    }
}