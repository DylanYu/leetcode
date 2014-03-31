package solution;

import java.util.Random;

public class LinkedList {
    
    public static ListNode createRandomValueList(int n) {
        ListNode dummyNode = new ListNode(-1);
        ListNode walker = dummyNode;
        Random rand = new Random(System.currentTimeMillis());
        for (int i = 0; i < n; i++) {
            walker.next = new ListNode(rand.nextInt(n * n));
            walker = walker.next;
        }
        ListNode head = dummyNode.next;
        dummyNode = null;
        return head;
    }
    
    /**
     * Create a linked list which starts from 0 ends with n with step 1.
     */
    public static ListNode createIncreasingList(int n) {
        ListNode fakeHead = new ListNode(-1);
        ListNode walker = fakeHead;
        for (int i = 0; i < n; i++) {
            walker.next = new ListNode(i);
            walker = walker.next;
        }
        ListNode head = fakeHead.next;
        fakeHead = null;
        return head;
    }
    
    public static void show(ListNode head) {
        ListNode walker = head;
        while (walker != null) {
            System.out.print(walker.val);
            if (walker.next != null)
                System.out.print("->");
            walker = walker.next;
        }
        System.out.println();
    }

}
