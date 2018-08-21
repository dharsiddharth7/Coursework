import java.util.Random;
import java.util.Scanner;

public class Game {
    private final static int ROCK = 1;
    private final static int PAPER = 2;
    private final static int SCISSORS = 3;
    private final static int QUIT = 4;
    
        public String comparator(int x) {
        if(x == ROCK)
            return "Rock";
        else if(x == PAPER)
            return "PAPER";
        else if(x == SCISSORS)
            return "Scissors";
        return "";
    }
    
        public void runGame() {
            Scanner sc = new Scanner(System.in);

            boolean isPlaying = false;

            
            while(!isPlaying) {
                System.out.println ("Welcome");
                System.out.println ("Please enter an option:");
                System.out.println ("1. Rock");
                System.out.println ("2. Paper");
                System.out.println ("3. Scissors");
                System.out.println ("4. Exit");

                    
                int userInput = sc.nextInt();
                
                if(userInput == QUIT) {
                    System.out.println ("Thanks for playing !");
                    break;
                }
                
                int move2 = simulateComputerMove();
                System.out.println("You played " + comparator(userInput));
                System.out.println ("Computer played " + comparator(move2));
                System.out.println("Winner is " + comparator(checkWinner(userInput, move2)));
                
            }
        
    }
    
        private int checkWinner (int move1 , int move2) {
       
         
        if (move1 == move2)
            
            return 0;
        else if ((move1 == 1 && move2 == 3) || (move1 == 2 && move2 == 1) || (move1 == 3 && move2 == 2)){
           
            System.out.println ("You win!");
            return 1;
            
        }
        else if ((move2 == 1 && move1 == 3) || (move2 == 2 && move1 == 1) || (move2 == 3 && move1 == 2)) {
            System.out.println ("You lose!");
            return 2;
        }
        else {
            System.out.println ("Thanks for playing!");
        }  
        
            return checkWinner(move1,move2);
        
    }
    
        private int simulateComputerMove () {
            //
            Random rd = new Random();
        
            //int move1 = sc.nextInt();
            //System.out.println ("You played " + comparator(move1));
        
            int move2 = rd.nextInt(3)+1;
            //System.out.println ("The computer played " + comparator(move2) + "!");
        
            //return checkWinner(move1,move2);
            return  move2;
        
    }
    
    public static void main(String[] args) {
        Game rps = new Game();
        rps.runGame();
    
    }
}