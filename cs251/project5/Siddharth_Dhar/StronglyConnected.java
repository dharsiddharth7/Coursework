import edu.princeton.cs.algs4.*;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.Stack;
import java.util.*;

/**
 * Created by Siddharth on 11/15/17.
 */

public class StronglyConnected {
    public static HashMap<Integer, ArrayList<Integer>> adj = new HashMap<Integer, ArrayList<Integer>>();
    public static HashMap<Integer,Integer> hashMap = new HashMap<>();
    public static Digraph diGraph;
    public static int V = 0;
    public static int connectedNodeCount = 0;
    public static int array[][];
    public static Object[] newArray;
    public static Set<Integer> set;
    public static int TPathCount = 0;
    public static int FPathCount = 0;
    
    public StronglyConnected(int V) {
        this.V = V;
        adj = new HashMap<Integer,ArrayList<Integer>>();
        for(int i = 0; i < V; i++) {
            adj.put(i,new ArrayList<Integer>());
        }
    }
    
    public static class Path {
        private final int s;
        private int[] edgeTo;
        private boolean[] marked;
        
        public Path(Digraph G, int s) {
            this.s = s;
            edgeTo = new int[G.V()];
            marked = new boolean[G.V()];
            dfs(G, s);
        }
        
        private void dfs(Digraph G, int v) {
            marked[v] = true;
            for (int w : G.adj(v)) {
                if (!marked[w]) {
                    edgeTo[w] = v;
                    dfs(G, w);
                }
            }
        }
        
        public boolean hasPathTo(int v) {
            return marked[v];
        }
        
        public Iterable<Integer> pathTo(int v) {
            if (!hasPathTo(v)) return null;
            Stack<Integer> path = new Stack<Integer>();
            for (int x = v; x != s; x = edgeTo[x])
                path.push(x);
            path.push(s);
            return path;
        }
    }
    
    public class Coordinates {
        public int x;
        public int y;
        
        public Coordinates(int x, int y) {
            this.x = x;
            this.y = y;
        }
        
        public Coordinates() {
            this.x = 0;
            this.y = 0;
        }
        
        public void setX(int x) {
            this.x = x;
        }
        
        public void setY(int y) {
            this.y = y;
        }
        
        public int getX() {
            return this.x;
        }
        
        public int getY() {
            return this.y;
        }
        
        @Override
        public boolean equals(Object other)
        {
            if (this == other)
                return true;
            
            if (!(other instanceof Coordinates))
                return false;
            
            Coordinates otherPoint = (Coordinates) other;
            return otherPoint.x == x && otherPoint.y == y;
        }
        
        @Override
        public int hashCode()
        {
            return (Integer.toString(x) + " " + Integer.toString(y)).hashCode();
        }
        
    }
    
    public static void sortKeys() {
        for (Integer i : adj.keySet()) {
            Collections.sort(adj.get(i));
        }
    }
    
    public static void addToAdjList(int u, int v) {
        if(!adj.containsKey(u)) {
            ArrayList<Integer> temp = new ArrayList<Integer>();
            temp.add(u);
            adj.put(u, temp);
        } else {
            adj.get(u).add(v);
        }
    }
    
    public static void main(String[] args) {
        int V = StdIn.readInt();
        int E = StdIn.readInt();
        set = new HashSet<Integer>();
        int maxElement = 0;
        int maxArEl = 0;
        diGraph = new Digraph(V);
        
        for (int i = 0; i < E;  i++) {
            int u = StdIn.readInt();
            int v = StdIn.readInt();
            set.add(u);
            set.add(v);
            Graph.addToAdjacencyList(u,v);
            Graph.addToAdjacencyList(v,u);
            maxElement = DFS.maxCoordinate(u,maxElement);
            maxElement = DFS.maxCoordinate(v,maxElement);
        }
        newArray = set.toArray();
        ArrayList<Integer> max = null;
        
        for (ArrayList<Integer> list : adj.values()) {
            if (max == null || list.size() > max.size()) {
                max = list;
                if(Collections.max(max) > maxArEl) {
                    maxArEl = Collections.max(max);
                }
            }
        }
        
        sortKeys();
        DFS.marked = new boolean[E];
        DFS.depthfirstsearch(diGraph,maxElement,E);
        
        TarjanSCC tarjanSCC = new TarjanSCC(diGraph);
        connectedNodeCount = tarjanSCC.count();
        
        if(connectedNodeCount == 1) {
            StdOut.println("0");
        } else {
            Queue<Integer>[] components = (Queue<Integer>[]) new Queue[connectedNodeCount];
            for (int i = 0; i < connectedNodeCount; i++) {
                components[i] = new Queue<Integer>();
            }
            for (int v = 0; v < diGraph.V(); v++) {
                components[tarjanSCC.id(v)].enqueue(v);
            }
            
            for (int i = 0; i < connectedNodeCount; i++) {
                for (int v : components[i]) {
                    hashMap.put(v,i);
                }
            }
            
            array = new int[connectedNodeCount][2];
            
            int four = 0;
            int five = 0;
            
            while(four < DFS.arrayList.size()) {
                int x = DFS.arrayList.get(four).getX();
                int y = DFS.arrayList.get(four).getY();
                
                if(!hashMap.get(x).equals(hashMap.get(y))) {
                    array[hashMap.get(x)][0]++;
                    array[hashMap.get(y)][1]++;
                }
                four++;
            }
            
            int ins = 0;
            int outs = 0;
            
            while(five < array.length) {
                if(array[five][0] == 0) {
                    outs++;
                }
                if(array[five][1] == 0) {
                    ins++;
                }
                five++;
            }
            StdOut.println(Math.max(ins,outs));
        }
        
        DFS.printList(DFS.arrayList);
    }
}

