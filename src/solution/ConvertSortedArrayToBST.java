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
    
    // [hi, lo]
    private TreeNode convert(int[] num, int hi, int lo) {
        if (hi > lo) return null;
        int mid = hi + (lo - hi) / 2;
        TreeNode node = new TreeNode(num[mid]);
        node.left = convert(num, hi, mid-1);
        node.right = convert(num, mid+1, lo);
        return node;
    }
}
