package solution;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
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
    /**
     *  use a set to record node's touched time, add to result when second touch
     *  
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ret = new LinkedList<Integer>();
        if (root == null) return ret;
        Set<TreeNode> set = new HashSet<TreeNode>();
        Stack<TreeNode> stk = new Stack<TreeNode>();
        stk.push(root);
        while (!stk.isEmpty()) {
            TreeNode curr = stk.pop();
            if (set.contains(curr)) {
                ret.add(curr.val);
                set.remove(curr);
            } else {
                set.add(curr);
                if (curr.right != null) stk.push(curr.right);
                stk.push(curr);
                if (curr.left != null) stk.push(curr.left);
            }
        }
        return ret;
    }
    */
    
    public List<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> queue = new ArrayList<Integer>();
        if (root == null)
            return queue;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode node = root;
        do {
            if (node != null) {
                stack.push(node);
                node = node.left;
            } else {
                node = stack.pop();
                queue.add(node.val);
                node = node.right;
            }
        } while (!stack.isEmpty() || 
                node != null); // avoid early stop
        return queue;
    }
    
    /**
     * same as above, easier to understand
     * 
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ret = new LinkedList<Integer>();
        if (root == null) return ret;
        Stack<TreeNode> stk = new Stack<TreeNode>();
        TreeNode node = root;
        while (!stk.isEmpty() || node != null) {
            while (node != null) {
                stk.push(node);
                node = node.left;
            }
            node = stk.pop();
            ret.add(node.val);
            if (node.right != null) node = node.right;
            else node = null;
        };
        return ret;
    }
    */
    
    public static void main(String[] args) {
        TreeNode root = BinaryTree.createTree();
        List<Integer> queue = new BinaryTreeInorder().inorderTraversal(root);
        for (Integer e : queue)
            System.out.println(e);
    }
}
