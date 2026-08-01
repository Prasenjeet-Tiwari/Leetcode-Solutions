import java.util.*;

class Solution {
    public int numBusesToDestination(int[][] routes, int source, int target) {
        // If source and target are the same, no buses are needed
        if (source == target) {
            return 0;
        }

        // Map each stop to all the bus routes (indices) that pass through it
        Map<Integer, List<Integer>> stopToRoutes = new HashMap<>();
        for (int routeId = 0; routeId < routes.length; routeId++) {
            for (int stop : routes[routeId]) {
                stopToRoutes.putIfAbsent(stop, new ArrayList<>());
                stopToRoutes.get(stop).add(routeId);
            }
        }

        // If the source or target stop doesn't exist in any route, a path is impossible
        if (!stopToRoutes.containsKey(source) || !stopToRoutes.containsKey(target)) {
            return -1;
        }

        // BFS Queue stores the current stop
        Queue<Integer> queue = new LinkedList<>();
        // Set to track visited stops to prevent cycles
        Set<Integer> visitedStops = new HashSet<>();
        // Array to track visited bus routes so we don't board the same bus twice
        boolean[] visitedRoutes = new boolean[routes.length];

        // Initialize BFS from the source stop
        queue.offer(source);
        visitedStops.add(source);
        int busCount = 0;

        // Standard level-by-level BFS
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            busCount++; // Increment bus count for the current level/boarding

            for (int i = 0; i < levelSize; i++) {
                int currentStop = queue.poll();

                // Get all bus routes passing through the current stop
                List<Integer> busLines = stopToRoutes.get(currentStop);
                if (busLines == null) continue;

                for (int routeId : busLines) {
                    // Skip if we have already boarded this bus route
                    if (visitedRoutes[routeId]) continue;
                    visitedRoutes[routeId] = true;

                    // Explore all stops reachable by this bus route
                    for (int nextStop : routes[routeId]) {
                        if (nextStop == target) {
                            return busCount;
                        }
                        
                        if (!visitedStops.contains(nextStop)) {
                            visitedStops.add(nextStop);
                            queue.offer(nextStop);
                        }
                    }
                }
            }
        }

        return -1;
    }
}
