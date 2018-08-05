import edu.princeton.cs.algs4.StdOut;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Siddharth on 10/30/17.
 */

public class SumSort {
    public static List<Coordinates> points;
    public static List<FourSum> output;
    public static List<Integer> list;
    
    public SumSort() {
        points = new ArrayList<>();
        list = new ArrayList<>();
        output = new ArrayList<>();
    }
    
    public static void sortSum() {
        int a = 0;
        while(a < list.size()) {
            int b = a + 1;
            while(b < list.size()) {
                points.add(new Coordinates(list.get(a), list.get(b), a, b));
                b++;
            }
            a++;
        }
        
        Collections.sort(points);
        
        int c = 0;
        while(c < points.size()) {
            int d = c + 1;
            while(d < points.size()) {
                if(points.get(c).sum == points.get(d).sum){
                    if(!(points.get(c).indexX == points.get(d).indexX || points.get(c).indexY == points.get(d).indexX ||points.get(c).indexX == points.get(d).indexY || points.get(c).indexX == points.get(d).indexX || points.get(c).indexY == points.get(d).indexY)) {
                        output.add(new FourSum(points.get(c), points.get(d)));
                    }
                }
                d++;
            }
            c++;
        }
        
        StdOut.println(output.size());
        
        int z = 0;
        while(z < output.size()) {
            output.get(z).printOutput();
            z++;
        }
    }
    
    public static void main(String[] args) {
        SumSort sumSort = new SumSort();
        int N = StdIn.readInt();
        while(!StdIn.isEmpty()) {
            int a = StdIn.readInt();
            list.add(a);
        }
        sortSum();
        
    }
}
