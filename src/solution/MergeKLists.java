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
		PriorityQueue<ListNode> heap = new PriorityQueue<ListNode>(100, new Comparator<ListNode>() {
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
            min.next = null;
            p.next = min;
            p = min;
            if (next != null) heap.add(next);
        }
        return dummy.next;
    }
	
	/**
    // O(nklog(k)) time complexity, n is the size of every single original list 
    public ListNode mergeKLists(List<ListNode> lists) {
        if (lists == null || lists.size() == 0) return null;
        int len = lists.size();
        int step = 1;
        while (step < len) {
            int i = 0;
            while (i < len) {
                ListNode l1 = lists.get(i);
                ListNode l2 = i+step < len ? lists.get(i+step) : null;
                lists.set(i, merge(l1, l2));
                if (i+step < len) lists.set(i+step, null);
                i += step*2;
            }
            step *= 2;
        }
        return lists.get(0);
    }
    
    private ListNode merge(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        ListNode h1 = new ListNode(-1);
        h1.next = l1;
        ListNode p1 = h1;
        while (l1 != null && l2 != null) {
            if (l1.val > l2.val) {
                ListNode tmp = l2;
                l2 = l2.next;
                p1.next = tmp;
                tmp.next = l1;
                p1 = p1.next;
            } else {
                p1 = p1.next;
                l1 = l1.next;
            }
        }
        if (l1 == null) p1.next = l2;
        return h1.next;
    }
    */
}
