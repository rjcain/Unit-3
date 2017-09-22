package lab_6.individual_lab;
import kareltherobot.*; 


/**
 * @author :  D. Appel
 */
public class Problem2 extends Robot
{
    public int beepers;
    public boolean checker;
    
    public Problem2(int st, int av, Direction dir, int numBeepers) {
        super(st, av, dir, numBeepers);
    }
    
    public void buildFence() {
        getBeepers();
        position();
        fence();
        returnOrigin();
    }
    
    public void getBeepers() {
        while(!facingNorth()) {
            turnLeft();
        }
        while(!nextToABeeper()) {
            move();
        }
        while(nextToABeeper()) {
            pickBeeper();
            beepers++;
        }
    }
    
    public void position() {
        while(!facingEast()) {
            turnLeft();
        }
        checker = true;
        while(checker == true) {
            move();
            turnLeft();
            if(!frontIsClear()) {
                checker = false;
             }
            turnLeft();
            turnLeft();
            turnLeft();
        }
    }
    
    public void fence() {
        checker = true;
        for(int x = 0; x < beepers; x++) {
            putBeeper();
            turnLeft();
            if(frontIsClear()) {
                move();
            }
            else {
                turnLeft();
                turnLeft();
                turnLeft();
                move();
            }
        }
    }
    
    public void returnOrigin() {
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
    }
}


