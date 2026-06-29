// 1846. Maximum Element After Decreasing and Rearranging

import java.util.Arrays;

public class Maximum_Element_After_Decreasing_Rearranging {
    public static int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        // Sort the array in ascending order
        Arrays.sort(arr);
        // Set the first element to 1
        arr[0] = 1;
        for (int i = 1; i < arr.length; i++) {
            // If the difference between the current element and the previous element is greater than 1
            // then set the current element to previous element + 1
            if (arr[i] - arr[i - 1] > 1) {
                arr[i] = arr[i - 1] + 1;
            }
        }
        return arr[arr.length - 1];
    }

    public static void main(String[] args) {
        // Test Case - 1
        int[] arr1 = {2, 2, 1, 2, 1};
        System.out.println(maximumElementAfterDecrementingAndRearranging(arr1)); // Output: 2

        // Test Case - 2
        int[] arr2 = {100, 1, 1000};
        System.out.println(maximumElementAfterDecrementingAndRearranging(arr2)); // Output: 3

        // Test Case - 3
        int[] arr3 = {1, 2, 3, 4, 5};
        System.out.println(maximumElementAfterDecrementingAndRearranging(arr3)); // Output: 5
    }
}