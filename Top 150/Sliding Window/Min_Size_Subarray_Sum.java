// 209. Minimum Size Subarray Sum

public class Min_Size_Subarray_Sum {
    public static int minSubArrayLen(int target, int[] nums) {
        int minLen = Integer.MAX_VALUE;
        int left = 0;
        int currSum = 0;

        for (int right = 0; right < nums.length; right++) {
            currSum += nums[right];

            // Shrink the window as long as the current sum is greater than or equal to the target
            while(currSum >= target) {
                // Update the minimum length if the current window is smaller
                if (right - left + 1 < minLen)
                    minLen = right - left + 1;

                // Move the left pointer to shrink the window and update the current sum
                currSum -= nums[left];
                left++;
            }
        }
        return minLen != Integer.MAX_VALUE ? minLen : 0;
    }

    public static void main(String[] args) {
        // Test Case - 1
        int target1 = 7;
        int[] nums1 = {2, 3, 1, 2, 4, 3};
        System.out.println(minSubArrayLen(target1, nums1)); // Output: 2

        // Test Case - 2
        int target2 = 4;
        int[] nums2 = {1, 4, 4};
        System.out.println(minSubArrayLen(target2, nums2)); // Output: 1

        // Test Case - 3
        int target3 = 11;
        int[] nums3 = {1, 1, 1, 1, 1, 1, 1, 1};
        System.out.println(minSubArrayLen(target3, nums3)); // Output: 0
    }
}