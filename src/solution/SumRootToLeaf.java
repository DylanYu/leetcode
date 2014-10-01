package solution;

/**
 * Given a binary tree containing digits from 0-9 only, 
 * each root-to-leaf path could represent a number.
 * <p>
 * An example is the root-to-leaf path 1->2->3 which represents the number 123.
 * Find the total sum of all root-to-leaf numbers.
 * <p>
 * For example,
 * <p>    1
 * <p>   / \
 * <p>  2   3
 * <p>The root-to-leaf path 1->2 represents the number 12.
 * <p>The root-to-leaf path 1->3 represents the number 13.
 * <p>
 * Return the sum = 12 + 13 = 25.
 * 
 * @author Dongliang Yu
 *
 */
public class SumRootToLeaf {
    public int sumNumbers(TreeNode root) {
        return helper(root, 0);
    }
    
    private int helper(TreeNode node, int sum) {
        if (node == null)
            return 0;
        sum = sum * 10 + node.val;
        if (node.left == null && node.right == null)
            return sum;
        else
            return helper(node.left, sum) + helper(node.right, sum);
    }
    
    /**
     * Another kind of recursion
     * 
    int sum;
    
    public int sumNumbers(TreeNode root) {
        sum = 0;
        collect(root, 0);
        return sum;
    }
    
    private void collect(TreeNode node, int num) {
        if (node == null) return;
        num = num*10 + node.val;
        if (node.left == null && node.right == null) {
            sum += num;
        } else {
            collect(node.left, num);
            collect(node.right, num);
        }
    }
    */
}
