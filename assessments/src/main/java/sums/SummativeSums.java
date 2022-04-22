package main.java.sums;

public class SummativeSums {
    public static void main(String[] args) {
        int[] Array1 = {1, 90, -33, -55, 67, -16, 28, -55, 15};
        int[] Array2 = { 999, -60, -77, 14, 160, 301 };
        int[] Array3 = { 10, 20, 30, 40, 50, 60, 70, 80, 90, 100, 110,
                120, 130, 140, 150, 160, 170, 180, 190, 200, -99 };
        int[][] jaggedArray = {Array1,Array2,Array3};

        for (int i = 0; i < jaggedArray.length; i++){
            System.out.print("Sum of Array "+(i+1)+" ");
            System.out.println(arrayAdder(jaggedArray[i]));
        }


    }

    public static int arrayAdder(int[] array){
        int result=0;
        for (int j : array) {
            result += j;
        }
        return result;
    }

}
