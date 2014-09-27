package solution;

import java.util.LinkedList;
import java.util.List;

/**
 * Given n, generate all structurally unique BST's (binary search trees) that store values 1...n.
 *
 * For example,
 * Given n = 3, your program should return all 5 unique BST's shown below.
 * 
 *   1         3     3      2      1
 *    \       /     /      / \      \
 *     3     2     1      1   3      2
 *    /     /       \                 \
 *   2     1         2                 3
 * 
 * @author Dongliang Yu
 *
 */
public class UniqueBinarySearchTreesII {
    public List<TreeNode> generateTrees(int n) {
        return generate(1, n); // when n is 0, a null pointer will be in the result list
    }
    
    // [start, end]
    private List<TreeNode> generate(int start, int end) {
        List<TreeNode> ret = new LinkedList<TreeNode>();
        
        if (start > end) { // no left or right sub tree case
            ret.add(null); // add one null element, not empty, for later for-each loop
            //return ret;
        }
        
        for (int i = start; i <= end; i++) {
            List<TreeNode> lefts = generate(start, i-1);
            List<TreeNode> rights = generate(i+1, end);
            for (TreeNode left : lefts) {
                for (TreeNode right : rights) {
                    TreeNode root = new TreeNode(i);
                    root.left = left;
                    root.right = right;
                    ret.add(root);
                }
            }
        }
        
        return ret;
    }
    
    /*
     * Alternative solution
     * 
    public List<TreeNode> generateTrees(int n) {
        List<TreeNode> ret = new LinkedList<TreeNode>();
        if (n == 0) ret.add(null); // this is required in OJ, but makes no sense
        for (int i = 1; i <= n; i++)
            ret.addAll(generate(1, i, n));
        return ret;
    }
    
    // [lo, hi]
    private List<TreeNode> generate(int lo, int rootVal, int hi) {
        List<TreeNode> ret = new LinkedList<TreeNode>();
        
        List<TreeNode> lefts = new LinkedList<TreeNode>();
        for (int i = lo; i <= rootVal-1; i++)
            lefts.addAll(generate(lo, i, rootVal-1));
        if (lo == rootVal) lefts.add(null); // no left sub tree
        
        List<TreeNode> rights = new LinkedList<TreeNode>();
        for (int i = rootVal+1; i <= hi; i++)
            rights.addAll(generate(rootVal+1, i, hi));
        if (rootVal == hi) rights.add(null); // no right sub tree
        
        for (TreeNode left : lefts) {
            for (TreeNode right : rights) {
                TreeNode root = new TreeNode(rootVal);
                root.left = left;
                root.right = right;
                ret.add(root);
            }
        }
            
        return ret;
    }
    */
}
