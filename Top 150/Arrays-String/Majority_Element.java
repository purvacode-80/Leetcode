// 169. Majority Element

public class Majority_Element {
    public static int majorityElement(int[] nums) {
        int res = 0;
        int majority = 0;

        for (int n : nums) {
            if (majority == 0) {
                res = n;
            }
            majority += n == res ? 1 : -1;
        }
        return res;
    }

    public static void main(String[] args) {
        // Test Case - 1
        int[] nums1 = {3, 2, 3};
        int majority1 = majorityElement(nums1);
        System.out.println("Majority Element: " + majority1);   // Output: 3

        // Test Case - 2
        int[] nums2 = {2, 2, 1, 1, 1, 2, 2};
        int majority2 = majorityElement(nums2);
        System.out.println("Majority Element: " + majority2);   // Output: 2
    }
}
