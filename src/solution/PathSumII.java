package solution;

import java.util.ArrayList;
import java.util.List;
import java.util.LinkedList;

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
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> ret = new LinkedList<List<Integer>>();
        traverse(root, new ArrayList<Integer>(), sum, ret);
        return ret;
    }
    
    // sum - remaining sum to get
    private void traverse(TreeNode node, List<Integer> path, int sum, List<List<Integer>> ret) {
        if (node == null) return;
        path.add(node.val); // add
        if (node.left == null && node.right == null) { // leaf
            if (node.val == sum)
                ret.add(new ArrayList<Integer>(path));
        } else {
            traverse(node.left, path, sum-node.val, ret);
            traverse(node.right, path, sum-node.val, ret);
        }
        path.remove(path.size()-1); // remove (back trace)
    }
    
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        List<List<Integer>> result = new PathSumII().pathSum(root, 1);
        for (List<Integer> list : result) {
            for (int e : list)
                System.out.print(e);
            System.out.println();
        }
    }
}
