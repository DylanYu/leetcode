package solution;

/**
 * Remove Nth Node From End of List.
 * <p>
 * Given a linked list, remove the nth node from the end of list and return 
 * its head.
 * <p>
 * For example,
 * Given linked list: 1->2->3->4->5, and n = 2.
 * After removing the second node from the end, the linked list becomes 
 * 1->2->3->5.
 * <p>
 * Note:
 * Given n will always be valid.
 * Try to do this in one pass.
 * 
 * @author Dongliang Yu
 *
 */
public class RemoveNodeFromListEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null)
            return null;
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode fast = dummyHead;
        while (n-- > 0)
            fast = fast.next;
        ListNode slow = dummyHead;
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;
        return dummyHead.next;
    }
}
