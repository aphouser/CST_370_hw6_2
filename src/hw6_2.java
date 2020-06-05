/*
 * Title: hw6_2.java
 * Abstract: User inputs number for array size and chooses ascending, descending, or random order.  Program them compares
 *           sort times for insertion sort, mergesort, and quicksort over 3 runs.
 * Author: Adam Houser
 * ID: 1144
 * Date: 6/4/2020
 */

import java.util.Random;
import java.util.Scanner;

public class hw6_2 {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        System.out.println("Enter input size: ");

        // reads the user input number of items
        int num = in.nextInt();

        // create an array for data generation
        int[] data = new int[num];

        // gives user a choice of how to generate data
        System.out.println("========== Select Order of Input Numbers ==========");
        System.out.println("1. Ascending Order");
        System.out.println("2. Descending Order");
        System.out.println("3. Random Order");
        System.out.println("Choose order: ");

        // gets user choice
        int choice = in.nextInt();

        in.close();

        // generate data based on user choice
        if (choice == 1) {
            // this is ascending order start with data[0] = 1 and ascend from there
            for (int i = 0; i < data.length; i++) {
                data[i] = i+1;
            }
        }
        else {
            // this is descending order start with last and descend from there ex: for 350 entered data[0] = 350
            // we'll also use this to setup the data and shuffle it for random if they choose 3
            for (int i = 0; i < data.length; i++) {
                data[i] = data.length - i;
            }
        }
        if (choice == 3) {
            shuffle(data);
        }

        for (int i = 0; i < data.length; i++) {
            System.out.print(data[i] + " ");
        }
    }

    static void shuffle(int data[]) {
        // implementation of Fisher-Yates shuffle to generate random number distribution in array
        // Creating a object for Random class
        Random r = new Random();

        for (int i = data.length - 1; i > 0; i--) {
            // Pick a random index from 0 to i
            int j = r.nextInt(i + 1);

            // Swap data[i] with the element at random index
            int temp = data[i];
            data[i] = data[j];
            data[j] = temp;
        }
    }
}
