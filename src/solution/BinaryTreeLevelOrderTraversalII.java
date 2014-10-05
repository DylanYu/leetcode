package solution;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

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
 *   [15,7]
 *   [9,20],
 *   [3],
 *  ]
 * 
 * @author Dongliang Yu
 *
 */
public class BinaryTreeLevelOrderTraversalII {
    // trick the levelOrder() by inserting at head
    public List<List<Integer>> levelOrder(TreeNode root) {
        LinkedList<List<Integer>> ret = new LinkedList<List<Integer>>();
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        if (root != null) queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode end = queue.getLast();
            List<Integer> level = new LinkedList<Integer>();
            while (!queue.isEmpty()) {
                TreeNode curr = queue.removeFirst();
                level.add(curr.val);
                if (curr.left != null) queue.add(curr.left);
                if (curr.right != null) queue.add(curr.right);
                if (curr == end) break;
            }
            ret.addFirst(level); // just this different from version I
        }
        return ret;
    }
    
    /*
     * modify the recursion version of LevelOrderTraversal
     * 
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        int h = height(root);
        // create result list first
        for (int i = 0; i < h; i++)
            ret.add(new LinkedList<Integer>());
        levelOrder(root, 0, h, ret);
        return ret;
    }
    
    private int height(TreeNode node) {
        if (node == null) return 0;
        return 1 + Math.max(height(node.left), height(node.right));
    }
    
    private void levelOrder(TreeNode node, int level, int height, List<List<Integer>> ret) {
        if (node == null) return;
        //if (level >= ret.size()) ret.add(new LinkedList<Integer>());
        levelOrder(node.left, level+1, height, ret);
        levelOrder(node.right, level+1, height, ret);
        ret.get(height-level-1).add(node.val); // kind of a post order traversal
    }
    */
    
    /* similar to BinaryTreeLevelOrderTraversal, with an extra stack to do the 'bottom'
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> rst = new ArrayList<List<Integer>>();
        Stack<TreeNode> stk = new Stack<TreeNode>();
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        if (root != null) queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode end = queue.getLast();
            while (true) {
                TreeNode got = queue.removeFirst();
                if (got.left != null) queue.add(got.left);
                if (got.right != null) queue.add(got.right);
                stk.push(got);
                if (got == end) {
                    stk.push(null);
                    break;
                }
            }
        }
        while (!stk.isEmpty()) {
            TreeNode cur = stk.pop();
            if (cur == null) {  // start a new level, and reverse the last level
                if (rst.size() > 0) Collections.reverse(rst.get(rst.size()-1));
                rst.add(new LinkedList<Integer>());
            } else {
                rst.get(rst.size()-1).add(cur.val);
            }
        }
        return rst;
    }
    */
}
