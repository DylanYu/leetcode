package solution;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Binary Tree Inorder Traversal
 * 
 * A non-recursive solution.
 * <p>Reference: http://leetcode.com/2010/04/binary-search-tree
 * -in-order-traversal.html
 * 
 * @author Dongliang Yu
 *
 */
public class BinaryTreeInorder {
    public static ArrayList<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> queue = new ArrayList<Integer>();
        if (root == null)
            return queue;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        TreeNode node = root;
        while (!stack.isEmpty()) {
            if (node.left != null) {
                stack.push(node.left);
                node = node.left;
            } else {
                node = stack.pop();
                queue.add(node.val);
                if (node.right != null) {
                    stack.push(node.right);
                    node = node.right;
                }
            }
        }
        return queue;
    }
    
    public static void main(String[] args) {
        TreeNode root = BinaryTree.createTree();
        ArrayList<Integer> queue = inorderTraversal(root);
        for (Integer e : queue)
            System.out.println(e);
    }
}
