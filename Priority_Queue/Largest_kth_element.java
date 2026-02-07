// 215. Kth Largest Element in an Array

import java.util.PriorityQueue;

public class Largest_kth_element {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        
        // Make a min heap of size k
        for (int i = 0; i < k; i++) {
            minHeap.offer(nums[i]);
        }

        // For remaining element of k, add the new element only if it is larger than the top element
        for (int i = k; i < nums.length; i++) {
            if (nums[i] > minHeap.peek()) {
                minHeap.poll();
                minHeap.offer(nums[i]);
            }
        }

        // The topmost element of the minHeap will be the kth largest element
        return minHeap.peek();
    }

    public static void main(String[] args) {
        // Test Case - 1
        Largest_kth_element solution = new Largest_kth_element();
        int[] nums1 = {3, 2, 1, 5, 6, 4};
        int k1 = 2;
        System.out.println(solution.findKthLargest(nums1, k1)); // return 5

        // Test Case - 2
        int[] nums2 = {3, 2, 3, 1, 2, 4, 5, 5, 6};
        int k2 = 4;
        System.out.println(solution.findKthLargest(nums2, k2)); // return 4
    }
}
