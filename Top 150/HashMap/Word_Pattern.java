// 290. Word Pattern

import java.util.HashMap;

public class Word_Pattern {
    public static boolean wordPattern(String pattern, String s) {
        HashMap<Character, String> map = new HashMap<>();
        String[] arr = s.split("\\s+");

        if (pattern.length() != arr.length) return false;

        for (int i = 0; i < pattern.length(); i++) {
            char c = pattern.charAt(i);

            if (map.containsKey(c)) {
                if (!map.get(c).equals(arr[i])) 
                    return false;
            } else {
                if (map.containsValue(arr[i]))
                    return false;
                map.put(c, arr[i]);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        // Test Case - 1
        String pattern1 = "abba";
        String s1 = "dog cat cat dog";
        System.out.println(wordPattern(pattern1, s1)); // Output: true

        // Test Case - 2
        String pattern2 = "abba";
        String s2 = "dog cat cat fish";
        System.out.println(wordPattern(pattern2, s2)); // Output: false

        // Test Case - 3
        String pattern3 = "aaaa";
        String s3 = "dog cat cat dog";
        System.out.println(wordPattern(pattern3, s3)); // Output: false
    }
}
