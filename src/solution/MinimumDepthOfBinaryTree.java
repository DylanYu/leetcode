package solution;

import java.util.LinkedList;

/**
 * Given a binary tree, find its minimum depth.
 *
 * The minimum depth is the number of nodes along the shortest 
 * path from the root node down to the nearest leaf node.
 * 
 * @author Dongliang Yu
 * @see MaximumDepthOfBinaryTree
 */
public class MinimumDepthOfBinaryTree {
    // BFS
    public int minDepth(TreeNode root) {
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        if (root == null) return 0;
        queue.add(root);
        int depth = 1;
        while (true) {
            TreeNode end = queue.getLast();
            TreeNode cur = null;
            do {
                cur = queue.poll();
                if (cur.left == null && cur.right == null) return depth;
                if (cur.left != null) queue.add(cur.left);
                if (cur.right != null) queue.add(cur.right);
            } while (cur != end);
            depth++;
        }
    }
    
    /* recursive way
    public int minDepth(TreeNode root) {
        if (root == null) return 0; // special case in null root
        return minDepthHelper(root);
    }
    
    private int minDepthHelper(TreeNode root) {
        if (root == null) return Integer.MAX_VALUE;
        if (root.left == null && root.right == null) return 1;
        return 1 + Math.min(minDepthHelper(root.left), minDepthHelper(root.right));
    }
    */
    
    /*
     * Another kind of recursion
     * 
    public int minDepth(TreeNode root) {
        if (root == null) return 0; //
        return minDepth(root, 1);
    }
    
    // current height
    private int minDepth(TreeNode node, int height) {
        if (node == null)
            return Integer.MAX_VALUE; // not leaf
        if (node.left == null && node.right == null) // leaf
            return height;
        return Math.min(minDepth(node.left, height+1), minDepth(node.right, height+1));
    }
    */
}
