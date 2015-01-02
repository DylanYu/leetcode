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
        int maxTotal= A[0];
        int max = A[0];
        int min = A[0];
        for (int i = 1; i < A.length; i++) {
            int prevMax = max;
            max = getMax(A[i], max*A[i], min*A[i]);
            min = getMin(A[i], prevMax*A[i], min*A[i]);
            maxTotal = Math.max(maxTotal, max);
        }
        return maxTotal;
    }
    
    private int getMax(int a, int b, int c) {
        return Math.max(a, Math.max(b, c));
    }
    
    private int getMin(int a, int b, int c) {
        return Math.min(a, Math.min(b, c));
    }
    
    /**
     * 
     * 
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
    */
}
