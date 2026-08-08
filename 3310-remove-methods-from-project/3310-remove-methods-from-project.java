import java.util.*;

class Solution {
    // Finds all suspicious methods reachable from k
    public void dfs(List<List<Integer>> list, boolean[] infected, int node) {
        infected[node] = true;
        for (int child : list.get(node)) {
            if (!infected[child]) {
                dfs(list, infected, child);
            }
        }
    }

    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(new ArrayList<>());
        }
        for (int i = 0; i < invocations.length; i++) {  //building graph
            int src = invocations[i][0];
            int dest = invocations[i][1];
            list.get(src).add(dest);
        }

        boolean[] infected = new boolean[n];
        dfs(list, infected, k);

        // Check if any uninfected (external) node invokes an infected node
        boolean canRemove = true;
        for (int i = 0; i < invocations.length; i++) {
            int src = invocations[i][0];
            int dest = invocations[i][1];
            if (!infected[src] && infected[dest]) { //src not infected but dest is then
                canRemove = false;
                break; 
            }
        }

        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (canRemove) {    //that means the infected node is not visted by any other to re-activate it
                if (!infected[i]) { // so if you are not infected node then i will add you
                    ans.add(i);
                }
            } else {            //even if any single node visits the infected one then all will be included
                ans.add(i);
            }
        }
        return ans;
    }
}
