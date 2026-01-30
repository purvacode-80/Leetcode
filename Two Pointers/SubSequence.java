// 392 - Is Subsequence

public class SubSequence {
    public static boolean isSubsequence(String s, String t) {
        int k = 0;   // Pointer for string s to track characters
        for (int i = 0; i < t.length() && k < s.length(); i++) {
            if (t.charAt(i) == s.charAt(k)) {
                k++;
            }
        }
        return k == s.length();
        //Return true if all characters of s are found in t in order
    }

    public static void main(String[] args) {
        // Test Case - 1
        String s = "abc";
        String t = "ahbgdc";
        System.out.println(isSubsequence(s, t));  // Output: true

        // Test Case - 2
        s = "axc";
        t = "ahbgdc";
        System.out.println(isSubsequence(s, t));  // Output: false
    }
}
