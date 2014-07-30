package solution;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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
    // interesting recursive solution
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> rst = new ArrayList<List<Integer>>();
        levelOrder(root, 0, rst);
        return rst;
    }
    
    private void levelOrder(TreeNode node, int level, List<List<Integer>> rst) {
        if (node == null) return;
        if (rst.size() == level) rst.add(new LinkedList<Integer>());
        rst.get(level).add(node.val);
        levelOrder(node.left, level+1, rst);
        levelOrder(node.right, level+1, rst);
    }
    
    /*
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> rst = new ArrayList<List<Integer>>();
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        if (root != null) queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode end = queue.getLast();
            List<Integer> levelRst = new LinkedList<Integer>();
            while (true) {
                TreeNode got = queue.removeFirst();
                levelRst.add(got.val);
                if (got.left != null) queue.add(got.left);
                if (got.right != null) queue.add(got.right);
                if (got == end) break;
            }
            rst.add(levelRst);
        }
        return rst;
    }
    */
    
    /* another similar solution
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> rst = new ArrayList<List<Integer>>();
        List<TreeNode> level = new LinkedList<TreeNode>();
        if (root != null) level.add(root);
        while (level.size() > 0) {
            List<Integer> levelRst = new ArrayList<Integer>();
            List<TreeNode> nextLevel = new LinkedList<TreeNode>();
            for (TreeNode node : level) {
                levelRst.add(node.val);
                if (node.left != null) nextLevel.add(node.left);
                if (node.right != null) nextLevel.add(node.right);
            }
            rst.add(levelRst);
            level = nextLevel;
        }
        return rst;
    }
    */
}
