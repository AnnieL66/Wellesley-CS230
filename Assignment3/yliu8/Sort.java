
/**
 * Sort.java <br>
 * The first for-loop in sortArray iterates through the input array in reversed order of the indices.
 * The second for-loop iterates through all the elements that come before the current element in the first loop.
 * It finds out the maximun number and its index by comparing maxNum with each element iterated by the second loop
 * and resetting the maxNum and maxIndex. 
 * 
 * <br>
 * Finally, it swaps the element in the first loop and the maximun found in the second loop so that all the maximums relative to
 * every sections of the array is automatically placed at the very end of the output array. Once it is done, 
 * the first loop continues its journey backwards and when it finishes, the input array is sorted in increasing order.
 */

public class Sort {
    /*
     * Sorts the integers in the input array in increasing order
     */
    public static void sortArray(int[] arrayA) {
        int maxNum; // maximum integer so far
        int maxIndex; // index of maximum integer
        int i, j;
        for (j = arrayA.length - 1; j > 0; j--) {
            maxIndex = 0;
            maxNum = arrayA[0];
            for (i = 1; i <= j; i++)
                if (arrayA[i] > maxNum) {
                    maxNum = arrayA[i];
                    maxIndex = i;
                }
            swap(arrayA, maxIndex, j);
        }
    }

    /**
     * Exchanges the contents of locations i and j in the input array
     */
    private static void swap(int[] arrayA, int i, int j) {
        int temp = arrayA[i];
        arrayA[i] = arrayA[j];
        arrayA[j] = temp;
    }
}