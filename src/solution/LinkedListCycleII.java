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
        if (head == null) return null;
        ListNode slow = head;
        ListNode fast = head.next;
        boolean hasCycle = false;
        while (fast != null) {
            if (slow == fast) {
                hasCycle = true;
                break;
            }
            slow = slow.next;
            fast = fast.next;
            if (fast == null) break;
            fast = fast.next;
        }
        if (!hasCycle) return null;
        int perimeter = 0;
        do {
            slow = slow.next;
            perimeter++;
        } while (slow != fast);
        int i = 0;
        fast = head;
        while (i++ < perimeter) fast = fast.next;
        slow = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}
