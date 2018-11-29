/**
 *  Represents a Console Printer.
 *
 * @author Ryan Cocuzzo
 * @version 1.0
 * @since 1.0
 */

import java.util.ArrayList;

public class P {
    /**
     * Prints an array
     *
     * @param a the array to print
     */
    static <E extends Comparable> void printA(E[] a) {
        // Iterate
        for (E s: a)
            // Print
            print(" : " + s + " ");
        print("");
    }

    /**
     * Prints an array
     *
     * @param a the array to print
     */
    static <E> void printA(BinElement[] a) {
        // Iterate
        for (BinElement e: a)
            // Print
            print(" : " + e.toInt() + " ");
        print("");
    }

    /**
     * Prints the elements of a BinElement array
     *
     * @param a the array to print the elements of
     */
    static <E> void elements(BinElement[] a) {
        // Iterate
        for (BinElement e: a)
            // Print
            print(e.bin_rep + " ");
        print("");
    }

    /**
     * Prints the elements of a BinElement arraylist
     *
     * @param a the arraylist to print the elements of
     */
    static <E> void elements(ArrayList<BinElement> a) {
        // Iterate
        for (BinElement e: a)
            // Print
            print(e.bin_rep + " ");
        print("");
    }

    /**
     * Prints the indices of a BinElement array
     *
     * @param a the array to print the indices of
     */
    static <E> void indices(BinElement[] a) {
        // Iterate
        for (BinElement e: a)
            // Print
            print(e.index + " ");
        print("");
    }

    /**
     * Prints the indices of a BinElement arraylist
     *
     * @param a the arraylist to print the indices of
     */
    static <E> void indices(ArrayList<BinElement> a) {
        // Iterate
        for (BinElement e: a)
            // Print
            print(e.index + " ");
        print("");
    }

    /**
     * Prints an array
     *
     * @param a the array to print
     */
    static <E> void printA(E[] a) {
        // Iterate
        for (E e: a)
            // Print
            print(e + " ");
        print("");
    }

    /**
     * Prints a string
     *
     * @param s the string to print
     */
    static void print(String s) {
        System.out.println(s);
    }

    /**
     * Prints an integer
     *
     * @param s the integer to print
     */
    static void print(int s) {
        System.out.println(s);
    }
}
