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
	// Also: In fact we can use Long.MIN_VALUE/MAX_VALUE
    public boolean isValidBST(TreeNode root) {
        //if (root == null) return true;
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    
    private boolean isValidBST(TreeNode node, long smallest, long largest) {
        if (node == null) return true;
        if (node.val <= smallest || node.val >= largest) return false;
        return isValidBST(node.left, smallest, node.val)
                && isValidBST(node.right, node.val, largest);
    }
    
    /*
     * complicated version but the same idea as above one
     * 
    private boolean valid;
    
    public boolean isValidBST(TreeNode root) {
        valid = true;
        range(root);
        return valid;
    }
    
    private int[] range(TreeNode node) {
        if (!valid) return null;
        if (node == null) return null;
        int[] leftRange = range(node.left);
        int[] rightRange = range(node.right);
        
        int leftMin = Integer.MIN_VALUE;
        int leftMax = Integer.MIN_VALUE;
        if (leftRange != null) {
            leftMin = leftRange[0];
            leftMax = leftRange[1];
        }
        int rightMin = Integer.MAX_VALUE;
        int rightMax = Integer.MAX_VALUE;
        if (rightRange != null) {
            rightMin = rightRange[0];
            rightMax = rightRange[1];
        }
        
        if (!(leftMax < node.val && node.val < rightMin)) {
            valid = false;
            return null; // range not important anymore, just return null
        }
        
        if (leftRange == null && rightRange == null) {
            int[] ret = new int[2];
            ret[0] = node.val;
            ret[1] = node.val;
            return ret;
        } else if (leftRange == null) {
            rightRange[0] = Math.min(rightRange[0], node.val);
            rightRange[1] = Math.max(rightRange[1], node.val);
            return rightRange;
        } else if (rightRange == null) {
            leftRange[0] = Math.min(leftRange[0], node.val);
            leftRange[1] = Math.max(leftRange[1], node.val);
            return leftRange;
        } else {
            int[] ret = new int[2];
            ret[0] = Math.min(node.val, Math.min(leftMin, rightMin));
            ret[1] = Math.max(node.val, Math.max(leftMax, rightMax));
            return ret;
        }
    }
    */

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
