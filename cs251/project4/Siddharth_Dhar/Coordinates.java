import edu.princeton.cs.algs4.StdOut;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/**
 * Created by Siddharth on 10/30/17.
 */
public class Coordinates implements Comparable<Coordinates> {
    int sum = 0;
    int indexX = 0;
    int indexY = 0;
    int x_coordinate = 0;
    int y_coordinate = 0;
    
    public Coordinates(int x_coordinate, int y_coordinate, int indexX, int indexY) {
        sum = x_coordinate + y_coordinate;
        this.indexX = indexX;
        this.indexY = indexY;
        this.x_coordinate = x_coordinate;
        this.y_coordinate = y_coordinate;
    }
    
    public int getX_coordinate(int x) {
        return x;
    }
    
    public int getY_coordinate(int y) {
        return y;
    }
    
    public int getIndexX(int index) {
        return index;
    }
    
    public int getIndexY(int index) {
        return index;
    }
    
    public int compareTo(Coordinates coordinates) {
        
        if(indexX < coordinates.indexX) {
            return -1;
        } else if(indexX == coordinates.indexX && indexY < coordinates.indexY) {
            return -1;
        } else if(indexX > coordinates.indexX) {
            return 1;
        } else if(indexX == coordinates.indexX && indexY > coordinates.indexY) {
            return 1;
        } else {
            return 0;
        }
    }
}
