// 136. Single Number 
// XOR operation has a property that a ^ a = 0 and a ^ 0 = a.
// We initialize a variable result to 0 and XOR it with each number in the array. 
// The duplicate numbers will cancel out each other and we will be left with the single number.

public class Single_Number {
    public static int singleNumber(int[] nums) {
        int result = 0;
        for (int num : nums) {
            result ^= num; // XOR operation
        }
        return result;
    }

    public static void main(String[] args) {
        // Test Case - 1
        int[] nums1 = {2, 2, 1};
        System.out.println("Single Number in Test Case 1: " + singleNumber(nums1)); // Output: 1

        // Test Case - 2
        int[] nums2 = {4, 1, 2, 1, 2};
        System.out.println("Single Number in Test Case 2: " + singleNumber(nums2)); // Output: 4

        // Test Case - 3
        int[] nums3 = {1};
        System.out.println("Single Number in Test Case 3: " + singleNumber(nums3)); // Output: 1
    }
}
