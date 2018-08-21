/**
 * Created by dhar1 on 9/15/16.
 */
public class Rectangle {
    public double length,breadth;

    public Rectangle(double length,double breadth){
        this.length = length;
        this.breadth = breadth;
    }

    public double getPerimeter() {
        double perimeter = 2*(length+breadth);
        return perimeter;
    }

    public double getArea() {
        double area = length*breadth;
        return area;
    }
}
