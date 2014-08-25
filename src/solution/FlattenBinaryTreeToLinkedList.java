package solution;

import java.util.Stack;

/**
 * Given a binary tree, flatten it to a linked list in-place.
 *
 * For example,
 * Given
 * 
 *          1
 *         / \
 *        2   5
 *       / \   \ 
 *      3   4   6
 * The flattened tree should look like:
 *    1
 *     \
 *      2
 *       \
 *        3
 *         \
 *          4
 *           \
 *            5
 *             \
 *              6
 *
 * 
 * @author Dongliang Yu
 *
 */
public class FlattenBinaryTreeToLinkedList {
    // awesome non-recursive solution
    public void flatten(TreeNode root) {
        while (root != null) {
            if (root.left != null) {
                TreeNode mostRight = root.left;
                while (mostRight.right != null) mostRight = mostRight.right;
                mostRight.right = root.right;
                root.right = root.left;
                root.left = null;
            }
            root = root.right;
        }
    }
    
    /* use a stack
    public void flatten(TreeNode root) {
        if (root == null) return;
        Stack<TreeNode> stk = new Stack<TreeNode>();
        TreeNode curr = root;
        while (curr != null) {
            if (curr.right != null) stk.push(curr.right);
            if (curr.left != null) {
                curr.right = curr.left;
            } else if (!stk.isEmpty()) {
                curr.right = stk.pop();
            } else 
                curr.right = null; // as as break
            curr.left = null;
            curr = curr.right;
        }
    }
    */

    /* recursive way
    private TreeNode last = null;
    
    public void flatten(TreeNode root) {
        flattenSub(root);
    }
    
    public void flattenSub(TreeNode node) {
        if (node == null) return;
        TreeNode savedRight = node.right;
        if (last != null) {
            last.left = null;
            last.right = node;
        }
        last = node;
        flattenSub(node.left);
        flattenSub(savedRight);
    }
    */
}
