// 2215. Find the Difference of Two Arrays
import java.util.*;

public class difference {
    public static List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
    
        // Create sets to store unique elements from both arrays
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        
        // Populate the sets
        for (int num : nums1) {
            set1.add(num);
        }
        
        for (int num : nums2) {
            set2.add(num);
        }
        
        // Find elements unique to each set
        List<Integer> onlyInNums1 = new ArrayList<>();
        List<Integer> onlyInNums2 = new ArrayList<>();
        
        for (int num : set1) {
            if (!set2.contains(num)) {  // Check if num is not in set2
                onlyInNums1.add(num);
            }
        }
        
        for (int num : set2) {
            if (!set1.contains(num)) {  // Check if num is not in set1
                onlyInNums2.add(num);
            }
        }
        
        // Create return list which contain both unique lists
        List<List<Integer>> result = new ArrayList<>();
        result.add(onlyInNums1);
        result.add(onlyInNums2);
        
        return result;
    }

    public static void main(String[] args) {
        //Test Case 1
        int[] nums1 = {1, 2, 3};
        int[] nums2 = {2, 4, 6};
        System.out.println(findDifference(nums1, nums2)); // Expected: [[1, 3], [4, 6]]

        //Test Case 2
        int[] nums3 = {1, 2, 3, 3};
        int[] nums4 = {1, 1, 2, 2};
        System.out.println(findDifference(nums3, nums4)); // Expected: [[3], []]
    }
}
