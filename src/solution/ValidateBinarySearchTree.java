package solution;

/**
 * Given a binary tree, determine if it is a valid binary search tree (BST).
 * 
 * Assume a BST is defined as follows:
 *  The left subtree of a node contains only nodes with keys less than the node's key.
 *  The right subtree of a node contains only nodes with keys greater than the node's key.
 *  Both the left and right subtrees must also be binary search trees.
 * 
 * @author Dongliang Yu
 *
 */
public class ValidateBinarySearchTree {
    // Caveat: We should avoid use Integer.MIN_VALUE and Integer.MAX_VALUE to pass 
    // edge cases which have Integer.MIN_VALUE/MAX_VALUE as node.val
    // Also: Double.MIN_VALUE is the closest positive number to zero
    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        return isValidBST(root.left, -Double.MAX_VALUE, root.val)
                && isValidBST(root.right, root.val, Double.MAX_VALUE);
    }
    
    private boolean isValidBST(TreeNode node, double smallest, double largest) {
        if (node == null) return true;
        if (node.val <= smallest || node.val >= largest) return false;
        return isValidBST(node.left, smallest, node.val)
                && isValidBST(node.right, node.val, largest);
    }

    /* straight forward way
    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        if ((root.left != null && getMax(root.left) >= root.val) ||
            (root.right != null && getMin(root.right) <= root.val))
            return false;
        return isValidBST(root.left) && isValidBST(root.right);
     }
     */
}
