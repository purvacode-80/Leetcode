public class Non_Zero_Multiply_Sum_II {
    public static int[] sumAndMultiply(String s, int[][] queries) {
        final int MOD = 1_000_000_007;

        int[] result = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int start = queries[i][0];
            int end = queries[i][1];

            int x = 0;
            int sum = 0;

            for (int j = start; j <= end; j++) {
                if (s.charAt(j) == '0') {
                    continue; // Skip zeros
                }
                x = (x * 10) + (s.charAt(j) - '0');
                sum += (s.charAt(j) - '0');
            }
            result[i] = (x * sum) % MOD;
        }    
        return result;
    }

    public static void main(String[] args) {
        // Test Case - 1
        String s1 = "10203004";
        int[][] queries1 = {{0, 7}, {1, 3}, {4, 6}};
        int[] result1 = sumAndMultiply(s1, queries1);
        System.out.println("Results: " + java.util.Arrays.toString(result1)); // Expected: [123456, 6, 12]

        // Test Case - 2
        String s2 = "1000";
        int[][] queries2 = {{0, 3}, {1, 1}};
        int[] result2 = sumAndMultiply(s2, queries2);
        System.out.println("Results: " + java.util.Arrays.toString(result2)); // Expected: [1, 0]

        // Test Case - 3
        String s3 = "9876543210";
        int[][] queries3 = {{0, 9}};
        int[] result3 = sumAndMultiply(s3, queries3);
        System.out.println("Results: " + java.util.Arrays.toString(result3)); // Expected: [444444137]
    }
}
