package solution;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
 * 
 * @author Dongliang Yu
 *
 */
public class MergeKLists {
    public ListNode mergeKLists(List<ListNode> lists) {
        PriorityQueue<ListNode> heap = new PriorityQueue<ListNode>(new Comparator<ListNode>() {
            public int compare(ListNode l1, ListNode l2) {
                return l1.val - l2.val;
            }
        });
        for (ListNode node : lists)
            if (node != null) heap.add(node); // we MUST do the null check
        ListNode dummy = new ListNode(-1);
        ListNode p = dummy;
        while (!heap.isEmpty()) {
            ListNode min = heap.poll();
            ListNode next = min.next;
            min.next = null; // not necessary but good practice
            p.next = min;
            p = min;
            p.next = null;
            if (next != null) heap.add(next);
        }
        return dummy.next;
    }
    
    /**
    // O(nklog(k)) time complexity, n is the size of every single original list 
    public ListNode mergeKLists(List<ListNode> lists) {
        if (lists == null || lists.size() == 0) return null;
        int size = lists.size();
        int step = 1;
        while (step < size) {
            for (int i = 0; i < size; i += step*2) {
                ListNode l1 = lists.get(i);
                ListNode l2 = null;
                if (i+step < size)
                    l2 = lists.get(i+step);
                lists.set(i, merge(l1, l2));
                //if (i+step < len) lists.set(i+step, null); // not necessary
            }
            step *= 2;
        }
        return lists.get(0);
    }
    
    private ListNode merge(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        ListNode dummy1 = new ListNode(-1);
        dummy1.next = l1;
        ListNode p1 = dummy1;
        while (p1.next != null && l2 != null) {
            if (p1.next.val > l2.val) {
                ListNode tmp = l2;
                l2 = l2.next;
                tmp.next = p1.next;
                p1.next = tmp;
                p1 = p1.next;
            } else {
                p1 = p1.next;
            }
        }
        if (l2 != null) // do NOT forget this
            p1.next = l2;
        return dummy1.next;
    }
    */
}
