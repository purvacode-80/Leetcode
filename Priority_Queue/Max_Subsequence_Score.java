// 2542. Maximum Subsequence Score

import java.util.Arrays;
import java.util.PriorityQueue;

public class Max_Subsequence_Score {

    public static long maxScore(int[] nums1, int[] nums2, int k) {
        int n = nums1.length;

        // Create an array of pairs (nums1[i], nums2[i])
        // Each sub array contains 2 values, the first value is from nums1 and the second value is from nums2
        int[][] pairs = new int[n][2];
        for (int i = 0; i < n; i++) {
            pairs[i][0] = nums2[i];     // 0 - nums2
            pairs[i][1] = nums1[i];     // 1 - nums1
        }

        // Sort by nums2 descending
        // Custom comparator we will compare the elements at 0th element 
        // return negative → a comes before b
        // return positive → b comes before a
        // return 0 → equal

        Arrays.sort(pairs, (a,b) -> b[0] - a[0]);

        // Initialize minHeap to keep k elements
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        long sum = 0;
        long result = 0;

        for(int[] p : pairs) {
            // Add the element to minHeap
            minHeap.add(p[1]);
            sum += p[1];

            // If the minHeap size is greater than k srink the window and subtract the 1st element
            if (minHeap.size() > k) {
                sum -= minHeap.poll();
            }

            if (minHeap.size() == k) {
                result = Math.max(result, sum * p[0]);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        // Test Case - 1
        int[] nums1 = {1, 3, 3, 2};
        int[] nums2 = {2, 1, 3, 4};
        int k = 3;
        System.out.println(maxScore(nums1, nums2, k));  // Output : 12

        // Test Case - 2
        int[] nums1_2 = {4, 2, 3, 1, 1};
        int[] nums2_2 = {7, 5, 10, 9, 6};
        int k_2 = 1;
        System.out.println(maxScore(nums1_2, nums2_2, k_2));    // Output : 30
    }
}