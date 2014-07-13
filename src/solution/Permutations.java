package solution;

import java.util.ArrayList;

public class Permutations {
    /*
     * This solution does not depend on NextPermutation, but use a direct recursive way.
    public List<List<Integer>> permute(int[] num) {
        ArrayList<List<Integer>> result = new ArrayList<List<Integer>>();
        ArrayList<Integer> cur = new ArrayList<Integer>();
        ArrayList<Integer> left = new ArrayList<Integer>();
        for (int e : num) left.add(e);
        generate(cur, left, result);
        return result;
    }
    
    private void generate(ArrayList<Integer> cur, ArrayList<Integer> left, ArrayList<List<Integer>> result) {
        if (left.size() == 0) {
            result.add(cur);
            return;
        }
        for (int i = 0; i < left.size(); i++) {
            ArrayList<Integer> curCopy = (ArrayList<Integer>) cur.clone();
            int e = left.get(i);
            curCopy.add(e);
            left.remove(i);
            generate(curCopy, left, result);
            left.add(i, e); // add back to left, so we do not need to copy it.
        }
    }
    */
    
    public static ArrayList<ArrayList<Integer>> permute(int[] num) {
        int length = num.length;
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if (length == 0)
            return result;
        result.add(getList(num));
        int total = factorial(length);
        for (int i = 1; i < total; i++) {
            NextPermutation.nextPermutation(num);
            result.add(getList(num));
        }
        return result;
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
        int[] num = {1, 2, 3, 4};
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
