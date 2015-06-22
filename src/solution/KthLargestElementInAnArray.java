package solution;

/**
 * Find the kth largest element in an unsorted array. Note that it is the kth largest 
 * element in the sorted order, not the kth distinct element.
 * 
 * For example,
 * Given [3,2,1,5,6,4] and k = 2, return 5.
 * 
 * Note: 
 * You may assume k is always valid, 1 ≤ k ≤ array's length.
 * 
 * @author Dongliang Yu
 *
 */
public class KthLargestElementInAnArray {
	// quick select algorithm
	public int findKthLargest(int[] nums, int k) {
        return findKthLargest(nums, 0, nums.length-1, nums.length-k);
    }
    
    private int findKthLargest(int[] nums, int lo, int hi, int k) {
        int index = partition(nums, lo, hi);
        if (index == k) return nums[index];
        else if (index < k) return findKthLargest(nums, index+1, hi, k);
        else return findKthLargest(nums, lo, index-1, k);
    }
    
    private int partition(int[] nums, int lo, int hi) {
        //if (lo == hi) return lo;
        /* choose a middle pivot
        int a = nums[lo];
        int mid = lo + (hi-lo)/2;
        int b = nums[mid];
        int c = nums[hi];
        int pivot;
        if (a >= b) {
            if (a <= c) pivot = a;
            else if (b >= c) { pivot = b; swap(nums, lo, mid); }
            else { pivot = c; swap(nums, lo, hi); }
        } else {
            if (a >= c) pivot = a;
            else if (b <= c) { pivot = b; swap(nums, lo, mid); }
            else { pivot = c; swap(nums, lo, hi); }
        }
        */
        int pivot = nums[lo];
        int i = lo+1;
        int j = hi;
        while (i <= j) {
            if (nums[i] > pivot)
                swap(nums, i, j--);
            else
                i++;
        }
        swap(nums, lo, i-1);
        return i-1;
    }
    
    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
