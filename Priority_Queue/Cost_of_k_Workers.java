// 2462. Total Cost to Hire K Workers

import java.util.PriorityQueue;

public class Cost_of_k_Workers {
    public static long totalCost(int[] costs, int k, int candidates) {
        int n = costs.length;
        // Store first candidates
        PriorityQueue<Integer> left = new PriorityQueue<>();
        // Store last candidates
        PriorityQueue<Integer> right = new PriorityQueue<>();
        int i = 0; 
        int j = n - 1;
        long total = 0;

        // Populate both the heaps until the window size <= candidates and both left and right does not clash

        for (int c = 0; c < candidates && i <= j ; c++) {
            left.add(costs[i++]);
        }

        for (int c = 0; c < candidates && i <= j ; c++) {
            right.add(costs[j--]);
        }

        // Iterate until all k sessions are completed
        while (k-- > 0) {
            int leftMin = left.isEmpty() ? Integer.MAX_VALUE : left.peek();
            int rightMin = right.isEmpty() ? Integer.MAX_VALUE : right.peek();

            if (leftMin <= rightMin) {
                total += leftMin;
                left.poll();
                if (i <= j) {
                    left.add(costs[i++]);
                }
            } else {
                total += rightMin;
                right.poll();
                if (i <= j) {
                    right.add(costs[j--]);
                }
            }
        }

        return total;
    }

    public static void main(String[] args) {
        // Test Case - 1
        int[] costs = {17,12,10,2,7,2,11,20,8};
        int k = 3;
        int candidates = 4;
        System.out.println(totalCost(costs, k, candidates));    // Output: 11

        // Test Case - 2
        int[] costs2 = {1,2,4,1};
        int k2 = 3;
        int candidates2 = 3;
        System.out.println(totalCost(costs2, k2, candidates2));    // Output: 4
    }
}
