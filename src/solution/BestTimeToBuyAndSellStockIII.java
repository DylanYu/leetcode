package solution;

import java.util.ArrayList;
import java.util.List;

/**
 * Say you have an array for which the ith element is the price of a given stock on day i.
 *
 * Design an algorithm to find the maximum profit. You may complete at most two transactions.
 *
 * Note:
 * You may not engage in multiple transactions at the same time (ie, you must sell the stock 
 * before you buy again).
 * 
 * @author Dongliang Yu
 *
 */
public class BestTimeToBuyAndSellStockIII {
    // O(N) DP solution
    public int maxProfit(int[] prices) {
        int len = prices.length;
        if (len <= 1) return 0;
        int[] A = new int[len]; // A[i] - max profit of one transaction during [0,i]
        int[] B = new int[len]; // B[i] - max profit of one transaction during [i, len-1]
        A[0] = 0;
        int min = prices[0];
        for (int i = 1; i < len; i++) {
            A[i] = Math.max(A[i-1], prices[i] - min);
            if (prices[i] < min) min = prices[i];
        }
        B[len-1] = 0;
        int max = prices[len-1];
        for (int i = len-2; i >= 0; i--) {
            B[i] = Math.max(B[i+1], max - prices[i]);
            if (prices[i] > max) max = prices[i];
        }
        int maxProfit = 0;
        for (int i = 0; i < len; i++) {
            int profit = A[i] + B[i];
            if (profit > maxProfit) maxProfit = profit;
        }
        return maxProfit;
    }
    
    /* O(N^2) solution
    public int maxProfit(int[] prices) {
        int len = prices.length;
        if (len <= 1) return 0;
        int max = 0;
        List<Integer> turnpoints = new ArrayList<Integer>();
        if (prices[1] > prices[0]) turnpoints.add(prices[0]);
        for (int i = 1; i < len-1; i++) {
            int a = prices[i-1];
            int b = prices[i];
            int c = prices[i+1];
            if (a < b && b >= c || a <= b && b > c || a > b && b <= c || a >= b && b < c)
                turnpoints.add(prices[i]);
        }
        if (prices[len-2] < prices[len-1]) turnpoints.add(prices[len-1]);
        
        for (int i = 0; i < turnpoints.size()-1; i++) {
            int profit = maxProfit(turnpoints, 0, i) + maxProfit(turnpoints, i, turnpoints.size()-1);
            if (profit > max) max = profit;
        }
        return max;
    }
    
    // [lo, hi]
    private int maxProfit(List<Integer> turnpoints, int lo, int hi) {
        if (lo >= hi) return 0;
        int min = Integer.MAX_VALUE;
        int profit = Integer.MIN_VALUE;
        for (int i = lo; i <= hi; i++) {
            min = Math.min(min, turnpoints.get(i));
            profit = Math.max(profit, turnpoints.get(i) - min);
        }
        return profit;
    }
    */
}
