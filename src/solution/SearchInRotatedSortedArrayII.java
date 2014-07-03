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
    private static boolean flag;
    
    public static boolean search(int[] A, int target) {
        flag = false;
        return binary(A, 0, A.length - 1, target);
    }
    
    private static boolean binary(int[] A, int lo, int hi, int target) {
        if (lo > hi) return false;
        int mid = lo + (hi - lo) / 2;
        int cur = A[mid];
        if (cur == target) {
            return true;
        } else if(flag) {
            if (cur < target) return binary(A, mid + 1, hi, target);
            else return binary(A, lo, mid - 1, target);
        } else {
            if (cur < A[hi]) {
                if (cur < target) {
                    boolean left = binary(A, lo, mid - 1, target);
                    if (left) return left;
                    else {
                        flag = true;
                        return binary(A, mid + 1, hi, target);
                    }
                } else {
                    return binary(A, lo, mid - 1, target);
                }
            } else if (cur > A[hi]) {
                if (cur < target) {
                    return binary(A, mid + 1, hi, target);
                } else {
                    boolean right = binary(A, mid + 1, hi, target);
                    if (right) return right;
                    else {
                        flag = true;
                        return binary(A, lo, mid - 1, target);
                    }
                }
            } else { // cur == A[hi], cannot decide which side, so search both
                boolean left = binary(A, lo, mid - 1, target);
                if (left) return left;
                else return binary(A, mid + 1, hi, target);
            }
        }
    }
}
