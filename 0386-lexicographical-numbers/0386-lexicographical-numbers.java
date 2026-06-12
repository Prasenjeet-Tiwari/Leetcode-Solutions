class Solution {

    public List<Integer> lexicalOrder(int n) {

        List<Integer> ans = new ArrayList<>();

        for(int i = 1; i <= 9; i++) {
            dfs(i, n, ans);
        }

        return ans;
    }

    private void dfs(int curr, int n, List<Integer> ans) {

        if(curr > n) return;

        ans.add(curr);

        for(int digit = 0; digit <= 9; digit++) {

            int next = curr * 10 + digit;

            if(next > n) return;

            dfs(next, n, ans);
        }
    }
}