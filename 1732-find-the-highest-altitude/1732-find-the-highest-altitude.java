class Solution {
    public int largestAltitude(int[] gain) {

        int max=0;
        int curr=0;
        for(int x: gain){
            curr=curr+x;
            max=Math.max( max, curr);
        }
        return max;
    }
}