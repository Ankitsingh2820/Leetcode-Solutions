import java.util.*;

class Solution {
    public int numBusesToDestination(int[][] routes, int source, int target) {
        if (source == target) return 0;

        // Map each stop to the list of bus routes that pass through it
        Map<Integer, List<Integer>> stopToBuses = new HashMap<>();
        for (int bus = 0; bus < routes.length; bus++) {
            for (int stop : routes[bus]) {
                stopToBuses.computeIfAbsent(stop, k -> new ArrayList<>()).add(bus);
            }
        }

        // BFS setup
        Queue<Integer> q = new LinkedList<>();
        Set<Integer> visitedStops = new HashSet<>();
        Set<Integer> visitedBuses = new HashSet<>();

        q.offer(source);
        visitedStops.add(source);

        int busesTaken = 0;

        while (!q.isEmpty()) {
            int size = q.size();
            busesTaken++;

            for (int i = 0; i < size; i++) {
                int stop = q.poll();

                // Check all buses passing through this stop
                for (int bus : stopToBuses.getOrDefault(stop, new ArrayList<>())) {
                    if (visitedBuses.contains(bus)) continue;
                    visitedBuses.add(bus);

                    // Add all stops from this bus
                    for (int nextStop : routes[bus]) {
                        if (nextStop == target) return busesTaken;
                        if (!visitedStops.contains(nextStop)) {
                            visitedStops.add(nextStop);
                            q.offer(nextStop);
                        }
                    }
                }
            }
        }

        return -1; // not reachable
    }
}


