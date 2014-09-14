package solution;

/**
 * 
 * Given a singly linked list L: L0→L1→…→Ln-1→Ln,
 * reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…
 * You must do this in-place without altering the nodes' values.
 * For example,
 * Given {1,2,3,4}, reorder it to {1,4,2,3}.
 * 
 * @author Dongliang Yu
 *
 */
public class ReorderList {
    public void reorderList(ListNode head) {
        if (head == null)
            return;
        ListNode walker = head;
        int size = 0;
        while (walker != null) {
            size++;
            walker = walker.next;
        }
        ListNode tail = walker;
        
        //reverse the second half
        walker = head;
        for (int i = 0; i < size / 2; i++)
            walker = walker.next;
        ListNode p = walker;
        ListNode q = p.next;
        while (q != null) {
            ListNode tmp = q.next;
            q.next = p;
            p = q;
            q = tmp;
        }
        
        ListNode target = head;
        while (target != tail && target.next != tail) {
            ListNode insertedNode = tail;
            tail = tail.next;
            
            insertedNode.next = target.next;
            target.next = insertedNode;
            target = insertedNode.next;
        }
        if (target != head)
            tail.next = null;
    }
    
    public static void main(String[] args) {
        ListNode head = LinkedList.createIncreasingList(10);
        LinkedList.show(head);
        new ReorderList().reorderList(head);
        LinkedList.show(head);
    }
}
