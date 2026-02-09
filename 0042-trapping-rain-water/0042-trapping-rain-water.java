class Solution {
    public int trap(int[] height) {
        int n = height.length;

        int left_max[] = new int[n];
        left_max[0] = height[0];
        for (int i = 1; i < n; i++) {
            left_max[i] = Math.max(height[i], left_max[i - 1]);
        }

        int right_max[] = new int[n];
        right_max[n - 1] = height[n - 1];
        for (int j = n - 2; j >= 0; j--) {
            right_max[j] = Math.max(height[j], right_max[j + 1]);
        }
        for(int a : right_max)
         System.out.print(a);
         System.out.println();
        for(int b : left_max){
            System.out.print(b);
        }

        int trapped_water = 0;
        for (int k = 0; k < n; k++) {
            int calculative_height = Math.min(left_max[k], right_max[k]);
            int final_height = calculative_height - height[k];
            trapped_water += final_height > 0 ? final_height : 0;
        }
        return trapped_water;
    }

        
}
