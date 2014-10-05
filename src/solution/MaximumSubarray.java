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
        if (A.length == 0) return Integer.MIN_VALUE;
        int max = A[0];
        int currMaxSum = A[0];
        for (int i = 1; i < A.length; i++) {
            currMaxSum = Math.max(currMaxSum+A[i] , A[i]); // maximum sum of subarray ends with A[i], kind of DP
            max = Math.max(max, currMaxSum);
        }
        return max;
    }
    
    /*
     * O(nlgn) divide and conquer approach 
     * 
    public int maxSubArray(int[] A) {
        return maxSubarray(A, 0, A.length-1);
    }
    
    private int maxSubarray(int[] A, int start, int end) {
        //if (start > end) return Integer.MIN_VALUE; // this case will not happen
        if (start == end) return A[start];
        int mid = start + (end-start)/2;
        int leftMax = maxSubarray(A, start, mid);
        int rightMax = maxSubarray(A, mid+1, end);
        //int leftSuffixMax = A[mid];
        int leftSuffixMax = Integer.MIN_VALUE;
        int tmp = 0;
        for (int i = mid; i >= start; i--)
            leftSuffixMax = Math.max(leftSuffixMax, tmp += A[i]);
        //int rightPrefixMax = A[mid+1];
        int rightPrefixMax = Integer.MIN_VALUE;
        tmp = 0;
        for (int i = mid+1; i <= end; i++)
            rightPrefixMax = Math.max(rightPrefixMax, tmp += A[i]);
        int midIncludedMax = leftSuffixMax + rightPrefixMax;
        return Math.max(midIncludedMax, Math.max(leftMax, rightMax));
    }
    */
}
