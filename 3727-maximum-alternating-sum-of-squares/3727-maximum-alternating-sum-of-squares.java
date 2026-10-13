class Solution {
    public long maxAlternatingSum(int[] nums) {

        for(int i=0; i<nums.length; i++){
            if(nums[i]<0){
                nums[i]=nums[i]*(-1);
            }
        }
        Arrays.sort(nums);

        int n=nums.length;

        int left=0;
        int right=n-1;
        long ans=0;
        while(left<right){
            ans+=(nums[right]*nums[right])-(nums[left]*nums[left]);
            left++;
            right--;
        }
        if(left==right){
            ans+=nums[left]*nums[left];
        }

        return ans;
        
    }
}