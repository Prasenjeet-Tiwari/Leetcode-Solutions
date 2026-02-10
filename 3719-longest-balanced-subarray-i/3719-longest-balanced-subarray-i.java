class Solution {
    public int longestBalanced(int[] nums) {

        int ans=0;
        for(int i=0; i<nums.length; i++){
            HashMap<Integer,Integer> hme=new HashMap<>();
            HashMap<Integer,Integer> hmo=new HashMap<>();
            for(int j=i; j<nums.length; j++){
                int curr=nums[j];
                if(curr%2==0){
                    hme.put(curr,hme.getOrDefault(hme.get(nums[j]),0)+1);
                }else{
                    hmo.put(curr,hmo.getOrDefault(hmo.get(nums[j]),0)+1);
                }

                if(hme.size()==hmo.size()){
                    ans=Math.max(ans,j-i+1);
                }
            }
        }
        return ans;
        
    }
}