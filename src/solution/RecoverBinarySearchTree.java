package solution;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Two elements of a binary search tree (BST) are swapped by mistake.
 * 
 * Recover the tree without changing its structure.
 * 
 * @author Dongliang Yu
 *
 */
public class RecoverBinarySearchTree {
    private TreeNode prev;
    private TreeNode a;
    private TreeNode b;
    
    /* O(1) extra space
     * Note:
     * 1. Given a sequence {1, 4, 3, 7, 9}, you find pair 4(!<=)3, swap this pair and sequence is in order.
     * 2. Given a sequence {1, 9, 4, 5, 3, 10}, you get first pair 9(!<=)4 and second pair 5(!<=)3, swap pair 9(!<=)3 and sequence is in order.
     * 3. Given a sequence, only in two above (general) cases, that you can just swap one pair numbers to convert an unordered sequence into ordered. 
     * 4. You can tranverse BST inorder to get above sequence.
     * Reference: https://oj.leetcode.com/discuss/7319/an-elegent-time-complexity-and-space-complexity-algorithm
     */
    public void recoverTree(TreeNode root) {
        if (root == null) return;
        prev = new TreeNode(Integer.MIN_VALUE);
        a = null;
        b = null;
        recover(root);
        
        int tmp = a.val;
        a.val = b.val;
        b.val = tmp;
    }
    
    private void recover(TreeNode curr) {
        if (curr == null) return;
        recover(curr.left);
        if (prev.val > curr.val) {
            if (a == null) a = prev; // bigger (swapped to left) one, change only once
            b = curr; // smaller (swapped to right) one, could change twice
        }
        prev = curr;
        recover(curr.right);
    }
    
    /*
     * O(N) extra space
     * 
    public void recoverTree(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        inorder(root, list);
        Collections.sort(list);
        recover(root, list);
    }
    
    private int idx = 0;
    
    private void recover(TreeNode root, List<Integer> list) {
        if (root == null) return;
        recover(root.left, list);
        root.val = list.get(idx++);
        recover(root.right, list);
    }
    
    private void inorder(TreeNode root, List<Integer> list) {
        if (root == null) return;
        inorder(root.left, list);
        list.add(root.val);
        inorder(root.right, list);
    }
    */
}
