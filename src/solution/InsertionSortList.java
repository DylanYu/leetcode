package solution;

/**
 * Sort a linked list using insertion sort.
 * 
 * @author Dongliang Yu
 *
 */
public class InsertionSortList {
    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode walker1 = dummy;
        ListNode walker2 = dummy.next;
        walker1.next = null;
        while (walker2 != null) {
            // reverse a node
            ListNode middle = walker2;
            walker2 = walker2.next;
            middle.next = walker1;
            walker1 = middle;
            // insertion sort subroutine
            ListNode reverseWalker = walker1;
            while (reverseWalker.next != dummy && 
                    reverseWalker.next.val > walker1.val)
                reverseWalker = reverseWalker.next;
            if (reverseWalker != walker1) {
                ListNode tmp = walker1.next;
                walker1.next = reverseWalker.next;
                reverseWalker.next = walker1;
                walker1 = tmp;
            }
        }
        // reverse the list
        walker2 = walker1.next;
        walker1.next = null;
        while (walker2 != null) {
            ListNode middle = walker2;
            walker2 = walker2.next;
            middle.next = walker1;
            walker1 = middle;
        }
        return walker1.next;
    }
}
