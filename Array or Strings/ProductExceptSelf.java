// 238. Product of Array Except Self

class ProductExceptSelf {
    public static int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] output = new int[n];
        int leftProduct = 1;
        int rightProduct = 1;

        for (int i = 0; i < n; i++) {
            output[i] = 1; // Initialize output[i] to 1
        }

        for (int i = 0; i < n; i++) {
            output[i] *= leftProduct;
            leftProduct *= nums[i];
        }

        for (int i = n - 1; i >= 0; i--) {
            output[i] *= rightProduct;
            rightProduct *= nums[i];
        }

        return output;
    }

    public static void main(String[] args) {
        // Test Case - 1
        int[] nums = {1, 2, 3, 4};
        int[] result = productExceptSelf(nums);
        for (int i : result) {
            System.out.print(i + " ");
        }

        System.out.println("\n");

        //Test Case - 2
        int[] nums2 = {-1,1,0,-3,3};
        int[] result2 = productExceptSelf(nums2);
        for (int i : result2) {
            System.out.print(i + " ");
        }
    }
}