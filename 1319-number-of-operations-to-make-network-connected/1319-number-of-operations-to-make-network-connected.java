import java.util.*;

class Solution {
    public int makeConnected(int n, int[][] connections) {
        // Condition 1: Not enough total cables to connect 'n' computers
        if (connections.length < n - 1) {
            return -1;
        }

        // Build the adjacency list for the graph
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] connection : connections) {
            adj.get(connection[0]).add(connection[1]);
            adj.get(connection[1]).add(connection[0]);
        }

        boolean[] visited = new boolean[n];
        int components = 0;

        // Count the number of connected components
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                components++;
                dfs(i, adj, visited);
            }
        }

        // To connect 'C' components, we need exactly 'C - 1' cables
        return components - 1;
    }

    private void dfs(int node, List<List<Integer>> adj, boolean[] visited) {
        visited[node] = true;
        for (int neighbor : adj.get(node)) {
            if (!visited[neighbor]) {
                dfs(neighbor, adj, visited);
            }
        }
    }
}