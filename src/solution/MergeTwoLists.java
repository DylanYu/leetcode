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
        ListNode pre1 = new ListNode(-1);
        pre1.next = l1;
        ListNode dummyHead = pre1;
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
        if (l1 == null) {
            pre1.next = l2;
        }
        return dummyHead.next;
    }
    
    public static void main(String[] args) {
        ListNode l1 = LinkedList.createIncreasingList(3, 4, 2);
        LinkedList.show(l1);
        ListNode l2 = LinkedList.createIncreasingList(2, 7, 1);
        LinkedList.show(l2);
        LinkedList.show(new MergeTwoLists().mergeTwoLists(l1, l2));
    }

}
