/*
 * Title: hw6_2.java
 * Abstract: User inputs number for array size and chooses ascending, descending, or random order.  Program them compares
 *           sort times for insertion sort, mergesort, and quicksort over 3 runs.
 * Author: Adam Houser
 * ID: 1144
 * Date: 6/5/2020
 */

import java.time.Duration;
import java.time.Instant;
import java.util.Random;
import java.util.Scanner;

public class hw6_2 {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        // for calculating the average of each sort method
        double iAvg = 0;
        double mAvg = 0;
        double qAvg = 0;

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

        System.out.println("============================================================");

        // generate data based on user choice
        if (choice == 1) {
            // this is ascending order start with data[0] = 1 and ascend from there
            for (int i = 0; i < data.length; i++) {
                data[i] = i+1;
            }

            // printing for format
            System.out.println("Generate input data in ascending order . . .");

        }
        else if (choice == 2) {
            // this is descending order start with last and descend from there ex: for 350 entered data[0] = 350
            // we'll also use this to setup the data and shuffle it for random if they choose 3
            for (int i = 0; i < data.length; i++) {
                data[i] = data.length - i;
            }

            // printing for format
            System.out.println("Generate input data in descending order . . .");
        }
        else if (choice == 3) {
            Random rd = new Random();

            for (int i = 0; i < data.length; i++) {
                data[i] = rd.nextInt();
            }

            // printing for format
            System.out.println("Generate input data in random order . . .");

        }

        System.out.println("Done.");
        System.out.println("============================================================");
        System.out.println();

        // prepare arrays for each of the three sorting methods gives them the same data to pull from
        int insertData[] = data.clone();
        int mergeData[] = data.clone();
        int quickData[] = data.clone();

        // call each sort method the first time
        System.out.println("========================== 1st Run =========================");
        Instant iStart1 = Instant.now();
        insertionSort(insertData);
        Instant iEnd1 = Instant.now();
        long iDelta1 = Duration.between(iStart1, iEnd1).toMillis();
        System.out.println("Insertion sort: " + iDelta1 + " milliseconds");

        Instant mStart1 = Instant.now();
        mergeSort(mergeData, 0, mergeData.length - 1);
        Instant mEnd1 = Instant.now();
        long mDelta1 = Duration.between(mStart1, mEnd1).toMillis();
        System.out.println("Merge sort:     " + mDelta1 + " milliseconds");

        Instant qStart1 = Instant.now();
        quickSort(quickData, 0, quickData.length - 1);
        Instant qEnd1 = Instant.now();
        long qDelta1 = Duration.between(qStart1, qEnd1).toMillis();
        System.out.println("Quick sort:     " + qDelta1 + " milliseconds");

        System.out.println("============================================================");
        System.out.println();

        // add the deltas to the avg
        iAvg += iDelta1;
        mAvg += mDelta1;
        qAvg += qDelta1;

        // reset the arrays for run 2
        for (int i = 0; i < data.length; i++) {
            insertData[i] = data[i];
            mergeData[i] = data[i];
            quickData[i] = data[i];
        }

        // call each sort method the second time
        System.out.println("========================== 2nd Run =========================");
        Instant iStart2 = Instant.now();
        insertionSort(insertData);
        Instant iEnd2 = Instant.now();
        long iDelta2 = Duration.between(iStart2, iEnd2).toMillis();
        System.out.println("Insertion sort: " + iDelta2 + " milliseconds");

        Instant mStart2 = Instant.now();
        mergeSort(mergeData, 0, mergeData.length - 1);
        Instant mEnd2 = Instant.now();
        long mDelta2 = Duration.between(mStart2, mEnd2).toMillis();
        System.out.println("Merge sort:     " + mDelta2 + " milliseconds");

        Instant qStart2 = Instant.now();
        quickSort(quickData, 0, quickData.length - 1);
        Instant qEnd2 = Instant.now();
        long qDelta2 = Duration.between(qStart2, qEnd2).toMillis();
        System.out.println("Quick sort:     " + qDelta2 + " milliseconds");

        System.out.println("============================================================");
        System.out.println();

        // add the deltas to the avg
        iAvg += iDelta2;
        mAvg += mDelta2;
        qAvg += qDelta2;

        // reset the arrays for run 3
        for (int i = 0; i < data.length; i++) {
            insertData[i] = data[i];
            mergeData[i] = data[i];
            quickData[i] = data[i];
        }

        // call each sort method the third time
        System.out.println("========================== 3rd Run =========================");
        Instant iStart3 = Instant.now();
        insertionSort(insertData);
        Instant iEnd3 = Instant.now();
        long iDelta3 = Duration.between(iStart3, iEnd3).toMillis();
        System.out.println("Insertion sort: " + iDelta3 + " milliseconds");

