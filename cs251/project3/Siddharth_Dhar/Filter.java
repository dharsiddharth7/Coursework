import edu.princeton.cs.algs4.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

/**
 * Created by Siddharth on 10/8/17.
 */

public class Filter {
    public static ArrayList<Coordinates> filter(ArrayList<Coordinates> arrayList) {
        ArrayList<Coordinates> newArrayList = new ArrayList<>();
        for(int prev = 0; prev < arrayList.size(); prev++) {
            boolean flag = false;
            int next = prev + 1;
            
            while(next <= arrayList.size()-1 && arrayList.get(prev).getY() > arrayList.get(next).getY()) { 
                next++;
            }
            
            if(next == arrayList.size()) {
                flag = false;
            } else {
                flag = true;
            }
            
            if(flag == true) {
                continue;
            } else {
                newArrayList.add(arrayList.get(prev));
            }
        }
        return newArrayList;
    }
    
    public static void main(String[] args) {
        ArrayList<Coordinates> arrayList = new ArrayList<>();
        
        int size = StdIn.readInt();
        while (!StdIn.isEmpty()) {
            int x = StdIn.readInt();
            int y = StdIn.readInt();
            arrayList.add(new Coordinates(x, y));
        }
        Collections.sort(arrayList, new Comparator<Coordinates>() {
            public int compare(Coordinates c1, Coordinates c2) {
                return Integer.compare(c1.getX(), c2.getX());
            }
        });
        
        ArrayList<Coordinates> newArrayList = new ArrayList<>();
        
        newArrayList = filter(arrayList);
        
        for (int i = 0; i < newArrayList.size(); i++) {
            StdOut.println(newArrayList.get(i).getX() + " " + newArrayList.get(i).getY());
        }
    }
    
}
