// 1679. Max Number of K-Sum Pairs

import java.util.HashMap;
import java.util.Map;

public class MaxOperations {
    public static int maxOperations(int[] nums, int k) {
        // Create a map to count occurrences of each number
        Map<Integer, Integer> countMap = new HashMap<>();
        int count = 0;  // Store no of operations

        for(int num : nums) {
            // Calculate the complement that would sum with num to k
            int complement = k - num;

            // If the complement exists in the map and has a positive count
            if (countMap.containsKey(complement)) {
                count++;  // We can perform an operation
                if (countMap.get(complement) == 1) {
                    countMap.remove(complement);  // Remove the complement if its count is 1
                } else {
                    countMap.put(complement, countMap.get(complement) - 1);  // Decrease the count of the complement
                    
                }
            } else {
                // Otherwise, increase the count of the current number
                countMap.put(num, countMap.getOrDefault(num, 0) + 1);
            }
        }
        return count;  // Return the total number of operations performed
    }

    public static void main(String[] args) {
        // Test Case - 1
        int[] nums = {1, 2, 3, 4};
        int k = 5;
        int result = maxOperations(nums, k);
        System.out.println("Max operations : " + result);   // Output: 2

        // Test Case - 2
        int[] nums2 = {3, 1, 3, 4, 3};
        int k2 = 6;
        int result2 = maxOperations(nums2, k2);
        System.out.println("Max operations : " + result2);  // Output: 1
    }
}
