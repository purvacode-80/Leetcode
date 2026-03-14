// 162. Find Peak Element

public class PeakElement {
    public static int findPeakElement(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        // Binary search for the peak element
        while (left < right) {
            int mid = left + (right - left) / 2;
            // Compare mid element with its next element
            // If mid element is greater than the next element, then the peak must be in the left half (including mid)
            if (nums[mid] > nums[mid+1]) {
                right = mid;
            }
            // If mid element is less than or equal to the next element, then the peak must be in the right half (excluding mid)
            else {
                left = mid + 1;
            }
        }
        // At the end of the loop, left and right will point to the same element, which is the peak element
        // Why not mid ? Because mid is calculated in the loop and can change, but left and right will converge to the same index which is the peak element.
        return left;
    }

    public static void main(String[] args) {
        // Test Case - 1
        int[] nums = {1, 2, 3, 1};
        int peakIndex = findPeakElement(nums);
        System.out.println("Peak Element Index = " + peakIndex); // Output: 2

        // Test Case - 2
        nums = new int[]{1, 2, 1, 3, 5, 6, 4};
        peakIndex = findPeakElement(nums);
        System.out.println("Peak Element Index = " + peakIndex); // Output: 1 or 5
    }
}
