package solution;

import java.util.ArrayList;
import java.util.Arrays;
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
    
    public static void main(String[] args) {
        int[] S = {1, 2, 3};
        ArrayList<ArrayList<Integer>> subsets = subsets(S);
        for (ArrayList<Integer> list : subsets) {
            for (Integer e : list)
                System.out.print(e + ",");
            System.out.println();
        }
    }
}
