package solution;

/**
 * Given a linked list, reverse the nodes of a linked list 
 * k at a time and return its modified list.
 *
 * If the number of nodes is not a multiple of k then left-out 
 * nodes in the end should remain as it is.
 *
 * You may not alter the values in the nodes, only nodes itself may be changed.
 * Only constant memory is allowed.
 *
 * For example,
 * Given this linked list: 1->2->3->4->5
 * For k = 2, you should return: 2->1->4->3->5
 * For k = 3, you should return: 3->2->1->4->5
 * 
 * @author Dongliang Yu
 *
 */
public class ReverseNodesInKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (k <= 1 || head == null) return head;
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode walker = dummyHead;
        while (walker != null) {
            // test whether we need another group reverse
            ListNode tester = walker;
            int n = k;
            while (n-- > 0 && tester != null) tester = tester.next;
            if (tester == null) break;
            // reverse nodes in k-group
            ListNode reversedTail = walker.next;
            ListNode p1 = walker.next;
            ListNode p2 = p1.next;
            ListNode p3 = p2.next;
            n = k-1; // k-1 times of reverse operation
            while (n-- > 0) {
                p2.next = p1;
                p1 = p2;
                p2 = p3;
                if (p3 != null) p3 = p3.next; // TODO
            }
            // link new head and tail
            walker.next = p1;
            reversedTail.next = p2;
            walker = reversedTail;
        }
        return dummyHead.next;
    }
}
