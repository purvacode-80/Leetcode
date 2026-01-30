// 334. Increasing Triplet Subsequence

public class IncreasingTriplet {
    public static boolean increasingTriplet(int[] nums) {
        int first = Integer.MAX_VALUE;
        int second = Integer.MAX_VALUE;

        for(int n : nums) {
            if(n <= first) {
                first = n; // Update first if n is smaller
            } else if(n <= second) {
                second = n; // Update second if n is smaller than second but larger than first
            } else {
                return true; // Found a number larger than both first and second - triplet found
            }
            }
        return false; // No increasing triplet found
    }

    public static void main(String[] args) {
        // Test Case - 1
        int[] nums1 = {1, 2, 3, 4, 5};
        System.out.println(increasingTriplet(nums1)); // Output: true

        // Test Case - 2
        int[] nums2 = {5, 4, 3, 2, 1};
        System.out.println(increasingTriplet(nums2)); // Output: false

        // Test Case - 3
        int[] nums3 = {2, 1, 5, 0, 4, 6};
        System.out.println(increasingTriplet(nums3)); // Output: true
    }
}
