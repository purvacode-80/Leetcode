// 13. Roman to Integer

import java.util.HashMap;

public class Roman_Integer {
    public static int romanToInt(String s) {
        int res = 0;    // Store final integer result
        // HashMap to store the integer values of Roman numerals
        HashMap<Character,Integer> map = new HashMap<>();

        // I             1
        // V             5
        // X             10
        // L             50
        // C             100
        // D             500
        // M             1000
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        for (int i = 0; i < s.length() - 1; i++) {
            // Current character's value is less than the next character's value, we need to subtract it from the result
            // Example : IV = 5 - 1 = 4, IX = 10 - 1 = 9, XL = 50 - 10 = 40, XC = 100 - 10 = 90, CD = 500 - 100 = 400, CM = 1000 - 100 = 900
            if (map.get(s.charAt(i)) < map.get(s.charAt(i+1))) {
                res -= map.get(s.charAt(i));
            }
            // Otherwise, we simply add the value of the current character to the result
            // Example : III = 1 + 1 + 1 = 3, LVIII = 50 + 5 + 1 + 1 + 1 = 58
            else {
                res += map.get(s.charAt(i));
            }
        }

        // Finally, we need to add the value of the last character in the string to the result, as it has not been processed in the loop
        return res + map.get(s.charAt(s.length() - 1));
    }

    public static void main(String[] args) {
        // Test Case - 1
        String s1 = "III";
        System.out.println(romanToInt(s1)); // Output: 3

        // Test Case - 2
        String s2 = "LVIII";
        System.out.println(romanToInt(s2)); // Output: 58

        // Test Case - 3
        String s3 = "MCMXCIV";
        System.out.println(romanToInt(s3)); // Output: 1994
    }
}
