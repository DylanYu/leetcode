package solution;

/**
 * Suppose a sorted array is rotated at some pivot unknown to you beforehand.
 * 
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 * 
 * Find the minimum element.
 * 
 * You may assume no duplicate exists in the array.
 * 
 * @author Dongliang Yu
 * @see FindMinimumInRotatedSortedArrayII
 * @see SearchInRotatedSortedArray
 * @see SearchInRotatedSortedArrayII
 *
 */
public class FindMinimumInRotatedSortedArray {
    public int findMin(int[] num) {
        if (num == null || num.length == 0) return Integer.MAX_VALUE;
        int lo = 0;
        int hi = num.length-1;
        while (lo < hi) {
            if (num[lo] < num[hi]) return num[lo];
            int mid = lo + (hi-lo)/2;
            if (num[mid] > num[hi]) lo = mid+1;
            else hi = mid; // NOT mid-1. For [3,0,1,2] case, num[mid]=0 is the minimum
        }
        return num[lo]; // one element case is also handled here
    }
}
