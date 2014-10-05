package solution;

/**
 * Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.
 *
 * You may assume no duplicates in the array.
 *
 * Here are few examples.
 * [1,3,5,6], 5 → 2
 * [1,3,5,6], 2 → 1
 * [1,3,5,6], 7 → 4
 * [1,3,5,6], 0 → 0
 * 
 * @author Dongliang Yu
 *
 */
public class SearchInsertPosition {
    public int searchInsert(int[] A, int target) {
        int lo = 0;
        int hi = A.length-1;
        while (lo <= hi) {
            int mid = lo + (hi-lo)/2;
            if (A[mid] < target) lo = mid+1;
            else if (A[mid] > target) hi = mid-1;
            else return mid;
        }
        return lo; // it is easy
    }
    
    /*
    public int searchInsert(int[] A, int target) {
        return searchInsert(A, 0, A.length-1, target);
    }
    
    private int searchInsert(int[] A, int lo, int hi, int target) {
        if (lo == hi && A[lo] != target) {
            if (A[lo] > target) return lo;
            else return lo+1;
        }
        int mid = lo + (hi - lo) / 2;
        if (A[mid] > target) return searchInsert(A, lo, mid == lo ? mid : mid-1, target);
        else if (A[mid] < target) return searchInsert(A, mid == hi ? mid : mid+1, hi, target);
        else return mid;
    }
    */
}
