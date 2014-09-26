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
    
    private class IntervalComparator implements Comparator<Interval> {
        @Override
        public int compare(Interval i1, Interval i2) {
            if (i1.start != i2.start) return i1.start - i2.start;
            else return i1.end - i2.end;
        }
    }
    
    // same idea as remove-duplicates-from-sorted-array in OJ
    public List<Interval> merge(List<Interval> intervals) {
        Collections.sort(intervals, new IntervalComparator());
        int count = 0;
        for (int i = 1; i < intervals.size(); i++) {
            Interval curr = intervals.get(i);
            Interval prev = intervals.get(i-count-1);
            if (curr.start <= prev.end) { // merge
                prev.end = Math.max(prev.end, curr.end);
                count++;
            } else {
                intervals.set(i-count, curr);
            }
        }
        for (int i = 0; i < count; i++)
            intervals.remove(intervals.size()-1);
        return intervals;
    }
    
    /*
     * Straight forward solution.
     * We can also use a stack to do the merge job.
     * 
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
        int i = 0;
        while (i < intervals.size()) {
            Interval curr = intervals.get(i);
            if (prev.end >= curr.start) {
                prev.end = Math.max(prev.end, curr.end);
                intervals.remove(i);
            } else { // the above case do not need these steps
                i++;
                prev = curr; //
            }
        }
        return intervals;
    }
    */
}
