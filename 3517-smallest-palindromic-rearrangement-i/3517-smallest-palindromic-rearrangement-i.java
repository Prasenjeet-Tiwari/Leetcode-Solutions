class Solution { 
    public String smallestPalindrome(String s) { 
        int x[] = new int[26]; 
        for (char c : s.toCharArray()) { 
            int idx = c - 'a'; 
            x[idx]++; 
        } 

        boolean flag = false; 
        int val = -1; 
        
        // Find the character with an odd count (or count of 1) to place in the middle
        for (int i = 0; i < 26; i++) { 
            if (x[i] % 2 != 0) { 
                flag = true; 
                val = i; 
            } 
        } 

        StringBuilder str = new StringBuilder(); 
        
        // Build the first half of the palindrome lexicographically
        for (int i = 0; i < 26; i++) { 
            if (x[i] > 1) { 
                // Append half of the matching pairs
                for (int j = 0; j < x[i] / 2; j++) {
                    str.append((char)('a' + i)); 
                }
            } 
        } 

        String firstHalf = str.toString();
        
        // Append the middle character if it exists
        if (flag) { 
            str.append((char)('a' + val));
        } 
        
        // Append the mirrored first half
        str.append(new StringBuilder(firstHalf).reverse().toString()); 

        return str.toString(); 
    } 
}
