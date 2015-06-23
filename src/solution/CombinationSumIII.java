package solution;

import java.util.*;

/**
 * Find all possible combinations of k numbers that add up to a number n, given that only 
 * numbers from 1 to 9 can be used and each combination should be a unique set of numbers.
 * 
 * Ensure that numbers within the set are sorted in ascending order.
 * 
 * Example 1:
 * 
 * Input: k = 3, n = 7
 * 
 * Output:
 * 
 * [[1,2,4]]
 * 
 * Example 2:
 * 
 * Input: k = 3, n = 9
 * 
 * Output:
 * 
 * [[1,2,6], [1,3,5], [2,3,4]]
 * 
 * @author Dongliang Yu
 *
 */
public class CombinationSumIII {
	public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ret = new LinkedList<List<Integer>>();
        if (k <= 0 || n <= 0) return ret;
        collect(new ArrayList<Integer>(), 1, k, n, ret);
        return ret;
    }
    
    // remaining k and n
    private void collect(List<Integer> list, int curr, int k, int n, List<List<Integer>> ret) {
        if (k == 0 || n == 0) {
            if (k == 0 && n == 0)
                ret.add(new ArrayList<Integer>(list));
            return;
        }
        if ((2 * curr + k - 1) * k / 2 > n) return; // sum of (curr...curr+k-1]), too big to satisfy
        if ((curr + 9) * (10 - curr) / 2 < n) return; // sum of (curr...9), too small to satisfy
        list.add(curr);
        collect(list, curr+1, k-1, n-curr, ret);
        list.remove(list.size()-1);
        collect(list, curr+1, k, n, ret);
    }
}
