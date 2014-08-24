package solution;

/**
 * Given inorder and postorder traversal of a tree, construct the binary tree.
 *
 * Note:
 * You may assume that duplicates do not exist in the tree.
 * 
 * @author Dongliang Yu
 *
 */
public class ConstructBinaryTreeFromInorderAndPostorderTraversal {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return buildTree(inorder, postorder, postorder.length-1, 0, inorder.length-1);
    }
    
    // postRootIdx in postorder, lo and hi in inorder
    private TreeNode buildTree(int[] inorder, int[] postorder, int postRootIdx, int lo, int hi) {
        if (lo > hi) return null;
        int val = postorder[postRootIdx];
        int inRootIdx = getIdx(inorder, val);
        TreeNode node = new TreeNode(val);
        node.left = buildTree(inorder, postorder, postRootIdx-(hi-inRootIdx)-1, lo, inRootIdx-1); // (hi-inRootIdx) is the num of nodes in right sub tree
        node.right = buildTree(inorder, postorder, postRootIdx-1, inRootIdx+1, hi);
        return node;
    }
    
    private int getIdx(int[] order, int val) {
        for (int i = 0; i < order.length; i++)
            if (order[i] == val) return i;
        return -1;
    }
}
