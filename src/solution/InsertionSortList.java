package solution;

/**
 * Sort a linked list using insertion sort.
 * 
 * @author Dongliang Yu
 *
 */
public class InsertionSortList {
    public ListNode insertionSortList(ListNode head) {
        if (head == null) return head;
        //if (head.next == null) return head; // handled by later logic
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode p1 = dummy;
        ListNode p2 = dummy.next;
        p1.next = null; // necessary
        while (p2 != null) {
            // reverse a node
            ListNode middle = p2;
            p2 = p2.next;
            middle.next = p1;
            p1 = middle;
            // insertion sort subroutine
            ListNode q = p1;
            while (q.next != dummy && 
                    q.next.val > p1.val)
                q = q.next;
            if (q != p1) {
                ListNode newP1 = p1.next;
                p1.next = q.next;
                q.next = p1;
                p1 = newP1;
            }
        }
        // reverse the list
        p2 = p1.next;
        p1.next = null;
        while (p2 != null) {
            ListNode middle = p2;
            p2 = p2.next;
            middle.next = p1;
            p1 = middle;
        }
        return p1.next;
    }
}
