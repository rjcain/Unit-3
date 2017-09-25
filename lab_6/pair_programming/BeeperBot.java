package lab_6.pair_programming;
import kareltherobot.*; 


/**
 * @author :  D. Appel
 */
public class BeeperBot extends Robot
{
    //instance variable to store beeper count
    int[] beeperList = new int[13];
    int tempCount = 0;
    int avenue = 1;
    
    public BeeperBot(int st, int av, Direction dir, int numBeepers) {
        super(st, av, dir, numBeepers);
    }
    
    public void findAndCountBeepers() {
        while(frontIsClear()) {
            if(nextToABeeper()) {
                 steeple();
            }
            move();
            avenue++;
        }
    }
    
    public void steeple() {
        turnLeft();
        while(nextToABeeper()) {
            pickBeeper();
            tempCount++;
            move();
        }
        beeperList[avenue] = tempCount;
        turnLeft();
        turnLeft();
        while(frontIsClear()) {
            move();
        }
        turnLeft();
        tempCount = 0;
    }
    
    public int[] getBeeperList() {
            //This will be used to print the beepers found.  No need to modify.
            return beeperList;
    }
   
}

