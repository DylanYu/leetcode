package solution;

/**
 * Find the contiguous subarray within an array (containing at least one number) which has the largest sum.
 * 
 * For example, given the array [−2,1,−3,4,−1,2,1,−5,4],
 * the contiguous subarray [4,−1,2,1] has the largest sum = 6.
 * 
 * @author Dongliang Yu
 *
 */
public class MaximumSubarray {
    public int maxSubArray(int[] A) {
        int max = A[0];
        int curr = A[0];
        for (int i = 1; i < A.length; i++) {
            if (curr < 0) curr = 0;
            curr += A[i];
            max = Math.max(max, curr);
        }
        return max;
    }
}
