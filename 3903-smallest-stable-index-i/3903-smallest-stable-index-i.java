class Solution {
    public int firstStableIndex(int[] nums, int k) {
        
        int n=nums.length;

        int large[]=new int[n];
        int small[]=new int[n];
        
        
        large[0]=nums[0];
        for(int i=1; i<n; i++){
            large[i]=Math.max(nums[i], large[i-1]);
        }

        small[n-1]=nums[n-1];
        for(int i=n-2; i>=0; i--){
            small[i]=Math.min(nums[i], small[i+1]);
        }
        int ans=-1;
        int min=Integer.MAX_VALUE;
        for(int i=0; i<n; i++){
            int val= (large[i]-small[i]);
            if(val<=k){ 
                return i; 
            } 
        } 
        return -1; 
    }
}