class Solution { 
    public int divide(int dividend, int divisor) { 
        // Handle overflow edge case: -2147483648 / -1 = 2147483648 (overflows int)
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        // Determine the sign of the quotient
        int sign = ((dividend < 0) ^ (divisor < 0)) ? -1 : 1; 

        // Convert to long to safely avoid Math.abs overflow
        long dvdt = Math.abs((long) dividend); 
        long dvs = Math.abs((long) divisor); 

        // Perform division
        long ans = dvdt / dvs; 

        // Apply sign and return
        return (int) (sign * ans);
    } 
}
