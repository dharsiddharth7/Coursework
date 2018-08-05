/**
 * Created by Siddharth on 11/15/17.
 */
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

