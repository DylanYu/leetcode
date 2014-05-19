package solution;

/**
 * You are given two linked lists representing two non-negative numbers. The digits are stored in 
 * reverse order and each of their nodes contain a single digit. Add the two numbers and return 
 * it as a linked list.
 * <p>
 * <p>Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * <p>Output: 7 -> 0 -> 8
 * 
 * @author Dongliang Yu
 *
 */
public class AddTwoNumbers {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) return new ListNode(0);
        else if (l1 == null) return l2;
        else if (l2 == null) return l1;
        ListNode dummyHead = new ListNode(-1);
        ListNode walker = dummyHead;
        boolean carry = false;
        while (l1 != null || l2 != null) {
            int sum = carry ? 1 : 0;
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }
            carry = sum <= 9 ? false : true; // sum / 10
            sum = sum % 10;
            walker.next = new ListNode(sum);
            walker = walker.next;
        }
        if (carry) walker.next = new ListNode(1);
        return dummyHead.next;
    }
}
