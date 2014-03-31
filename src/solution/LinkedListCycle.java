package solution;

/**
 * 
 * Given a linked list, determine if it has a cycle in it.
 * 
 * @author Dongliang Yu
 * 
 */
public class LinkedListCycle {

    public boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast)
                return true;
        }
        return false;
    }

}