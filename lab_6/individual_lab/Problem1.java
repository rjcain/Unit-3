package lab_6.individual_lab;
import kareltherobot.*; 


/**
 * @author :  D. Appel
 */
public class Problem1 extends Robot
{
    public int beepers;
    int[] beepVal;
    int arrayNum;
    int comparer;
    int follower;
    int temp;
    
    public Problem1(int st, int av, Direction dir, int numBeepers) {
        super(st, av, dir, numBeepers);
        beepVal = new int[8];
    }
    
    public void sortBeepers() {
        position();
        collect();
        reposition();
        rearrange();
        place();
    }
    public void position() {
        while(frontIsClear()) {
            move();
        }
        turnLeft();
        while(frontIsClear()) {
            move();
        }
        turnLeft();
        turnLeft();
    }
    public void collect() {
        while(nextToABeeper()) {
            countBeeps();
            record();
            moveToNextRow();
         }
    }
    public void reposition() {
        while(!facingWest()) {
            turnLeft();
        }
        while(frontIsClear()) {
            move();
        }
        turnLeft();
        while(frontIsClear()) {
            move();
        }
        turnLeft();
        turnLeft();
    }
    public void rearrange() {
        System.out.println(beepVal[0]);
        System.out.println(beepVal[1]);
        System.out.println(beepVal[2]);
        System.out.println(beepVal[3]);
        //defines array number, comparing number,
        arrayNum = 0;
        comparer = 1;
        
            while(arrayNum <= 6) {   
            follower = arrayNum + comparer;
            System.out.println(comparer);
            if(beepVal[arrayNum] > beepVal[follower]) {
                //switches array values
                int temp = beepVal[arrayNum];
                beepVal[arrayNum] = beepVal[follower];
                beepVal[follower] = temp;
                if(comparer <= 6 - arrayNum) {
                    //compares to successive array value
                    //changes the array value being compared
                    comparer++;
                 }
                else {
                    comparer = 1;
                    arrayNum++;
                 }
            }
            else {
                if(comparer <= 6 - arrayNum) {
                    comparer++;
                }
                else {
                    comparer = 1;
                    arrayNum++;
                }
            }
        }
    }
    public void place() {
      arrayNum = 0;
        for(int x = 0; x < 8; x++) {
        placeBeeps();
        moveToNextRow();
        arrayNum++;
      }
    }
    public void countBeeps() {
        while(nextToABeeper()) {
            beepers++;
            pickBeeper();
            move();
        }
    }
    public void record() {
        beepVal[arrayNum] = beepers;
        beepers = 0;
        arrayNum++;
    }
    public void moveToNextRow() {
        turnLeft();
        turnLeft();
        while(frontIsClear()) {
            move();
        }
        turnLeft();
        move();
        turnLeft();
    }
    public void placeBeeps() {
        
        for(int x = 0; x < beepVal[arrayNum]; x++) {
                putBeeper();
                move();
                
         }
    }
}

