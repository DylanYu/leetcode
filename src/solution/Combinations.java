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
        if (n <= 0 || k <= 0) return ret;
        collect(new ArrayList<Integer>(), 1, n, k, ret);
        return ret;
    }
    
    private void collect(ArrayList<Integer> list, int curr, int n, int k, List<List<Integer>> ret) {
        if (list.size() == k) {
            ret.add(new ArrayList<Integer>(list));
            return;
        }
        //if (curr == n+1) return;
        for (int i = curr; i <= n; i++) {
            if (list.size() + n-i+1 < k) break;
            list.add(i);
            collect(list, i+1, n, k, ret);
            list.remove(list.size()-1);
        }
        // no need to do the 'not choose anything' operation, possible result is already check at first
    }
    
    /*
     * different approach to proceed recursion, less efficient than above one
     * 
    private void collect(ArrayList<Integer> list, int curr, int n, int k, List<List<Integer>> ret) {
        if (k == 0) {
            ret.add(list); //
            return;
        }
        for (int i = curr; i <= n-k+1; i++) {
            ArrayList<Integer> copy =  new ArrayList<Integer>(list); //
            copy.add(i);
            collect(copy, i+1, n, k-1, ret);
        }
    }
    */
}
