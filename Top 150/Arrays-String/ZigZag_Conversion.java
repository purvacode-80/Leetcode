// 6. Zigzag Conversion

import java.util.ArrayList;
import java.util.List;

public class ZigZag_Conversion {
    public static String convert(String s, int numRows) {
        if(numRows == 1 || s.length() <= numRows) {
            // If numRows is 1 or the string length is less than or equal to numRows, return the original string
            return s;
        }

        int idx = 0;  // Index to keep track of the current position in the input string
        int d = 1;    // Direction variable to determine whether we are moving down or up the zigzag pattern
        // d = 1 : Downwards
        // d = -1 : Upwards
        StringBuilder result = new StringBuilder();

        List<Character>[] rows = new ArrayList[numRows];
        
        for(int i = 0; i < numRows; i++) {
            rows[i] = new ArrayList<>();
        }

        for (char c : s.toCharArray()) {
            rows[idx].add(c);

            if (idx == 0) d = 1;  // Change direction to downwards when we reach the top row
            else if (idx == numRows - 1) d = -1;  // Change direction to upwards when we reach the bottom row
            idx += d;  // Move to the next row based on the current direction
        }

        for (List<Character> row : rows) {
            for (char c : row) {
                result.append(c);
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        // Test Case - 1
        String s1 = "PAYPALISHIRING";
        // Zig Zag pattern for numRows = 3:
        // P   A   H   N
        // A P L S I I G
        // Y   I   R
        int numRows1 = 3;
        System.out.println(convert(s1, numRows1)); // Output: "PAHNAPLSIIGYIR"

        // Test Case - 2
        String s2 = "PAYPALISHIRING";
        int numRows2 = 4;
        System.out.println(convert(s2, numRows2)); // Output: "PINALSIGYAHRPI"
    }
}
