package lab_7.individual_lab;
import kareltherobot.*; 


/**
 * @author :  D. Appel
 */
public class Quad extends Robot
{
    int beepers;
    int row;
    int column;
    int columns[][] = new int[5][6];
    public Quad(int st, int av, Direction dir, int numBeepers) {
        super(st, av, dir, numBeepers);
    }
    
    public void fixQuad() {
        for(int x = 0; x < 4; x++) {
            fixNrecord();
            reposition();
        }
    }
    
    public void fixNrecord() {
        turnLeft();
        for(int x = 0; x < 4; x++) {
            fixSegment();
            recordData();
            position();
        }
        fixSegment();
        recordData();
    }
    
    public void reposition() {
        turnLeft();
        turnLeft();
        while(frontIsClear()) {
            move();
        }
        turnLeft();
        move();
        move();
        move();
        move();
        column++;
        row = 0;
    }
    
    public void fixSegment() {
        beepers = 0;
        if(nextToABeeper()) {
            beepers ++;
        }
        else {
            putBeeper();
        }
    }
    
    public void recordData() {
        columns[row][column] = beepers;
    }
    
    public void position() { 
        move();
        row++;
    }
    
    public void printFixes() {
        row = 4;
        column = 0;
        for(int x = 0; x < 4; x++) {
            for(int y = 0; y < 5; y++) {
                System.out.print(columns[row][column] + "  ");
                column++;
            }
            row--;
            column = 0;
            System.out.println();
        }
    }
   
}

