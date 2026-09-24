class Solution {
    public int value(int x){
        int sum=0;
        while(x>0){
            sum+= (x%10);
            x/=10;
        }
        return sum;
    }
    public int smallestIndex(int[] nums) {
      int ans=-1;

      for(int i=0; i<nums.length; i++){
        int x= value(nums[i]);
        if(x==i){
            ans=i;
            break;
        }
      }  
      return ans;
    }
}