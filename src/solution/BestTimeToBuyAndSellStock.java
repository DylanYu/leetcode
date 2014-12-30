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
        if (prices == null || prices.length == 0) return 0;
        int min = prices[0];
        int maxProfit = 0; // previous max profit
        for (int i = 1; i < prices.length; i++) {
            maxProfit = Math.max(maxProfit, prices[i] - min);
            min = Math.min(min, prices[i]);
        }
        return maxProfit;
    }

    /* scan from back
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) return 0;
        int len = prices.length;
        int max = prices[len-1];
        int maxProfit = 0; // previous max profit
        for (int i = len-2; i >= 0; i--) {
            maxProfit = Math.max(maxProfit, max - prices[i]);
            max = Math.max(max, prices[i]);
        }
        return maxProfit;
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
