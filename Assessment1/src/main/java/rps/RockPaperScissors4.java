package rps;

import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors4 {
    static int computerScore = 0;
    static int playerScore = 0;
    static int draws = 0;
    static boolean restart = true;
    public static void main(String[] args) {
        boolean restart = true;
        while (restart) {
            Scanner scanner = new Scanner(System.in);
            Random rng = new Random();
            int rounds;
            System.out.println("I want to play a game.\n");

            rounds = getRoundsCatchInvalid();
            String[] throwName = {"Rock", "Paper", "Scissors"};

            for (int i = 0; i < rounds; i++) {

                int playerThrow = getThrowCatchInvalid(i);

                //computer chooses throw via random number
                int computerThrow = rng.nextInt(throwName.length);//possible values : 0,1,2.

                System.out.println("\nYou chose: " + throwName[playerThrow] + "\nComputer chose: " + throwName[computerThrow]);

                whoWon(playerThrow,computerThrow);

                System.out.println("current scores - Computer: " + computerScore + ", Player: " + playerScore + " Draws:" + draws + "\n");
            }
            overallWinnerCheck();
            restartChoice();
        }
    }
    public static boolean outOfBoundsCheckQuit(int lowerBound, int upperBound, int input){
        if (input<lowerBound || input>upperBound){
            System.out.println("** Error - Out of bounds. Exiting. **");
            System.exit(0);
        } else {
            return true;//returns true so the do (try catch) while loop can exit
        }
        return false;
    }
    public static boolean outOfBoundsCheck(int lowerBound, int upperBound, int input){
        if (input<lowerBound || input>upperBound){
            System.out.println("** Error - Out of bounds. Choose a valid throw **.\n-----------------");
            return false;
        } else {
            return true;//returns true so the do (try catch) while loop can exit
        }
    }
    public static String winnerCheckIfNotDraw(int playerMove,int compMove){
        if ((playerMove==0 && compMove==2)||(playerMove==1&&compMove==0)||(playerMove==2&&compMove==1)){
            return "You win this round!";
        } else {
            return "Computer wins this round!";
        }
    }
    public static int getRoundsCatchInvalid(){
        boolean validRoundsInput = false;
        Scanner scanner = new Scanner(System.in);
        int rounds = 0;
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
        return rounds;
    }
    public static int getThrowCatchInvalid(int i){
        boolean validPlayerInput = false;
        Scanner scanner = new Scanner(System.in);
        int playerThrow=0;
        do {
            try {
                System.out.println("Round " + (i + 1) + ". Prepare your throw.\n[1]Rock\n[2]Paper\n[3]Scissors");

                playerThrow = Integer.parseInt(scanner.nextLine()) - 1;
                validPlayerInput = outOfBoundsCheck(0, 2, playerThrow);

            } catch (NumberFormatException ex) {
                System.out.println("** Please enter a number **\n-----");
            }

        } while (!validPlayerInput);
        return playerThrow;
    }
    public static void whoWon(int playerThrow, int computerThrow){
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
    }
    public static void restartChoice(){
        boolean validRestartResponse = false;
        Scanner scanner = new Scanner(System.in);
        do {
            try {
                System.out.println("would you like to play again?\n[0]NO\n[1]YES");
                int response = Integer.parseInt(scanner.nextLine());

                if (response==0){
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
    public static void overallWinnerCheck(){
        System.out.println("final score - computer: " + computerScore + " player: " + playerScore + " Draws:" + draws);
        if (computerScore == playerScore) {
            System.out.println("overall - DRAW");
        } else if (computerScore > playerScore) {
            System.out.println("Computer wins!");
        } else {
            System.out.println("You win!");
        }
    }
}
