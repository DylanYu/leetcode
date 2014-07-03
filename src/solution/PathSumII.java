package solution;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.
 *
 * For example:
 * Given the below binary tree and sum = 22,
 *               5
 *              / \
 *             4   8
 *            /   / \
 *           11  13  4
 *          /  \    / \
 *         7    2  5   1
 * return
 * [
 *    [5,4,11,2],
 *    [5,8,4,5]
 * ]
 * 
 * @author Dongliang Yu
 *
 */
public class PathSumII {
    public static List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (root == null) return result;
        subroutine(root, 0, new ArrayList<Integer>(), result, sum);
        return result;
    }
   
    private static void subroutine(TreeNode node, int curVal, ArrayList<Integer> curList, List<List<Integer>> result, int sum) {
        curVal += node.val;
        curList.add(node.val);
        if (curVal == sum && node.left == null && node.right == null) {
            ArrayList<Integer> list = (ArrayList<Integer>) curList.clone();
            result.add(list);
        }
        if (node.left != null)
            subroutine(node.left, curVal, curList, result, sum);
        if (node.right != null)
            subroutine(node.right, curVal, curList, result, sum);
        curList.remove(curList.size() - 1);
    }
    
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        List<List<Integer>> result = pathSum(root, 1);
        for (List<Integer> list : result) {
            for (int e : list)
                System.out.print(e);
            System.out.println();
        }
    }
}
