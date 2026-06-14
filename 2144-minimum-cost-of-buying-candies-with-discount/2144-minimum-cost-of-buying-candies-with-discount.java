class Solution {
    public int minimumCost(int[] cost) {
    
        Arrays.sort(cost);
        int i=cost.length-1;
        int n=cost.length;

        int total_money=0;
        int limit=0;

        if(n%3==0 || n%3 == 0){
            limit=0;
        }else if(n%3 == 1){
            limit=1;
            total_money+=cost[0];
        }

        while(i-1>=limit){
            total_money+=cost[i];
            total_money+=cost[i-1];
            i=i-3;
        }
        return total_money;
        
    }
}