// 1466. Reorder Routes to Make All Paths Lead to the City Zero

import java.util.ArrayList;
import java.util.List;

public class Reorder {
    public static int dfs(List<List<Integer>> al, boolean[] visited, int from) {
        int count = 0;
        visited[from] = true;

        // Traverse all adjacent cities (both outgoing and incoming)
        for (var to : al.get(from)) {
            // If 'to' is positive, it's an outgoing edge that needs to be reversed
            // If 'to' is negative, it's an incoming edge that doesn't need to be reversed
            if (!visited[Math.abs(to)]) {
                count += dfs(al, visited, Math.abs(to)) + ( to > 0 ? 1 : 0);
            }
        }
        return count;
    }

    public static int minReorder(int n, int[][] connections) {
        // Create an adjacency list to represent the graph
        List<List<Integer>> al = new ArrayList<>();
        for(int i=0; i < n; i++) {
            // Initialize the adjacency list for each city
            // We will store positive values for outgoing edges and negative values for incoming edges
            al.add(new ArrayList<>());
        }
        for (var c : connections) {
            // Outgoing edge from c[0] to c[1] - Positive
            al.get(c[0]).add(c[1]);
            // Incoming edge to c[1] from c[0] - Negative
            al.get(c[1]).add(-c[0]);
        }
        return dfs(al, new boolean[n], 0);
    }

    public static void main(String[] args) {
        // Test Case 1 : n = 6, connections = [[0,1],[1,3],[2,3],[4,0],[4,5]]
        int n = 6;
        int[][] connections = {
            {0, 1},
            {1, 3},
            {2, 3},
            {4, 0},
            {4, 5}
        };
        System.out.println(minReorder(n, connections)); // Output: 3

        // Test Case 2 : n = 5, connections = [[1,0],[1,2],[3,2],[3,4]]
        int n2 = 5;
        int[][] connections2 = {
            {1, 0},
            {1, 2},
            {3, 2},
            {3, 4}
        };
        System.out.println(minReorder(n2, connections2)); // Output: 2

        // Test Case 3 : n = 3, connections = [[1,0],[2,0]]
        int n3 = 3;
        int[][] connections3 = {
            {1, 0},
            {2, 0}
        };
        System.out.println(minReorder(n3, connections3)); // Output: 0
    }
}