package solution;

import java.util.List;
import java.util.LinkedList;

/**
 * Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).
 * 
 * You may assume that the intervals were initially sorted according to their start times.
 * 
 * Example 1:
 * Given intervals [1,3],[6,9], insert and merge [2,5] in as [1,5],[6,9].
 * 
 * Example 2:
 * Given [1,2],[3,5],[6,7],[8,10],[12,16], insert and merge [4,9] in as [1,2],[3,10],[12,16].
 * 
 * This is because the new interval [4,9] overlaps with [3,5],[6,7],[8,10].
 * 
 * @author Dongliang Yu
 *
 */
public class InsertInterval {
    public class Interval {
        int start;
        int end;
        Interval() { start = 0; end = 0; }
        Interval(int s, int e) { start = s; end = e; }
    }
    
    /**
     * Cases:
     * null input,
     * empty list,
     * insert in tail,
     * merge,
     * no more merge
     */
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        if (intervals == null)
            intervals = new LinkedList<Interval>();
        if (newInterval == null) return intervals;
        // empty list or insert at tail
        if (intervals.size() == 0 || newInterval.start > intervals.get(intervals.size()-1).end) {
            intervals.add(newInterval);
            return intervals;
        }
        
        Interval prev = new Interval(Integer.MIN_VALUE, Integer.MIN_VALUE);
        int i = 0;
        boolean inserted = false;
        while (i < intervals.size()) {
            Interval curr = intervals.get(i);
            if (inserted) { // try to merge
                if (prev.end < curr.start) // no more merge
                    break;
                curr.start = Math.min(prev.start, curr.start);
                curr.end = Math.max(prev.end, curr.end);
                intervals.remove(i-1);
                i--;
            } else if (newInterval.start <= curr.end) { // curr.end not curr.start
                intervals.add(i, newInterval);
                curr = newInterval;
                inserted = true;
            }
            prev = curr;
            i++;
        }
        return intervals;
    }
}
