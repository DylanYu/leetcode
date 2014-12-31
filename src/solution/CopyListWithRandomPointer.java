package solution;

/**
 * A linked list is given such that each node contains an additional 
 * random pointer which could point to any node in the list or null.
 *
 * Return a deep copy of the list.
 * 
 * @author Dongliang Yu
 *
 */
public class CopyListWithRandomPointer {
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) return null;
        RandomListNode p = head;
        while (p != null) {
            RandomListNode newNode = new RandomListNode(p.label);
            newNode.next = p.next;
            p.next = newNode;
            p = newNode.next;
        }
        p = head;
        while (p != null) {
            RandomListNode copy = p.next;
            if (p.random != null) //
                copy.random = p.random.next;
            p = copy.next;
        }
        // restore original list and get copied list
        RandomListNode copyHead = head.next;
        p = head;
        while (p != null) { // p != null then p.next != null
            RandomListNode copy = p.next;
            p.next = copy.next;
            p = p.next;
            if (p == null) break; //
            copy.next = p.next;
            copy = copy.next;
        }
        return copyHead;
    }
}
