// 283. Move Zeroes

class MoveZeros {
    public static void moveZeroes(int[] nums) {
        int j = 0; // Pointer for the position of the next non-zero element
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                j++; // Move the pointer for the next non-zero element
            }
        }
    }

    public static void main(String[] args) {
        // Test Case - 1
        int[] nums = {0, 1, 0, 3, 12};
        moveZeroes(nums);
        for (int num : nums) {
            System.out.print(num + " ");
        }
        // Output: 1 3 12 0 0

        System.err.println();

        // Test Case - 2
        int[] nums2 = {0};
        moveZeroes(nums2);
        for (int num : nums2) {
            System.out.print(num + " ");
        }
        // Output: 0
    }
}
