import java.util.*;

class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        // 1. Build the adjacency list
        List<List<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] flight : flights) {
            int u = flight[0];
            int v = flight[1];
            int cost = flight[2];
            adj.get(u).add(new int[]{v, cost});
        }

        // 2. Track minimum distance to each node
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        // 3. Queue stores elements as {current_node, current_cost}
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{src, 0});

        int stops = 0;

        // 4. BFS layer by layer up to k stops
        while (!q.isEmpty() && stops <= k) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] curr = q.poll();
                int u = curr[0];
                int cost = curr[1];

                for (int[] neighbor : adj.get(u)) {
                    int v = neighbor[0];
                    int weight = neighbor[1];

                    // Relax the edge if a cheaper path is found
                    if (cost + weight < dist[v]) {
                        dist[v] = cost + weight;
                        q.offer(new int[]{v, dist[v]});
                    }
                }
            }
            stops++;
        }

        return dist[dst] == Integer.MAX_VALUE ? -1 : dist[dst];
    }
}
