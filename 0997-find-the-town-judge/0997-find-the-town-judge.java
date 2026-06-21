class Solution {
    public int findJudge(int n, int[][] trust) {

        //same logic as star problem, 

        int[] trustScore = new int[n + 1];
        
        for (int[] t : trust) {
            trustScore[t[0]]--; // Gives trust, can't be judge
            trustScore[t[1]]++; // Receives trust
        }
        
        for (int i = 1; i <= n; i++) {
            // A judge is trusted by everyone else (N - 1)
            if (trustScore[i] == n - 1) {
                return i;
            }
        }
        
        return -1;
    }
}