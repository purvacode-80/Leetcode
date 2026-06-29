// 383. Ransom Note

import java.util.HashMap;
import java.util.Map;

public class Ransom_Note {
    public static boolean canConstruct(String ransomNote, String magazine) {
        if (ransomNote.length() > magazine.length()) {
            return false;
        }
        
        Map<Character,Integer> map = new HashMap<>();
        for (char c : magazine.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for (char c : ransomNote.toCharArray()) {
            if (map.containsKey(c) && map.get(c) > 0) {
                map.put(c, map.get(c) - 1);
            }
            else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        // Test Case - 1
        String ransomNote1 = "a";   
        String magazine1 = "b";
        System.out.println(canConstruct(ransomNote1, magazine1)); // Output: false

        // Test Case - 2
        String ransomNote2 = "aa";
        String magazine2 = "ab";
        System.out.println(canConstruct(ransomNote2, magazine2)); // Output: false

        // Test Case - 3
        String ransomNote3 = "aa";
        String magazine3 = "aab";
        System.out.println(canConstruct(ransomNote3, magazine3)); // Output: true
    }
}