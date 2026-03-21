// 790. Domino and Tromino Tiling

class Domino_Trimino {
    public static int numTilings(int n) {
        int MOD = 1_000_000_007;
        if (n <= 2) return n;

        long[] dp = new long[n+1];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;

        for(int i = 3; i <= n; i++) {
            dp[i] = (2 * dp[i-1] + dp[i-3]) % MOD;
        }

        return (int) dp[n];
    }

    public static void main(String[] args) {
        // Test Case - 1
        int n1 = 3;
        System.out.println(numTilings(n1)); // Output: 5

        // Test Case - 2
        int n2 = 1;
        System.out.println(numTilings(n2)); // Output: 1
    }
}