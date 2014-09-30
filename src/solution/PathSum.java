package solution;

import java.util.HashSet;
import java.util.Set;

/**
 * Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding 
 * up all the values along the path equals the given sum.
 * 
 * For example:
 * Given the below binary tree and sum = 22,
 *               5
 *              / \
 *             4   8
 *            /   / \
 *           11  13  4
 *          /  \      \
 *         7    2      1
 * return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.
 * 
 * @author Dongliang Yu
 *
 */
public class PathSum {
	// decided by leaf
    public static boolean hasPathSum(TreeNode root, int sum) {
        return subroutine(root, 0, sum);
    }
    
    private static boolean subroutine(TreeNode node, int now, int sum) {
        if (node == null) return false;
        now += node.val;
        if (now == sum && node.left == null && node.right == null) return true;
        return subroutine(node.left, now, sum) || subroutine(node.right, now, sum);
    }
    
    /**
     * Another recursive approach, decided by root
     * 
    public boolean hasPathSum(TreeNode root, int sum) {
        //if (root == null) return false;
        Set<Integer> sums = pathSum(root);
        for (int e : sums)
            if (e == sum) return true;
        return false;
    }
    
    private Set<Integer> pathSum(TreeNode node) {
        Set<Integer> ret = new HashSet<Integer>();
        if (node == null) return ret;
        
        Set<Integer> lefts = pathSum(node.left);
        for (int l : lefts) ret.add(l+node.val);
        Set<Integer> rights = pathSum(node.right);
        for (int r : rights) ret.add(r+node.val);
        if (ret.size() == 0) ret.add(node.val);
        return ret;
    }
    */
}
