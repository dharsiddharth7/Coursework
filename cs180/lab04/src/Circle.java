/**
 * CS - 180 Lab05
 * Created by dhar1 on 9/15/16.
 */
public class Circle {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    public double getCircumference() {
        double circumference;

        circumference = 2*Math.PI*radius;
        return circumference;
    }

    public double getArea() {
        double area;

        area = Math.PI*radius*radius;
        return area;
    }
}
