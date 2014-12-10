package solution;

/**
 * 
 * @author Dongliang Yu
 * 
 * Given a binary tree where all the right nodes are either leaf nodes with a sibling (a left node 
 * that shares the same parent node) or empty, flip it upside down and turn it into a tree where 
 * the original right nodes turned into left leaf nodes. Return the new root.
 * 
 * For example:
 * Given a binary tree {1,2,3,4,5},
 *     1
 *    / \
 *   2   3
 *  / \
 * 4   5
 * 
 * turn it into:
 *        1
 *       /
 *      2---3
 *     /
 *    4---5
 * 
 * that is:
 *    4
 *   / \
 *  5   2
 *     / \
 *    3   1
 * 
 * return the root of the binary tree [4,5,2,#,#,3,1].
 * 
 */
public class BinaryTreeUpsideDown {
    private TreeNode newRoot;
    
    public TreeNode UpsideDownBinaryTree(TreeNode root) {
        newRoot = null;
        helper(root);
        return newRoot;
    }
    
    public void helper(TreeNode root) {
        if (root == null) return;
        if (root.left == null) {
            newRoot = root;
            return;
        }
        TreeNode left = root.left;
        helper(left);
        left.left = root.right;
        left.right = root;
        root.left = null;
        root.right = null;
    }
    
    public static void main(String[] args) {
        TreeNode root = BinaryTree.createTreeForUpsideDown();
        BinaryTree.show(root);
        root = new BinaryTreeUpsideDown().UpsideDownBinaryTree(root);
        BinaryTree.show(root);
    }
}
