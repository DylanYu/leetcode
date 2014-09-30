package solution;

import java.util.ArrayList;

public class Permutations {
    /*
     * This solution does not depend on NextPermutation, but use a direct recursive way.
     * 
    public List<List<Integer>> permute(int[] num) {
        List<List<Integer>> ret = new LinkedList<List<Integer>>();
        if (num.length == 0) return ret;
        ArrayList<Integer> left = new ArrayList<Integer>();
        for (int e : num) left.add(e);
        generate(new ArrayList<Integer>(), left, ret);
        return ret;
    }
    
    private void generate(List<Integer> curr, List<Integer> left, List<List<Integer>> ret) {
        if (left.size() == 0) {
            ret.add(new ArrayList<Integer>(curr));
            return;
        }
        for (int i = 0; i < left.size(); i++) {
        	int e = left.remove(i);
            curr.add(e);
            generate(curr, left, ret);
            curr.remove(curr.size()-1);
            left.add(i, e);
        }
    }
    */
    
    public static ArrayList<ArrayList<Integer>> permute(int[] num) {
        int length = num.length;
        ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
        if (length == 0) return ret;
        int total = factorial(length); // if any duplicate elements, this is NOT correct, see PermutationsII
        for (int i = 0; i < total; i++) {
            ret.add(getList(num));
            NextPermutation.nextPermutation(num);
        }
        return ret;
    }
    
    public static ArrayList<Integer> getList(int[] num) {
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
        ArrayList<ArrayList<Integer>> permutations = permute(num);
        System.out.println("number of permutations: " + permutations.size());
        for (int i = 0; i < permutations.size(); i++) {
            ArrayList<Integer> item = permutations.get(i);
            for (int j = 0; j < item.size(); j++)
                System.out.print(item.get(j) + " ");
            System.out.println();
        }
    }
}
