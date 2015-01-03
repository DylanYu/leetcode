package solution;

/**
 * Suppose a sorted array is rotated at some pivot unknown to you beforehand.
 * 
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 * 
 * Find the minimum element.
 * 
 * The array may contain duplicates.
 * 
 * @author Dongliang Yu
 * @see FindMinimumInRotatedSortedArray
 * @see SearchInRotatedSortedArray
 * @see SearchInRotatedSortedArrayII
 *
 */
public class FindMinimumInRotatedSortedArrayII {
    public int findMin(int[] num) {
        if (num == null || num.length == 0) return Integer.MAX_VALUE;
        int lo = 0;
        int hi = num.length-1;
        while (lo < hi) {
            if (num[lo] < num[hi]) return num[lo];
            int mid = lo + (hi-lo)/2;
            if (num[mid] > num[hi]) {
                lo = mid+1;
            } else if (num[mid] < num[hi]) {
                hi = mid;
            } else {
                if (num[lo] == num[mid]) {
                    lo++;
                    hi--;
                } else
                    hi = mid;
            }
            /*
            if (num[mid] > num[lo]) lo = mid+1;
            else if (num[mid] < num[lo]) hi = mid; // no -1
            else {
                if (num[lo] == num[hi]) {
                    lo++;
                    hi--;
                } else
                    lo = mid+1;
            }
            */
        }
        return num[lo];
    }
}
