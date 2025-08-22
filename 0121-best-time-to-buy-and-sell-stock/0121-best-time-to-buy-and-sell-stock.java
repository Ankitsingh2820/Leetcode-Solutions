class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int minPrice = prices[0];

        for (int i = 1; i < prices.length; i++) {
            // update minPrice if we find a lower price
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            } else {
                // calculate profit if selling today
                int profit = prices[i] - minPrice;
                maxProfit = Math.max(maxProfit, profit);
            }
        }
        return maxProfit;
    }
}
