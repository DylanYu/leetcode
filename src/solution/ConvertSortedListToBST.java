package solution;

/**
 * Given a singly linked list where elements are sorted in ascending order, 
 * convert it to a height balanced BST.
 * 
 * @author Dongliang Yu
 *
 */
public class ConvertSortedListToBST {
    // awesome recursive solution
    private ListNode listNode;
    
    public TreeNode sortedListToBST(ListNode head) {
        this.listNode = head;
        int n = 0;
        for (ListNode walker = head; walker != null; walker = walker.next) n++;
        return sortedListToBST(0, n-1);
    }
    
    // [lo, hi]
    private TreeNode sortedListToBST(int lo, int hi) {
        if (lo > hi) return null;
        int mid = lo + (hi - lo) / 2;
        TreeNode left = sortedListToBST(lo, mid-1);
        TreeNode root = new TreeNode(listNode.val);
        root.left = left;
        listNode = listNode.next; //
        root.right = sortedListToBST(mid+1, hi);
        return root;
    }
    
    /**
     * Another recursive solution
     * 
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) return null;
        int len = 0;
        ListNode p = head;
        while (p != null) { p = p.next; len++; }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        p = dummy;
        for (int i = 0; i < len/2; i++) p = p.next;
        ListNode pNext = p.next;
        p.next = null; //
        p = pNext;
        
        TreeNode root = new TreeNode(p.val);
        if (p != head) root.left = sortedListToBST(head); //
        else root.left = null;
        root.right = sortedListToBST(p.next);
        return root;
    }
    */
    
    /* naive way uses an extra array
    public TreeNode sortedListToBST(ListNode head) {
        int n = 0;
        for (ListNode walker = head; walker != null; walker = walker.next) n++;
        int[] A = new int[n];
        ListNode walker = head;
        for(int i = 0; i < n; i++) {
            A[i] = walker.val;
            walker = walker.next;
        }
        return sortedArrayToBST(A, 0, n-1);
    }
    
    // [lo, hi]
    private TreeNode sortedArrayToBST(int[] A, int lo, int hi) {
        if (lo > hi) return null;
        int mid = lo + (hi - lo) / 2;
        TreeNode root = new TreeNode(A[mid]);
        root.left = sortedArrayToBST(A, lo, mid-1);
        root.right = sortedArrayToBST(A, mid+1, hi);
        return root;
    }
    */
}
