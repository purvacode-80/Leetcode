public class max_consecutive_ones_3 {

    public static int longestOnes(int[] nums, int k) {
        int left = 0;
        int maxLen = 0;
        int zeroCount = 0;

        for (int right = 0; right < nums.length; right++) {
            //If we encounter a zero, increment the zero count
            if (nums[right] == 0) {
                zeroCount++;
            }

            //If zero count exceeds k, move the left pointer to the right
            while (zeroCount > k) {
                if (nums[left] == 0) {
                    zeroCount--;
                }
                left++;
            }

            //Update the maximum length of the window
            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }

    public static void main(String[] args) {
        //Case 1
        int[] nums = {1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0};
        int k = 2;
        int result = longestOnes(nums, k);
        System.out.println("The longest subarray of 1s after flipping at most " + k + " zeros is: " + result);

        //Case 2
        int[] nums2 = {0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1};
        int k2 = 3;
        int result2 = longestOnes(nums2, k2);
        System.out.println("The longest subarray of 1s after flipping at most " + k2 + " zeros is: " + result2);
    }
}