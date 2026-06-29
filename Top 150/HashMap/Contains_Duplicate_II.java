// 219. Contains Duplicate II

import java.util.HashMap;

public class Contains_Duplicate_II {
    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                int index = map.get(nums[i]);
                if (Math.abs(i - index) <= k)
                    return true;
            } 
            map.put(nums[i], i);
        }
        return false;
    }

    public static void main(String[] args) {
        // Test Case - 1
        int[] nums1 = {1,2,3,1};
        int k1 = 3;
        System.out.println("Output : " + containsNearbyDuplicate(nums1, k1));   // Output : true

        // Test Case - 1
        int[] nums2 = {1,0,1,1};
        int k2 = 1;
        System.out.println("Output : " + containsNearbyDuplicate(nums2, k2));   // Output : true

        // Test Case - 1
        int[] nums3 = {1,2,3,1,2,3};
        int k3 = 2;
        System.out.println("Output : " + containsNearbyDuplicate(nums3, k3));   // Output : false
    }
}