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
        //if (inorder.length == 0 || postorder.length == 0) return null;
        return buildTree(inorder, 0, inorder.length-1, postorder, 0, postorder.length-1);
    }
    
    private TreeNode buildTree(int[] inorder, int lo1, int hi1, int[] postorder, int lo2, int hi2) {
        if (lo1 > hi1 || lo2 > hi2) return null; //
        int midElement = postorder[hi2];
        TreeNode root = new TreeNode(midElement);
        int midIdx = getIdx(inorder, lo1, hi1, midElement);
        int rightLen = hi1 - midIdx;
        root.left = buildTree(inorder, lo1, midIdx-1, postorder, lo2, hi2-rightLen-1);
        root.right = buildTree(inorder, midIdx+1, hi1, postorder, hi2-rightLen, hi2-1);
        return root;
    }

	/**
	 * almost the same as above one
	 * 
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
    */
    
    private int getIdx(int[] arr, int lo, int hi, int target) {
        for (int i = lo; i <= hi; i++)
            if (arr[i] == target) return i;
        return -1;
    }
}
