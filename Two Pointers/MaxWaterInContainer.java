public class MaxWaterInContainer {
    public static int maxArea(int[] height) {
        int maxWater = 0;
        int lp = 0;
        int rp = height.length - 1;

        while (lp < rp) {
            int width = rp - lp;
            int minHeight = Math.min(height[lp], height[rp]);
            maxWater = Math.max(maxWater, width * minHeight);

            // If the pointer is small the area will have no effect therefore move to next pointer
            if (height[lp] < height[rp]) {
                lp++;
            }
            else {
                rp--;
            }
        }
        return maxWater;
    }

    public static void main(String[] args) {
        // Test Case - 1
        int[] height = {1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(height));  // Output: 49

        // Test Case - 2
        height = new int[]{1,1};
        System.out.println(maxArea(height));  // Output: 1

        // Test Case - 3
        height = new int[]{4,3,2,1,4};
        System.out.println(maxArea(height));  // Output: 16
    }
}
