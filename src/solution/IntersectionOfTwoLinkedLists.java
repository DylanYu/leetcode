package solution;

/**
 * 
 * @author Dongliang Yu
 * 
 * Write a program to find the node at which the intersection of two singly linked lists begins.
 * 
 * For example, the following two linked lists:
 * 
 * A:          a1 → a2
 *                    ↘
 *                      c1 → c2 → c3
 *                    ↗            
 * B:     b1 → b2 → b3
 * begin to intersect at node c1.
 * 
 * Notes:
 * 
 * If the two linked lists have no intersection at all, return null.
 * The linked lists must retain their original structure after the function returns.
 * You may assume there are no cycles anywhere in the entire linked structure.
 * Your code should preferably run in O(n) time and use only O(1) memory.
 *
 */
public class IntersectionOfTwoLinkedLists {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        ListNode p1 = headA;
        int step1 = 1;
        while (p1.next != null) {
            p1 = p1.next;
            step1++;
        }
        ListNode p2 = headB;
        int step2 = 1;
        while (p2.next != null) {
            p2 = p2.next;
            step2++;
        }
        
        if (p1 != p2) return null;
        int diff = Math.abs(step1 - step2);
        p1 = headA;
        p2 = headB;
        if (step1 > step2) {
            while (diff > 0) {
                p1 = p1.next;
                diff--;
            }
        } else {
            while (diff > 0) {
                p2 = p2.next;
                diff--;
            }
        }
        while (p1 != p2) {
            p1 = p1.next;
            p2 = p2.next;
        }
        return p1;
    }
    
    /*
     * interesting solution
     * 
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        ListNode p1 = headA;
        ListNode p2 = headB;
        while (p1 != null && p2 != null && p1 != p2) {
            p1 = p1.next;
            p2 = p2.next;
            // if intersection exists, return the intersection; or return null
            if (p1 == p2) return p1;
            if (p1 == null) p1 = headB;
            if (p2 == null) p2 = headA;
        }
        return p1;
    }
    */
}
