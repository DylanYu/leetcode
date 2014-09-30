package solution;

/**
 * Follow up for "Search in Rotated Sorted Array":
 * <p>What if duplicates are allowed?
 * <p>Would this affect the run-time complexity? How and why?
 * <p>Write a function to determine if a given target is in the array.
 * 
 * @author Dongliang Yu
 *
 */
public class SearchInRotatedSortedArrayII {
	public boolean search(int[] A, int target) {
        int lo = 0;
        int hi = A.length-1;
        while (lo <= hi) {
            int mid = lo + (hi-lo)/2;
            if (A[mid] == target) return true;
            if (A[mid] > A[lo]) {
                if (A[lo] <= target && target <= A[mid]) hi = mid-1;
                else lo = mid+1;
            } else if (A[mid] < A[lo]) {
                if (A[mid] <= target && target <= A[hi]) lo = mid+1;
                else hi = mid-1;
            } else { // or just simply lo++
                int i = mid-1;
                while (i >= lo && A[i] == A[mid]) i--; // lo not 0
                if (i == lo-1) lo = mid+1; // lo-1 not -1
                else hi = mid-1;
            }
        }
        return false;
    }
}
