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
        ListNode walker1 = dummy;
        ListNode walker2 = head;
        ListNode walker3 = head.next;
        while (walker3 != null) {
            walker1.next = walker3;
            walker2.next = walker3.next;
            walker3.next = walker2;
            walker1 = walker2;
            walker2 = walker1.next;
            if (walker2 == null) break;
            walker3 = walker2.next;
        }
        return dummy.next;
    }
}
