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
    
	private void combine(ArrayList<Integer> list, int curr, int n, int k, List<List<Integer>> ret) {
        if (k == 0) {
            ret.add(new ArrayList<Integer>(list)); //
            return;
        }
        for (int i = curr; i <= n-k+1; i++) {
            list.add(i);
            combine(list, i+1, n, k-1, ret);
            list.remove(list.size()-1); //
        }
    }
	
	/*
	 * different approach to proceed recursion, less efficient than above one
	 * 
    private void combine(ArrayList<Integer> list, int curr, int n, int k, List<List<Integer>> ret) {
        if (k == 0) {
            ret.add(list); //
            return;
        }
        for (int i = curr; i <= n-k+1; i++) {
            ArrayList<Integer> copy =  new ArrayList<Integer>(list); //
            copy.add(i);
            combine(copy, i+1, n, k-1, ret);
        }
    }
    */
}
