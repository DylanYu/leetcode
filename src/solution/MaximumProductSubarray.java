package solution;

/**
 * Find the contiguous subarray within an array (containing at least one number) 
 * which has the largest product.
 * 
 * For example, given the array [2,3,-2,4],
 * the contiguous subarray [2,3] has the largest product = 6.
 * 
 * @author Dongliang Yu
 *
 */
public class MaximumProductSubarray {
    public int maxProduct(int[] A) {
        if (A.length == 1) return A[0]; //
        int max = Integer.MIN_VALUE;
        int maxProduct = 0;
        int minProduct = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] > 0) {
                maxProduct = Math.max(maxProduct*A[i], A[i]);
                minProduct = minProduct*A[i];
            } else if (A[i] < 0) {
                int tmp = maxProduct;
                maxProduct = minProduct * A[i];
                minProduct = Math.min(tmp*A[i], A[i]);
            } else {
                maxProduct = 0;
                minProduct = 0;
            }
            max = Math.max(max, maxProduct);
        }
        return max;
    }
}
