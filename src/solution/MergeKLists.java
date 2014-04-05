package solution;

import java.util.ArrayList;

public class MergeKLists {
    public ListNode mergeKLists(ArrayList<ListNode> lists) {
        if (lists == null)
            return null;
        int size = lists.size();
        if (size == 0)
            return null;
        while (size > 1) {
            int i = 0;
            while (i < size) {
                ListNode l1 = lists.get(i);
                ListNode l2 = (i + 1 < size) ? lists.get(i + 1) : null;
                lists.set(i, merge(l1, l2));
                i++;
                if (i < size) {
                    lists.remove(i);
                    size--;
                }
            }
        }
        return lists.get(0);
    }
    
    private ListNode merge(ListNode l1, ListNode l2) {
        if (l1 == null)
            return l2;
        if (l2 == null)
            return l1;
        ListNode dummyHead1 = new ListNode(-1);
        dummyHead1.next = l1;
        ListNode dummyHead2 = new ListNode(-1);
        dummyHead2.next = l2;
        ListNode walker1 = dummyHead1;
        // walker1 keeps walking while dummyHead2 stays
        while (walker1.next != null && dummyHead2.next != null) {
            if (walker1.next.val <= dummyHead2.next.val) {
                walker1 = walker1.next;
            } else {
                ListNode p = dummyHead2.next;
                dummyHead2.next = p.next;
                
                p.next = walker1.next;
                walker1.next = p;
                
                walker1 = walker1.next;
            }
        }
        if (walker1.next == null)
            walker1.next = dummyHead2.next;
        return dummyHead1.next;
    }
}
