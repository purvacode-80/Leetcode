// 88. Merge Sorted Array

public class Merge_Sorted_Array {
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;

        while(j >= 0) {
            if (i >= 0 && nums1[i] > nums2[j]) {
                nums1[k--] = nums1[i--];
            }
            else {
                nums1[k--] = nums2[j--];
            }
        }
    }

    public static void main(String[] args) {
        // Test Case - 1
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int m = 3;
        int[] nums2 = {2, 5, 6};
        int n = 3;
        merge(nums1, m, nums2, n);      
        System.out.print("Merged Array: ");
        for (int num : nums1) {
            System.out.print(num + " ");
        }

        // Test Case - 2
        int[] nums3 = {1};
        int m2 = 1;
        int[] nums4 = {0};
        int n2 = 0;
        merge(nums3, m2, nums4, n2);
        System.out.print("\nMerged Array: ");
        for (int num : nums3) {
            System.out.print(num + " ");
        }

        // Test Case - 3
        int[] nums5 = {0};
        int m3 = 0;
        int[] nums6 = {1};
        int n3 = 1; 
        merge(nums5, m3, nums6, n3);
        System.out.print("\nMerged Array: ");
        for (int num : nums5) {
            System.out.print(num + " ");
        }
    }
}