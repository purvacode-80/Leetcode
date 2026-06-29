// 3614. Process String with Special Operations II

public class Process_String_Special_Operations_II {
    public static char processStr(String s, long k) {
        int n = s.length();
        long[] len = new long[n + 1];

        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);

            if (ch == '*') {
                // length decreased by 1 - Last character removed
                len[i + 1] = Math.max(0, len[i] - 1);

            } else if (ch == '#') {
                // length doubled - String duplicated
                len[i + 1] = Math.min(Long.MAX_VALUE / 2, len[i] * 2);

            } else if (ch == '%') {
                // length remains unchanged - String reversed
                len[i + 1] = len[i];

            } else {
                // length increased by 1 - Character added
                len[i + 1] = len[i] + 1;
            }
        }

        if (k >= len[n]) {
            return '.';
        }

        for (int i = n - 1; i >= 0; i--) {
            char ch = s.charAt(i);
            long currLen = len[i + 1];
            long prevLen = len[i];

            if (ch == '%') {
                k = currLen - 1 - k;
            } else if (ch == '#') {
                if (k >= prevLen) {
                    k -= prevLen;
                }
            } else if (ch == '*') {
                // length decreased by 1
                // removed last character
                // any valid index remains unchanged
            } else {
                if (k == prevLen) {
                    return ch;
                }
            }
        }
        return '.';
    }

    public static void main(String[] args) {
        // Test Case - 1
        String s1 = "a#b%*";
        long k1 = 1; 
        System.out.println(processStr(s1, k1)); // Output: 'a'

        // Test Case - 2
        String s2 = "cd%#*#";
        long k2 = 3;
        System.out.println(processStr(s2, k2)); // Output: 'd'

        // Test Case - 3
        String s3 = "z*#";
        long k3 = 0;
        System.out.println(processStr(s3, k3)); // Output: '.'
    }
}
