// 2161. Partition Array According to Given Pivot

import java.util.ArrayList;
import java.util.List;

public class Partition_Array_Pivot {
    public static int[] pivotArray(int[] nums, int pivot) {
        int n = nums.length;
        int index = 0;
        int[] result = new int[n];
        
        List<Integer> smaller = new ArrayList<>();
        List<Integer> greater = new ArrayList<>();
        int equalCount = 0;

        for(int num : nums) {
            if (num < pivot)    smaller.add(num);
            else if (num == pivot)  equalCount++;
            else    greater.add(num);
        }

        for (Integer num : smaller) {
            result[index++] = num;
        }

        for (int i = 1; i <= equalCount; i++)
            result[index++] = pivot;

        for (Integer num : greater) {
            result[index++] = num;
        }
        return result;
    }

    public static void main(String[] args) {
        // Test Case - 1
        int[] nums1 = {9,12,5,10,14,3,10};
        int pivot1 = 10;
        int[] result1 = pivotArray(nums1, pivot1);
        System.out.print("Result of Test Case 1: ");
        for (int num : result1) {
            System.out.print(num + " ");
        }
        System.out.println();

        // Test Case - 2
        int[] nums2 = {-3,4,3,2};
        int pivot2 = 2;
        int[] result2 = pivotArray(nums2, pivot2);
        System.out.print("Result of Test Case 2: ");
        for (int num : result2) {
            System.out.print(num + " ");
        }
    }
}