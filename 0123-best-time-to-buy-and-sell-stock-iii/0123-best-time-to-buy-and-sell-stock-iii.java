class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }

        // Initialize cash balances
        int firstBuy = Integer.MIN_VALUE;
        int firstSell = 0;
        int secondBuy = Integer.MIN_VALUE;
        int secondSell = 0;

        for (int price : prices) {
            // Transaction 1
            firstBuy = Math.max(firstBuy, -price);          // Maximize cash left after buying 1st stock
            firstSell = Math.max(firstSell, firstBuy + price); // Maximize profit after selling 1st stock

            // Transaction 2
            secondBuy = Math.max(secondBuy, firstSell - price); // Maximize cash left after buying 2nd stock
            secondSell = Math.max(secondSell, secondBuy + price); // Maximize total profit after selling 2nd stock
        }

        return secondSell;
    }
}
