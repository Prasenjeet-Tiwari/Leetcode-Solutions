class Solution {
    public int hammingWeight(int n) {

        int count = 0;
        
        // Loop through all 32 bits of the integer
        while (n != 0) {
            // Check if the lowest bit is a 1
            if ((n & 1) == 1) {
                count++;
            }
            // Use the unsigned right shift operator to process the next bit
            n = n >>> 1;
        }
        
        return count;
    }
}