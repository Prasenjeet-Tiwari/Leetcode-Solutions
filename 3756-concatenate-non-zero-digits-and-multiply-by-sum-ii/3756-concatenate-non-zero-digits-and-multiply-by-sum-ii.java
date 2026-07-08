class Solution {
    long MOD = 1_000_000_007;

    public int[] sumAndMultiply(String s, int[][] queries) {
        int n = s.length();
        long[] pSum = new long[n + 1]; // prefix sum of digits
        long[] pNum = new long[n + 1]; // prefix number from non-zero digits
        int[] pCnt = new int[n + 1];   // prefix count of non-zero digits
        long[] pow = new long[n + 1];   // powers of 10

        // Precompute powers of 10
        pow[0] = 1;
        for (int i = 1; i <= n; i++) {
            pow[i] = (pow[i - 1] * 10) % MOD;
        }

        // Build prefix arrays
        for (int i = 0; i < n; i++) {
            pSum[i + 1] = pSum[i];
            pNum[i + 1] = pNum[i];
            pCnt[i + 1] = pCnt[i];

            int digit = s.charAt(i) - '0';
            if (digit != 0) {
                pSum[i + 1] = (pSum[i] + digit) % MOD;
                pNum[i + 1] = ((pNum[i] * 10) % MOD + digit) % MOD;
                pCnt[i + 1]++;
            }
        }

        //output
        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int l = queries[i][0];
            int r = queries[i][1];

            long sum = (pSum[r + 1] - pSum[l] + MOD) % MOD;
            int cnt = pCnt[r + 1] - pCnt[l];
            
            // Extract the range number and fix negative modulo
            long num = (pNum[r + 1] - (pNum[l] * pow[cnt]) % MOD + MOD) % MOD;

            ans[i] = (int) ((sum * num) % MOD);
        }

        return ans;
    }
}
