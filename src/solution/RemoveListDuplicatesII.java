package solution;

/**
 * Remove Duplicates from Sorted List II
 * <p>
 * Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.
 * <p>
 * For example,
 * <p>Given 1->2->3->3->4->4->5, return 1->2->5.
 * <p>Given 1->1->1->2->3, return 2->3.
 * 
 * @author Dongliang Yu
 *
 */
public class RemoveListDuplicatesII {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null)
            return null;
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode walker1 = dummyHead;
        ListNode walker2 = dummyHead.next;
        ListNode walker3 = walker2.next;
        while (walker3 != null) {
            if (walker2.val == walker3.val) {
                do {
                    walker2 = walker3;
                    walker3 = walker3.next;
                } while (walker3 != null && walker2.val == walker3.val);
                walker1.next = walker3;
                walker2 = walker3;
                if (walker3 != null)
                    walker3 = walker3.next;
            } else {
                walker1 = walker1.next;
                walker2 = walker2.next;
                walker3 = walker3.next;
            }
        }
        return dummyHead.next;
    }
}
