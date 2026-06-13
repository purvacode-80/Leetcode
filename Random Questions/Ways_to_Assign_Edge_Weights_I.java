// 3558. Number of Ways to Assign Edge Weights I

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Ways_to_Assign_Edge_Weights_I {
    static final int MOD = 1000000007;
    public static int countWays(int[][] edges) {
        int n = edges.length + 1;
        List<Integer>[] graph = new ArrayList[n+1];

        for(int i = 0; i <= n; i++)
            graph[i] = new ArrayList<>();

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            graph[u].add(v);
            graph[v].add(u);
        }

        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[n+1];

        queue.offer(1);
        visited[1] = true;

        int depth = -1;

        while (!queue.isEmpty()) {
            int size = queue.size();
            depth++;

            for (int i = 0; i < size; i++) {
                int node = queue.poll();

                for(int next : graph[node]) {
                    if(!visited[next]) {
                        visited[next] = true;
                        queue.offer(next);
                    }
                }
            }
        }
        return (int) modPow(2, depth - 1);
    }
    private static long modPow(long base, long exp) {
        long result = 1;

        while (exp > 0) {
            if ((exp & 1) == 1) {
                 result = (result * base) % MOD;
            }
            base = (base * base) % MOD;
            exp >>= 1;
        }
        return result;
    }

    public static void main(String[] args) {
        // Test Case - 1
        int[][] edges1 = {{1, 2}};
        System.out.println(countWays(edges1)); // Output: 1

        // Test Case - 2
        int[][] edges2 = {{1, 2}, {1, 3}, {3, 4}, {3, 5}};
        System.out.println(countWays(edges2)); // Output: 2
    }
}