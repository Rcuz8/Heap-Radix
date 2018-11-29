/**
 *  Represents the Heap class (Max-heap).
 *
 * @author Ryan Cocuzzo
 * @version 1.0
 * @since 1.0
 */

public class Heap<E extends Comparable> {
    // The heap values stored as an array
    public E[] tree;
    // The current # of values in the heap
    private int size;

    /**
     * Constructor that takes an input values and makes the heap out of them
     *
     * @param arr the input values
     */
    public Heap(E[] arr) {
        // Init tree to size of array * 2 to allow room for additional insertions
        tree = (E[]) new Comparable[2*arr.length];
        // Init size of array (the # of values provided)
        this.size = arr.length;
        // Build tree
        buildTree(arr);
        // Heapify tree
        heapify();

    }


    /**
     * Build the heap tree given an array of inputs
     *
     * @param arr the array to be converted into a heap
     */
    void buildTree(E[] arr) {

        // Copy array into heap
        for (int i = 0; i < arr.length; i++)
            tree[i] = arr[i];

    }

    /**
     * (private) Heapifies the parent index (swaps it with larger child if it is > parent and sifts down)
     *
     * @param parentIndex the parent index
     */
    private void siftdown(int parentIndex) {
        // Get largest child, if one exists
        int largest_child_index = largestChildIndex(parentIndex);

        if (largest_child_index != -1 && tree[largest_child_index].compareTo(tree[parentIndex]) > 0) {
            // Swap parent with child
            swap(parentIndex, largest_child_index);
            // sift down child node
            siftdown(largest_child_index);
        }
    }

    /**
     * (public) Heapifies an array of integers (tree)
     * (i.e swaps parent with larger child if it is > parent and sifts down)
     */
    public void heapify() {
        // Get length
        int n = size;
        // Iterate from (n-1)/2 to 0 in the array
        for (int parentIndex = (n-1)/2; parentIndex >= 0; parentIndex--) {
            // Get largest child, if one exists
            siftdown(parentIndex);
        }
    }

    /**
     * Allows the user to turn the sorted heap back into a structured heap
     */
    public void reHeapify() {
        heapify();
    }

    /**
     * Sorts the heap
     */
    public void heapsort() {
        // Temp store the size to reference later
        int n = size;
        // Iterate through heap
        for (int i = size; i > 0; i--) {
            // Swap root & smallest element
            swap(0, i-1);
            // Decrement size
            size--;
            // Sift down root node
            siftdown(0);
        }

        // Reset the size back to its original value
        size = n;

    }

    /**
     * Sorts the heap
     */
    public void heapsort(E[] newHeap) {
        // Build new heap tree
        buildTree(newHeap);
        // Turn into heap
        heapify();
        // Temp store the size to reference later
        int n = size;
        // Iterate through heap
        for (int i = size; i > 0; i--) {
            // Swap root & smallest element
            swap(0, i-1);
            // Decrement size
            size--;
            // Sift down root node
            siftdown(0);
        }

        // Reset the size back to its original value
        size = n;

    }

    /**
     * Get the parent of a child element stored at the inputted index
     *
     * @param index the index of the child
     * @return the parent
     */
    E parentOf(int index) {
        // Check that index is appropriate and element exists
        if (index/2-1 >= 0 && index/2-1 < size && tree[index/2-1] != null) return tree[index/2-1];
        else return null;
    }

    /**
     * Get the left child of a parent element stored at the inputted index
     *
     * @param index the index of the parent
     * @return the left child of the parent
     */
    E leftChildOf(int index) {
        // Reference index as n for visual purposes
        int n = index;
        // Get index we are checking
        int checkIndex = n*2+1;
        assert checkIndex >= 0 && checkIndex < size : " No such child exists!";
        // Check that index is appropriate and element exists
        if (tree[checkIndex] != null)
            return tree[checkIndex];
        else
            return null;
    }

