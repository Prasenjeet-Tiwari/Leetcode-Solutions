class Solution {
    private final long MOD = 1_000_000_007;

    public int countGoodNumbers(long n) {
        // Even indices (0, 2, 4...) have 5 choices: 0, 2, 4, 6, 8
        long evenIndices = (n + 1) / 2;
        
        // Odd indices (1, 3, 5...) have 4 choices: 2, 3, 5, 7
        long oddIndices = n / 2;

        // Compute total combinations for even and odd positions
        long totalEvenChoices = power(5, evenIndices);
        long totalOddChoices = power(4, oddIndices);

        // Multiply the two parts together and apply the final modulo
        return (int) ((totalEvenChoices * totalOddChoices) % MOD);
    }

    // Computes (base^exp) % MOD efficiently in O(log exp) time
    private long power(long base, long exp) {
        long res = 1;
        base = base % MOD; // Handle cases where base >= MOD
        
        while (exp > 0) {
            // If exponent is odd, multiply base with the result
            if (exp % 2 == 1) {
                res = (res * base) % MOD;
            }
            // Exponent must be even now, square the base and halve exponent
            base = (base * base) % MOD;
            exp /= 2;
        }
        return res;
    }
}
