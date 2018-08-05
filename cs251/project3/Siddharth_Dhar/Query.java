import edu.princeton.cs.algs4.*;
import edu.princeton.cs.algs4.StdIn;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

/**
 * Created by Siddharth on 10/14/17.
 */
public class Query {
    public static void query(ArrayList<Coordinates> arrayList, int x, int y) {
        ArrayList<Coordinates> newArrayList = new ArrayList<>();
        ArrayList<Coordinates> finalArrayList = new ArrayList<>();

        Collections.sort(arrayList, new Comparator<Coordinates>() {
            public int compare(Coordinates c1, Coordinates c2) {
                return Integer.compare(c1.getX(), c2.getX());
            }
        });

        int indexX = Collections.binarySearch(arrayList,new Coordinates(x,y),Comparator.comparingInt(one -> one.x));

        if(indexX >= 0) {
            for (int i = indexX + 1; i < arrayList.size(); i++) {
                newArrayList.add(arrayList.get(i));
            }
        } else {
            for (int i = Math.abs(indexX) - 1; i < arrayList.size(); i++) {
                newArrayList.add(arrayList.get(i));
            }
        }

        Collections.sort(newArrayList, new Comparator<Coordinates>() {
            public int compare(Coordinates c1, Coordinates c2) {
                return Integer.compare(c1.getY(), c2.getY());
            }
        });

        int indexY = Collections.binarySearch(newArrayList,new Coordinates(x,y),Comparator.comparingInt(two -> two.y));

        if(indexY >= 0) {
            for (int i = indexY + 1; i < newArrayList.size(); i++) {
                finalArrayList.add(newArrayList.get(i));
            }
        } else {
            for(int i = Math.abs(indexY)-1; i < newArrayList.size(); i++) {
                finalArrayList.add(newArrayList.get(i));
            }
        }

        Collections.sort(finalArrayList, new Comparator<Coordinates>() {
            public int compare(Coordinates c1, Coordinates c2) {
                return Integer.compare(c1.getX(), c2.getX());
            }
        });
        if(finalArrayList.size() > 0) {
            for (int i = 0; i < finalArrayList.size(); i++) {
                StdOut.println(finalArrayList.get(i).getX() + " " + finalArrayList.get(i).getY());
            }
        } else {
            StdOut.println("none");
        }
    }

    public static void main(String[] args) {
        ArrayList<Coordinates> arrayList = new ArrayList<>();
        int size = StdIn.readInt();
        for(int i = 0; i < size; i++) {
            int x = StdIn.readInt();
            int y = StdIn.readInt();
            arrayList.add(new Coordinates(x,y));
        }

        int T = StdIn.readInt();

        for(int i = 0; i < T; i++) {
            int x = StdIn.readInt();
            int y = StdIn.readInt();
            query(arrayList,x,y);
        }
    }
}