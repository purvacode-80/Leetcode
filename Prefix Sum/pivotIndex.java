// 724. Find Pivot Index

public class pivotIndex {
    
    public static int pivotIndex(int[] nums) {
        int leftSum = 0;
        int rightSum = 0;

        // Calculate the total sum of the array initially
        for (int i = 0; i < nums.length; i++) {
            rightSum += nums[i];
        }

        for (int i = 0; i < nums.length; i++) {
            rightSum -= nums[i];    // Minus the current element from right sum

            if (leftSum == rightSum) {
                return i;   // Pivot index found
            }

            leftSum += nums[i]; // Add the current element to left sum
        }
        return -1;  // No pivot index found
    }

    public static void main(String[] args) {
        // Case 1
        int[] nums1 = {1, 7, 3, 6, 5, 6};
        System.out.println("Pivot Index Case 1: " + pivotIndex(nums1)); // 3

        // Case 2
        int[] nums2 = {1, 2, 3};
        System.out.println("Pivot Index Case 2: " + pivotIndex(nums2)); // -1

        // Case 3
        int[] nums3 = {2, 1, -1};
        System.out.println("Pivot Index Case 3: " + pivotIndex(nums3)); // 0
    }
}
