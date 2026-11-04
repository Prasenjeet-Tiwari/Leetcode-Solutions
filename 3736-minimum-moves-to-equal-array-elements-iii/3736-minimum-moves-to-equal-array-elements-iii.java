class Solution {
    public int minMoves(int[] nums) {
        int sum=0;
        int n=nums.length;
        int max=Integer.MIN_VALUE;
        for(int x : nums){
            if(x>max){
                max=x;
            }
            sum+=x;
        }

        return (n*max)-sum;
        
    }
}