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
        if (head == null || k <= 0) return null;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode p1 = dummy;
        while (p1.next != null) {
            ListNode p2 = p1;
            int i = 0;
            while (p2 != null && i++ < k) p2 = p2.next;
            if (p2 == null) break;
            ListNode p2Next = p2.next;
            p2.next = null; // necessary for later q2!=null
            
            //reverse
            ListNode q1 = p1.next; // won't be null
            ListNode q2 = q1.next;
            ListNode tail = q1;
            q1.next = null;
            while (q2 != null) {
                ListNode q2Next = q2.next;
                q2.next = q1;
                q1 = q2;
                q2 = q2Next;
            }
            p1.next = q1;
            tail.next = p2Next;
            
            p1 = tail;
        }
        return dummy.next;
    }
}