    /**
     * Get the right child of a parent element stored at the inputted index
     *
     * @param index the index of the parent
     * @return the right child of the parent
     */
    E rightChildOf(int index) {
        // Reference index as n for visual purposes
        int n = index;
        // Get index we are checking
        int checkIndex = n*2+2;
        assert checkIndex >= 0 && checkIndex < size : " No such child exists!";
        // Check that index is appropriate and element exists
        if (tree[checkIndex] != null)
            return tree[checkIndex];
        else
            return null;
    }

    /**
     * Get the largest child of a parent.
     *
     * @param index the index of the parent
     * @return the largest child of the parent
     */
    E largestChildOf(int index) {
        int n = index;
        // Track that the parent has a right child
        boolean hasRight = false;
        // Track that the parent has a left child
        boolean hasLeft = false;
        // Set right child
        int r_child = n * 2 + 2;
        // Set left child
        int l_child = n * 2 + 1;
        // Check that right child exists
        if (r_child >= 0 && r_child < size && tree[r_child] != null)
            hasRight = true;
        // Check that left child exists
        if (l_child >= 0 && l_child < size && tree[l_child] != null)
            hasLeft = true;
        // If heap has both children
        if (hasLeft && hasRight) {
            // Determine larger of left and right. If equal, defaults to left
            if (rightChildOf(index).compareTo(leftChildOf(index)) > 0)
                // Return right child
                return rightChildOf(index);
            else
                // Return left child
                return leftChildOf(index);
        } else if (hasLeft)
            return leftChildOf(index);
         else if (hasRight)
            return rightChildOf(index);
         else
             return null;
    }

    /**
     * Get the largest child's index of a parent.
     *
     * @param index the index of the parent
     * @return the largest child of the parent's index
     */
    int largestChildIndex(int index) {
        int n = index;
        // Track that the parent has a right child
        boolean hasRight = false;
        // Track that the parent has a left child
        boolean hasLeft = false;
        // Set right child
        int r_child = n * 2 + 2;
        // Set left child
        int l_child = n * 2 + 1;
        // Check that right child exists
        if (r_child >= 0 && r_child < size && tree[r_child] != null)
            hasRight = true;
        // Check that left child exists
        if (l_child >= 0 && l_child < size && tree[l_child] != null)
            hasLeft = true;
        // If heap has both children
        if (hasLeft && hasRight) {
            // Determine larger of left and right. If equal, defaults to left
            if (rightChildOf(index).compareTo(leftChildOf(index)) > 0)
                // Return index of right child
                return rightChildIndex(index);
            else
                // Return index of left child
                return leftChildIndex(index);
        } else if (hasLeft)
            return leftChildIndex(index);
         else if (hasRight)
            return rightChildIndex(index);
         else return -1;

    }


    /**
     * Get the left child index of a parent element stored at the inputted index
     *
     * @param index the index of the parent
     * @return the index of the parent's left child
     */
    int leftChildIndex(int index) {
        int n = index;
        // Check that index is appropriate and element exists
        if (n*2+1 >= 0 && n*2+1 < size) return n*2+1;
        else return -1;
    }


    /**
     * Get the right child index of a parent element stored at the inputted index
     *
     * @param index the index of the parent
     * @return the index of the parent's right child
     */
    int rightChildIndex(int index) {
        int n = index;
        // Check that index is appropriate and element exists
        if (n*2+2 >= 0 && n*2+2 < size) return n*2+2;
        else return -1;
    }

    /**
     * Swaps two positions in the heap
     *
     * @param p1 the first posiiton
     * @param p2 the second position
     */
    public void swap( int p1, int p2) {
        // Create temp variable
        E temp = this.tree[p1];
        // put 2 into 1
        this.tree[p1] = this.tree[p2];
        // put temp into 2
        this.tree[p2] = temp;
    }

    /**
     * Prints tree
     */
    public void print() {
        // Iterate & print
        for (int i = 0; i < size; i++)
            System.out.println(": " + tree[i].toString());
    }


}
