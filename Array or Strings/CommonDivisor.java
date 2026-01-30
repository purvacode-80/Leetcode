// 1071. Greatest Common Divisor of Strings

class CommonDivisor {
    public static String gcdOfStrings(String str1, String str2) {
        if(!(str1 + str2).equals(str2 + str1)) {
            return "";
        }
        int gcdLength = gcd(str1.length(), str2.length());
        return str1.substring(0, gcdLength);
    }

    private static int gcd(int len1, int len2) {
        int minVal = Math.min(len1, len2);
        for(int i=minVal;i>0;i--) {
            if(len1%i == 0 && len2%i == 0) {
                return i;
            }
        }
        return 1;
    }

    public static void main(String[] args) {
        // Test Case - 1
        String str1 = "ABCABC";
        String str2 = "ABC";
        System.out.println(gcdOfStrings(str1, str2)); // Output: "ABC"

        // Test Case - 2
        str1 = "ABABAB";
        str2 = "ABAB";
        System.out.println(gcdOfStrings(str1, str2)); // Output: "AB"

        // Test Case - 3
        str1 = "LEET";
        str2 = "CODE";
        System.out.println(gcdOfStrings(str1, str2)); // Output: ""
    }
}