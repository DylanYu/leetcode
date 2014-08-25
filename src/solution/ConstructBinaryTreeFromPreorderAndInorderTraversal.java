package solution;

/**
 * Given preorder and inorder traversal of a tree, construct the binary tree.
 *
 * Note:
 * You may assume that duplicates do not exist in the tree.
 * 
 * @author Dongliang Yu
 *
 */
public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(preorder, inorder, 0, 0, inorder.length-1);
    }
    
    // rootIdx1 in preorder, lo and hi in inorder
    private TreeNode buildTree(int[] preorder, int[] inorder, int rootIdx1, int lo, int hi) {
        if (lo > hi) return null;
        //if (rootIdx >= preorder.length) return null; // not necessary
        int rootIdx2 = getIdx(inorder, preorder[rootIdx1]);
        //if (rootIdx2 < 0) return null; // not necessary
        TreeNode node = new TreeNode(preorder[rootIdx1]);
        node.left = buildTree(preorder, inorder, rootIdx1+1, lo, rootIdx2-1);
        node.right = buildTree(preorder, inorder, rootIdx1+1+(rootIdx2-lo), rootIdx2+1, hi);
        return node;
    }
    
    private int getIdx(int[] inorder, int val) {
        for (int i = 0; i < inorder.length; i++)
            if (inorder[i] == val) return i;
        return -1;
    }
    
    public static void main(String[] args) {
        int[] preorder = {1, 2, 3};
        int[] inorder = {2, 1, 3};
        new ConstructBinaryTreeFromPreorderAndInorderTraversal().buildTree(preorder, inorder);
    }
}
