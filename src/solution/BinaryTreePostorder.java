package solution;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.LinkedList;
import java.util.Set;
import java.util.Stack;

/**
 * Binary Tree Postorder Traversal
 * 
 * 3 non-recursive solutions including:
 *  Straight forward way with one stack
 *  Magic solution with two stacks
 *  Use a counter for each node
 * 
 * @author Dongliang Yu
 * @see http://leetcode.com/2010/10/binary-tree-post-order-traversal.html
 *
 */
public class BinaryTreePostorder {
    /**
     *
    public static List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ret = new ArrayList<Integer>();
        if (root == null)
            return ret;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        TreeNode prev = null;
        while (!stack.empty()) {
            TreeNode cur = stack.peek();    // not pop
            if (prev == null || prev.left == cur || prev.right == cur) { // traverse down the tree
                if (cur.left != null) {
                    stack.push(cur.left);
                }
                else if (cur.right != null) {
                    stack.push(cur.right);
                }
                else {
                    ret.add(cur.val);
                    stack.pop();
                }
            } else if (cur.left == prev) { // traverse up from left
                if (cur.right != null) {
                    stack.push(cur.right);
                } else {
                    ret.add(cur.val);
                    stack.pop();
                }
            } else if (cur.right == prev) { // traverse up from right
                ret.add(cur.val);
                stack.pop();
            }
            prev = cur;
        }
        return ret;
    }
    */
    
    
    /* Magic solution with two stacks */
    public static List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ret = new LinkedList<Integer>();
        if (root == null)
            return ret;
        Stack<TreeNode> stk = new Stack<TreeNode>();
        Stack<Integer> output = new Stack<Integer>();
        stk.push(root);
        while (!stk.empty()) {
            TreeNode from1 = stk.pop();
            output.push(from1.val);
            if (from1.left != null)
                stk.push(from1.left);
            if (from1.right != null)
                stk.push(from1.right);
        }
        while (!output.isEmpty())
            ret.add(output.pop());
        return ret;
    }
    
    /* use a set to record node's touched time, add to result when second touch (or leaf node) */
    public List<Integer> postorderTraversalWithSet(TreeNode root) {
        List<Integer> ret = new LinkedList<Integer>();
        if (root == null) return ret;
        Stack<TreeNode> stk = new Stack<TreeNode>();
        stk.push(root); // init
        Set<TreeNode> set = new HashSet<TreeNode>();
        while (!stk.isEmpty()) {
            TreeNode curr = stk.pop();
            // leaf node could be added immediately
            //if (curr.left == null && curr.right == null) {
            //    ret.add(curr.val);
            //    continue;
            //}
            if (set.contains(curr)) {
                ret.add(curr.val);
                set.remove(curr);
            } else {
                set.add(curr);
                stk.push(curr);
                if (curr.right != null) stk.push(curr.right);
                if (curr.left != null) stk.push(curr.left);
            }
        }
        return ret;
    }
    

    /* The version below requires a counter in each node, which is 
     * less recommended 
     */
    
    private static class Node {
        int val;
        Node left;
        Node right;
        int count;
        Node (TreeNode node) { // recursively create node
            if (node != null) {
                val = node.val;
                count = 0;
                if (node.left != null)
                    left = new Node(node.left);
                if (node.right != null)
                    right = new Node(node.right);
            }
        }
    }
    
    public static List<Integer> postorderTraversalWithCounter(TreeNode root) {
        List<Integer> ret = new ArrayList<Integer>();
        if (root == null)
            return ret;
        Node current = new Node(root);
        Stack<Node> stack = new Stack<Node>();
        do {
            if (current != null) {
                current.count++;
                if (current.count == 3) {
                    ret.add(current.val);
                    if (stack.isEmpty()) // traversal is finished
                        break;
                    current = stack.pop();
                } else {
                    stack.push(current);
                    if (current.left != null) {
                        if (current.count == 1)
                            current = current.left;
                        else
                            current = current.right;
                    }
                    else if (current.right != null) {
                        current.count++; // cannot goto left but it counts
                        current = current.right;
                    }
                    else
                        current = stack.pop();
                }
            } else {
                current = stack.pop();
            }
        } while (!stack.isEmpty() || current.count != 3); // avoid early stop
        return ret;
    }
    
    public static void main(String[] args) {
        TreeNode root = BinaryTree.createTree();
        List<Integer> queue = postorderTraversal(root);
        //List<Integer> queue = postorderTraversalWithCounter(root);
        for (Integer e : queue)
            System.out.println(e);
    }
}
