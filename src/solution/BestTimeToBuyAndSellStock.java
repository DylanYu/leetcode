package solution;

/**
 * Say you have an array for which the ith element is the price of a given stock on day i.
 *
 * If you were only permitted to complete at most one transaction (ie, buy one and sell one 
 * share of the stock), design an algorithm to find the maximum profit.
 * 
 * @author Dongliang Yu
 *
 */
public class BestTimeToBuyAndSellStock {
    // scan from front
    public int maxProfit(int[] prices) {
        int len = prices.length;
        if (len <= 1) return 0;
        int min = Integer.MAX_VALUE;
        int profit = 0; // no need to use Integer.MIN_VALUE because profit >= 0
        for (int i = 0; i < len; i++) {
            min = Math.min(min, prices[i]);
            profit = Math.max(profit, prices[i] - min);
        }
        return profit;
    }

    /* scan from back
    public int maxProfit(int[] prices) {
        int len = prices.length;
        if (len <= 1) return 0;
        int max = 0;
        int profit = 0;
        for (int i = len-1; i >= 0; i--) {
            if (prices[i] > max) max = prices[i];
            profit = Math.max(profit, max - prices[i]);
        }
        return profit;
    }
    */
    
    /*
    public int maxProfit(int[] prices) {
        if (prices.length <= 1) return 0;
        int max = 0;
        ArrayList<Integer> turnpoints = new ArrayList<Integer>();
        turnpoints.add(prices[0]);
        for (int i = 1; i < prices.length-1; i++) {
            int a = prices[i-1];
            int b = prices[i];
            int c = prices[i+1];
            if (a > b && b <= c || a >= b && b < c
                || a < b && b >= c || a <= b && b > c)
                turnpoints.add(prices[i]);
        }
        turnpoints.add(prices[prices.length-1]);
        for (int i = 0; i < turnpoints.size(); i++) {
            int buy = turnpoints.get(i);
            for (int j = i+1; j < turnpoints.size(); j++) {
                int profit = turnpoints.get(j) - buy;
                if (profit > max) max = profit;
            }
        }
        return max;
    }*/
}
