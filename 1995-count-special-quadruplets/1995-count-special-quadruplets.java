class Solution {
    public int countQuadruplets(int[] nums) {
        int n=nums.length;
        int result=0;
        HashMap<Integer, Integer> hm=new HashMap<>();
        for(int i=1; i<=n-3;  i++){
            int a=nums[i];
            for(int j=0; j<i; j++){
                int b=nums[j];
                hm.put(a+b, hm.getOrDefault(a+b,0)+1);
            }

            int c=nums[i+1];
            for(int k=i+2; k<n; k++){
                int d=nums[k];
                int val=d-c;
                if(hm.containsKey(val)){
                    result+=hm.get(val);
                }
            }
        }
        return result;
    }
}