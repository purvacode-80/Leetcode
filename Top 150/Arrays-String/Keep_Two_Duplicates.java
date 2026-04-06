// 80. Remove Duplicates from Sorted Array II

public class Keep_Two_Duplicates {
    public static int removeDuplicates(int[] nums) {
        int k = 2;

        for (int i = 2; i < nums.length; i++) {
            if(nums[i] != nums[k-2]) {
                nums[k] = nums[i];
                k++;
            }
        }
        return k;
    }

    public static void main(String[] args) {
        // Test Case - 1
        int[] nums1 = {1, 1, 1, 2, 2, 3};
        int newLength1 = removeDuplicates(nums1);
        System.out.println("New Length: " + newLength1);
        System.out.print("Modified Array: ");
        for (int i = 0; i < newLength1; i++) {
            System.out.print(nums1[i] + " ");
        }

        // Test Case - 2
        int[] nums2 = {0, 0, 1, 1, 1, 1, 2, 3, 3};
        int newLength2 = removeDuplicates(nums2);
        System.out.println("\nNew Length: " + newLength2);
        System.out.print("Modified Array: ");
        for (int i = 0; i < newLength2; i++) {
            System.out.print(nums2[i] + " ");
        }
    }
}
