package solution;

/**
 * Given an unsorted integer array, find the first missing positive integer.
 * 
 * For example,
 * Given [1,2,0] return 3,
 * and [3,4,-1,1] return 2.
 * 
 * Your algorithm should run in O(n) time and uses constant space.
 * 
 * @author Dongliang Yu
 *
 */
public class FirstMissingPositive {
    // use the idea of bucket sort, there're some tricky edge cases
    public int firstMissingPositive(int[] A) {
        if (A.length == 0) return 1;
        //if (A.length == 1) return A[0] == 1 ? 2 : 1; // handled by later logic
        int i = 0;
        while (i < A.length) {
            if (A[i] == i || A[i] < 0 || A[i] >= A.length || A[i] == A[A[i]])
                // the last condition is used to avoid infinite loop on same number case
                i++;
            else
                swap(A, i, A[i]); // keep i still
        }
        for (int j = 1; j < A.length; j++)
            if (A[j] != j) return j;
        // we want to store i in index i rather than index i-1, so for array [1,2,3,4];
        // 4 will be placed at 0, there's a special case we should take care of.
        if (A[0] == A.length) return A.length+1;
        else return A.length;
    }
    
    private void swap(int[] A, int i, int j) {
        int tmp = A[i];
        A[i] = A[j];
        A[j] = tmp;
    }
    
    /**
     * zero based solution, almost the same as above one
     * 
    public int firstMissingPositive(int[] A) {
        int n = A.length;
        if (n == 0) return 1;
        int i = 0;
        while (i < n) {
            if (A[i]-1 != i) {
                if (A[i] > n || A[i] <= 0) i++;
                else {
                    int tmp = A[i];
                    swap(A, i, A[i]-1);
                    if (A[i] == tmp) i++;
                }
            } else
                i++;
        }
        i = 0;
        while (i < n) {
            if (A[i]-1 != i) return i+1;
            i++;
        }
        return n+1;
    }
    */
}
