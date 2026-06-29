// 205. Isomorphic Strings

import java.util.HashMap;

public class Isomorphic_Strings {
    public static boolean isIsomorphic(String s, String t) {
        HashMap<Character, Integer> sMap = new HashMap<>();
        HashMap<Character, Integer> tMap = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            if (!sMap.containsKey(s.charAt(i)))
                sMap.put((s.charAt(i)), i);

            if (!tMap.containsKey(t.charAt(i)))
                tMap.put((t.charAt(i)), i);

            if (!(sMap.get(s.charAt(i)).equals(tMap.get(t.charAt(i)))))
                return false;
        }

        return true;
    }

    public static void main(String[] args) {
        // Test Case - 1
        String s1 = "egg";
        String t1 = "add";
        System.out.println(isIsomorphic(s1, t1)); // Output: true

        // Test Case - 2
        String s2 = "f11";
        String t2 = "b23";
        System.out.println(isIsomorphic(s2, t2)); // Output: false

        // Test Case - 3
        String s3 = "paper";
        String t3 = "title";
        System.out.println(isIsomorphic(s3, t3)); // Output: true
    }
}
