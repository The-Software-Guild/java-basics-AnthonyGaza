package dog;

import java.util.Random;
import java.util.Scanner;

public class DogGenetics {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random rng = new Random();

        String[] dogBreeds = {"Corgi","Dachshund","Labradoodle","Alaskan Malamute","Pomeranian"};
        int[] percentages = new int[dogBreeds.length];
        int max = 100;
        int min = 1;

        for (int i=0; i< dogBreeds.length ;i++){
            if (i< dogBreeds.length-1) {
                percentages[i] = rng.nextInt(max - min) + min;
                max -= percentages[i];
            } else {
                percentages[i] = max;
            }
        }
        System.out.println("What is your dog's name?");
        String name = scanner.nextLine();
        System.out.println("Well then, I have this highly reliable report on "+ name
                +"'s prestigious background right here.\n"+
                name +" is:");
        for (int i=0; i< percentages.length;i++){
            System.out.println(percentages[i] + "% " + dogBreeds[i]);
        }

    }
}
