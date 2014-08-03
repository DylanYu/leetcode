package solution;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a binary tree, find the maximum path sum.
 *
 * The path may start and end at any node in the tree.
 *
 * For example:
 * Given the below binary tree,
 *
 *        1
 *       / \
 *      2   3
 * 
 * Return 6.
 * 
 * @author Dongliang Yu
 *
 */
public class BinaryTreeMaximumPathSum {
    private int max;
    private Map<TreeNode, Integer> pathNoTurnDic;

    public int maxPathSum(TreeNode root) {
        max = Integer.MIN_VALUE;
        pathNoTurnDic = new HashMap<TreeNode, Integer>(); // use HashMap to cache no-turn path
        maxPathSumHelper(root);
        return max;
    }
    
    // we calculate path sum for every (turning point) node, and return the maximum one
    private void maxPathSumHelper(TreeNode node) {
        if (node == null) return;
        int sum = maxPathWithTurn(node);
        if (sum > max) max = sum;
        maxPathSumHelper(node.left);
        maxPathSumHelper(node.right);
    }
    
    private int maxPathWithTurn(TreeNode node) {
        if (node == null) return 0;
        int left = maxPathNoTurn(node.left);
        int right = maxPathNoTurn(node.right);
        if (left < 0) left = 0;
        if (right < 0) right = 0;
        return node.val + left + right;
    }
    
    private int maxPathNoTurn(TreeNode node) {
        if (node == null) return 0;
        if (pathNoTurnDic.containsKey(node)) return pathNoTurnDic.get(node);
        int maxChildPath = Math.max(maxPathNoTurn(node.left), maxPathNoTurn(node.right));
        // path does not need to reach the leaf,
        // if children's path are both negative, do not use them
        int rst = node.val + (maxChildPath > 0 ? maxChildPath : 0);     
        pathNoTurnDic.put(node, rst);
        return rst;
    }
}
