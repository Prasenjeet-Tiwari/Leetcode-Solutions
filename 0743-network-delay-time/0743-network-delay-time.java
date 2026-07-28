import java.util.*;

class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        // 1. Build the adjacency list graph
        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] time : times) {
            int u = time[0];
            int v = time[1];
            int w = time[2];
            graph.get(u).add(new int[]{v, w}); // [neighbor, weight]
        }

        // 2. Initialize distance array with MAX_VALUE
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k] = 0; // Distance to source is 0

        // 3. Min-Heap priority queue stores [current_distance, node]
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        pq.offer(new int[]{0, k});

        // 4. Run Dijkstra's algorithm
        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int currentDist = current[0];
            int u = current[1];

            // Skip if we already found a shorter path to this node
            if (currentDist > dist[u]) {
                continue;
            }

            // Explore neighbors
            for (int[] edge : graph.get(u)) {
                int v = edge[0];
                int weight = edge[1];

                // If a shorter path to neighbor v is found
                if (dist[u] + weight < dist[v]) {
                    dist[v] = dist[u] + weight;
                    pq.offer(new int[]{dist[v], v});
                }
            }
        }

        // 5. Find the max value in the distance array
        int maxTime = 0;
        for (int i = 1; i <= n; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                return -1; // Node is unreachable
            }
            maxTime = Math.max(maxTime, dist[i]);
        }

        return maxTime;
    }
}
