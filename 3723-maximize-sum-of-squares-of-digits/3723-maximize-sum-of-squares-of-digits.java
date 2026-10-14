class Solution {
    public String maxSumOfSquares(int num, int sum) {
        if (sum > 9 * num || sum < 1) {
            return "";
        }

        StringBuilder ans = new StringBuilder();

        while (num > 0) {
            if (sum >= 9) {
                ans.append('9');
                sum -= 9;
            } else {
                ans.append(sum);
                sum = 0;
            }           
            num--;
        }

        return ans.toString();
    }
}
