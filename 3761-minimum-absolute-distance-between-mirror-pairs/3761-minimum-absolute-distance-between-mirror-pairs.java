class Solution {

    int reverse(int n){
       
        //String s=new StringBuilder(String.valueOf(n)).reverse().toString();
        //int value= Integer.parseInt(s);
        //return value;
        int value=0;
        while(n>0){
            value= value*10 + n%10;
            n/=10;
        }
        return value;
    }
    public int minMirrorPairDistance(int[] nums) {

        int min=Integer.MAX_VALUE;
        int flag=0;

        HashMap <Integer,Integer> hmRev=new HashMap<>();


        for(int i=0; i<nums.length; i++){
            int curr=nums[i];
            int rev=reverse(curr);
            /*Map stores only reverse numbers
             * Check if current number already exists in map.
             * If yes, it means:
             * reverse(previously encountered number) == current number
             * → valid mirror pair found            */

            if(hmRev.containsKey(curr)){
                flag=1;
                min=Math.min( min, Math.abs(i-hmRev.get(curr)) );
            }
            hmRev.put(rev,i);   //store reversed value of curr in hashmap
                                //if alreadye xist then its index will get updated to current ith
            
        }
        if(flag==0){
            return -1;
        }
        return min;
    }
}