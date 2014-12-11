package solution;

import java.util.List;
import java.util.LinkedList;

/**
 * Given a sorted integer array where the range of elements are [lower, upper] inclusive, return its missing ranges.
 * 
 * For example, given [0, 1, 3, 50, 75], lower = 0 and upper = 99, return ["2", "4->49", "51->74", "76->99"].
 * 
 * @author Dongliang Yu
 *
 */
public class MissingRanges {
    public List<String> findMissingRanges(int[] vals, int start, int end) {
        List<String> ret = new LinkedList<String>();
        if (vals == null || start > end) return ret;
        int prev = get(vals, start, end, -1);
        for (int i = 0; i <= vals.length; i++) {
            int curr = get(vals, start, end, i);
            if (curr-prev >= 2) {
                if (curr-prev == 2)
                    ret.add(curr-1+"");
                else
                    ret.add(String.format("%d->%d", prev+1, curr-1));
            }
            prev = curr;
        }
        return ret;
    }
    
    private int get(int[] vals, int start, int end, int index) {
        if (index == -1) return start-1;
        if (index == vals.length) return end+1;
        if (index >= 0 && index < vals.length)
            return vals[index];
        else
            return Integer.MAX_VALUE; // Exception
    }
    
    public static void main(String[] args) {
        int[] vals = {0, 1, 3, 50, 75};
        int start = 0;
        int end = 99;
//        int[] vals = {0, 1, 9};
//        int start = 0;
//        int end = 10;
//        int[] vals = {4, 9, 10};
//        int start = 0;
//        int end = 10;
//        int[] vals = {};
//        int start = 0;
//        int end = 10;
        List<String> ret = new MissingRanges().findMissingRanges(vals, start, end);
        for (String e : ret)
            System.out.print(e + ",");
    }
}
