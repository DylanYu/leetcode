package solution;

public class PartitionList {
    
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
    
    public static void main(String[] args) {
//        ListNode head = LinkedList.createCertainList(new int[]{60,52,65,68,26,93,85,69,62,4});
        ListNode head = LinkedList.createRandomValueList(10);
        LinkedList.show(head);
        head = new PartitionList().partition(head, 40);
//        System.out.println(new LinkedListCycle().hasCycle(head));
        LinkedList.show(head);
    }

}
