package solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.LinkedList;
import java.util.Stack;

/**
 * Given a collection of integers that might contain duplicates, S, return all possible subsets.
 * <p>
 * Note:
 * <p>Elements in a subset must be in non-descending order.
 * <p>The solution set must not contain duplicate subsets. 
 * 
 * @author Dongliang Yu
 *
 */
public class SubsetsII {
	public List<List<Integer>> subsetsWithDup(int[] num) {
        Arrays.sort(num);
        List<List<Integer>> ret = new LinkedList<List<Integer>>();
        collect(new ArrayList<Integer>(), num, 0, ret);
        return ret;
    }
    
    private void collect(ArrayList<Integer> list, int[] num, int idx, List<List<Integer>> ret) {
        ret.add(new ArrayList<Integer>(list)); // will include an empty list in final result
        if (idx == num.length) return;
        for (int i = idx; i < num.length; i++) {
            if (i == idx || i-1 >= idx && num[i] != num[i-1]) { // eliminate duplicates
                list.add(num[i]);
                collect(list, num, i+1, ret);
                list.remove(list.size()-1);
            }
        }
    }
	
	/*
    class SubsetCutter implements Cloneable{
        ArrayList<Integer> subset;
        Integer cut;
        
        public SubsetCutter(ArrayList<Integer> s, Integer c) {
            subset = s;
            cut = c;
        }
        
        @Override
        public SubsetCutter clone() {
            return new SubsetCutter(
                    (ArrayList<Integer>) subset.clone(), 
                    cut);  // we will not change the value of cut, so no need to clone
        }
    }
    
    public ArrayList<ArrayList<Integer>> subsetsWithDup(int[] num) {
        Arrays.sort(num);
        Stack<SubsetCutter> stack = new Stack<SubsetCutter>();
        stack.push(new SubsetCutter(new ArrayList<Integer>(), null));
        Stack<SubsetCutter> holder = new Stack<SubsetCutter>();
        for (int i = 0; i < num.length; i++) {
            while (!stack.isEmpty()) {
                SubsetCutter cutter = stack.pop();
                // right side, add a new item to list, no change to cut value
                // this node will still be split possibly for num[i]
                if (cutter.cut == null || cutter.cut != num[i]) {
                    SubsetCutter cutterCopy = cutter.clone();
                    cutterCopy.subset.add(num[i]);
                    holder.push(cutterCopy);
                }
                // left side, remain the same, but change cut value to stop early
                // this node will not be split possibly for num[i]
                cutter.cut = num[i];
                holder.push(cutter);
            }
            Stack<SubsetCutter> tmp = stack;
            stack = holder;
            holder = tmp;
        }
        ArrayList<ArrayList<Integer>> sets = new ArrayList<ArrayList<Integer>>();
        while (!stack.isEmpty())
            sets.add(stack.pop().subset);
        return sets;
    }
    */
}
