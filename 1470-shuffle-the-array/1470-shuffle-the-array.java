class Solution {

    public int[] shuffle(int[] nums, int n) {

        int ans[]= new int[nums.length];
        
        int start=0;
        int idx=0;
        int half= nums.length/2;
        
        while(half<nums.length){
            ans[idx]=nums[start];
            ans[idx+1]=nums[half];
            half++; start++;
            idx=idx+2;
        }

        return ans;
    }
}