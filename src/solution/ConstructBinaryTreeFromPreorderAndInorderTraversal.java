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
        //if (preorder.length == 0 || inorder.length == 0) return null;
        return buildTree(preorder, 0, preorder.length-1, inorder, 0, inorder.length);
    }
    
    private TreeNode buildTree(int[] preorder, int lo1, int hi1, int[] inorder, int lo2, int hi2) {
        if (lo1 > hi1 || lo2 > hi2) return null;
        int midElement = preorder[lo1];
        TreeNode root = new TreeNode(midElement);
        int midIdx = getIdx(inorder, lo2, hi2, midElement); // in inorder array
        int leftLen = midIdx - lo2;
        root.left = buildTree(preorder, lo1+1, lo1+leftLen, inorder, lo2, midIdx-1);
        root.right = buildTree(preorder, lo1+leftLen+1, hi1, inorder, midIdx+1, hi2);
        return root;
    }
	
    /**
     * almost the same as above one
     * 
    public TreeNode buildTree(int[] preorder, int[] inorder) {
    	//if (preorder.length == 0 || inorder.length == 0) return null;
        return buildTree(preorder, inorder, 0, 0, inorder.length-1);
    }
    
    // rootIdx1 in preorder, lo and hi in inorder
    private TreeNode buildTree(int[] preorder, int[] inorder, int rootIdx1, int lo, int hi) {
        if (lo > hi) return null;
        //if (rootIdx >= preorder.length) return null; // not necessary
        int rootIdx2 = getIdx(inorder, lo, hi, preorder[rootIdx1]);
        //if (rootIdx2 < 0) return null; // not necessary
        TreeNode node = new TreeNode(preorder[rootIdx1]);
        node.left = buildTree(preorder, inorder, rootIdx1+1, lo, rootIdx2-1);
        node.right = buildTree(preorder, inorder, rootIdx1+1+(rootIdx2-lo), rootIdx2+1, hi);
        return node;
    }
    */
    
    private int getIdx(int[] inorder, int lo, int hi, int target) {
        for (int i = lo; i <= hi; i++)
            if (inorder[i] == target) return i;
        return -1;
    }
    
    public static void main(String[] args) {
        int[] preorder = {1, 2, 3};
        int[] inorder = {2, 1, 3};
        new ConstructBinaryTreeFromPreorderAndInorderTraversal().buildTree(preorder, inorder);
    }
}
