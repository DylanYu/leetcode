package solution;

import java.util.ArrayList;
import java.util.Stack;

public class BinaryTreePostorder {
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
    
    public static ArrayList<Integer> postorderTraversalWithCount(TreeNode root) {
        ArrayList<Integer> queue = new ArrayList<Integer>();
        if (root == null)
            return queue;
        Node current = new Node(root);
        Stack<Node> stack = new Stack<Node>();
        do {
            if (current != null) {
                current.count++;
                if (current.count == 3) {
                    queue.add(current.val);
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
        return queue;
    }
    
    public static void main(String[] args) {
        TreeNode root = BinaryTree.createTree();
        ArrayList<Integer> queue = postorderTraversalWithCount(root);
        for (Integer e : queue)
            System.out.println(e);
    }
}
