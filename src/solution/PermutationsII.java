package solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.LinkedList;

/**
 * Given a collection of numbers that might contain duplicates, return all possible unique 
 * permutations.
 * <p>
 * <p>For example,
 * <p>[1,1,2] have the following unique permutations:
 * <p>[1,1,2], [1,2,1], and [2,1,1].
 * 
 * @author Dongliang Yu
 *
 */
public class PermutationsII {
    public List<List<Integer>> permuteUnique(int[] num) {
        List<List<Integer>> ret = new LinkedList<List<Integer>>();
        if (num.length == 0) return ret;
        Arrays.sort(num);
        collect(num, 0, ret);
        return ret;
    }
    
    private void collect(int[] num, int index, List<List<Integer>> ret) {
        if (index == num.length) {
            List<Integer> list = new LinkedList<Integer>();
            for (int e : num) list.add(e);
            ret.add(list);
            return;
        }
        for (int i = index; i < num.length; i++) {
            // if (i > index && num[i] == num[i-1]) continue; // This is not correct because right now the array may not be sorted
            // skip if we found duplicate
            boolean skip = false;
            for(int j = index; j < i; j++) {
                if(num[j] == num[i]) {
                    skip = true;
                    break;
                }
            }
            if (skip) continue;
            
            swap(num, i, index);
            collect(num, index+1, ret);
            swap(num, i, index);
        }
    }
    
    private void swap(int[] num, int i , int j) {
        int tmp = num[i];
        num[i] = num[j];
        num[j] = tmp;
    }
    
    /*
     * This solution does not depend on NextPermutation, but use a direct recursive way.
     * 
    public List<List<Integer>> permuteUnique(int[] num) {
        List<List<Integer>> ret = new LinkedList<List<Integer>>();
        if (num.length == 0) return ret;
        Arrays.sort(num);
        ArrayList<Integer> left = new ArrayList<Integer>();
        for (int e : num) left.add(e);
        generate(new ArrayList<Integer>(), left, ret);
        return ret;
    }
    
    private void collect(ArrayList<Integer> curr, ArrayList<Integer> remain, List<List<Integer>> ret) {
        if (remain.size() == 0) {
            ret.add(new ArrayList<Integer>(curr));
            return;
        }
        for (int i = 0; i < remain.size(); i++) { // size will not change after add and remove
            if (i > 0 && remain.get(i) == remain.get(i-1)) continue;
            int e = remain.get(i);
            remain.remove(i);
            curr.add(e);
            collect(curr, remain, ret);
            curr.remove(curr.size()-1);
            remain.add(i, e);
        }
    }
    */
    
    /**
     * Solution based on @link NextPermutation
     * 
    public static List<List<Integer>> permuteUnique(int[] num) {
        int length = num.length;
        List<List<Integer>> ret = new LinkedList<List<Integer>>();
        if (length == 0) return ret;
        Arrays.sort(num);
        while (true) {
            ret.add(Permutations.getList(num));
            if (isDesc(num)) break;
            NextPermutation.nextPermutation(num);
        }
        return ret;
    }
    
    // not strictly descending
    public static boolean isDesc(int[] num) {
        int length = num.length;
        for (int i = 0; i < length - 1; i++)
            if (num[i] < num[i + 1])
                return false;
        return true;
    }
    */
    
    public static void main(String[] args) {
        int[] num = {2, 1, 2, 4};
        List<List<Integer>> uniquePermutations = new PermutationsII().permuteUnique(num);
        System.out.println("number of permutations: " + uniquePermutations.size());
        for (int i = 0; i < uniquePermutations.size(); i++) {
            List<Integer> item = uniquePermutations.get(i);
            for (int e : item)
                System.out.print(e + " ");
            System.out.println();
        }
    }
}
