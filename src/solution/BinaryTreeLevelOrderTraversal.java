package solution;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a binary tree, return the level order traversal of its nodes' values. 
 * (ie, from left to right, level by level).
 *
 * For example:
 * Given binary tree {3,9,20,#,#,15,7},
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * return its level order traversal as:
 *  [
 *   [3],
 *   [9,20],
 *   [15,7]
 *  ]
 * 
 * @author Dongliang Yu
 *
 */
public class BinaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> rst = new ArrayList<List<Integer>>();
        List<TreeNode> level = new ArrayList<TreeNode>();
        if (root != null) level.add(root);
        while (level.size() > 0) {
            List<Integer> levelRst = new ArrayList<Integer>();
            List<TreeNode> nextLevel = new ArrayList<TreeNode>();
            for(TreeNode node : level) {
                levelRst.add(node.val);
                if (node.left != null) nextLevel.add(node.left);
                if (node.right != null) nextLevel.add(node.right);
            }
            rst.add(levelRst);
            level = nextLevel;
        }
        return rst;
    }
}
