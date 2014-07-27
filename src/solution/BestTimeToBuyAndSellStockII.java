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
public class BestTimeToBuyAndSellStockII {
    // As simple as you could image
    public int maxProfit(int[] prices) {
        int profit = 0;
        for (int i = 1; i < prices.length; i++)
            if (prices[i] > prices[i-1]) profit += (prices[i] - prices[i-1]);
        return profit;
    }

    /* This solution becomes meaningful when we are nor allowed to sell and buy at the same day
    public int maxProfit(int[] prices) {
        int len = prices.length;
        if (len <= 1) return 0;
        ArrayList<Integer> turnpoints = new ArrayList<Integer>();
        if (prices[1] > prices[0]) turnpoints.add(prices[0]);
        for (int i = 1; i < len-1; i++) {
            int a = prices[i-1];
            int b = prices[i];
            int c = prices[i+1];
            if (a < b && b >= c || a <= b && b > c || a > b && b <= c || a >= b && b < c)
                turnpoints.add(prices[i]);
        }
        if (prices[len-2] < prices[len-1]) turnpoints.add(prices[len-1]);
        
        int profit = 0;
        int i = 1;
        while (i < turnpoints.size()) {
            int a = turnpoints.get(i-1);
            int b = turnpoints.get(i);
            if (b > a) {
                profit += (b-a);
                i+=2;
            } else
                i+=1;
        }
        return profit;
    }*/
}
