import java.util.*;

class Solution {
    private void dfs(int node, List<List<Integer>> graph, boolean[] vis, int[] stats) {
        vis[node] = true;
        stats[0]++; // Increment node count
        stats[1] += graph.get(node).size(); // Add edge contribution
        
        for (int neighbor : graph.get(node)) {
            if (!vis[neighbor]) {
                dfs(neighbor, graph, vis, stats);
            }
        }
    }
    public int countCompleteComponents(int n, int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        
        // Build the graph
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        
        boolean[] vis = new boolean[n];
        int completeComponentsCount = 0;
        
        for (int i = 0; i < n; i++) {
            if (!vis[i]) {
                int[] stats = new int[2]; // stats[0] for nodes, stats[1] for edges
                dfs(i, graph, vis, stats);
                
                int nodes = stats[0];
                int actualEdges = stats[1]; // Undirected edges are counted twice(so need to divide by 2 later)
                
                // A complete graph has V * (V - 1) / 2 edges
                if (actualEdges/2 == (nodes * (nodes - 1)) / 2) {
                    completeComponentsCount++;
                }
            }
        }
        
        return completeComponentsCount;
    }    
}
