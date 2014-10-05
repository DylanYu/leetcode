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
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        //if (root == null) return result;
        recurse(root, new ArrayList<Integer>(), 0, sum, ret);
        return ret;
    }
   
    private static void recurse(TreeNode node, ArrayList<Integer> curList, int curVal, int sum, List<List<Integer>> ret) {
        if (node == null) return;
        curVal += node.val;
        curList.add(node.val);
        if (curVal == sum && node.left == null && node.right == null) {
            ArrayList<Integer> copy = new ArrayList<Integer>(curList);
            ret.add(copy);
            curList.remove(curList.size()-1); //
            return;
        }
        recurse(node.left, curList, curVal, sum, ret);
        recurse(node.right, curList, curVal, sum, ret);
        curList.remove(curList.size()-1); //
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
