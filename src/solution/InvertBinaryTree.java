package solution;

import java.util.*;

/**
 * Invert a binary tree.
 * 
 *      4
 *    /   \
 *   2     7
 *  / \   / \
 * 1   3 6   9
 * 
 * to
 * 
 *      4
 *    /   \
 *   7     2
 *  / \   / \
 * 9   6 3   1
 * 
 * @author Dongliang Yu
 *
 */
public class InvertBinaryTree {
	/*
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        TreeNode tmp = invertTree(root.left);
        root.left = invertTree(root.right);
        root.right = tmp;
        return root;
    }
    */
    
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        Stack<TreeNode> stk = new Stack<TreeNode>();
        stk.push(root);
        while (!stk.isEmpty()) {
            TreeNode curr = stk.pop();
            if (curr.left != null) stk.push(curr.left);
            if (curr.right != null) stk.push(curr.right);
            TreeNode tmp = curr.left;
            curr.left = curr.right;
            curr.right = tmp;
        }
        return root;
    }
}
