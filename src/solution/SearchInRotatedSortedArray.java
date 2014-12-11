package solution;

/**
 * Suppose a sorted array is rotated at some pivot unknown to you beforehand.
 * <p>
 * (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).
 * <p>
 * You are given a target value to search. If found in the array return its index, 
 * otherwise return -1.
 * <p>
 * You may assume no duplicate exists in the array.
 * 
 * @author Dongliang Yu
 *
 */
public class SearchInRotatedSortedArray {
    // check if the target is in the sorted part, if so keep doing the binary search
    // otherwise throw away the sorted part and do the same on the other part of the array
    public int search(int[] A, int target) {
        int lo = 0;
        int hi = A.length-1;
        while (lo <= hi) {
            int mid = lo + (hi-lo)/2;
            if (A[mid] == target) return mid;
            if (A[lo] <= A[mid]) { // NOT <
                if (A[lo] <= target && target <= A[mid])
                    hi = mid-1;
                else
                    lo = mid+1;
            } else {
                if (A[mid] <= target && target <= A[hi])
                    lo = mid+1;
                else
                    hi = mid-1;
            }
        }
        return -1;
    }
}