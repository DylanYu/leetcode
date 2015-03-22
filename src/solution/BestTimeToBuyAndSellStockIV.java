package solution;

import java.util.ArrayList;

/**
 * Say you have an array for which the ith element is the price of a given stock on day i.
 *
 * Design an algorithm to find the maximum profit. You may complete at most k transactions.
 *
 * Note:
 * You may not engage in multiple transactions at the same time (ie, you must sell the stock 
 * before you buy again).
 * 
 * @author Dongliang Yu
 *
 */
public class BestTimeToBuyAndSellStockIV {
    class Interval {
        int start;
        int end;
        public Interval(int a, int b) { start = a; end = b; }
        public int profit() { return end-start; }
        public Interval merge(Interval other) {
            int profitSelf = this.profit();
            int profitOther = other.profit();
            int profitMerge = other.end - this.start;
            if (profitSelf > profitOther) {
                if (profitSelf > profitMerge) return this;
                else return new Interval(this.start, other.end);
            } else {
                if (profitOther > profitMerge) return other;
                else return new Interval(this.start, other.end);
            }
        }
    }
    
    public int maxProfit(int k, int[] prices) {
        if (k == 0 || prices == null || prices.length == 0) return 0;
        int len = prices.length;
        ArrayList<Interval> intervals = new ArrayList<Interval>();
        for (int i = 0; i < len;) {
            int j = i+1;
            while (j < len && prices[j] >= prices[j-1]) j++;
            j--;
            if (i != j && prices[j] > prices[i])
                intervals.add(new Interval(prices[i], prices[j]));
            i = j+1;
        }
        while (intervals.size() > k) {
            int maxMergeIndex = -1;
            int maxMergeProfitDiff = Integer.MIN_VALUE;
            Interval prev = intervals.get(0);
            for (int i = 1; i < intervals.size(); i++) {
                Interval curr = intervals.get(i);
                Interval merge = prev.merge(curr);
                int mergeProfitDiff = merge.profit() - prev.profit() - curr.profit();
                if (mergeProfitDiff > maxMergeProfitDiff) {
                    maxMergeProfitDiff = mergeProfitDiff;
                    maxMergeIndex = i; // (i-1, i)
                }
                prev = curr;
            }
            if (maxMergeIndex != -1) {
                intervals.set(maxMergeIndex, 
                        intervals.get(maxMergeIndex-1).merge(intervals.get(maxMergeIndex)));
                intervals.remove(maxMergeIndex-1);
            }
        }
        int maxProfit = 0;
        for (Interval interval : intervals)
            maxProfit += interval.profit();
        return maxProfit;
    }
}
