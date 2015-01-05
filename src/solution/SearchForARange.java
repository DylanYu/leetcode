package solution;

/**
 * 
 * Given a sorted array of integers, find the starting and ending position of a given target value.
 * 
 * Your algorithm's runtime complexity must be in the order of O(log n).
 * 
 * If the target is not found in the array, return [-1, -1].
 * 
 * For example,
 * Given [5, 7, 7, 8, 8, 10] and target value 8,
 * return [3, 4].
 * 
 * @author Dongliang Yu
 *
 */
public class SearchForARange {
    public int[] searchRange(int[] A, int target) {
        int[] ret = new int[2];
        int i = search(A, target);
        if (i < A.length && A[i] == target) { // i >= 0 is not necessary 
            int left = search(A, target-0.5);
            int right = search(A, target+0.5);
            ret[0] = left;
            ret[1] = right-1;
        } else {
            ret[0] = -1;
            ret[1] = -1;
        }
        return ret;
    }
    
    private int search(int[] A, double target) {
        int lo = 0;
        int hi = A.length-1;
        while (lo <= hi) {
            int mid = lo + (hi-lo) /  2;
            if (A[mid] == target) return mid;
            else if (A[mid] < target) lo = mid+1;
            else hi = mid-1;
        }
        return lo; // (possible) index of element which is >= target
    }
    
    /**
     * same as the above one, thinking about the difference between "return lo" and "return hi"
     * 
    public int[] searchRange(int[] A, int target) {
        int[] ret = new int[2];
        int i = search(A, target);
        if (i >= 0 && A[i] == target) { // i < A.length is not necessary 
            int left = search(A, target-0.5);
            int right = search(A, target+0.5);
            ret[0] = left+1;
            ret[1] = right;
        } else {
            ret[0] = -1;
            ret[1] = -1;
        }
        return ret;
    }
    
    private int search(int[] A, double target) {
        int lo = 0;
        int hi = A.length-1;
        while (lo <= hi) {
            int mid = lo + (hi-lo) /  2;
            if (A[mid] == target) return mid;
            else if (A[mid] < target) lo = mid+1;
            else hi = mid-1;
        }
        return hi; // (possible) index of element which is <= target
    }
    */
    
    public static void main(String[] args) {
        //int[] num = {5, 7, 7, 8, 8, 10};
        //int[] ret = new SearchForARange().searchRange(num, 7);
        //int[] ret = new SearchForARange().searchRange(num, 4);
        //int[] ret = new SearchForARange().searchRange(num, 11);
        int[] num = {2, 2};
        int[] ret = new SearchForARange().searchRange(num, 2);
        System.out.println(String.format("[%d, %d]", ret[0], ret[1]));
    }
}
