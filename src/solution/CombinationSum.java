package solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.LinkedList;

/**
 * Given a set of candidate numbers (C) and a target number (T), find all unique combinations in C 
 * where the candidate numbers sums to T.
 * The same repeated number may be chosen from C unlimited number of times.
 * 
 * Note:
 * Assume all candidates are distinct.
 * All numbers (including target) will be positive integers.
 * Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
 * The solution set must not contain duplicate combinations.
 * For example, given candidate set 2,3,6,7 and target 7, 
 * A solution set is: 
 * [7] 
 * [2, 2, 3] 
 * 
 * @author Dongliang Yu
 *
 */
public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ret = new LinkedList<List<Integer>>();
        if (candidates == null) return ret;
        Arrays.sort(candidates); //
        collect(new ArrayList<Integer>(), 0, target, candidates, ret);
        return ret;
    }
    
    private void collect(ArrayList<Integer> list, int idx, int target, int[] candidates, List<List<Integer>> ret) {
        if (target == 0) {
            ret.add(new ArrayList<Integer>(list));
            return;
        }
        for (int i = idx; i < candidates.length; i++) {
            int newTarget = target-candidates[i];
            if (newTarget < 0) break; // improvement
            list.add(candidates[i]);
            collect(list, i, newTarget, candidates, ret);
            list.remove(list.size()-1);
        }
        // no need to do the 'not choose anything' operation
    }
    
    /**
     * another approach
     *
    private void collect(ArrayList<Integer> list, int idx, int target, int[] candidates, List<List<Integer>> ret) {
        if (target == 0) {
            ret.add(new ArrayList<Integer>(list));
            return;
        }
        if (idx == candidates.length) return; 
        
        collect(list, idx+1, target, candidates, ret);
        int newTarget = target-candidates[idx];
        if (newTarget < 0) return; // improvement
        list.add(candidates[idx]);
        collect(list, idx, newTarget, candidates, ret); // same element can be chosen several times
        list.remove(list.size()-1);
    }
    */
    
    public static void main(String[] args) {
        //int[] num = {2, 2, 3, 3, 6, 7};
        int[] num = {2, 3, 6, 7};
        List<List<Integer>> ret = new CombinationSum().combinationSum(num, 7);
        System.out.println(ret.size());
    }
}
