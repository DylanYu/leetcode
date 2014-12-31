package solution;

import java.util.Stack;

/**
 * Implement an iterator over a binary search tree (BST). Your iterator will 
 * be initialized with the root node of a BST.
 * 
 * Calling next() will return the next smallest number in the BST.
 * 
 * Note: next() and hasNext() should run in average O(1) time and uses O(h) 
 * memory, where h is the height of the tree.
 * 
 * @author Dongliang Yu
 *
 */
public class BinarySearchTreeIterator {
    private Stack<TreeNode> stack;
    
    public BinarySearchTreeIterator(TreeNode root) {
        stack = new Stack<TreeNode>();
        pushLeft(root);
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {
        if (stack.isEmpty()) return -1; // Exception
        TreeNode node = stack.pop();
        pushLeft(node.right);
        return node.val;
    }
    
    private void pushLeft(TreeNode node) {
        while (node != null) {
            stack.push(node);
            node = node.left;
        }
    }
}
