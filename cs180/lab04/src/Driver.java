import java.util.Scanner;
/**
 * Created by dhar1 on 9/15/16.
 */
public class Driver {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the radius of the Circle: ");
        double radius = sc.nextDouble();
        Circle c = new Circle(radius);
        System.out.println ("The Perimeter of the Circle is " + c.getCircumference());
        System.out.println ("The Area of the circle is " + c.getArea());


        System.out.println("Enter the length of the Rectangle: ");
        double length = sc.nextDouble();
        System.out.println ("Enter the breadth of the Rectangle: ");
        double breadth = sc.nextDouble();
        Rectangle r = new Rectangle(length,breadth);
        System.out.println ("The Perimeter of the Rectangle is " + r.getPerimeter());
        System.out.println ("The Area of the Rectangle is " + r.getArea());

        System.out.println ("Enter the side of the Triangle: ");
        double side = sc.nextDouble();
        Triangle t = new Triangle(side);
        System.out.println("The Perimeter of the Triangle is " + t.getPerimeter());
        System.out.println ("The Area of the Triangle is " + t.getArea());


    }
}
