class Solution {
    public int sumCounts(List<Integer> nums) {

        int n=nums.size();
        int ans=0;

        for(int i=0; i<n; i++){
            int vist[]=new int[101];
            int count=0;
            for(int j=i; j<n; j++){
                int val=nums.get(j);
                if(vist[val]==0){
                    count++;
                    vist[val]+=1;
                }
                ans=ans+(count*count);
            }
            
        }

        return ans;
        
    }
}