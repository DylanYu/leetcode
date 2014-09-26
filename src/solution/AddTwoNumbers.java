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
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) return null;
        ListNode dummy = new ListNode(-1);
        ListNode p = dummy;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int n1 = l1 == null ? 0 : l1.val;
            int n2 = l2 == null ? 0 : l2.val;
            int sum = n1 + n2 + carry;
            if (sum >= 10) carry = 1;
            else carry = 0;
            sum = sum % 10;
            p.next = new ListNode(sum);
            p = p.next;
            
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }
        if (carry == 1) p.next = new ListNode(1);
        return dummy.next;
    }
}
