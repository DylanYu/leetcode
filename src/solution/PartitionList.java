package solution;

/**
 * Given a linked list and a value x, partition it such that all nodes less than x come before 
 * nodes greater than or equal to x.
 * 
 * You should preserve the original relative order of the nodes in each of the two partitions.
 * 
 * For example,
 * Given 1->4->3->2->5->2 and x = 3,
 * return 1->2->2->4->3->5.
 * 
 * @author Dongliang Yu
 *
 */
public class PartitionList {
    // one pass solution
    public ListNode partition(ListNode head, int x) {
        if (head == null)
            return null;
        if (head.next == null)
            return head;
        ListNode dummyNode = new ListNode(Integer.MIN_VALUE);
        dummyNode.next = head;
        
        ListNode less = dummyNode;
        ListNode greater = head;
//        ListNode lessHead = less;
        ListNode greaterHead = greater;
        
        if (greater.val < x) {
            while (less.next != null && less.next.val < x)
                less = less.next;
            greater = less.next;
            greaterHead = greater;
        }
        
        if (greaterHead == null)
            return head;
        
        boolean flag = true;
        while (less != null && greater != null && less.next != null && greater.next != null) {
            if (flag) { //walker for greater
                while (greater.next != null && greater.next.val >= x)
                    greater = greater.next;
                less.next = greater.next;
                if (less.next != null)
                    less = less.next;
            } else { //walker for less
                while (less.next != null && less.next.val < x)
                    less = less.next;
                greater.next = less.next;
                if (greater.next != null)
                    greater = greater.next;
            }
            flag = !flag;
        }
        if (greater.next != null) // TODO
            greater.next = null;
        less.next = greaterHead;
        return dummyNode.next;
    }
    
    /*
    public ListNode partition(ListNode head, int x) {
        if (head == null) return null;
        //if (head.next == null) return head;
        ListNode p = head;
        int L = 1;
        while (p.next != null) {
            p = p.next;
            L++;
        }
        ListNode tail = p;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode p1 = dummy;
        ListNode p2 = head;
        for (int i = 0; i < L; i++) {
            if (p2.val >= x && p2 != tail) { // p2 != tail is tricky case
                p1.next = p2.next;
                tail.next = p2;
                tail = p2;
                tail.next = null;
                p2 = p1.next;
            } else {
                p1 = p2;
                p2 = p2.next;
            }
        }
        return dummy.next;
    }
    */
    
    public static void main(String[] args) {
//        ListNode head = LinkedList.createCertainList(new int[]{60,52,65,68,26,93,85,69,62,4});
        ListNode head = LinkedList.createRandomValueList(10);
        LinkedList.show(head);
        head = new PartitionList().partition(head, 40);
//        System.out.println(new LinkedListCycle().hasCycle(head));
        LinkedList.show(head);
    }

}
