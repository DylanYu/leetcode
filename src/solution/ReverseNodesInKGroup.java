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
        if (head == null || head.next == null || k <= 0) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode p = dummy;
        while (p.next != null) {
            ListNode test = p;
            for (int i = 0; i < k && test != null; i++) test = test.next;
            if (test == null) break;
            ListNode nextGroup = test.next;
            ListNode tail = p.next;
            
            // reverse
            ListNode p1 = p.next;
            ListNode p2 = p1.next;
            p1.next = null;
            while (p2 != nextGroup) {
                ListNode p2Next = p2.next;
                p2.next = p1;
                p1 = p2;
                p2 = p2Next;
            }
            p.next = p1;
            tail.next = nextGroup;
            p = tail;
        }
        return dummy.next;
    }
}
