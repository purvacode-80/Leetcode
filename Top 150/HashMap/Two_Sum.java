// 1. Two Sum

import java.util.HashMap;

public class Two_Sum {
    public static int[] twoSum(int[] nums, int target) {
        // Create a HashMap to store the numbers and their corresponding indices
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            // Calculate the complement of the current number
            int complement = target - nums[i];
            // Check if the complement exists in the HashMap
            if (map.containsKey(complement)) {
                // If it exists, return the indices of the current number and the complement
                int index = map.get(complement);
                return new int[]{i,index};
            }
            map.put(nums[i], i);
        }
        return new int[]{};
    }

    public static void main(String[] args) {
        // Test Case - 1
        int[] nums1 = {2, 7, 11, 15};
        int target1 = 9;
        int[] result1 = twoSum(nums1, target1);
        System.out.println("Output: [" + result1[0] + ", " + result1[1] + "]"); // Output: [0, 1]

        // Test Case - 2
        int[] nums2 = {3, 2, 4};        
        int target2 = 6;
        int[] result2 = twoSum(nums2, target2);
        System.out.println("Output: [" + result2[0] + ", " + result2[1] + "]"); // Output: [1, 2]

        // Test Case - 3
        int[] nums3 = {3, 3};
        int target3 = 6;
        int[] result3 = twoSum(nums3, target3);
        System.out.println("Output: [" + result3[0] + ", " + result3[1] + "]"); // Output: [0, 1]
    }
}