// 62. Unique Paths

public class Unique_Paths {
       public static int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];

        // First Row
        for (int i = 0; i < m; i++) dp[i][0] = 1;

        // First Column
        for (int i = 0; i < n; i++) dp[0][i] = 1;

        // Fill DP Table

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }

        return dp[m-1][n-1];
    }

    public static void main(String[] args) {
       // Test Case - 1
       int m = 3, n = 7;
       System.out.println(uniquePaths(m, n)); // Output: 28

       // Test Case - 2
       m = 3; n = 2;
       System.out.println(uniquePaths(m, n)); // Output: 3
    }
}