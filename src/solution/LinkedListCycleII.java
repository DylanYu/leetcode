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
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                ListNode slow2 = slow.next;
                int perimeter = 1;
                while (slow2 != slow) {
                    perimeter++;
                    slow2 = slow2.next;
                }
                slow = head;
                slow2 = head;
                for (int i = 0; i < perimeter; i++)
                    slow = slow.next;
                while (slow != slow2) {
                    slow = slow.next;
                    slow2 = slow2.next;
                }
                return slow;
            }
        }
        return null;
    }

}
