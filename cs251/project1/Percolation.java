import edu.princeton.cs.algs4.WeightedQuickUnionUF;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;

/**
 * Created by Siddharth on 9/5/17.
 */

public class Percolation {

    private boolean[][] grid;
    private int top;
    private int bottom;
    private WeightedQuickUnionUF unionFind;
    private int gridSize;


    public Percolation(int N) {
        gridSize = N;
        top = gridSize * gridSize + 1;
        bottom = gridSize * gridSize;
        //bottom = gridSize * gridSize + 1;
        unionFind = new WeightedQuickUnionUF(1 + (gridSize * gridSize) + 1);
        grid = new boolean[gridSize][gridSize];
    }

    public void union(int i, int j) {
        unionFind.union(i, j);
    }

    public boolean isConnected(int i, int j) {
        return unionFind.connected(i,j);
    }

    public boolean validateIndices(int i, int j) {
        return i >= 0 && i < gridSize && j >= 0 && j < gridSize;
    }


    public void open(int i, int j) {
        grid[gridSize - i - 1][j] = true; //Sets the bottom left index to (0,0)
        if(isFull(i,j)) {
            union(getGridID(i,j),top);
        }

        if(validateIndices(i,j)) {
            connectOpenSites(i,j);
        } else {
            throw new IndexOutOfBoundsException("Illegal Index Entered!!!");
        }
    }

    public void connectOpenSites(int i, int j) {

        if (i == 0) {
            union(getGridID(i, j), top); // Unions the top sentinel node with element from row 1
        }

        //if(i == gridSize - 1 && j == 0) {
          //  union(getGridID(i,j),top);
        //}

        if(j >= 0 && j < gridSize) {
            if (i > 0 && isOpen(i - 1, j) == true) {
                union(getGridID(i, j), getGridID(i - 1, j)); // unions top & current node
            }

            if (i + 1 < gridSize && isOpen(i + 1, j) == true) {
                union(getGridID(i, j), getGridID(i + 1, j)); // unions bottom & current node
            }
        }

        if(i >= 0 && i < gridSize) {
            if (j > 0 && isOpen(i, j - 1) == true) {
                union(getGridID(i, j), getGridID(i, j - 1)); // unions left & current node
            }

            if (j + 1 < gridSize && isOpen(i, j + 1) == true) {
                union(getGridID(i, j), getGridID(i, j + 1)); // unions right & current node
            }
        }

        //if(j == gridSize - 1 && i == 0) {
          //  union(getGridID(i,j),bottom);
        //}

        if (i == gridSize - 1) {
            union(getGridID(i, j), bottom); // Unions the bottom sentinel node with element from row n.
        }
    }


    public boolean isOpen(int i, int j) {
        if(validateIndices(i,j)) {
            return grid[gridSize - i - 1][j]; //Checks if the desired site is open or not
        } else {
            throw new IndexOutOfBoundsException("Illegal Index Entered!!!");
        }
    }


    public boolean isFull(int i, int j) {
        return isConnected(getGridID(i, j), top);
    }

    public int getGridID(int i, int j) {
        if(validateIndices(i,j)) {
            return ((gridSize * i) + j) + 1;
        } else {
            throw new IndexOutOfBoundsException("Illegal Index Entered!!!");
        }
    }


    public boolean percolates() {
        return isConnected(top,bottom);
    }



     public static void main(String[] args) throws FileNotFoundException {

     int size = StdIn.readInt();
     
     Percolation percolation = new Percolation(size);
     while(!StdIn.isEmpty()) {
     int i = size-StdIn.readInt()-1;
     int j = StdIn.readInt();
     percolation.open(j,i);
     }
     StdOut.println(percolation.percolates() ? "Yes":"No");
     }


}
