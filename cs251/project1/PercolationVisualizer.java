import java.awt.*;
/**
 * Created by Siddharth on 9/8/17.
 */
public class PercolationVisualizer {
    private static int delay = 400;
    
    public static void visualizer(Percolation percolation, int size) {
        StdDraw.clear();
        //StdDraw.setCanvasSize(500,500);
        StdDraw.setXscale(0, size);
        StdDraw.setYscale(0, size);
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.filledSquare(size/2.0,size/2.0,size/2.0);
        StdDraw.setFont(new Font("TimesRoman", Font.ROMAN_BASELINE, 15));
        
        int sites = 0;
        
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                
                if (percolation.isFull(i,j) && percolation.isOpen(i,j) && percolation.validateIndices(i,j)) {
                    sites++;
                    StdDraw.setPenColor(StdDraw.BOOK_BLUE);
                } else if (percolation.isOpen(i,j) && percolation.validateIndices(i,j)) {
                    sites++;
                    StdDraw.setPenColor(StdDraw.WHITE);
                } else
                    StdDraw.setPenColor(StdDraw.BLACK);
                StdDraw.filledSquare(j + 0.498, size - i - 0.498, 0.498);
            }
        }
        
        percolates(percolation,size);
        
        StdDraw.text(0.09 * size, -(size * 0.025), sites + " open sites");
    }
    
    public static void percolates(Percolation percolation,int size) {
        if (percolation.percolates()) {
            StdDraw.text(0.935 * size, -(size * 0.025), "Percolates");
        }
        else {
            StdDraw.text(0.875 * size, -(size * 0.025), "Does not percolate");
        }
    }
    
    
    
    public static void main(String[] args) {
        //In in = new In("/Users/Siddharth/Desktop/samples/test5.txt/");
        int gridSize = StdIn.readInt();
        
        Percolation percolation = new Percolation(gridSize);
        StdDraw.show(0);
        
        while (!StdIn.isEmpty()) {
            int i = StdIn.readInt();
            int j = gridSize-StdIn.readInt()-1;
            percolation.open(j,i);
            visualizer(percolation, gridSize);
            StdDraw.show(delay);
        }
    }
}
