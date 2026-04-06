// 27. Remove Element

public class Remove_Element {
    public static int removeElement(int[] nums, int val) {
        int index = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[index] = nums[i];
                index++;
            }
        }
        return index;
    }

    public static void main(String[] args) {
        // Test Case - 1
        int[] nums1 = {3, 2, 2, 3};
        int val1 = 3;
        int newLength1 = removeElement(nums1, val1);
        System.out.print("New Array: ");
        for (int i = 0; i < newLength1; i++) {
            System.out.print(nums1[i] + " ");
        }

        // Test Case - 2
        int[] nums2 = {0, 1, 2, 2, 3, 0, 4, 2};
        int val2 = 2;
        int newLength2 = removeElement(nums2, val2);
        System.out.print("\nNew Array: ");
        for (int i = 0; i < newLength2; i++) {
            System.out.print(nums2[i] + " ");
        }

        // Test Case - 3
        int[] nums3 = {1, 1, 1, 1};
        int val3 = 1;
        int newLength3 = removeElement(nums3, val3);
        System.out.print("\nNew Array: ");
        for (int i = 0; i < newLength3; i++) {
            System.out.print(nums3[i] + " ");
        }
    }
}
