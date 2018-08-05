import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.*;

/**
 * Created by Siddharth on 11/01/17.
 */

public class SumHash {
    public static HashMap<Integer, ArrayList<Coordinates>> hashMap;
    public static List<Integer> data;
    public static List<FourSum> output;
    public static List<Coordinates> points;
    
    
    public SumHash() {
        hashMap = new HashMap<>();
        points = new ArrayList<>();
        output = new ArrayList<>();
        data = new ArrayList<>();
    }
    
    public static void fourSum() {
        int a = 0;
        while(a < data.size()) {
            int b = a + 1;
            while(b < data.size()) {
                int sum = data.get(a) + data.get(b);
                if(!hashMap.containsKey(sum)){
                    ArrayList<Coordinates> temp = new ArrayList<>();
                    temp.add(new Coordinates(data.get(a), data.get(b), a, b));
                    hashMap.put(sum, temp);
                }else{
                    hashMap.get(sum).add(new Coordinates(data.get(a), data.get(b), a, b));
                }
                b++;
            }
            a++;
        }
        
        Set<Integer> keyHolder = hashMap.keySet();
        Iterator<Integer> itr = keyHolder.iterator();
        while (itr.hasNext()) {
            Integer var = itr.next();
            ArrayList<Coordinates> list = new ArrayList<>();
            list = hashMap.get(var);
            for(int i = 0; i<list.size();i++){
                points.add(list.get(i));
            }
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
        
        int e = 0;
        
        while(e < output.size()) {
            output.get(e).printOutput();
            e++;
        }
    }
    
    public static void main(String[] args) {
        SumHash sumHash = new SumHash();
        int N = StdIn.readInt();
        while(!StdIn.isEmpty()) {
            int a = StdIn.readInt();
            data.add(a);
        }
        fourSum();
    }
}
