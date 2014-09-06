package solution;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Given a collection of intervals, merge all overlapping intervals.
 * 
 * For example,
 * Given [1,3],[2,6],[8,10],[15,18],
 * return [1,6],[8,10],[15,18].
 *  
 * @author Dongliang Yu
 *
 */
public class MergeIntervals {
    class Interval {
        int start;
        int end;
        Interval() { start = 0; end = 0; }
        Interval(int s, int e) { start = s; end = e; }
    }
    
    public List<Interval> merge(List<Interval> intervals) {
        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval i1, Interval i2) {
                int diff = i1.start - i2.start;
                if (diff != 0) return diff;
                else return i1.end - i2.end;
            }
        });
        Interval prev = new Interval(Integer.MIN_VALUE, Integer.MIN_VALUE);
        for (int i = 0; i < intervals.size(); i++) {
            Interval curr = intervals.get(i);
            if (curr.start <= prev.end) {
                prev.end = Math.max(prev.end, curr.end);
                intervals.remove(i);
                i--;
            } else
                prev = curr; // upper case doesn't require changing prev explicitly
        }
        return intervals;
    }
}
