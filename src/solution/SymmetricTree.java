package solution;

/**
 * Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
 *
 * For example, this binary tree is symmetric:
 *
 *     1
 *    / \
 *   2   2
 *  / \ / \
 * 3  4 4  3
 * But the following is not:
 *     1
 *    / \
 *   2   2
 *    \   \
 *    3    3
 * Note:
 * Bonus points if you could solve it both recursively and iteratively.
 * 
 * @author Dongliang Yu
 *
 */
public class SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return isSymmetric(root.left, root.right);
    }
    
    private boolean isSymmetric(TreeNode left, TreeNode right) {
        if (left == null) return right == null;
        if (right == null) return left == null;
        return left.val == right.val 
                && isSymmetric(left.right, right.left)
                && isSymmetric(left.left, right.right);
    }
    
    /*
     * iterative approach: use two Stacks to simulate the recursive process
     * 
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        Stack<TreeNode> stk1 = new Stack<TreeNode>();
        Stack<TreeNode> stk2 = new Stack<TreeNode>();
        stk1.push(root.left);
        stk2.push(root.right);
        while (!stk1.isEmpty() && !stk2.isEmpty()) {
            TreeNode n1 = stk1.pop();
            TreeNode n2 = stk2.pop();
            if (n1 == null && n2 == null) continue;
            if (n1 == null || n2 == null) return false;
            if (n1.val != n2.val) return false;
            stk1.push(n1.left);
            stk2.push(n2.right);
            stk1.push(n1.right);
            stk2.push(n2.left);
        }
        return stk1.isEmpty() && stk2.isEmpty();
    }
    */
    
    /*
     * iterative approach
     * 
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        LinkedList<TreeNode> currLevel = new LinkedList<TreeNode>();
        currLevel.add(root);
        while (!currLevel.isEmpty()) {
            LinkedList<TreeNode> nextLevel = new LinkedList<TreeNode>();
            for (TreeNode node : currLevel) {
                if (node != null) {
                    nextLevel.add(node.left);
                    nextLevel.add(node.right);
                }
            }
            while (!currLevel.isEmpty()) {
                TreeNode head = currLevel.removeFirst();
                TreeNode tail = null;
                if (currLevel.isEmpty()) break; // odd number of nodes, only for root case
                else tail = currLevel.removeLast();
                if (head == null && tail != null
                    || head != null && tail == null
                    || head != null && tail != null && head.val != tail.val)
                    return false;
            }
            currLevel = nextLevel;
        }
        return true;
    }
    */
}
