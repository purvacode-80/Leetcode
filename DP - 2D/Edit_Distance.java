// 72. Edit Distance

public class Edit_Distance {
    public static int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();

        int[][] dp = new int[m+1][n+1];

        // Initialize the first row and column of the dp table
        for (int i = 0; i <= m; i++)    dp[i][0] = i;
        for (int j = 0; j <= n; j++)    dp[0][j] = j;

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                // If the characters are the same, no operation is needed
                if(word1.charAt(i-1) == word2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1];
                }
                // If the characters are different, consider the three operations: insert, delete, replace
                else {
                    dp[i][j] = 1 + Math.min(dp[i][j-1], // Insert
                        Math.min(dp[i-1][j],            // Delete
                        dp[i-1][j-1])                   // Replace
                    );
                }
            }
        }
        
        return dp[m][n];
    }

    public static void main(String[] args) {
        // Test Case - 1
        String word1 = "horse";
        String word2 = "ros";
        System.out.println(minDistance(word1, word2));  // Output : 3

        // Test Case - 2
        word1 = "intention";
        word2 = "execution";
        System.out.println(minDistance(word1, word2));  // Output : 5
    }
}
