package lab_7.individual_lab;
import kareltherobot.*; 


/**
 * @author :  D. Appel
 */
public class Harvester extends Robot
{
    public int[][]field = new int[6][5];
    int column;
    int row;
    int beepers;
    
    public Harvester(int st, int av, Direction dir, int numBeepers) {
        super(st, av, dir, numBeepers);
    }
    
    public void harvest() {
        move();
        for(int x = 0; x < 6; x++) {
            harvestOneRow();
            reposition();
            row++;
        }
        returnOrigin();
    }
    
    public void printField() {
       row = 0;
       column = 0;
       for(int y = 0; y < 6; y++) {
           for(int x = 0; x < 5; x++) {
               System.out.print(field[row][column] + " ");
               column++;
           }
           row++;
           System.out.println();
           column = 0;
       }
    }
    
    public void harvestOneRow() {
        column = 0;
        for(int x = 0; x < 5; x++) {
            if(nextToABeeper()) {
                 pickBeeper();
                 beepers++;
            }
            System.out.println(row);
            System.out.println(column);
            System.out.println(beepers);
            field[row][column] = beepers;
            move();
            column++;
            beepers = 0;
        }
    }
    
    public void reposition() {
        while(!facingWest()) {
            turnLeft();
        }
        while(frontIsClear()) {
            move();
        }
        while(!facingNorth()) {
            turnLeft();
        }
        move();
        while(!facingEast()) {
            turnLeft();
        }
        move();
        move();
    }
    
    public void returnOrigin() {
        while(!facingWest()) {
            turnLeft();
        }
        while(frontIsClear()) {
            move();
        }
        while(!facingSouth()) {
            turnLeft();
        }
        while(frontIsClear()) {
            move();
        }
        turnLeft();
        turnLeft();
    }
}

