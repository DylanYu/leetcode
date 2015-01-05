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
        int len = A.length;
        int[] ret = new int[2];
        int i = search(A, target);
        if (/*i >= 0 && */i < len && A[i] == target) { // 
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
    
    /*
    public int[] searchRange(int[] A, int target) {
        int[] ret = new int[2];
        int idx = binarySearch(A, target);
        if (idx == -1) {
            ret[0] = -1;
            ret[1] = -1;
        } else {
            int l = searchInsertPosition(A, 0, idx, target-0.1);
            int r = searchInsertPosition(A, idx, A.length-1, target+0.1);
            ret[0] = l;
            ret[1] = r-1;
        }
        return ret;
    }
    
    private int binarySearch(int[] A, int target) {
        int lo = 0;
        int hi = A.length-1;
        while (lo <= hi) {
            int mid = lo + (hi-lo)/2;
            if (A[mid] < target) lo = mid+1;
            else if (A[mid] > target) hi = mid-1;
            else return mid;
        }
        return -1;
    }
    
    private int searchInsertPosition(int[] A, int lo, int hi, double target) {
        while (lo <= hi) {
            int mid = lo + (hi-lo)/2;
            //if (A[mid] == target) return mid; // not possible
            if (A[mid] < target) lo = mid+1;
            else if (A[mid] > target) hi = mid-1;
        }
        return lo;
    }
    */
    
    public static void main(String[] args) {
        int[] num = {5, 7, 7, 8, 8, 10};
        int[] ret = new SearchForARange().searchRange(num, 7);
        //int[] ret = new SearchForARange().searchRange(num, 4);
        //int[] ret = new SearchForARange().searchRange(num, 11);
        System.out.println(String.format("[%d, %d]", ret[0], ret[1]));
    }
}
