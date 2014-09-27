package solution;

/**
 * Given a binary tree, find its maximum depth.
 *
 * The maximum depth is the number of nodes along the longest path from 
 * the root node down to the farthest leaf node.
 * 
 * @author Dongliang Yu
 *
 */
public class MaximumDepthOfBinaryTree {
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }
    
    /*
    public int maxDepth(TreeNode root) {
        return maxDepth(root, 0);
    }
    
    private int maxDepth(TreeNode node, int height) {
        if (node == null) return height;
        return Math.max(maxDepth(node.left, height+1), maxDepth(node.right, height+1));
    }
    */
}
