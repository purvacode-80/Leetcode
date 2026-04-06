// 189. Rotate Array

public class Rotate_Array {
    public static void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n; // Handle cases where k is greater than n

        reverse(nums, 0, n-1);  // Step 1: Reverse the entire array
        reverse(nums, 0, k-1);  // Step 2: Reverse the first k elements
        reverse(nums, k, n-1);       // Step 3: Reverse the remaining n-k elements from index k to n-1
    }

    private static void reverse(int[] nums, int left, int right) {
        while (left < right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        // Test Case - 1
        int[] nums1 = {1, 2, 3, 4, 5, 6, 7};
        int k1 = 3;
        rotate(nums1, k1);
        System.out.print("Rotated Array: ");
        for (int num : nums1) {
            System.out.print(num + " ");
        }
        // Output: 5 6 7 1 2 3 4

        // Test Case - 2
        int[] nums2 = {-1, -100, 3, 99};
        int k2 = 2;
        rotate(nums2, k2);
        System.out.print("\nRotated Array: ");
        for (int num : nums2) {
            System.out.print(num + " ");
        }
        // Output: 3 99 -1 -100
    }
}
