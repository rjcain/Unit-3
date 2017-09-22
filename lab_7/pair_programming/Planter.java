package lab_7.pair_programming;
import kareltherobot.*; 


/**
 * @author :  D. Appel
 */
public class Planter extends Robot
{
    //Instance variable used to store the array for beeper field
    int[][]field;
    
    public Planter(int st, int av, Direction dir, int numBeepers) {
        super(st, av, dir, numBeepers);
    }
    
    public void setField(int[][]fieldSpecs) {
        this.field = fieldSpecs;
    }
    
    public void plantField() {
        
    }
    
    public void printField() {
        //Print out the beeperField to console
        for(int row = 0; row < this.field.length; row++){
            for(int col = 0; col < this.field[0].length; col++) {
                System.out.print(this.field[row][col] + " ,");
            }
            System.out.println();
        }
    }
   
}

