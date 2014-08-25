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
        boolean leftToRight = true;
        List<TreeNode> level = new ArrayList<TreeNode>();
        level.add(root);
        while (!level.isEmpty()) {
            List<TreeNode> nextLevel = new ArrayList<TreeNode>(level.size()*2); // to avoid resize ArrayList
            int idx = 0;
            while (idx < level.size()) {
                TreeNode curr = level.get(idx);
                if (curr.left != null) nextLevel.add(curr.left);
                if (curr.right != null) nextLevel.add(curr.right);
                idx++;
            }
            
            List<Integer> subRet = new LinkedList<Integer>();
            if (leftToRight) {
                for (int i = 0; i < level.size(); i++)
                    subRet.add(level.get(i).val);
            } else {
                for (int i = level.size()-1; i >= 0; i--)
                    subRet.add(level.get(i).val);
            }
            ret.add(subRet);
            
            leftToRight = !leftToRight;
            level = nextLevel;
        }
        return ret;
    }
}
