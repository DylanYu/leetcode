package solution;

import java.util.ArrayList;
import java.util.Arrays;

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
    
    private void generate(ArrayList<Integer> curr, ArrayList<Integer> left, List<List<Integer>> ret) {
        if (left.size() == 0) {
            ret.add(new ArrayList<Integer>(curr));
            return;
        }
        int i = 0;
        while (i < left.size()) {
            int e = left.remove(i);
            curr.add(e);
            generate(curr, left, ret);
            curr.remove(curr.size()-1);
            left.add(i, e);
            int j = i+1;
            while (j < left.size() && left.get(j) == left.get(j-1)) j++;
            i = j;
        }
    }
    */
	
    public static ArrayList<ArrayList<Integer>> permuteUnique(int[] num) {
        int length = num.length;
        ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
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
    
    public static void main(String[] args) {
        int[] num = {2, 1, 2, 4};
        ArrayList<ArrayList<Integer>> uniquePermutations = permuteUnique(num);
        System.out.println("number of permutations: " + uniquePermutations.size());
        for (int i = 0; i < uniquePermutations.size(); i++) {
            ArrayList<Integer> item = uniquePermutations.get(i);
            for (int j = 0; j < item.size(); j++)
                System.out.print(item.get(j) + " ");
            System.out.println();
        }
    }
}
