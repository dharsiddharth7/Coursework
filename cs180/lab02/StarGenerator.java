import java.util.Scanner;
import java.util.Random;
/**
 *CS180 - Lab02
 *This program takes two inputs from the user and generates a Purdue email address for the user based on the input name.
 *@author Siddharth Dhar, dhar1@purdue.edu, G044;
 *@version 09/01/2016
 */
public class StarGenerator {
    public static void main(String[]args) {
	Scanner sc = new Scanner(System.in);

	String firstName,lastName,name,college,email,namelwr;

	System.out.println("Please enter your name:");
	name = sc.nextLine();
	namelwr = name.toLowerCase();

	System.out.println ("Enter the college that you are in: ");
	college = sc.nextLine();

	email = namelwr.charAt(0) + namelwr.substring(namelwr.indexOf(" ") + 1, namelwr.length()) + "@purdue.edu";

	Random rd = new Random();
	int rdnum = rd.nextInt(5);

	System.out.println ("Your Name: " + name);
	System.out.println("Your Email: " + email.toLowerCase());
	System.out.println("Your College: " + college);
	System.out.println("STAR Group: " + college.substring(0,3).toUpperCase() + rdnum);

    }
}

	
