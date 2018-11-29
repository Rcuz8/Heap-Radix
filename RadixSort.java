import java.util.ArrayList;

/**
 *  Represents the Radix-sort implementation.
 *
 * @author Ryan Cocuzzo
 * @version 1.0
 * @since 1.0
 */

public class RadixSort {



    /**
     * Bitshifts integer right
     *
     * @param n int to bitshift
     * @return the bitshifted int
     */
    private static int bitShiftRight(int n) {
        return n>>1;
    }

    /**
     * Bitshifts an array of BinElements right
     *
     * @param a array of BinElements
     * @return the bitshifted array
     */
    private static void iterateAndBitShift(BinElement[] a) {
        // Iterate through array
        for (int i = 0; i < a.length; i++) {
            // Parse binary rep of int (base 2) into int
            int x = Integer.parseInt(a[i].bin_rep,2);
            // Get bitshifted binary rep if element
            String shifted_rep = Integer.toBinaryString(bitShiftRight(x));
            // Set the bin rep of element equal to it's bitshifted self
            a[i].bin_rep = shifted_rep;
        }
        // pad each element with zeros to have the same amount of binary digits
        pad(a);
    }

    /**
     * Pads the elements with zeros
     * @param els the elements to pad
     */
    private static void pad(BinElement[] els) {
        // Get max element
        BinElement max = max(els);
        // Get padded version of element array
        String[] padded = paddedElements(els);
        // Iterate and copy padded new binary rep to element's unpadded binary rep
        for (int i = 0; i < els.length; i++) {
            // Copy
            els[i].bin_rep = padded[i];
        }
    }

    /**
     * Radix Sort => Sorts an array if Integers
     *
     * @param arr the unsorted array
     * @return the sorted array
     */
    public static Integer[] radSort(Integer[] arr) {
        // Clone arr (not needed, I don't think)
        Integer[] a_clone = arr.clone();
        // Create new BinElement array to track indices
        BinElement[] elements = new BinElement[arr.length];

        // Get padded string reps
        String[] string_numbers = paddedIntegers(arr);

        // Copy string arr into elements
        for (int i = 0; i < arr.length; i++) {
            elements[i] = new BinElement(i, string_numbers[i]);
        }

        // While all integers are not zero
        while (!allZero(elements)) {
            // Intantiate bins
            ArrayList<BinElement> b1 = new ArrayList<>();
            ArrayList<BinElement> b0 = new ArrayList<>();

            // Iterate through elements
            for (int i = 0; i < elements.length; i++) {
                // Get string at index
                String el = elements[i].bin_rep;
                // Get last char
                char last = el.charAt(el.length()-1);
                // Check last digit and add arr element to bin
                if (last == '0') {
                    b0.add(elements[i]);
                } else {
                    b1.add(elements[i]);
                }

            }

            // Convert lists to arrays and conjoin into one array
            elements = conjoin(convertedList(b0), convertedList(b1));

            // Shift each element
            iterateAndBitShift(elements);

            // Get padded string reps
            String[] string_numbers_2 = paddedElements(elements); // To be regenerated

            // Copy string arr into elements
            for (int i = 0; i < arr.length; i++) {
                elements[i].bin_rep = string_numbers_2[i];
            }

        }

        // Create new temp sorted array
        Integer[] sorted = new Integer[arr.length];

        // Iterate through sorted elements' values
        for (int i = 0; i < elements.length; i++) {
            // Get index of element in original array (a_clone)
            int index = elements[i].index;
            // Get element in array
            Integer unsortedEl = a_clone[index];
            // Set to new sorted array
            sorted[i] = unsortedEl;
        }

        return sorted;

    }

    /**
     * Checks whether or not the array consists entirely of zeros
     * @param a the array
     * @return whether or not the array consists entirely of zeros
     */
    private static boolean allZero(BinElement[] a) {
        // Iterate through each element
        for (BinElement i: a) {
            // Check for null
            if (i == null) P.print(" found null el!");
            // Check for no binary rep
            if (i.bin_rep == null) P.print(" found null binrep in el!");
            // Check if el is zero. If yes, return that not all elements are zero
            if (i.bin_rep.compareTo("0") != 0)
                return false;
        }
        // Return all elements are zero
        return true;
    }

