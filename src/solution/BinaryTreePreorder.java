package solution;

import java.util.ArrayList;
import java.util.List;
import java.util.LinkedList;
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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ret = new LinkedList<Integer>();
        if (root == null) return ret;
        Stack<TreeNode> stk = new Stack<TreeNode>();
        stk.push(root);
        while (!stk.isEmpty()) {
            TreeNode curr = stk.pop();
            ret.add(curr.val);
            if (curr.right != null) stk.push(curr.right);
            if (curr.left != null) stk.push(curr.left);
        }
        return ret;
    }
    
    /**
     * complicated solution
     * 
    public List<Integer> preorderTraversal(TreeNode root) {
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
    */
    
    public static void main(String[] args) {
        TreeNode root = BinaryTree.createTree();
        List<Integer> queue = new BinaryTreePreorder().preorderTraversal(root);
        for (Integer e : queue)
            System.out.println(e);
    }
}
