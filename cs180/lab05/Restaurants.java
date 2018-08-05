import java.util.Scanner;

public class Restaurants {
    // On campus
    public static final String ON_CAMPUS_VEGAN = "Purdue Dining Courts\nFlatbreads";
    public static final String ON_CAMPUS_VEGETARIAN = ON_CAMPUS_VEGAN + "\nOasis Cafe\nAh*Z\nFreshens";
    public static final String ON_CAMPUS_GLUTEN_FREE = "Purdue Dining Courts\nFlatbreads\nOasis Cafe\nPappy's " +
            "Sweet Shop";
    public static final String ON_CAMPUS_BURGERS = "Pappy's Sweet Shop\nCary Knight Spot";
    public static final String ON_CAMPUS_SANDWICHES = "Flatbreads\nOasis Cafe\nErbert & Gerbert's";
    public static final String ON_CAMPUS_OTHERS = "Purdue Dining Courts\nAh*Z\nFreshens\nLemongrass";
    public static final String ON_CAMPUS_ALL = ON_CAMPUS_BURGERS + "\n" + ON_CAMPUS_SANDWICHES + "\n" +
            ON_CAMPUS_OTHERS;

    // Off campus
    public static final String OFF_CAMPUS_VEGAN = "Chipotle\nQdoba\nNine Irish Brothers\nFive Guys\n Puccini's " +
            "Smiling Teeth\nPanera Bread";
    public static final String OFF_CAMPUS_VEGETARIAN = OFF_CAMPUS_VEGAN + "\nWendy's\nBruno's Pizza\nJimmy " +
            "John's\nPotbelly Sandwich Shop\nBasil Thai\nIndia Mahal";
    public static final String OFF_CAMPUS_GLUTEN_FREE = "Chipotle\nQdoba\nNine Irish Brothers\nPuccini's Smiling " +
            "Teeth\nWendy's\nScotty's Brewhouse\nPanera Bread\nBasil Thai";
    public static final String OFF_CAMPUS_BURGERS = "Five Guys\nWendy's\nTriple XXX\nScotty's Brewhouse";
    public static final String OFF_CAMPUS_SANDWICHES ="Panera Bread\nJimmy John's\nPotbelly Sandwich Shop";
    public static final String OFF_CAMPUS_PIZZAS = "Puccini's Smiling Teeth\nMad Mushroom Pizza\nBruno's Pizza\n";
    public static final String OFF_CAMPUS_OTHERS = "Chipotle\nQdoba\nNine Irish Brothers\nFamous Frank's\n Von's " +
            "Dough Shack\nBuffalo Wild Wings\nBasil Thai\nMaru Sushi\nIndia Mahal\nHappy China\nYori";
    public static final String offCampusAll = OFF_CAMPUS_BURGERS + "\n" + OFF_CAMPUS_SANDWICHES + "\n" +
            OFF_CAMPUS_PIZZAS + OFF_CAMPUS_OTHERS;
    public static void main (String[] args) {
        Scanner sc = new Scanner (System.in);
        
        System.out.println ("1. On Campus");
        System.out.println ("2. Off Campus");
        
        int num = sc.nextInt();
        
        if (num == 1) {
            System.out.println ("Dietary Restrictions? (Y/N)");
            String input = sc.next();
        
            if (input.equalsIgnoreCase("Y")) {
            
                System.out.println ("1.Vegan" + "\n" + "2.Vegetarian" + "\n" + "3.Gluten-free");
                String num2 = sc.next();
            
                if (num2.equals("1"))
                System.out.println (ON_CAMPUS_VEGAN);
            
                if (num2.equals("2"))
                System.out.println (ON_CAMPUS_VEGETARIAN);
            
                if (num2.equals("3"))
                System.out.println (ON_CAMPUS_GLUTEN_FREE);
            }
            
            else if (input.equalsIgnoreCase("N")) {
                System.out.println ("Food Preference? (Y/N)");
                
                String input2 = sc.next();
                
                if (input2.equalsIgnoreCase("N"))
                    System.out.println (ON_CAMPUS_ALL);
                
                if (input2.equalsIgnoreCase("Y"))
                    System.out.println ("1.Burgers" + "\n" + "2.Sandwiches" + "\n" + "3.Others");
                
                int num2 = sc.nextInt();
                
                if (num2 == 1) 
                    System.out.println(ON_CAMPUS_BURGERS);
                if (num2 == 2)
                    System.out.println (ON_CAMPUS_SANDWICHES);
                if (num2 == 3)
                    System.out.println(ON_CAMPUS_OTHERS);
                
            }
        } else if (num == 2) {
            System.out.println ("Dietary Restrictions? (Y/N)");
            String input = sc.next();
        
            if (input.equalsIgnoreCase("Y")) {
            
                System.out.println ("1.Vegan" + "\n" + "2.Vegetarian" + "\n" + "3.Gluten-free");
                String num2 = sc.next();
            
                if (num2.equals("1"))
                System.out.println (OFF_CAMPUS_VEGAN);
            
                if (num2.equals("2"))
                System.out.println (OFF_CAMPUS_VEGETARIAN);
            
                if (num2.equals("3"))
                System.out.println (OFF_CAMPUS_GLUTEN_FREE);
            }
            
            else if (input.equalsIgnoreCase("N")) {
                System.out.println ("Food Preference? (Y/N)");
                
                String input2 = sc.next();
                
                if (input2.equalsIgnoreCase("N"))
                    System.out.println (offCampusAll);
                
                if (input2.equalsIgnoreCase("Y"))
                    System.out.println ("1.Burgers" + "\n" + "2.Sandwiches" + "\n" + "3.Pizza" + "\n" + "4.Others");
                
                int num2 = sc.nextInt();
                
                if (num2 == 1) 
                    System.out.println(OFF_CAMPUS_BURGERS);
                if (num2 == 2)
                    System.out.println (OFF_CAMPUS_SANDWICHES);
                if (num2 == 3)
                    System.out.println(OFF_CAMPUS_PIZZAS);
                if (num2 == 4)
                    System.out.println (OFF_CAMPUS_OTHERS);
                
            }
        }
        
    }
}