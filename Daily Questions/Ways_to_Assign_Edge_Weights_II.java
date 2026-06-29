import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Ways_to_Assign_Edge_Weights_II {
    static final int MOD = 1000000007;

    List<Integer>[] graph;
    int[][] up;
    int[] depth;
    int LOG;

     public int[] assignEdgeWeights(int[][] edges, int[][] queries) {

        int n = edges.length + 1;

        LOG = 18;

        graph = new ArrayList[n + 1];

        for (int i = 0; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] e : edges) {
            graph[e[0]].add(e[1]);
            graph[e[1]].add(e[0]);
        }

        up = new int[n + 1][LOG];
        depth = new int[n + 1];

        dfs(1, 0);

        for (int j = 1; j < LOG; j++) {
            for (int i = 1; i <= n; i++) {
                up[i][j] = up[up[i][j - 1]][j - 1];
            }
        }

        int[] ans = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {

            int u = queries[i][0];
            int v = queries[i][1];

            int lca = lca(u, v);

            int dist = depth[u] + depth[v] - 2 * depth[lca];

            if (dist == 0) {
                ans[i] = 0;
            } else {
                ans[i] = (int) modPow(2, dist - 1);
            }
        }
        return ans;
    }

    private void dfs(int node, int parent) {

        up[node][0] = parent;

        for (int next : graph[node]) {

            if (next == parent) continue;

            depth[next] = depth[node] + 1;

            dfs(next, node);
        }
    }

    private int lca(int a, int b) {

        if (depth[a] < depth[b]) {
            int temp = a;
            a = b;
            b = temp;
        }

        int diff = depth[a] - depth[b];

        for (int j = 0; j < LOG; j++) {
            if ((diff & (1 << j)) != 0) {
                a = up[a][j];
            }
        }

        if (a == b) return a;

        for (int j = LOG - 1; j >= 0; j--) {

            if (up[a][j] != up[b][j]) {

                a = up[a][j];
                b = up[b][j];
            }
        }

        return up[a][0];
    }

    private long modPow(long base, long exp) {

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
        int[][] queries1 = {{1,1},{1, 2}};
        Ways_to_Assign_Edge_Weights_II solution = new Ways_to_Assign_Edge_Weights_II();
        int[] result1 = solution.assignEdgeWeights(edges1, queries1);
        System.out.println(Arrays.toString(result1)); // Output: [0,1]

        // Test Case - 2
        int[][] edges2 = {{1, 2}, {1, 3}, {3, 4}, {3, 5}};
        int[][] queries2 = {{1, 4}, {3, 4}, {2, 5}};
        int[] result2 = solution.assignEdgeWeights(edges2, queries2);
        System.out.println(Arrays.toString(result2)); // Output: [2, 1, 4]
    }
}
