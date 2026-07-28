import java.util.*;

class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        // 1. Build the adjacency list graph (undirected graph)
        List<List<Pair>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            double prob = succProb[i];
            graph.get(u).add(new Pair(v, prob));
            graph.get(v).add(new Pair(u, prob)); // Undirected graph
        }

        // 2. Initialize probabilities array with 0.0
        double[] maxProb = new double[n];
        maxProb[start_node] = 1.0; // Probability of starting node is 100%

        // 3. Max-Heap priority queue stores [current_probability, node]
        // Sorted in descending order (b[0] - a[0])
        PriorityQueue<State> pq = new PriorityQueue<>((a, b) -> Double.compare(b.prob, a.prob));
        pq.offer(new State(1.0, start_node));

        // 4. Run Modified Dijkstra's algorithm
        while (!pq.isEmpty()) {
            State current = pq.poll();
            double currentProb = current.prob;
            int u = current.node;

            // Early exit if we reached the destination with the highest possible probability
            if (u == end_node) {
                return currentProb;
            }

            // Skip if we already found a higher probability path to this node
            if (currentProb < maxProb[u]) {
                continue;
            }

            // Explore neighbors
            for (Pair edge : graph.get(u)) {
                int v = edge.neighbor;
                double edgeProb = edge.weight;

                // If a higher probability path to neighbor v is found
                if (maxProb[u] * edgeProb > maxProb[v]) {
                    maxProb[v] = maxProb[u] * edgeProb;
                    pq.offer(new State(maxProb[v], v));
                }
            }
        }

        // 5. If the end_node was never reached, return 0.0
        return maxProb[end_node];
    }

    // Helper classes for clean type handling with doubles
    class Pair {
        int neighbor;
        double weight;
        Pair(int neighbor, double weight) {
            this.neighbor = neighbor;
            this.weight = weight;
        }
    }

    class State {
        double prob;
        int node;
        State(double prob, int node) {
            this.prob = prob;
            this.node = node;
        }
    }
}
