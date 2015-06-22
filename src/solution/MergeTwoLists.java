package solution;

/**
 * 
 * Merge two sorted linked lists and return it as a new list. The new list 
 * should be made by splicing together the nodes of the first two lists.
 * 
 * @author Dongliang Yu
 *
 */
public class MergeTwoLists {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        ListNode pre1 = new ListNode(Integer.MIN_VALUE);
        pre1.next = l1;
        ListNode dummy = pre1;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                pre1 = pre1.next;
                l1 = l1.next;
            } else {
                ListNode tmp = l2;
                l2 = l2.next;
                tmp.next = l1;
                pre1.next = tmp;
                pre1 = pre1.next;
            }
        }
        // join with l2
        if (l2 != null)
            pre1.next = l2;
        return dummy.next;
    }
    
    public static void main(String[] args) {
        ListNode l1 = LinkedListUtil.createIncreasingList(3, 4, 2);
        LinkedListUtil.show(l1);
        ListNode l2 = LinkedListUtil.createIncreasingList(2, 7, 1);
        LinkedListUtil.show(l2);
        LinkedListUtil.show(new MergeTwoLists().mergeTwoLists(l1, l2));
    }

}
