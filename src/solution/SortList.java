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
            /**
             * delete to accept
             */
            System.out.println("After interval " + interval + ":");
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
    
    public static void main(String[] args) {
        ListNode head = LinkedList.createRandomValueList(10);
        LinkedList.show(head);
        head = new SortList().sortList(head);
        LinkedList.show(head);
    }
}
