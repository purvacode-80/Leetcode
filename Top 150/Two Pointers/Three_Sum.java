// 15. 3Sum

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Three_Sum {
    public static List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;    
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        
        for (int i = 0; i < n - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue; // Skip duplicates

            int left = i + 1, right = n - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    res.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    while (left < right && nums[left] == nums[left + 1]) left++; // Skip duplicates
                    while (left < right && nums[right] == nums[right - 1]) right--; // Skip duplicates
                    left++;
                    right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        // Test Case - 1
        int[] nums1 = {-1, 0, 1, 2, -1, -4};
        System.out.println(threeSum(nums1)); // Output: [[-1, -1, 2], [-1, 0, 1]]

        // Test Case - 2
        int[] nums2 = {0, 1, 1};
        System.out.println(threeSum(nums2)); // Output: []

        // Test Case - 3
        int[] nums3 = {0, 0, 0};
        System.out.println(threeSum(nums3)); // Output: [[0, 0, 0]]
    }
}