package solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.LinkedList;

public class Permutations {
    public List<List<Integer>> permute(int[] num) {
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
        for (int i = index; i < num.length; i++) { // not index+1, will swap self
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
    public List<List<Integer>> permute(int[] num) {
        List<List<Integer>> ret = new LinkedList<List<Integer>>();
        if (num.length == 0) return ret;
        ArrayList<Integer> remaining = new ArrayList<Integer>();
        for (int e : num) remaining.add(e);
        collect(new ArrayList<Integer>(), remaining, ret);
        return ret;
    }
    
    private void collect(List<Integer> curr, List<Integer> remaining, List<List<Integer>> ret) {
        if (remaining.size() == 0) {
            ret.add(new ArrayList<Integer>(curr));
            return;
        }
        for (int i = 0; i < remaining.size(); i++) {
            int e = remaining.remove(i);
            curr.add(e);
            collect(curr, remaining, ret);
            curr.remove(curr.size()-1);
            remaining.add(i, e); // MUST add at i
        }
    }
    */
    
    /**
     * Solution based on @link NextPermutation
     * 
    public List<ArrayList<Integer>> permute(int[] num) {
        int length = num.length;
        List<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
        if (length == 0) return ret;
        int total = factorial(length); // if any duplicate elements, this is NOT correct, see PermutationsII
        for (int i = 0; i < total; i++) {
            ret.add(getList(num));
            NextPermutation.nextPermutation(num);
        }
        return ret;
    }
    */
    
    public static List<Integer> getList(int[] num) {
        int length = num.length;
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < length; i++)
            list.add(num[i]);
        return list;
    }
    
    public static int factorial(int n) {
        int f = 1;
        while (n >= 1)
            f *= n--;
        return f;
    }
    
    
    public static void main(String[] args) {
        int[] num = {1, 2, 2, 4};
        List<List<Integer>> permutations = new Permutations().permute(num);
        System.out.println("number of permutations: " + permutations.size());
        for (int i = 0; i < permutations.size(); i++) {
            List<Integer> item = permutations.get(i);
            for (int e : item)
                System.out.print(e + " ");
            System.out.println();
        }
    }
}
