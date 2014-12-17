package solution;

/**
 * Given a linked list, return the node where the cycle begins. 
 * If there is no cycle, return null.
 * 
 * @author Dongliang Yu
 *
 */
public class LinkedListCycleII {
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) return null;
        ListNode slow = head;
        ListNode fast = head;
        do {
            slow = slow.next;
            fast = fast.next;
            if (fast == null) return null;
            fast = fast.next;
            if (fast == null) return null; //
        } while (slow != fast);
        int perimeter = 1;
        ListNode p = slow.next;
        while (p != slow) {
            p = p.next;
            perimeter++;
        }
        fast = head;
        for (int i = 0; i < perimeter; i++)
            fast = fast.next;
        slow = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}
