import edu.princeton.cs.algs4.StdOut;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/**
 * Created by Siddharth on 10/30/17.
 */
public class FourSum {
    Coordinates c1;
    Coordinates c2;
    int sum = 0;
    
    public FourSum(Coordinates c1, Coordinates c2){
        this.c1 = c1;
        this.c2 = c2;
    }
    
    public int getA(int a) {
        return a;
    }
    
    public int getB(int b) {
        return b;
    }
    
    public void printOutput(){
        StdOut.printf("%d %d %d %d%n", c1.indexX,c1.indexY,c2.indexX,c2.indexY);
    }
}
