import javax.swing.*;
/**
 * CS180 - Lab02
 * This program takes an input word from a user and decodes this word from the user and decodes this word this word and displays the result to the user.
 *@author Siddharth Dhar, dhar1@purdue.edu, G044
@version 09/01/2016
*/

public class WordFixGUI {
    public static void main(String[] args) {

		String input,finalString;

		input = JOptionPane.showInputDialog(null,"Enter a word to be deciphered: ");
		char firstChar = input.charAt(0);
		char lastChar =input.charAt(input.length()-1);


		int ast = input.indexOf('*');
        String beforeast = input.substring(1,ast);
		String afterast = input.substring(ast + 1,input.length()-1);
        finalString = lastChar+afterast+beforeast+firstChar;

   	    JOptionPane.showMessageDialog(null,finalString);

	}
 }
	
	
	

	
				   
					    
	
    
