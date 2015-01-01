package solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.LinkedList;
import java.util.Stack;

/**
 * Given a set of distinct integers, S, return all possible subsets.
 * <p>
 * Note:
 * <p>Elements in a subset must be in non-descending order.
 * <p>The solution set must not contain duplicate subsets.
 *
 * @author Dongliang Yu
 *
 */
public class Subsets {
    public static List<List<Integer>> subsets(int[] S) {
        List<List<Integer>> ret = new LinkedList<List<Integer>>();
        Arrays.sort(S);
        collect(new ArrayList<Integer>(), S, 0, ret);
        return ret;
    }
    
    private static void collect(List<Integer> list, int[] S, int idx, List<List<Integer>> ret) {
        if (idx == S.length) {
            ret.add(new ArrayList<Integer>(list));
            return;
        }
        
        collect(list, S, idx+1, ret); // skip current element
        
        list.add(S[idx]); // include current element
        collect(list, S, idx+1, ret);
        list.remove(list.size()-1);
    }
    
    /*
    private static void collect(ArrayList<Integer> list, int[] S, int idx, List<List<Integer>> ret) {
        ret.add(new ArrayList<Integer>(list)); // will include an empty list in final result
        if (idx == S.length) return;
        for (int i = idx; i < S.length; i++) {
            list.add(S[i]);
            collect(list, S, i+1, ret);
            list.remove(list.size()-1); //
        }
    }
    */
    
    /*
     * awesome solution using bit manipulation 
     * 
    public List<List<Integer>> subsets(int[] S) {
        List<List<Integer>> ret = new LinkedList<List<Integer>>();
        int total = 1 << S.length;
        Arrays.sort(S);
        for (int i = 0; i < total; i++) {
            LinkedList<Integer> list = new LinkedList<Integer>();
            for (int j = 0; j < S.length; j++) {
                if (((i >> j) & 1) == 1)
                    list.add(S[j]);
            }
            ret.add(list);
        }
        return ret;
    }
    */
    
    /*
    public static ArrayList<ArrayList<Integer>> subsets(int[] S) {
        Arrays.sort(S);
        Stack<ArrayList<Integer>> stack = new Stack<ArrayList<Integer>>();
        stack.push(new ArrayList<Integer>()); // empty element
        for (Integer e : S) {
            Stack<ArrayList<Integer>> holder = new Stack<ArrayList<Integer>>();
            while (!stack.isEmpty()) {
                ArrayList<Integer> element = stack.pop();                
                ArrayList<Integer> copy = (ArrayList<Integer>) element.clone();
                copy.add(e);
                holder.push(element);
                holder.push(copy);
            }
            stack = holder;
        }
        ArrayList<ArrayList<Integer>> sets = new ArrayList<ArrayList<Integer>>();
        while (!stack.isEmpty())
            sets.add(stack.pop());
        return sets;
    }
    */
    
    public static void main(String[] args) {
        int[] S = {1, 2, 3};
        List<List<Integer>> subsets = subsets(S);
        for (List<Integer> list : subsets) {
            for (Integer e : list)
                System.out.print(e + ",");
            System.out.println();
        }
    }
}
