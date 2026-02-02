// 1207. Unique Number of Occurrences
import java.util.*;

public class UniqueOccurence {
    public static boolean uniqueOccurrences(int[] arr) {
        // Count occurrences of each number
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int num : arr) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }

        // Check if all occurrence counts are unique
        Set<Integer> occurrenceSet = new HashSet<>(countMap.values());
        return occurrenceSet.size() == countMap.size();
    }

    public static void main(String[] args) {
        // Test Case - 1
        int[] arr1 = {1, 2, 2, 1, 1, 3};
        System.out.println(uniqueOccurrences(arr1)); // Output: true

        // Test Case - 2
        int[] arr2 = {1, 2};
        System.out.println(uniqueOccurrences(arr2)); // Output: false

        // Test Case - 3
        int[] arr3 = {-3, 0, 1, -3, 1, 1, 1, -3, 10, 0};
        System.out.println(uniqueOccurrences(arr3)); // Output: true
    }
}
