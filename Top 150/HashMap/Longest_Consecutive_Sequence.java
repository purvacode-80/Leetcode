// 128. Longest Consecutive Sequence

import java.util.HashSet;

public class Longest_Consecutive_Sequence {
    public static int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();

        // Store all the numbers in a HashSet for O(1) lookups
        for (int num : nums) {
            set.add(num);
        }

        int max = 0;
        int length = 0;

        for (Integer num : set) {
            // Check if the current number is the start of a sequence
            // If num - 1 is not in the set, then num is the start of a sequence
            if (!set.contains(num - 1)) {
                length = 1;
            
                // Count the length of the consecutive sequence starting from num
                while (set.contains(num + length)) {
                    length++;
                }
            }
            max = Math.max(max, length);
        }
        return max;
    }
    
    public static void main(String[] args) {
        // Test Case - 1
        int[] nums1 = {100, 4, 200, 1, 3, 2};
        System.out.println(longestConsecutive(nums1)); // Output: 4

        // Test Case - 2
        int[] nums2 = {0, 3, 7, 2, 5, 8, 4, 6, 0, 1};
        System.out.println(longestConsecutive(nums2)); // Output: 9

        // Test Case - 3
        int[] nums3 = {1, 2, 0, 1};
        System.out.println(longestConsecutive(nums3)); // Output: 3
    }
}
