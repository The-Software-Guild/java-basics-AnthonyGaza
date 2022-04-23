package rps;

import java.util.Random;
import java.util.Scanner;

public class UnderstandingDoTryCatch {

    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);
        Random rng = new Random();
        int rounds = 0;
        System.out.println("I want to play a game.\n");
        rounds = DTC1();
        System.out.println("rounds"+rounds);

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

    public static int DTC1(){
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
}
