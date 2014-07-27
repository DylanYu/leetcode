package solution;

/**
 * Reverse a linked list from position m to n. Do it in-place and in one-pass.
 *
 * For example:
 * Given 1->2->3->4->5->NULL, m = 2 and n = 4,
 *
 * return 1->4->3->2->5->NULL.
 *
 * Note:
 * Given m, n satisfy the following condition:
 * 1 ≤ m ≤ n ≤ length of list.
 * 
 * @author Dongliang Yu
 *
 */
public class ReverseLinkedListII {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        //if (head == null || head.next == null) return head; // not necessary anymore
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode walker = dummyHead;
        for (int i = 1; i < m; i++) walker = walker.next;
        ListNode beforeStart = walker;
        walker = walker.next;
        ListNode start = walker; // start
        ListNode walker2 = walker.next;
        for (int i = m; i < n; i++) {
            ListNode tmp = walker2.next;
            walker2.next = walker;
            walker = walker2;
            walker2 = tmp;
        }
        beforeStart.next = walker;
        start.next = walker2;
        return dummyHead.next;
    }
}
