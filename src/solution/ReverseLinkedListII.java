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
        ListNode p = dummyHead;
        for (int i = 1; i < m; i++) p = p.next;
        ListNode firstTail = p;
        p = p.next;
        ListNode secondTail = p;
        ListNode p2 = p.next;
        for (int i = m; i < n; i++) {
            ListNode tmp = p2.next;
            p2.next = p;
            p = p2;
            p2 = tmp;
        }
        firstTail.next = p;
        secondTail.next = p2;
        return dummyHead.next;
    }
}
