// 242. Valid Anagram

import java.util.HashMap;

public class Anagrams {
    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) 
            return false;

        HashMap<Character, Integer> map = new HashMap<>();

        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for (char c : t.toCharArray()) {
            if (!map.containsKey(c) || map.get(c) == 0) {
                return false;
            }
            map.put(c, map.get(c) - 1);
        }
        return true;
    }

    public static void main(String[] args) {
        // Test Case - 1
        String s1 = "anagram";
        String t1 = "nagaram";
        System.out.println(isAnagram(s1, t1)); // Output: true

        // Test Case - 2
        String s2 = "rat";
        String t2 = "car";
        System.out.println(isAnagram(s2, t2)); // Output: false
    }
}
