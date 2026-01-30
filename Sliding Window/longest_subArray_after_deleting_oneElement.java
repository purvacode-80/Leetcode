// 1493. Longest Subarray of 1's After Deleting One Element

public class longest_subArray_after_deleting_oneElement {
    public static int longestSubarray(int[] nums) {
        int max = 0;
        int left = 0;
        int zeroCount = 0;

        for(int right = 0; right < nums.length; right++) {
            if(nums[right] == 0) {
                zeroCount++;
            }

            while (zeroCount > 1) {
                if(nums[left] == 0) {
                    zeroCount--;
                }
                left++;
            }

            max = Math.max(max, right - left);
        }
        return max;
    }
    public static void main(String[] args) {
        // Case 1
        int[] num1 = {1,1,0,1};
        System.out.println(longestSubarray(num1)); // Output: 3

        // Case 2
        int[] num2 = {0,1,1,1,0,1,1,0,1};
        System.out.println(longestSubarray(num2)); // Output: 5

        // Case 3
        int[] num3 = {1,1,1};
        System.out.println(longestSubarray(num3)); // Output: 2
    }
}
