package hearts;
import java.util.Scanner;

public class HealthyHearts {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int age = 0;

        boolean validInput = false;
        do {
            try {
                System.out.println("Hello. Please enter your age:");
                age = Integer.parseInt(scanner.nextLine());

                if (age >= 1) {
                    validInput = true;
                }

            } catch(NumberFormatException ex) {
                System.out.println("** Please enter a number **\n");
            }

        } while(!validInput);


        int maxHeartRate = 220-age;
        double zoneMax = age*0.85;
        double zoneMin = age*0.5;
        System.out.printf("\nYour maximum heart rate should be %d beats per minute" +
                ". Your target HR Zone is %.0f to %.0f beats per minute%n", maxHeartRate,  zoneMin, zoneMax);
    }
}