package solution;

/**
 * Populate each next pointer to point to its next right node. If there is no next right node, 
 * the next pointer should be set to NULL.
 * 
 * Initially, all next pointers are set to NULL.
 *
 * Note:
 *
 * You may only use constant extra space.
 * You may assume that it is a perfect binary tree (ie, all leaves are at the same level, 
 * and every parent has two children).
 * For example,
 * Given the following perfect binary tree,
 *          1
 *        /  \
 *       2    3
 *      / \  / \
 *     4  5  6  7
 * After calling your function, the tree should look like:
 *          1 -> NULL
 *        /  \
 *       2 -> 3 -> NULL
 *      / \  / \
 *     4->5->6->7 -> NULL
 * 
 * @author Dongliang Yu
 *
 */
public class PopulateNextRightPointers {
    // non-recursive solution. Note: it's a perfect binary tree
    public void connect(TreeLinkNode root) {
        if (root == null) return;
        TreeLinkNode curr = root;
        while (curr.left != null) {
            TreeLinkNode nextLevel = curr.left;
            while (curr != null) {
                curr.left.next = curr.right;
                if (curr.next != null) curr.right.next = curr.next.left;
                curr = curr.next;
            }
            curr = nextLevel;
        }
    }
    
    /*
     * recursive solution. Note: it's a perfect binary tree
     * 
    public void connect(TreeLinkNode root) {
        if (root == null || root.left == null) return;
        root.left.next = root.right;
        if (root.next != null) root.right.next = root.next.left;
        
        connect(root.left);
        connect(root.right);
    }
    */
    
    /* 
     * use extra queue
     * 
    public void connect(TreeLinkNode root) {
        if (root == null) return;
        LinkedList<TreeLinkNode> queue = new LinkedList<TreeLinkNode>();
        queue.add(root);
        while (queue.size() > 0) {
            TreeLinkNode tail = queue.getLast();
            TreeLinkNode cur;
            do {
                cur = queue.removeFirst();
                if (cur == tail) cur.next = null;
                else cur.next = queue.getFirst();
                if (cur.left != null) queue.add(cur.left);
                if (cur.right != null) queue.add(cur.right);
            } while (cur != tail);
        }
    }
    */
}
