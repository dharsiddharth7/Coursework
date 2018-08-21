import java.util.Scanner;

/**
 * Created by dhar1 on 9/8/16.
 */
public class ExpressionEvaluator {
    public static void main(String[] args) {
        Double n1,n2,n3,n4,n5,n6,n7,n8;
        String x1,x2,x3,x4,x5,x6,x7,x8;

        Scanner scan = new Scanner(System.in);
        String line = scan.nextLine();
        String original = new String(line);
        //String line = "(-10 + sqrt(25 * 4 - 4 * 3 * 2)) / (2 * 7)";

        x1 = line.substring(line.indexOf("(") + 1, line.indexOf("+"));
        line = line.substring(line.indexOf("+"));

        x2 = line.substring(line.indexOf("(") + 1, line.indexOf("*"));
        line = line.substring(line.indexOf("*"));

        x3 = line.substring(line.indexOf("*") + 1, line.indexOf("-"));
        line = line.substring(line.indexOf("-"));

        x4 = line.substring(line.indexOf("-") + 1, line.indexOf("*"));
        line = line.substring(line.indexOf("*") + 1) ;

        x5 = line.substring( 0, line.indexOf("*"));
        line = line.substring(line.indexOf("*"));

        x6 = line.substring(line.indexOf("*") + 1, line.indexOf(")"));
        line = line.substring(line.indexOf("/"));

        x7 = line.substring(line.indexOf("(") + 1, line.indexOf("*"));
        line = line.substring(line.indexOf("*"));

        x8 = line.substring(line.indexOf("*") + 1, line.indexOf(")"));

        n1 = Double.parseDouble(x1);
        n2 = Double.parseDouble(x2);
        n3 = Double.parseDouble(x3);
        n4 = Double.parseDouble(x4);
        n5 = Double.parseDouble(x5);
        n6 = Double.parseDouble(x6);
        n7 = Double.parseDouble(x7);
        n8 = Double.parseDouble(x8);


        Double denominator = n7 * n8;
        Double squareRoot = Math.sqrt(n2 * n3 - n4 * n5 * n6);
        Double result = (n1 + squareRoot) / denominator;


        System.out.println("Result is " + result);

    }

}

