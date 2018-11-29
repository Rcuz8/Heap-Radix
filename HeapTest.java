/**
 *  Represents the HeapTest executable class. Contains the Radix-sort implementation.
 *
 * @author Ryan Cocuzzo
 * @version 1.0
 * @since 1.0
 */

import java.io.PrintStream;
import java.util.ArrayList;

public class HeapTest {

    public static void main(String[] args) {
        // Create test array
        Integer[] arr = {5, 18, 3, 25, 27, 45, 97, 88, 26, 16, 49, 67};
        // Instantiate heap
        Heap heap = new Heap(arr);

        /*
            Test Heap commands
         */

        heap.heapify();
        P.print("\nHeapified Heap:");
        // Print heap tree
        heap.print();

        // Create test array
        Integer[] arr2 = {15, 99, 3, 77, 27, 45, 7, 88, 26, 5};
        // Heapsort heap
        heap.heapsort(arr2);
        P.print("\nSorted Heap:");
        // Print heap tree
        heap.print();

        /*
            Test Radix Sort
         */
        

        Integer[] arr_1 = {5, 18, 72, 32, 27, 45, 65, 88, 26, 16, 49, 74};
        Integer[] arr_2 = {52, 28, 3, 64, 98, 28, 97, 4, 26, 16, 23, 61};
        Integer[] arr_3 = {15, 48, 2, 25, 5, 43, 36, 88, 101, 11, 49, 67};
        Integer[] arr_4 = {57, 13, 92, 33, 27, 45, 97, 88, 26, 16, 9, 91};
        Integer[] arr_5 = {23, 18, 17, 25, 1, 89, 6, 12, 2, 16, 12, 6};
        Integer[] arr_6 = {7, 18, 3, 25, 27, 36, 97, 88, 26, 16, 49, 67};

        // New Line
        P.print("");
        
        // Test my personal implementation
        
        my_radix_test(arr_1, 1);
        my_radix_test(arr_2, 2);
        my_radix_test(arr_3, 3);
        my_radix_test(arr_4, 4);
        my_radix_test(arr_5, 5);
        my_radix_test(arr_6, 6);
        

        Integer[] arr_7 = {5, 18, 72, 32, 27, 45, 65, 88, 26, 16, 49, 74};
        Integer[] arr_8 = {52, 28, 3, 64, 98, 28, 97, 4, 26, 16, 23, 61};
        Integer[] arr_9 = {15, 48, 2, 25, 5, 43, 36, 88, 101, 11, 49, 67};
        Integer[] arr_10 = {57, 13, 92, 33, 27, 45, 97, 88, 26, 16, 9, 91};
        Integer[] arr_11 = {23, 18, 17, 25, 1, 89, 6, 12, 2, 16, 12, 6};
        Integer[] arr_12 = {7, 18, 3, 25, 27, 36, 97, 88, 26, 16, 49, 67};
        
        // New Line
        P.print("");
        
        // Test the class implementation (default)

        default_radix_test(arr_7, 1);
        default_radix_test(arr_8, 2);
        default_radix_test(arr_9, 3);
        default_radix_test(arr_10, 4);
        default_radix_test(arr_11, 5);
        default_radix_test(arr_12, 6);

    }
    /**
    * Test my implementation of Radix sort.
    *
    * @param arr the test array
    * @param test_num the test number (for printing)
    */
    static void my_radix_test(Integer[] arr, int test_num) {
        
        // Mark Start time
        long start = System.currentTimeMillis();

        // Radix sort
        arr = RadixSort.radSort(arr);

        // Mark End time
        long end = System.currentTimeMillis();
        
        // Get difference in times
        long time = end - start;
        
        // Print
        P.print("My Test #" + test_num + " : " + time + " ms");
    }

    /**
    * Test my implementation of Radix sort.
    *
    * @param arr the test array
    * @param test_num the test number (for printing)
    */
    static void default_radix_test(Integer[] arr, int test_num) {

        // Mark Start time
        long start = System.currentTimeMillis();
        // Set threshold
        Sortmain.THRESHOLD = 2;
        // Radix sort
        Sortmain.Sort(arr);

        // Mark End time
        long end = System.currentTimeMillis();
        // Get difference
        long time = end - start;
        // Print
        P.print("Class Test #" + test_num + " : " + time + " ms");
    }



}
