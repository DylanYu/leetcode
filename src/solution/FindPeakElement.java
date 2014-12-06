package solution;

/**
 * 
 * @author Dongliang Yu
 * 
 * A peak element is an element that is greater than its neighbors.
 * 
 * Given an input array where num[i] ≠ num[i+1], find a peak element and return its index.
 * 
 * You may imagine that num[-1] = num[n] = -∞.
 * 
 * For example, in array [1, 2, 3, 1], 3 is a peak element and your function should return the index number 2.
 *
 */
public class FindPeakElement {
    public int findPeakElement(int[] num) {
        if (num == null) return Integer.MIN_VALUE;
        int left = 0;
        int right = num.length-1;
        while (left < right) {
            int mid = left + (right-left) / 2;
            long leftNeighbor = arr(num, mid-1);
            long midNum = arr(num, mid);
            long rightNeighbor = arr(num, mid+1);
            if (midNum > leftNeighbor && midNum > rightNeighbor) return mid;
            else if (leftNeighbor < midNum && midNum <= rightNeighbor) left = mid+1; // mid+1 to keep index moving
            else if (leftNeighbor >= midNum && midNum > rightNeighbor) right = mid; // however mid-1 is not necessary here
            else right = mid; // left = mid+1 is also OK
        }
        return left; // all equal elements, invalid input
    }
    
    // Use LONG to represent Negative Infinite
    private long arr(int[] num, int index) {
        if (index == -1 || index == num.length) return Long.MIN_VALUE;
        else return num[index];
    }
}
