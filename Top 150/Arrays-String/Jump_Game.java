// 55. Jump Game

public class Jump_Game {
    public static boolean canJump(int[] nums) {
        int maxReach = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > maxReach) {
                return false; // Cannot reach this position
            }
            maxReach = Math.max(maxReach, i + nums[i]);
        }
        return true; // Can reach the end
    }

    public static void main(String[] args) {
        // Test Case - 1
        int[] nums = {2,3,1,1,4};
        System.out.println(canJump(nums)); // Output: true

        // Test Case - 2
        int[] nums2 = {3,2,1,0,4};
        System.out.println(canJump(nums2)); // Output: false
    }
}