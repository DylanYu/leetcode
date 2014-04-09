package solution;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Binary Tree Preorder Traversal
 * 
 * A non-recursive solution.
 * 
 * @author Dongliang Yu
 *
 */
public class BinaryTreePreorder {
    public static ArrayList<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> queue = new ArrayList<Integer>();
        if (root == null)
            return queue;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode node = root;
        do {
            if (node != null) {                      
                queue.add(node.val);
                if (node.right != null)
                    stack.push(node.right);
                node = node.left;
            } else {
                node = stack.pop();
            }
        } while (!stack.isEmpty() ||
                node != null); // avoid early stop
        return queue;
    }
    
    public static void main(String[] args) {
        TreeNode root = BinaryTree.createTree();
        ArrayList<Integer> queue = preorderTraversal(root);
        for (Integer e : queue)
            System.out.println(e);
    }
}
