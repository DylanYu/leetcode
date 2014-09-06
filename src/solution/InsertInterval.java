package solution;

import java.util.List;

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
     * empty list,
     * one item list
     * insert in head,
     * insert in tail,
     */
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        if (intervals.size() == 0) {
            intervals.add(newInterval);
            return intervals;
        }
        for (int i = 0; i < intervals.size(); i++) {
            Interval curr = intervals.get(i);
            if (newInterval.start > curr.end) {
                if (i == intervals.size()-1) { // last item
                    intervals.add(newInterval);
                    break;
                } else
                    continue;
            } else if (newInterval.end < curr.start) {
                intervals.add(i, newInterval);
                break;
            } else{
                curr.start = Math.min(newInterval.start, curr.start);
                curr.end = Math.max(newInterval.end, curr.end);
                if (i == intervals.size()-1) break; // last item
                newInterval = curr;
                intervals.remove(i);
                i--;
            }
        }
        return intervals;
    }
}
