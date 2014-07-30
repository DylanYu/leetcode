package solution;

import java.util.ArrayList;

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
    public ArrayList<TreeNode> generateTrees(int n) {
        return generateTrees(1, n);
    }
    
    // [start, end]
    private ArrayList<TreeNode> generateTrees(int start, int end) {
        ArrayList<TreeNode> rst = new ArrayList<TreeNode>();
        if (start > end) {
            rst.add(null);
            return rst;
        }
        for (int i = start; i <= end; i++) {
            ArrayList<TreeNode> lefts = generateTrees(start, i-1);
            ArrayList<TreeNode> rights = generateTrees(i+1, end);
            for (TreeNode left : lefts) {
                for (TreeNode right : rights) {
                    TreeNode node = new TreeNode(i);
                    node.left = left;
                    node.right = right;
                    rst.add(node);
                }
            }
        }
        return rst;
    }
}
