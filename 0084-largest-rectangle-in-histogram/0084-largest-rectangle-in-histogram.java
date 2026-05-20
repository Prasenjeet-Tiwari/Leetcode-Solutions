import java.util.Stack;

class Solution {
    public int sol(int heights[]) {
        int n = heights.length;
        if (n == 0) return 0;

        int left[] = new int[n];
        int right[] = new int[n];
        Stack<Integer> st = new Stack<>();

        // 1. Build Left Array (Previous Smaller Element index)
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && heights[st.peek()] >= heights[i]) {
                st.pop();
            }
            // If empty, no smaller element exists on left -> fallback to -1
            left[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }

        // 2. Build Right Array (Next Smaller Element index)
        st.clear();
        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && heights[st.peek()] >= heights[i]) {
                st.pop();
            }
            // If empty, no smaller element exists on right -> fallback to n
            right[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }

        // 3. Calculate Max Area
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int width = right[i] - left[i] - 1;
            int currHeight = heights[i] * width;
            ans = Math.max(ans, currHeight);
        }

        return ans;
    }

    public int largestRectangleArea(int[] heights) {
        return sol(heights);
    }
}