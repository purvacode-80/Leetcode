// 3. Longest Substring Without Repeating Characters

import java.util.HashSet;

public class Substring_Without_Repeating_Characters {
    public static int lengthOfLongestSubstring(String s) {
        int maxLen = 0;
        int left = 0;
        HashSet<Character> set = new HashSet<>();

        for (int right = 0; right < s.length(); right++) {
            while (set.contains(s.charAt(right))) {
                set.remove(s.charAt(left));
                left++;
            }
            set.add(s.charAt(right));
            maxLen = Math.max(maxLen, right - left + 1);
        }
        return maxLen;
    }
    public static void main(String[] args) {
        // Test Case - 1
        String s1 = "abcabcbb";
        System.out.println(lengthOfLongestSubstring(s1)); // Output: 3

        // Test Case - 2
        String s2 = "bbbbb";
        System.out.println(lengthOfLongestSubstring(s2)); // Output: 1

        // Test Case - 3
        String s3 = "pwwkew";
        System.out.println(lengthOfLongestSubstring(s3)); // Output: 3
    }
}
