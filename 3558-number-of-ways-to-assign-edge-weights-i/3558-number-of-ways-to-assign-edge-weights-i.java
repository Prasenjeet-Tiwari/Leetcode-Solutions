import java.util.ArrayList;
import java.util.List;

class Solution {

    // 1. Added variable name 'MOD'
    private static final int MOD = 1_000_000_007;

    public int assignEdgeWeights(int[][] edges) {
        
        // The tree has N nodes and N-1 edges
        int n = edges.length + 1; 
        
        // 2. Fixed array of generics syntax and sized for 1-indexed nodes
        List<Integer>[] graph = new ArrayList[n + 1]; 
        for (int i = 0; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        // 3. Correctly built the undirected graph
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            graph[u].add(v);
            graph[v].add(u);
        }

        int maxDepth = dfs(1, 0, graph);
        
        // Return 2^(depth - 1) % MOD
        return (int) pow(2, maxDepth - 1);
    }

    // 4. Completed the DFS logic
    private int dfs(int node, int prev, List<Integer>[] graph) {
        int dist = 0;
        for (int neighbor : graph[node]) {
            if (neighbor != prev) {
                // Add 1 for the current edge, plus the depth of the neighbor
                dist = Math.max(dist, 1 + dfs(neighbor, node, graph));
            }
        }
        return dist;
    }

    // 5. Fixed typos ('mood' -> 'MOD') and ensured proper modulo arithmetic
    private long pow(long base, int exp) {
        long res = 1;
        while (exp > 0) {
            if (exp % 2 == 1) { // Changed > 0 to == 1 for clarity
                res = (res * base) % MOD;
            }
            base = (base * base) % MOD;
            exp /= 2;
        }
        return res;
    }
}