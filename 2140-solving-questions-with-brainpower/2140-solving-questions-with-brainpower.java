class Solution {
    public long tabulation(int[][] ques){
        int m = ques.length;
        long dp[] = new long[m];

        // Base case: The last question has no next questions to skip to
        dp[m - 1] = ques[m - 1][0];

        // Fill DP array from right to left
        for (int i = m - 2; i >= 0; i--) {
            long skipHowMany = ques[i][1] + 1; 
            long points = ques[i][0];

            long nextPoints = 0;
            int nextIndex = i + (int)skipHowMany;
            
            // Look up the next available question's score safely in O(1) time
            if (nextIndex < m) {
                nextPoints = dp[nextIndex];
            }

            // Decision: Solve current question OR skip current question
            // If we skip current, we take the best answer from the right side (dp[i + 1])
            dp[i] = Math.max(points + nextPoints, dp[i + 1]);
        }

        // The maximum possible points will always end up at index 0
        return dp[0];
    }

    public long mostPoints(int[][] questions) {
        return tabulation(questions);
    }
}
