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
        RandomListNode walker = head;
        // add a new node after every original node
        while (walker != null) {
            RandomListNode next = walker.next;
            RandomListNode newNode = new RandomListNode(walker.label);
            walker.next = newNode;
            newNode.next = next;
            walker = newNode.next;
        }
        walker = head;
        // link 'random' relation for added node
        while (walker != null) {
            RandomListNode copy = walker.next;
            if (walker.random != null) copy.random = walker.random.next;
            walker = copy.next;
        }
        walker = head;
        // link 'next' relation for added node, and restore original input list
        RandomListNode copyHead = head.next;
        while (walker != null) {
            RandomListNode copy = walker.next;
            walker.next = copy.next;
            if (walker.next != null) copy.next = walker.next.next;
            
            walker = walker.next;
            copy = copy.next;
        }
        return copyHead;
    }
}
