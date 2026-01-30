// 643. Maximum Average Subarray I

class maxAverageContiguous {
    public static double findMaxAverage(int[] nums, int k) {
        double windowSum = 0;
        double maxSum = 0;

        // Sum of first k elements
        for(int i=0;i<k;i++) {
            windowSum += nums[i];
        }
        maxSum = windowSum;

        // Slide the window
        for(int i=k;i<nums.length;i++) {
            // Remove the element going out of the window and add the new element
            windowSum += nums[i] - nums[i-k];
            maxSum = Math.max(maxSum, windowSum);
        }

        return maxSum / k; // Return the maximum average
    }

    public static void main(String[] args) {
        // Test Case - 1
        int[] nums1 = {1, 12, -5, -6, 50, 3};
        int k1 = 4;
        System.out.println("Max Average: " + findMaxAverage(nums1, k1)); // Output: 12.75

        // Test Case - 2
        int[] nums2 = {5};
        int k2 = 1;
        System.out.println("Max Average: " + findMaxAverage(nums2, k2)); // Output: 5.0
    }
}