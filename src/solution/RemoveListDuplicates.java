package solution;

/**
 * Remove Duplicates from Sorted List
 * <p>
 * Given a sorted linked list, delete all duplicates such that each element appear only once.
 * <p>
 * For example,
 * Given 1->1->2, return 1->2.
 * Given 1->1->2->3->3, return 1->2->3.
 * 
 * @author Dongliang Yu
 *
 */
public class RemoveListDuplicates {
    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null)
            return null;
        ListNode walker1 = head;
        ListNode walker2 = walker1.next;
        while (walker2 != null) {
            if (walker1.val == walker2.val) {
                do {
                    walker2 = walker2.next;
                } while (walker2 != null && walker1.val == walker2.val);
                walker1.next = walker2;
            }
            if (walker2 != null) {
                walker1 = walker2;
                walker2 = walker1.next;
            }
        }
        return head;
    }
}
