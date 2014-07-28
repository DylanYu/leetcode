package solution;

/**
 * Given an array where elements are sorted in ascending order, convert it to 
 * a height balanced BST.
 * 
 * @author Dongliang Yu
 *
 */
public class ConvertSortedArrayToBST {
    public TreeNode sortedArrayToBST(int[] num) {
        return convert(num, 0, num.length-1);
    }
    
    // [lo, hi]
    private TreeNode convert(int[] num, int lo, int hi) {
        if (lo > hi) return null;
        int mid = lo + (hi - lo) / 2;
        TreeNode node = new TreeNode(num[mid]);
        node.left = convert(num, lo, mid-1);
        node.right = convert(num, mid+1, hi);
        return node;
    }
}
