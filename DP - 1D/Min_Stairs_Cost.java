// 746. Min Cost Climbing Stairs

public class Min_Stairs_Cost {
    public static int minCostClimbingStairs(int[] cost) {
        int n = cost.length;

        if (n <= 2) return Math.min(cost[0], cost[1]);

        int first = cost[0];
        int second = cost[1];

        for(int i = 2; i < n; i++) {
            // Calculate the cost to reach the current step
            // The cost to reach the current step is the cost of the current step plus the minimum cost of the previous two steps
            int curr = cost[i] + Math.min(first,second);
            first = second;
            second = curr;
        }

        return Math.min(first, second);
    }

    public static void main(String[] args) {
        // Test Case - 1
        int[] cost1 = {10, 15, 20};
        System.out.println(minCostClimbingStairs(cost1)); // Output: 15

        // Test Case - 2
        int[] cost2 = {1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
        System.out.println(minCostClimbingStairs(cost2)); // Output: 6
    }
}
