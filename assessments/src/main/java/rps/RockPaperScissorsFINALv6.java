package main.java.rps;

import java.util.Random;
import java.util.Scanner;

public class RockPaperScissorsFINALv6 {
    public static void main(String[] args) {
        boolean restart = true;
        while (restart) {
            Scanner scanner = new Scanner(System.in);
            Random rng = new Random();
            int rounds = 0;
            System.out.println("I want to play a game.\n");
            boolean validRoundsInput = false;
            do {
                try {
                    System.out.println("How many rounds would you like to play? (1-10)");
                    rounds = Integer.parseInt(scanner.nextLine());
                    validRoundsInput = outOfBoundsCheckQuit(1, 10, rounds);
                    outOfBoundsCheckQuit(1, 10, rounds);
                } catch (NumberFormatException ex) {
                    System.out.println("** Please enter a number **");
                }

            } while (!validRoundsInput);

            //score tracking
            int computerScore = 0;
            int playerScore = 0;
            int draws = 0;
            String[] throwName = {"Rock", "Paper", "Scissors"};
            int playerThrow = 0;

            //looping through rounds
            for (int i = 0; i < rounds; i++) {
                boolean validPlayerInput = false;
                do {
                    try {
                        System.out.println("Round " + (i + 1) + ". Prepare your throw.\n[1]Rock\n[2]Paper\n[3]Scissors");

                        playerThrow = Integer.parseInt(scanner.nextLine()) - 1;
                        validPlayerInput = outOfBoundsCheck(0, 2, playerThrow);

                    } catch (NumberFormatException ex) {
                        System.out.println("** Please enter a number **\n-----");
                    }

                } while (!validPlayerInput);


                //computer chooses throw via random number
                int computerThrow = rng.nextInt(throwName.length);//possible values : 0,1,2.

                System.out.println("\nYou chose: " + throwName[playerThrow] + "\nComputer chose: " + throwName[computerThrow]);

                if (playerThrow == computerThrow) {
                    System.out.println("draw!");
                    draws += 1;
                } else {
                    String winner = winnerCheckIfNotDraw(playerThrow, computerThrow);
                    System.out.println(winner);
                    if (winner.equalsIgnoreCase("you win!")) {
                        playerScore++;
                    } else {
                        computerScore++;
                    }
                }
                System.out.println("current scores - Computer: " + computerScore + ", Player: " + playerScore + " Draws:" + draws + "\n");
            }
            System.out.println("final score - computer: " + computerScore + " player: " + playerScore + " Draws:" + draws);
            if (computerScore == playerScore) {
                System.out.println("overall - DRAW");
            } else if (computerScore > playerScore) {
                System.out.println("Computer wins!");
            } else {
                System.out.println("You win!");
            }


            boolean validRestartResponse = false;
            do {
                try {
                    System.out.println("would you like to play again?\n[0]NO\n[1]YES");
                    int response = Integer.parseInt(scanner.nextLine());

                    if (response==0){
                        //System.exit(0);
                        restart = false;
                    } else if (response==1) {
                        System.out.println("restarting.\n");
                    }
                    if (response==1 || response==0) {
                        validRestartResponse = true;
                    }
                } catch(NumberFormatException ex) {
                    System.out.println("** That was not a valid response. **\nPlease enter [0] or [1]\n");
                }
            } while(!validRestartResponse);
        }
    }
    public static boolean outOfBoundsCheckQuit(int lowerBound, int upperBound, int input){
        //method to check if user input is valid.
        if (input<lowerBound || input>upperBound){
            System.out.println("** Error - Out of bounds. Exiting. **");
            System.exit(0);
        } else {
            return true;
        }
        return false;
    }
    public static boolean outOfBoundsCheck(int lowerBound, int upperBound, int input){
        if (input<lowerBound || input>upperBound){
            System.out.println("** Error - Out of bounds. Choose a valid throw **.\n-----------------");
            return false;
        } else {
            return true;
        }
    }

    public static String winnerCheckIfNotDraw(int playerMove,int compMove){
        if ((playerMove==0 && compMove==2)||(playerMove==1&&compMove==0)||(playerMove==2&&compMove==1)){
            return "You win!";
        } else {
            return "Computer Wins!";
        }
    }
}
