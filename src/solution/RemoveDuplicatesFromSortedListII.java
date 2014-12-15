package solution;

/**
 * Remove Duplicates from Sorted List II
 * <p>
 * Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.
 * <p>
 * For example,
 * <p>Given 1->2->3->3->4->4->5, return 1->2->5.
 * <p>Given 1->1->1->2->3, return 2->3.
 * 
 * @author Dongliang Yu
 *
 */
public class RemoveDuplicatesFromSortedListII {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return head;
        ListNode dummy = new ListNode(Integer.MIN_VALUE);
        dummy.next = head;
        ListNode prev = dummy;
        while (prev != null && prev.next != null) {
            ListNode p1 = prev.next;
            ListNode p2 = p1.next;
            while (p2 != null && p1.val == p2.val)
                p2 = p2.next;
            if (p2 != p1.next)
                prev.next = p2;
            else
                prev = prev.next;
        }
        return dummy.next;
    }
}
