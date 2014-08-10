package solution;

import java.util.ArrayList;
import java.util.List;
import java.util.LinkedList;

/**
 * Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.
 *
 * For example,
 * If n = 4 and k = 2, a solution is:
 *
 * [
 *   [2,4],
 *   [3,4],
 *   [2,3],
 *   [1,2],
 *   [1,3],
 *   [1,4],
 * ]
 * 
 * @author Dongliang Yu
 *
 */
public class Combinations {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ret = new LinkedList<List<Integer>>();
        combine(new ArrayList<Integer>(), 1, n, k, ret);
        return ret;
    }
    
    // select k items from [lo, hi]
    private void combine(ArrayList<Integer> cur, int lo, int hi, int k, List<List<Integer>> ret) {
        //if ((hi - lo + 1) < k) return; // not necessary any more
        if (k == 0) {
            ret.add(cur);
            return;
        }
        for (int i = lo; i <= hi-k+1; i++) {
            ArrayList<Integer> next = (ArrayList<Integer>) cur.clone();
            next.add(i);
            combine(next, i+1, hi, k-1, ret);
        }
    }
}
