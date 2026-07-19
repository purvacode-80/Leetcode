// 228. Summary Ranges

import java.util.ArrayList;
import java.util.List;

public class Summary_Ranges {
    public static List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }
        
        int i = 0;
        int start = nums[0];

        while (i < nums.length) {
            start = nums[i];    // Initialize the start of the range
            int j = i;

            // Move j to the end of the current range
            // Check if the next number is consecutive
            while (j + 1 < nums.length && nums[j + 1] == nums[j] + 1 ) {
                j++;
            }

            // Add the range to the result list
            // If start and nums[j] are the same, it means there's no range, just a single number
            if (nums[j] == start) {
                result.add(String.valueOf(nums[j]));
            }
            else {
                result.add(start + "->" + nums[j]);
            }

            // Move i to the next number after the current range (j + 1)
            i = j + 1;
        }
        return result;
    }

    public static void main(String[] args) {
        // Test Case - 1
        int[] nums1 = {0, 1, 2, 4, 5, 7};
        System.out.println(summaryRanges(nums1)); // Expected: ["0->2", "4->5", "7"]

        // Test Case - 2
        int[] nums2 = {0, 2, 3, 4, 6, 8, 9};
        System.out.println(summaryRanges(nums2)); // Expected: ["0", "2->4", "6", "8->9"]
    }
}