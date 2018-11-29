/**
 *  Represents a Binary Element.
 *
 * @author Ryan Cocuzzo
 * @version 1.0
 * @since 1.0
 */
public class BinElement {
    // Index within the unsorted array
    int index;
    // Binary representation of the number
    String bin_rep;

    /**
     * Constructs a Binary Element
     *
     * @param index the index in the unsorted array
     * @param bin_rep the binary representation of the value
     */
    public BinElement(int index, String bin_rep) {
        this.index = index;
        this.bin_rep = bin_rep;
    }

    /**
     * Retrieves the base-10 integer value that this binary element encapsulates as a binary string
     * @return the base-10 integer value of bin_rep
     */
    int toInt() {
        return Integer.parseInt(bin_rep, 2);
    }

}



