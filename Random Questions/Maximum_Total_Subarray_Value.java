// 3689. Maximum Total Subarray Value I

public class Maximum_Total_Subarray_Value {
    public static long maxTotalValue(int[] nums, int k) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int num : nums) {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }
        return (long) (max - min) * k;
    }

    public static void main(String[] args) {
        // Test Case - 1
        int[] nums1 = {1, 2, 3};
        int k1 = 2;
        System.out.println(maxTotalValue(nums1, k1)); // Output: 4

        // Test Case - 2
        int[] nums2 = {4, 2, 5, 1};
        int k2 = 3;
        System.out.println(maxTotalValue(nums2, k2)); // Output: 12
    }
}