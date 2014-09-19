package solution;

/**
 * Sort a linked list in O(n log n) time using constant space complexity.
 * 
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 * 
 * @author Dongliang Yu
 * 
 */
public class SortList {
    public ListNode sortList(ListNode head) {
        if (head == null) return null;
        int N = 0;
        ListNode walker = head;
        while (walker != null) {
            walker = walker.next;
            N++;
        }
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        int step = 1;
        
        while (step < N) {
            ListNode h = dummyHead;
            while (h != null) {
                merge(h, step);
                
                int count = 0;
                while (count++ < 2*step && h != null) h = h.next;
            }
            step *= 2;
        }
        return dummyHead.next;
    }
    
    private void merge(ListNode h1, int step) {
        ListNode h2 = h1;
        int count = 0;
        while (count++ < step && h2 != null) h2 = h2.next;
        if (h2 == null) return;
        ListNode p1 = h1.next;
        ListNode p2 = h2.next;
        int i = 0;
        int j = 0;
        while (i < step && p1 != null && j < step && p2 != null) {
            if (p1.val < p2.val) {
                p1 = p1.next;
                h1 = h1.next;
                i++;
            } else {
                h2.next = p2.next;
                h1.next = p2;
                p2.next = p1;
                h1 = h1.next;
                p2 = h2.next;
                j++;
            }
        }
    }
    
    /*
    public ListNode sortList(ListNode head) {
        ListNode walker = head;
        int N = 0;
        while (walker != null) {
            N++;
            walker = walker.next;
        }
        ListNode fakeHead = new ListNode(-1);
        fakeHead.next = head;
        for (int interval = 2; interval < N * 2; interval *= 2) {
            mergeIntervals(fakeHead, interval);
            LinkedList.show(fakeHead.next);
        }
        return fakeHead.next;
    }
    
    private void mergeIntervals(ListNode fakeHead, int interval) {
        ListNode walker = fakeHead;
        while (walker.next != null) {
            merge(walker, interval);
            for (int i = 0; walker.next != null && i < interval; i++)
                walker = walker.next;
        }
    }
    
    private void merge(ListNode fakeHead, int interval) {
        if (fakeHead.next == null)
            return;
        int length = interval / 2;
        ListNode left = fakeHead.next;
        ListNode right = left;
        ListNode pl = fakeHead;
        pl.next = left;
        ListNode pr = null;
        for (int i = 0; right != null && i < length; i++) {
            pr = right;
            right = right.next;
            if (right == null)
                return;
        }
        
        int indexl = 0;
        int indexr = 0;
        while (left != null && right != null && indexl < length && indexr < length) {
            if (left.val < right.val) {
                pl = pl.next;
                left = left.next;
                indexl++;
            } else {
                pr.next = right.next;
                right.next = left;
                pl.next = right;
                
                right = pr.next;
                pl = pl.next;
                
                indexr++;
            }
        }
    }
    */
    
    public static void main(String[] args) {
        ListNode head = LinkedList.createRandomValueList(10);
        LinkedList.show(head);
        head = new SortList().sortList(head);
        LinkedList.show(head);
    }
}
