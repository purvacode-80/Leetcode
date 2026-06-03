// 28. Find the Index of the First Occurrence in a String

public class First_Occurence {
    public static int strStr(String haystack, String needle) {
        return haystack.indexOf(needle);
    }

    public static void main(String[] args) {
        // Test Case - 1
        String haystack1 = "sadbutsad";
        String needle1 = "sad";
        System.out.println(strStr(haystack1, needle1)); // Output: 0

        // Test Case - 2
        String haystack2 = "leetcode";
        String needle2 = "leeto";
        System.out.println(strStr(haystack2, needle2)); // Output: -1
    }
}