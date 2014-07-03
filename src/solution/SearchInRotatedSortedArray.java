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
    private static boolean flag;
    
    public static int search(int[] A, int target) {
        flag = false;
        return binary(A, 0, A.length - 1, target);
    }
    
    private static int binary(int[] A, int lo, int hi, int target) {
        if (lo > hi) return -1;
        int mid = lo + (hi - lo) / 2;
        int cur = A[mid];
        if (cur == target) {
            return mid;
        } else if(flag) {
            if (cur < target) return binary(A, mid + 1, hi, target);
            else return binary(A, lo, mid - 1, target);
        } else {
            if (cur < A[hi]) {
                if (cur < target) {
                    int left = binary(A, lo, mid - 1, target);
                    if (left != -1) return left;
                    else {
                        flag = true;
                        return binary(A, mid + 1, hi, target);
                    }
                } else {
                    return binary(A, lo, mid - 1, target);
                }
            } else {
                if (cur < target) {
                    return binary(A, mid + 1, hi, target);
                } else {
                    int right = binary(A, mid + 1, hi, target);
                    if (right != -1) return right;
                    else {
                        flag = true;
                        return binary(A, lo, mid - 1, target);
                    }
                }
            }
        }
    }
}