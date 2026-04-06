// 45. Jump Game II

public class Jump_Game_II {
    public static int jump(int[] nums) {
        int jumps = 0;
        int currentEnd = 0;
        int farthest = 0;

        // Iterate through the array, but we don't need to check the last element
        for (int i = 0; i < nums.length - 1; i++) {
            // Update the farthest reachable index
            farthest = Math.max(farthest, i + nums[i]);

            // If we have reached the end of the current jump, we need to make another jump
            if (i == currentEnd) {
                jumps++;    // Increment the jump count
                currentEnd = farthest;  // If we cannot move further, break out of the loop
                if (currentEnd >= nums.length - 1) {
                    break; // We can reach the end, so we can stop
                }
            }
        }
        return jumps;
    }

    public static void main(String[] args) {
        // Test Case - 1
        int[] nums = {2,3,1,1,4};
        System.out.println(jump(nums)); // Output: 2

        // Test Case - 2
        int[] nums2 = {2,3,0,1,4};
        System.out.println(jump(nums2)); // Output: 2
    }
}
