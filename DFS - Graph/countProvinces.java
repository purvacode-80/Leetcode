// 547. Number of Provinces

public class countProvinces {
    public static int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        boolean[] visited = new boolean[n];
        int provinces = 0;

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(isConnected, visited, i);
                provinces++;
            }
        }
        return provinces;
    }

    private static void dfs(int[][]graph, boolean visited[], int city) {
        visited[city] = true;

        for(int i = 0; i < graph.length; i++) {
            if (graph[city][i] == 1 && !visited[i]) {
                dfs(graph, visited, i);
            }
        }
    }

    public static void main(String[] args) {
        // Test case: isConnected = [[1,1,0],[1,1,0],[0,0,1]]
        int[][] isConnected = {
            {1, 1, 0},
            {1, 1, 0},
            {0, 0, 1}
        };
        System.out.println(findCircleNum(isConnected)); // Output: 2

        // Test case: isConnected = [[1,0,0],[0,1,0],[0,0,1]]
        int[][] isConnected2 = {
            {1, 0, 0},
            {0, 1, 0},
            {0, 0, 1}
        };
        System.out.println(findCircleNum(isConnected2)); // Output: 3
    }
}
