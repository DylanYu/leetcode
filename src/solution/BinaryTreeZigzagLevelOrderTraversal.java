package solution;

import java.util.ArrayList;
import java.util.List;
import java.util.LinkedList;

/**
 * Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, 
 * from left to right, then right to left for the next level and alternate between).
 *
 * For example:
 * Given binary tree {3,9,20,#,#,15,7},
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * return its zigzag level order traversal as:
 * [
 *   [3],
 *   [20,9],
 *   [15,7]
 * ]
 * 
 * @author Dongliang Yu
 *
 */
public class BinaryTreeZigzagLevelOrderTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ret = new LinkedList<List<Integer>>();
        if (root == null) return ret;
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        boolean leftToRight = true;
        while (!queue.isEmpty()) {
            LinkedList<Integer> level = new LinkedList<Integer>();
            TreeNode tail = queue.getLast();
            TreeNode curr;
            do {
                curr = queue.removeFirst();
                if (leftToRight) level.add(curr.val);
                else level.addFirst(curr.val);
                if (curr.left != null) queue.add(curr.left);
                if (curr.right != null) queue.add(curr.right);
            } while (curr != tail);
            ret.add(level);
            leftToRight = !leftToRight;
        }
        return ret;
    }
    
    /**
     * more subtle
     *
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ret = new LinkedList<List<Integer>>();
        if (root == null) return ret;
        boolean leftToRight = true;
        ArrayList<TreeNode> currlevel = new ArrayList<TreeNode>();
        currlevel.add(root);
        while (!currlevel.isEmpty()) {
            ArrayList<TreeNode> nextLevel = new ArrayList<TreeNode>();
            LinkedList<Integer> intLevel = new LinkedList<Integer>();
            for (int i = currlevel.size()-1; i >= 0; i--) {
                TreeNode curr = currlevel.get(i);
                intLevel.add(curr.val);
                if (leftToRight) {
                    if (curr.left != null) nextLevel.add(curr.left);
                    if (curr.right != null) nextLevel.add(curr.right);
                } else {
                    if (curr.right != null) nextLevel.add(curr.right);
                    if (curr.left != null) nextLevel.add(curr.left);
                }
            }
            leftToRight = !leftToRight;
            ret.add(intLevel);
            currlevel = nextLevel;
        }
        return ret;
    }
     */
}