        Instant mStart3 = Instant.now();
        mergeSort(mergeData, 0, mergeData.length - 1);
        Instant mEnd3 = Instant.now();
        long mDelta3 = Duration.between(mStart3, mEnd3).toMillis();
        System.out.println("Merge sort:     " + mDelta3 + " milliseconds");

        Instant qStart3 = Instant.now();
        quickSort(quickData, 0, quickData.length - 1);
        Instant qEnd3 = Instant.now();
        long qDelta3 = Duration.between(qStart3, qEnd3).toMillis();
        System.out.println("Quick sort:     " + qDelta3 + " milliseconds");

        System.out.println("============================================================");
        System.out.println();

        // add the deltas to the avg
        iAvg += iDelta3;
        mAvg += mDelta3;
        qAvg += qDelta3;

        // calculate average
        iAvg = iAvg/3;
        mAvg = mAvg/3;
        qAvg = qAvg/3;

        // print results
        System.out.println("========================== Ranking =========================");
        System.out.println("iAvg " + iAvg);
        System.out.println("mAvg " + mAvg);
        System.out.println("qAvg " + qAvg);
        System.out.println("============================================================");
    }

    // this insersertion sort taken from Geeksforgeeks.org
    // https://www.geeksforgeeks.org/insertion-sort/
    static void insertionSort(int arr[]) {
        int n = arr.length;
        for (int i = 1; i < n; ++i) {
            int key = arr[i];
            int j = i - 1;

            /* Move elements of arr[0..i-1], that are
               greater than key, to one position ahead
               of their current position */
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
    }

    // this merge sort and merge method taken from Geeksforgeeks.org
    // https://www.geeksforgeeks.org/merge-sort/
    // Merges two subarrays of arr[]. First subarray is arr[l..m] Second subarray is arr[m+1..r]
    static void merge(int arr[], int l, int m, int r)
    {
        // Find sizes of two subarrays to be merged
        int n1 = m - l + 1;
        int n2 = r - m;

        /* Create temp arrays */
        int L[] = new int [n1];
        int R[] = new int [n2];

        /*Copy data to temp arrays*/
        for (int i=0; i<n1; ++i)
            L[i] = arr[l + i];
        for (int j=0; j<n2; ++j)
            R[j] = arr[m + 1+ j];


        /* Merge the temp arrays */

        // Initial indexes of first and second subarrays
        int i = 0, j = 0;

        // Initial index of merged subarry array
        int k = l;
        while (i < n1 && j < n2)
        {
            if (L[i] <= R[j])
            {
                arr[k] = L[i];
                i++;
            }
            else
            {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        /* Copy remaining elements of L[] if any */
        while (i < n1)
        {
            arr[k] = L[i];
            i++;
            k++;
        }

        /* Copy remaining elements of R[] if any */
        while (j < n2)
        {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    // Main function that sorts arr[l..r] using
    // merge()
    static void mergeSort(int arr[], int l, int r)
    {
        if (l < r)
        {
            // Find the middle point
            int m = (l+r)/2;

            // Sort first and second halves
            mergeSort(arr, l, m);
            mergeSort(arr , m+1, r);

            // Merge the sorted halves
            merge(arr, l, m, r);
        }
    }

    // this quicksort and partition method taken from Geeksforgeeks.org
    // https://www.geeksforgeeks.org/quick-sort/
    /* This function takes last element as pivot, places the pivot element at its correct
       position in sorted array, and places all smaller (smaller than pivot) to left of
       pivot and all greater elements to right of pivot */
    static int partition(int arr[], int low, int high)
    {
        int pivot = arr[high];
        int i = (low-1); // index of smaller element
        for (int j=low; j<high; j++)
        {
            // If current element is smaller than the pivot
            if (arr[j] < pivot)
            {
                i++;

                // swap arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // swap arr[i+1] and arr[high] (or pivot)
        int temp = arr[i+1];
        arr[i+1] = arr[high];
        arr[high] = temp;

        return i+1;
    }


    /* The main function that implements QuickSort()
      arr[] --> Array to be sorted,
      low  --> Starting index,
      high  --> Ending index */
    static void quickSort(int arr[], int low, int high)
    {
        if (low < high)
        {
            /* pi is partitioning index, arr[pi] is now at right place */
            int pi = partition(arr, low, high);

            // Recursively sort elements before partition and after partition
            quickSort(arr, low, pi-1);
            quickSort(arr, pi+1, high);
        }
    }
}
