// 198. House Robber

public class House_Robber {
    public static int rob(int[] nums) {
        int prevRob = 0;
        int maxRob = 0;

        for (int curVal : nums) {
            int temp = Math.max(maxRob,curVal+prevRob);
            prevRob = maxRob;
            maxRob = temp;
        }

        return maxRob;
    }

    public static void main(String[] args) {
        // Test Case - 1
        int[] nums1 = {1, 2, 3, 1};
        System.out.println(rob(nums1)); // Output: 4

        // Test Case - 2
        int[] nums2 = {2, 7, 9, 3, 1};
        System.out.println(rob(nums2)); // Output: 12
    }
}
