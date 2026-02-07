class Solution {
    public int maxScore(int[] cardPoints, int k) {
        
        
        int sum=0;
        for( int p=0; p<k; p++){
            sum+=cardPoints[p];
        }
        int max=sum;
        
        int n=cardPoints.length; 
        for (int i = 0; i < k; i++) {
            // Subtract card from front
            sum -= cardPoints[k - 1 - i];

            // Add card from back
            sum += cardPoints[n - 1 - i];

            // Update the max score
            max = Math.max(max, sum);
        }
        return max;
    }
}