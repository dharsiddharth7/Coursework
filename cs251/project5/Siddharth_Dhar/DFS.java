import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Stack;
import edu.princeton.cs.algs4.*;

/**
 * Created by Siddharth on 11/15/17.
 */

public class DFS {
    public static boolean[] marked;
    public static int keyElement;
    public static boolean flag = true;
    public static ArrayList<Coordinates> arrayList = new ArrayList<>();
    
    public static void printList(ArrayList<Coordinates> arrayList) {
        for(int i = 0; i < arrayList.size(); i++) {
            StdOut.println(arrayList.get(i).getX() + " " + arrayList.get(i).getY());
        }
    }
    
    public static int maxCoordinate(int element,int max) {
        if(element > max) {
            max = element;
        }
        return max;
    }
    
    public static void addToAdjacencyList(int u,int v) {
        if(!StronglyConnected.adj.containsKey(u)) {
            ArrayList<Integer> aList = new ArrayList<>();
            aList.add(v);
            StronglyConnected.adj.put(u,aList);
        } else {
            StronglyConnected.adj.get(u).add(v);
        }
    }
    
    public static void depthfirstsearch(Digraph diGraph, Integer v, Integer E) {
        marked[v] = true;
        ArrayList<Integer> aL = new ArrayList<>(StronglyConnected.adj.get(v));
        for(Integer u : aL) {
            if(StronglyConnected.adj.get(u).contains(v) && StronglyConnected.adj.get(v).contains(u)) {
                arrayList.add(new Coordinates(v,u));
                diGraph.addEdge(v,u);
            }
            StronglyConnected.adj.get(v).remove(u);
            StronglyConnected.adj.get(u).remove(v);
            if(!marked[u]) {
                depthfirstsearch(diGraph,u,E);
            }
        }
    }
}

