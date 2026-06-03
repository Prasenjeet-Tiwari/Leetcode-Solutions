class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {

        HashMap<Integer, Integer> hm= new HashMap<>();

        for(int i=0; i<nums.length; i++){
            int curr=nums[i];
            if(hm.containsKey(curr)){  // if this poss then the occurence before this  also possible
                int prv_idx= hm.get(curr);
                int check= Math.abs(i - prv_idx);
                if(check<=k){
                    return true;
                }else{ 
                    //update the idx of occured numebr
                    hm.put(curr, i);
                }
            }else{
                hm.put(curr, i);
            }
        }
        return false;
        
    }
}