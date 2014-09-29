package solution;

/**
 * Given a binary tree, determine if it is height-balanced.
 * 
 * For this problem, a height-balanced binary tree is defined as a binary tree in which the depth 
 * of the two subtrees of every node never differ by more than 1.
 * 
 * @author Dongliang Yu
 *
 */
public class BalancedBinaryTree {
    private boolean balance;
    
    // check when getting heights
    public boolean isBalanced(TreeNode root) {
        balance = true;
        height(root);
        return balance;
    }
    
    private int height(TreeNode node) {
        if (node == null) return 0;
        if (balance == false) return 0; // 0 does not represent the height, just return early
        int leftH = height(node.left);
        int rightH = height(node.right);
        if (Math.abs(leftH-rightH) > 1) balance = false;
        return 1 + Math.max(leftH, rightH);
    }
}
