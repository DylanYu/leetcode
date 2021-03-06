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
    /*
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
    */
    
    // straight-forward recursive solution
    public void flatten(TreeNode root) {
        recurse(root);
    }
    
    private TreeNode recurse(TreeNode node) {
        if (node == null) return null;
        TreeNode leftMostRight = recurse(node.left);
        TreeNode rightMostRight = recurse(node.right);
        if (leftMostRight == null && rightMostRight == null)
            return node;
        else if (leftMostRight == null && rightMostRight != null)
            return rightMostRight;
        else if (leftMostRight != null && rightMostRight == null) {
            node.right = node.left;
            node.left = null;
            return leftMostRight;
        } else { // left != null && right != null
            leftMostRight.right = node.right;
            node.right = node.left;
            node.left = null;
            return rightMostRight;
        }
    }
    
    /**
     * iterative preorder solution
     * 
    public void flatten(TreeNode root) {
        if (root == null) return;
        TreeNode prev = null;
        Stack<TreeNode> stk = new Stack<TreeNode>();
        stk.push(root);
        while (!stk.isEmpty()) {
            TreeNode curr = stk.pop();
            if (prev != null) {
                prev.left = null;
                prev.right = curr;
            }
            if (curr.right != null) stk.push(curr.right);
            if (curr.left != null) stk.push(curr.left);
            prev = curr;
        }
    }
    */
    
    /*
     * more 'stack-like' stack solution
     * 
    public TreeNode flatten(TreeNode root) {
        //if (root == null) return null;
        Stack<TreeNode> stk = new Stack<TreeNode>();
        stk.push(root);
        while (!stk.isEmpty()) {
            TreeNode curr = stk.pop();
            if (curr == null) continue;
            if (curr.left == null && curr.right == null) {
                if (stk.isEmpty()) break; // nothing to proceed
                curr.right = stk.pop();
                stk.push(curr.right);
            } else { // MUST else because we will make curr.right from null to not null 
                if (curr.right != null) stk.push(curr.right);
                if (curr.left != null) {
                    curr.right = curr.left;
                    curr.left = null;
                    stk.push(curr.right);
                }
            }
        }
        return root;
    }
    */
    
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

    /*
     * recursive approach, use the property of preorder traverse
     * 
    private TreeNode prev;
    
    public void flatten(TreeNode root) {
        prev = null;
        recurse(root);
    }
    
    private void recurse(TreeNode node) {
        if (node == null) return;
        if (prev != null) {
            prev.right = node;
            prev.left = null;
        }
        prev = node;
        TreeNode right = node.right; // record to avoid poisoning link
        recurse(node.left);
        recurse(right);
    }
    */
    
    /*
     * Another straight-forward recursive solution
     * 
    public void flatten(TreeNode root) {
        helper(root);
    }
    
    private TreeNode helper(TreeNode node) {
        if (node == null) return null;
        if (node.left == null) {
            if (node.right == null) return node;
            else return helper(node.right);
        } else {
            TreeNode right = node.right;
            node.right = node.left;
            node.left = null;
            TreeNode mostRight = helper(node.right);
            mostRight.right = right;
            if (right != null) {
                return helper(right);
            } else
                return mostRight;
        }
    }
    */
    
    /* recursive way
    private TreeNode last = null;
    
    public void flatten(TreeNode root) {
        flattenSub(root);
        return root;
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
