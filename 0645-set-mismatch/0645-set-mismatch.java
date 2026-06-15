class Solution { 
    public int[] findErrorNums(int[] nums) { 
        int ans[] = new int[2]; 
        int n = nums.length; 
        // 1. Size must be n + 1 to easily map values 1 to n to indices 1 to n
        int temp[] = new int[n + 1]; 
        
        // 2. Count occurrences of each number directly without the modulo operator
        for(int i = 0; i < nums.length; i++){ 
            int curr = nums[i]; 
            temp[curr] += 1; 
        } 
        
        // 3. Loop from 1 to n to identify the duplicate and missing numbers
        for(int i = 1; i <= n; i++){ 
            if(temp[i] > 1){ 
                ans[0] = i; // The number that repeated (index i itself)
            }
            if(temp[i] == 0){ 
                ans[1] = i; // The number that is missing (index i itself)
            } 
        } 
        return ans; 
    } 
}
