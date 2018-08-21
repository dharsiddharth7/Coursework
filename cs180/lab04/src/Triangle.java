/**
 * Created by dhar1 on 9/15/16.
 */
public class Triangle {
    private double triangleSide;

    public Triangle(double triangleSide) {
        this.triangleSide = triangleSide;
    }

    public double getPerimeter() {
        double perimeter = (3*triangleSide);
        return perimeter;
    }

    public double getArea() {
        double area =  (Math.sqrt(3)/4)*(Math.pow(triangleSide,2));
        return area;
    }

}
