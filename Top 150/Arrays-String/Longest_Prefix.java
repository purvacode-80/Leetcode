// 14. Longest Common Prefix

import java.util.Arrays;

public class Longest_Prefix {
    public static String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length == 0) {
            return "";  // Return empty string if the input array is null or empty
        }

        // Sorting the array of strings will bring the strings with common prefixes together
        // Example: ["flower", "flow", "flight"] will be sorted to ["flight", "flow", "flower"]
        Arrays.sort(strs);  // Sort the array of strings

        String first = strs[0];
        String last = strs[strs.length - 1];
        int idx = 0;

        // Compare the first and last strings character by character until a mismatch is found
        while(idx < first.length() && idx < last.length() && first.charAt(idx) == last.charAt(idx))
            idx++;  // Increment the index until characters match

        // Return substring of the first string from index 0 to idx (exclusive) 
        return first.substring(0,idx);
    }

    public static void main(String[] args) {
        // Test Case - 1
        String[] strs1 = {"flower","flow","flight"};
        System.out.println(longestCommonPrefix(strs1)); // Output: "fl"

        // Test Case - 2
        String[] strs2 = {"dog","racecar","car"};
        System.out.println(longestCommonPrefix(strs2)); // Output: ""
    }
}
