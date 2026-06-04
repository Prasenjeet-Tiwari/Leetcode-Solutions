class Solution {

    public int maxProfit(int[] arr) {

        int max=0;
        int low=arr[0];

        for(int x: arr){
            if(x>low){
                max+=x-low;
                low=x;
            }else{
                low=x;
            }
        }
        return max;
    }
}