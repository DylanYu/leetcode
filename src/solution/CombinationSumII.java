package solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.LinkedList;
import java.util.Set;

/**
 * Given a collection of candidate numbers (C) and a target number (T), find all unique 
 * combinations in C where the candidate numbers sums to T.
 * 
 * Each number in C may only be used once in the combination.
 * 
 * Note:
 * Assume all candidates are distinct.
 * All numbers (including target) will be positive integers.
 * Elements in a combination (a1, a2, … , ak) must be in non-descending order. 
 * (ie, a1 ≤ a2 ≤ … ≤ ak).
 * The solution set must not contain duplicate combinations.
 * 
 * For example, given candidate set 10,1,2,7,6,1,5 and target 8, 
 * A solution set is: 
 * [1, 7] 
 * [1, 2, 5] 
 * [2, 6] 
 * [1, 1, 6] 
 * 
 * @author Dongliang Yu
 *
 */
public class CombinationSumII {
    public List<List<Integer>> combinationSum2(int[] num, int target) {
        List<List<Integer>> ret = new LinkedList<List<Integer>>();
        if (num == null) return ret;
        Arrays.sort(num); //
        collect(new ArrayList<Integer>(), 0, target, num, ret);
        return ret;
    }
    
    private void collect(ArrayList<Integer> list, int index, int target, int[] num, List<List<Integer>> ret) {
        if (target == 0)  {
            ret.add(new ArrayList<Integer>(list));
            return;
        }
        if (index == num.length)
            return;
        int remaining = target - num[index];
        if (remaining < 0) return;
        list.add(num[index]);
        collect(list, index+1, remaining, num, ret);
        list.remove(list.size()-1);
        
        // skip current element (and consecutive identical elements)
        do {
            index++; 
        } while (index < num.length && num[index] == num[index-1]);
        collect(list, index, remaining, num, ret);
    }
    
    /**
     * another solution
     * 
    private void collect(ArrayList<Integer> list, int idx, int target, int[] num, List<List<Integer>> ret) {
        if (target == 0) {
            ret.add(new ArrayList<Integer>(list));
            return;
        }
        //if (idx == num.length) return; // not necessary
        for (int i = idx; i < num.length; i++) {
            if (i >idx && num[i] == num[i-1]) continue; // eliminate duplicates
            if (i == num.length) break;
            int newTarget = target - num[i];
            if (newTarget < 0) break; // early stop
            list.add(num[i]);
            collect(list, i+1, newTarget, num, ret);
            list.remove(list.size()-1);
        }
    }
    */
    
    /*
     * solution using Set to eliminate duplicates
     * 
    public List<List<Integer>> combinationSum2(int[] num, int target) {
        // hashCode for List is defined by the following calculation:
        //  int hashCode = 1;
        //  for (E e : list)
        //      hashCode = 31*hashCode + (e==null ? 0 : e.hashCode());
        // 
        // equals for Lists is true if and only if all corresponding pairs of elements are equal
        Set<List<Integer>> set = new HashSet<List<Integer>>();
        Arrays.sort(num);
        recurse(new ArrayList<Integer>(), num, 0, target, set);
        List<List<Integer>> list = new LinkedList<List<Integer>>();
        for (List<Integer> item : set)
            list.add(item);
        return list;
    }
    
    private void recurse(ArrayList<Integer> list, int[] num, int idx, int target, Set<List<Integer>> set) {
        if (target == 0) {
            set.add(list);
            return;
        }
        if (idx >= num.length) return;
        for (int i = idx; i < num.length; i++) {
            int targetLeft = target - num[i];
            if (targetLeft >= 0) {
                ArrayList<Integer> copy = new ArrayList<Integer>(list);
                copy.add(num[i]);
                recurse(copy, num, i+1, targetLeft, set);
            }
        }
    }
    */
    
    public static void main(String[] args) {
        //int[] num = {2, 2, 3, 3, 6, 7}; // error input
        int[] num = {2, 3, 6, 7};
        List<List<Integer>> ret = new CombinationSumII().combinationSum2(num, 7);
        System.out.println(ret.size());
    }
}
