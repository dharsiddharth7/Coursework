import java.text.Collator;
import java.util.*;

/**
 * Created by Siddharth on 11/15/17.
 */

public class Graph {
    public static ArrayList<ArrayList<Integer>> adjList;
    public final int V;
    
    public Graph(int V) {
        this.V = V;
        adjList = new ArrayList<ArrayList<Integer>>();
        
        for(int i = 0; i < V; i++) {
            adjList.add(new ArrayList<Integer>());
        }
    }
    
    public static void addToAdjacencyList(int e1, int e2) {
        if (!StronglyConnected.adj.containsKey(e1)) {
            ArrayList<Integer> temp = new ArrayList<Integer>();
            temp.add(e2);
            StronglyConnected.adj.put(e1, temp);
        }
        else {
            StronglyConnected.adj.get(e1).add(e2);
        }
    }
    
    public static void addEdge(Graph graph,int u, int v) {
        graph.adjList.get(u).add(v);
        graph.adjList.get(v).add(u);
    }
    
    public Iterable<Integer> adj(int v) {
        Collections.sort(adjList.get(v));
        return adjList.get(v);
    }
}
