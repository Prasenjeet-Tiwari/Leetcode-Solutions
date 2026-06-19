class Solution {
    public int[] twoSum(int[] nums, int target) {

        int output[]=new int[2];
        HashMap<Integer, Integer> hm=new HashMap<>();
        for(int i=0; i<nums.length; i++){
            int curr=nums[i];
            int req= target-curr;
            if(hm.containsKey(req)){
                output[0]=hm.get(req);  //we need index
                output[1]=i;    //we need index
                break;
            }
            hm.put( curr, i);
        }

        return output;
        
    }
}