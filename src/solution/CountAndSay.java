package solution;

import java.util.ArrayList;
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
        if (n <= 0) return "";
        ArrayList<Integer> curr = new ArrayList<Integer>();
        curr.add(1);
        ArrayList<Integer> next = new ArrayList<Integer>();
        for (int i = 2; i <= n; i++) {
            int j = 0;
            while (j < curr.size()) {
                int k = j+1;
                while (k < curr.size() && curr.get(k) == curr.get(j)) k++;
                int count = k-j;
                next.add(count);
                next.add(curr.get(j));
                j = k;
            }
            ArrayList<Integer> tmp = curr;
            curr = next;
            next = tmp;
            next.clear();
        }
        StringBuffer sb = new StringBuffer();
        for (int e : curr) sb.append(e);
        return sb.toString();
    }
    
    /**
    public String countAndSay(int n) {
        LinkedList<Integer> currRow = new LinkedList<Integer>();
        currRow.add(1);
        int i = 1;
        while (i < n) {
            LinkedList<Integer> nextRow = new LinkedList<Integer>();
            int count = 0;
            int last = currRow.getFirst();
            while (!currRow.isEmpty()) {
                int curr = currRow.removeFirst();
                if (curr != last) {
                    nextRow.add(count);
                    nextRow.add(last);
                    count = 0;
                }
                count++;
                last = curr;
            }
            nextRow.add(count); // add last count in above loop
            nextRow.add(last);
            i++;
            currRow = nextRow;
        }
        StringBuffer sb = new StringBuffer();
        for (int e : currRow)
            sb.append(e);
        return sb.toString();
    }
    */
}
