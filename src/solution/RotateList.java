package solution;

/**
 * Given a list, rotate the list to the right by k places, where k is non-negative.
 * 
 * For example:
 * Given 1->2->3->4->5->NULL and k = 2,
 * return 4->5->1->2->3->NULL.
 * 
 * @author Dongliang Yu
 *
 */
public class RotateList {
    public ListNode rotateRight(ListNode head, int n) {
        if (head == null) return null;
        int len = 0;
        ListNode walker = head;
        while (walker.next != null) {
            walker = walker.next;
            len++;
        }
        len++;
        walker.next = head; // link tail and head
        ListNode tail = walker;
        int shift = (len - (n % len)) % len;
        for (int i = 0; i < shift; i++)
            tail = tail.next;
        head = tail.next;
        tail.next = null;
        return head;
    }
}
