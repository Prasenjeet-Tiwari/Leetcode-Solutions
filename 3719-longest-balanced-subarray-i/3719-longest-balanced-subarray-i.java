class Solution {
    public int longestBalanced(int[] nums) {

        int ans=0;
        for(int i=0; i<nums.length; i++){
            HashSet<Integer> hme=new HashSet<>();
            HashSet<Integer> hmo=new HashSet<>();
            for(int j=i; j<nums.length; j++){
                int curr=nums[j];
                if(curr%2==0){
                    hme.add(nums[j]);
                }else{
                    hmo.add(nums[j]);
                }

                if(hme.size()==hmo.size()){
                    ans=Math.max(ans,j-i+1);
                }
            }
        }
        return ans;
        
    }
}