    /**
     * Converts AList to array
     * @param list list to convert
     * @return Alist as standard array
     */
    private static BinElement[] convertedList(ArrayList<BinElement> list) {
        // Init new temp list
        BinElement[] a = new BinElement[list.size()];
        // Iterate and insert el into arr
        for (int i = 0; i < list.size(); i++) {
            a[i] = list.get(i);
        }
        return a;
    }

    /**
     * Conjoins two arrays into one
     *
     * @param a the first, lesser array
     * @param b the second, larger array
     * @return the conjoined array of size (a.length+b.length)
     */
    private static BinElement[] conjoin(BinElement[] a, BinElement[] b) {
        // New temp array to hold both arrays
        BinElement[] temp = new BinElement[a.length + b.length];
        // Import els from a
        for (int i = 0; i < a.length; i++) {
            temp[i] = a[i];
        }
        // import els from b
        for (int i = a.length; i < temp.length; i++) {
            temp[i] = b[i-a.length];
        }
        return temp;
    }

    /**
     * Gets max element in Integer array
     *
     * @param arr the array
     * @return the max element
     */
    private static Integer max(Integer[] arr) {
        // Check arr length
        assert (arr.length > 1) : "Invalid request for max: array size zero!";
        // Get first value
        int max = arr[0].intValue();
        // Iterate through, checking for higher max
        for (Integer i: arr)
            // If val > max, set max to val
            if (i.intValue() > max)
                max = i.intValue();
        return max;
    }

    /**
     * Gets max element in BinElement array
     *
     * @param arr the array
     * @return the max element
     */
    private static BinElement max(BinElement[] arr) {
        // Check arr length
        assert (arr.length > 1) : "Invalid request for max: array size zero!";
        // Get first value
        BinElement max = arr[0];
        // Get max bin rep
        int mbr = Integer.parseInt(max.bin_rep, 2);
        // Iterate through, checking for higher max
        for (BinElement i: arr)
            // If parsed val > parsed max, set max to val
            if (Integer.parseInt(i.bin_rep, 2) > mbr)
                max = i;
        return max;
    }

    /**
     * Pads an array of integers
     *
     * @param arr the array of integers
     * @return the padded binary string representation of the integers
     */
    private static String[] paddedIntegers(Integer[] arr) {
        // Get max value
        Integer max = max(arr);
        // Make temp str array
        String[] strings = new String[arr.length];
        // Iterate & convert (pad)
        for (int i = 0; i < arr.length; i++)
            strings[i] = paddedN(arr[i], max);
        return strings;
    }

    /**
     * Pads an array of BinElements
     *
     * @param arr the array of BinElements
     * @return the padded binary string representation of the BinElements
     */
    private static String[] paddedElements(BinElement[] arr) {
        // Get max value
        BinElement max = max(arr);
        // Get max bin rep
        int mbr = Integer.parseInt(max.bin_rep,2);
        // Make temp str array
        String[] strings = new String[arr.length];
        // Iterate & convert (pad)
        for (int i = 0; i < arr.length; i++)
            strings[i] = paddedN(Integer.parseInt(arr[i].bin_rep,2), mbr);
        return strings;
    }

    /**
     * Pads number with zeros, in accordance to the amount the max value has.
     *
     * @param n the number
     * @param max the max value
     * @return the padded binary string representation of the number
     */
    private static String paddedN(Integer n, Integer max) {
        // Get the max string rep
        String max_string = Integer.toBinaryString(max.intValue());
        // Get the int value of n
        int n_val = n.intValue();
        // Get the bin string of n when it has a padding to the length of max string and take out first element
        String new_bin_rep_of_n = Integer.toBinaryString( (1 << max_string.length()) | n_val ).substring( 1 );
        return new_bin_rep_of_n;
    }

}
