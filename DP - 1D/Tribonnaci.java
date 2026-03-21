// 1137. N-th Tribonacci Number

// The Tribonacci sequence Tn is defined as follows:
// T0 = 0, T1 = 1, T2 = 1, and Tn+3 = Tn + Tn+1 + Tn+2 for n >= 0.

public class Tribonnaci {
    public static int tribonacci(int n) {
        // If 0 is given, return 0
        if (n == 0) return 0;

        // If 1 or 2 is given, return 1
        if (n == 1 || n == 2) return 1;

        // Create a dp array to store the results of subproblems
        int[] dp = new int[n+1];

        dp[1] = 1;
        dp[2] = 1;

        for (int i=3; i <= n; i++) {
            dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
        }

        return dp[n];
    }
    
    public static void main(String[] args) {
        // Test Case - 1

        int n1 = 4;
        System.out.println(tribonacci(n1)); // Output: 4

        // Test Case - 2    
        int n2 = 25;
        System.out.println(tribonacci(n2)); // Output: 1389537
    }
}