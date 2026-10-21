import java.util.Arrays;

class Solution {
    public int minOperations(String s) {
        int n = s.length();

        //  Get the sorted arr
        char[] arr = s.toCharArray();
        Arrays.sort(arr);
        String sorted = new String(arr);
        
        //already sorted
        if (sorted.equals(s)) {
            return 0;
        }
        
        // impossible for length 2 if not already sorted
        if (n == 2) {
            return -1; 
        }
        
        char minChar = arr[0];
        char maxChar = arr[n - 1];

        //if min at start and max at end then only 1 step needed
        if (s.charAt(0) == minChar || s.charAt(n - 1) == maxChar) {
            return 1;
        }

        // 5. If min or max characters exist anywhere in the middle boundaries
        for (int i = 1; i < n - 1; i++) {
            if (s.charAt(i) == minChar || s.charAt(i) == maxChar) {
                return 2;
            }
        }

        // 6. Worst-case scenario (min is at the end and max is at the beginning)
        return 3;
    }
}
