package solution;

import java.util.LinkedList;

/**
 * The count-and-say sequence is the sequence of integers beginning as follows:
 * 1, 11, 21, 1211, 111221, ...
 * 
 * 1 is read off as "one 1" or 11.
 * 11 is read off as "two 1s" or 21.
 * 21 is read off as "one 2, then one 1" or 1211.
 * Given an integer n, generate the nth sequence.
 * 
 * Note: The sequence of integers will be represented as a string.
 * 
 * @author Dongliang Yu
 *
 */
public class CountAndSay {
    public String countAndSay(int n) {
        LinkedList<Integer> list = new LinkedList<Integer>();
        list.add(1);
        int count = 1;
        while (count < n) {
            LinkedList<Integer> next = new LinkedList<Integer>();
            int currCount = 0;
            int last = list.getFirst();
            while (!list.isEmpty()) {
                int curr = list.removeFirst();
                if (curr != last) {
                    next.add(currCount);
                    next.add(last);
                    currCount = 0;
                }
                currCount++;
                last = curr;
            }
            next.add(currCount); // add last count in above loop
            next.add(last);
            count++;
            list = next;
        }
        StringBuffer sb = new StringBuffer();
        for (int e : list)
            sb.append(e);
        return sb.toString();
    }
}
