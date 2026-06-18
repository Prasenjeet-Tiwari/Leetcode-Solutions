class Solution {
    public int singleNumber(int[] nums) {
        HashMap<Integer,Integer> hm=new HashMap<>();

        for(int i=0; i<nums.length; i++){
            int curr=nums[i];
            hm.put(curr, hm.getOrDefault( curr, 0) +1);
        }

        for(Map.Entry<Integer, Integer> entry :  hm.entrySet()){
            if(entry.getValue()==1){
                return entry.getKey();
            }
        }
        return -1;

        
    }
}