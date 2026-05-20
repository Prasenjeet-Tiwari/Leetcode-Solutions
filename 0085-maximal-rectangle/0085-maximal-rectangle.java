class Solution {

    int histogramArea_84(int heights[]){

        // Stack to store indices
        Stack<Integer> stack = new Stack<>();

        int maxArea = 0;

        // Append a sentinel height
        int[] newHeights = Arrays.copyOf(heights, heights.length + 1);

      
        for (int i = 0; i < newHeights.length; i++) {

            // While current bar is less than stack top
            while (!stack.isEmpty() && newHeights[i] < newHeights[stack.peek()]) {

                // Pop and calculate area
                int height = newHeights[stack.pop()]; // imp here pop is happening
                int width = stack.isEmpty() ? i : i - stack.peek() - 1; //imp here peeked
                maxArea = Math.max(maxArea, height * width);
            }
            
            // Push current index
            stack.push(i);
        }
        return maxArea;
    }

    public int maximalRectangle(char[][] matrix) {
        // Safe Guard Clause: check first before looking at columns
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }

        int rows = matrix.length;
        int colms = matrix[0].length;
        
        int[] arr = new int[colms];
        int ans = 0;

        // Process row by row
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < colms; j++) {
                // Read from char matrix directly to save memory
                if (matrix[i][j] == '0') {
                    arr[j] = 0;
                } else {
                    arr[j] += 1; // Naturally handles row 0 and accumulates up
                }                
            }
            
            // Calculate max area treating current row heights as a histogram
            int temp_Ans = histogramArea_84(arr);
            ans = Math.max(ans, temp_Ans);
        }
        
        return ans;
    }
}