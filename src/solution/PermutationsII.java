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
    public static ArrayList<ArrayList<Integer>> permuteUnique(int[] num) {
        int length = num.length;
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if (length == 0)
            return result;
        Arrays.sort(num);
        result.add(Permutations.getList(num));
        while (!isDesc(num)) {
            NextPermutation.nextPermutation(num);
            result.add(Permutations.getList(num));
        }
        return result;
    }
    
    /**
     * not strictly descending
     */
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
