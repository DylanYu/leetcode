package solution;

public class PopulateNextRightPointersII {
    // neat solution
    public void connect(TreeLinkNode root) {
        if (root == null) return;
        TreeLinkNode curr = root;
        TreeLinkNode prev = null;
        TreeLinkNode nextLevel = null;
        while (curr != null) {
            // iterate on current level
            while (curr != null) {
                if (curr.left != null) {
                    if (prev != null) prev.next = curr.left;
                    else nextLevel = curr.left;
                    prev = curr.left;
                }
                if (curr.right != null) {
                    if (prev != null) prev.next = curr.right;
                    else nextLevel = curr.right;
                    prev = curr.right;
                }
                // move to right sibling
                curr = curr.next;
            }
            // move to next level
            curr = nextLevel;
            prev = null;
            nextLevel = null;
        }
    }
    
    /**
     * complicated solution 
     *
    public void connect(TreeLinkNode root) {
        if (root == null) return;
        TreeLinkNode curr = null;
        TreeLinkNode nextLevel = root;
        do {
            curr = nextLevel;
            nextLevel = null;
            boolean nextLevelNotFound = true;
            
            while (curr != null) {
                TreeLinkNode next = curr.next;
                while (next != null && next.left == null && next.right == null)
                    next = next.next;
                
                if (curr.left != null) {
                    if (nextLevelNotFound) {
                        nextLevelNotFound = false;
                        nextLevel = curr.left;
                    }
                    if (curr.right != null) { // curr.left != null && curr.right != null
                        curr.left.next = curr.right;
                        if (next != null) {
                            if (next.left != null) curr.right.next = next.left;
                            else curr.right.next = next.right;
                        }
                    } else { // curr.left != null && curr.right == null
                        if (next != null) {
                            if (next.left != null) curr.left.next = next.left;
                            else curr.left.next = next.right;
                        }
                    }
                } else {
                    if (curr.right != null) { // curr.left == null && curr.right != null
                        if (nextLevelNotFound) {
                            nextLevelNotFound = false;
                            nextLevel = curr.right;
                        }
                        if (curr.next != null) {
                            if (next.left != null) curr.right.next = next.left;
                            else curr.right.next = next.right;
                        }
                    } else { // curr.left == null && curr.right == null
                        // do nothing
                    }
                }
                curr = next;
            }
        } while (nextLevel != null);
    }
    */
}
