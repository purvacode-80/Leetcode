// 42. Trapping Rain Water

public class Trapping_Rain_Water {
    public static int trap(int[] height) {
        int leftMax = 0, rightMax = 0;
        int start = 0, end = height.length - 1;
        int totalWater = 0;

        while (start < end) {
            // Update the leftMax and rightMax values based on the current heights
            leftMax = Math.max(leftMax, height[start]);
            rightMax = Math.max(rightMax, height[end]);

            // Calculate the trapped water based on the minimum of leftMax and rightMax
            if (leftMax < rightMax) {
                totalWater += leftMax - height[start];
                start++;
            } else {
                totalWater += rightMax - height[end];
                end--;
            }
        }
        return totalWater;
    }

    public static void main(String[] args) {
        // Test Case - 1
        int[] height1 = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println("Test Case 1: " + trap(height1)); // Output: 6

        // Test Case - 2
        int[] height2 = {4, 2, 0, 3, 2, 5};
        System.out.println("Test Case 2: " + trap(height2)); // Output: 9
    }
}