class Solution {

    int greedy(int prices[]){

        int n=prices.length;
        int amount=0;
        int currPrice=prices[0];

        for(int i=0; i<n; i++){
            int side_profit=0;
            if(prices[i]<currPrice){
                currPrice=prices[i];
            }
            if(prices[i]-currPrice>0){
                side_profit= prices[i]- currPrice;
                currPrice=prices[i];    //imp now this becomes new start
            }
            amount+=side_profit;
        }
        return amount;
    }
    public int maxProfit(int[] prices) {
        return greedy(prices);
    }
}