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
public class RemoveListDuplicatesII {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return head;
        ListNode dummy = new ListNode(Integer.MIN_VALUE);
        dummy.next = head;
        ListNode prev = dummy;
        ListNode p = head;
        while (p != null && p.next != null) {
            if (p.val == p.next.val) {
                ListNode dup = p.next;
                while (dup != null && dup.val == p.val) dup = dup.next;
                prev.next = dup;
                p = dup;
            } else {
                prev = prev.next;
                p = p.next;
            }
        }
        return dummy.next;
    }
}
