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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        LinkedList<List<Integer>> rst = new LinkedList<List<Integer>>();
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
            rst.addFirst(levelRst);
        }
        return rst;
    }
    
    /* just reveres the result of levelOrder()
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> rst = new ArrayList<List<Integer>>();
        levelOrderBottom(root, 0, rst);
        Collections.reverse(rst);
        return rst;
    }
    
    private void levelOrderBottom(TreeNode node, int level, List<List<Integer>> rst) {
        if (node == null) return;
        if (level >= rst.size()) rst.add(new LinkedList<Integer>());
        rst.get(level).add(node.val);
        levelOrderBottom(node.left, level+1, rst);
        levelOrderBottom(node.right, level+1, rst);
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
