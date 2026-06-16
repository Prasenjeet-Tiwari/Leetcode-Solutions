class Solution {

    public int check(int n, int digit){
        int freq=0;
        while(n>0){
            int mod= n%10;
            if(mod== digit){
                freq++;
            }
            n= n/10;
        }
        return freq;
    }
    public int countDigitOccurrences(int[] nums, int digit) {
        
        int count=0;
        for(int i=0; i<nums.length; i++){
            count += check(nums[i] , digit);
        }

        return count;
    }
}