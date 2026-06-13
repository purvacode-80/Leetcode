// 76. Minimum Window Substring

public class Minimum_Window_Substring {
    public static String minWindow(String s, String t) {
        if (s == null || t == null || s.length() < t.length()) {
            return "";
        }

        // Initialize frequency array for characters in t
        int[] freq = new int[128];
        for (char c : t.toCharArray()) {
            freq[c]++;
        }

        int left = 0, right = 0, count = t.length();
        int minLen = Integer.MAX_VALUE, start = 0;

        // Expand the right pointer to find a valid window
        while (right < s.length()) {
            char c = s.charAt(right);
            // If the character is needed, decrease the count
            if (freq[c] > 0) {
                count--;
            }
            freq[c]--;  // Decrease the frequency of the current character
            right++;    // Move the right pointer

            // Shrink the window from the left if it's valid
            while (count == 0) {
                if (right - left < minLen) {
                    minLen = right - left;
                    start = left;
                }

                // Move the left pointer and update the frequency and count
                char leftChar = s.charAt(left);
                freq[leftChar]++;
                // If the character is needed, increase the count
                if (freq[leftChar] > 0) {
                    count++;
                }
                left++;
            }
        }
        return minLen == Integer.MAX_VALUE ? "" : s.substring(start, start + minLen);
    }

    public static void main(String[] args) {
        // Test Case - 1
        String s1 = "ADOBECODEBANC";
        String t1 = "ABC";
        System.out.println(minWindow(s1, t1)); // Output: "BANC"

        // Test Case - 2
        String s2 = "a";
        String t2 = "a";
        System.out.println(minWindow(s2, t2)); // Output: "a"

        // Test Case - 3
        String s3 = "a";
        String t3 = "aa";
        System.out.println(minWindow(s3, t3)); // Output: ""
    }
}