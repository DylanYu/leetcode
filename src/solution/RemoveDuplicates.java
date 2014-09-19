package solution;

/**
 * Remove Duplicates from Sorted Array
 * <p>
 * Given a sorted array, remove the duplicates in place such that each element 
 * appear only once and return the new length.
 * <p>Do not allocate extra space for another array, you must do this in place 
 * with constant memory.
 * <p>For example,
 * Given input array A = [1,1,2],
 * Your function should return length = 2, and A is now [1,2].
 * 
 * @author Dongliang Yu
 *
 */
public class RemoveDuplicates {
    public int removeDuplicates(int[] A) {
        if (A.length == 0) return 0;
        int j = 0;
        for (int i = 1; i < A.length; i++) {
            if (A[i] != A[j]) {
                j++;
                A[j] = A[i];
            }
        }
        return j+1;
    }
    
    /*
    public int removeDuplicates(int[] A) {
        int length = A.length;
        int count = 0;
        for (int i = 1; i < length; i++) {
            if (A[i] == A[i - 1])
                count++;
            else
                A[i - count] = A[i];
        }
        return length - count;
    }
    */
}
