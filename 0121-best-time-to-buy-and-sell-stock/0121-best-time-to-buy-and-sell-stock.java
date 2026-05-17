class Solution {
    public int maxProfit(int[] prices) {

        int minPrice = prices[0];
        int maxProfit = 0;

        for(int i = 0; i < prices.length; i++) {

            // new low day encountered
            if(prices[i] < minPrice) {
                minPrice = prices[i];
            } 
            // sell on this day
            else if(prices[i] > minPrice) {
                maxProfit = Math.max(maxProfit, prices[i] - minPrice);
            }
        }

        return maxProfit;
    }
}