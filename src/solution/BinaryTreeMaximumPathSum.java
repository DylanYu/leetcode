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
    private Map<TreeNode, Integer> maxPathDownToLeafDic;

    public int maxPathSum(TreeNode root) {
        max = Integer.MIN_VALUE; // not 0, nodes have negative value
        maxPathDownToLeafDic = new HashMap<TreeNode, Integer>(); // use HashMap to cache no-turn path
        maxPathSumHelper(root);
        return max;
    }
    
    // we calculate path sum for every (turning point) node, and return the maximum one
    private void maxPathSumHelper(TreeNode node) {
        if (node == null) return;
        int left = maxPathDownToLeaf(node.left);
        int right = maxPathDownToLeaf(node.right);
        if (left < 0) left = 0; // do not use negative path from children
        if (right < 0) right = 0;
        int path = node.val + left + right;
        max = Math.max(max, path);
        maxPathSumHelper(node.left);
        maxPathSumHelper(node.right);
    }
    
    // max path from current node to leaf, children may not be included but current node must be included
    private int maxPathDownToLeaf(TreeNode node) {
        if (node == null) return 0;
        if (maxPathDownToLeafDic.containsKey(node)) return maxPathDownToLeafDic.get(node);
        int maxChildPath = Math.max(maxPathDownToLeaf(node.left), maxPathDownToLeaf(node.right));
        // path does not need to reach the leaf,
        // if children's path are both negative, do not use them
        int path = node.val + (maxChildPath > 0 ? maxChildPath : 0);     
        maxPathDownToLeafDic.put(node, path);
        return path;
    }
}
