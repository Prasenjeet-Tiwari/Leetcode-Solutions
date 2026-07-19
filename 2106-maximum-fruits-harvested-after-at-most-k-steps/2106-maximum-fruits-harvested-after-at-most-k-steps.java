class Solution {
    public int funcDist(int leftPos, int rightPos, int startPos){
        int total= Math.abs(rightPos-leftPos);
        int goLeftLater = Math.abs(startPos-leftPos);
        int goRightLater=Math.abs(startPos-rightPos);

        return total +Math.min(goLeftLater, goRightLater);
    }
    public int maxTotalFruits(int[][] fruits, int startPos, int k) {

        int n=fruits.length;
        int currentF=0;
        int left=0;
        
        int max=0;

        for(int right=0; right<n; right++){
            currentF +=fruits[right][1];

            while(left<=right && funcDist(fruits[left][0], fruits[right][0], startPos )>k){
                currentF -=fruits[left][1];
                left++;
            }

            max=Math.max(max, currentF);
        }
        return max;
    }
}