package solution;

/**
 * Given a linked list, swap every two adjacent nodes and return its head.
 *
 * For example,
 * Given 1->2->3->4, you should return the list as 2->1->4->3.
 *
 * Your algorithm should use only constant space. You may not modify the values in the list, 
 * only nodes itself can be changed.
 * 
 * @author Dongliang Yu
 *
 */
public class SwapNodesInPairs {
    public ListNode swapPairs(ListNode head) {
        if (head == null) return null;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode p1 = dummy;
        ListNode p2 = p1.next;
        ListNode p3 = p2.next;
        while (p3 != null) {
            p1.next = p3;
            p2.next = p3.next;
            p3.next = p2;
            // caution
            p1 = p2;
            p2 = p1.next;
            if (p2 == null) break;
            p3 = p2.next;
        }
        return dummy.next;
    }
}
