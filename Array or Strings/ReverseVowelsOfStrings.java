// 345. Reverse Vowels of a String

public class ReverseVowelsOfStrings {
    public static String reverseVowels(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }

        char[] chars = s.toCharArray();
        int start = 0;
        int end = chars.length - 1;

        while(start <= end) {
            if(!isVowel(chars[start])) {
                start++;
            } else if(!isVowel(chars[end])) {
                end--;
            } else {
                // Swap vowels
                char temp = chars[start];
                chars[start] = chars[end];
                chars[end] = temp;
                start++;
                end--;
            }
        }
        return new String(chars);
    }

    private static boolean isVowel(char c) {
        return "aeiouAEIOU".indexOf(c) != -1;
    }

    public static void main(String[] args) {
        String input = "IceCreAm";
        String result = reverseVowels(input);
        System.out.println("Reverse of " + input + " is " + result);    // Output: "IceCreAm" -> "AceCrIm"
        input = "leetcode";
        result = reverseVowels(input);
        System.out.println("Reverse of " + input + " is " + result);    // Output: "leetcode" -> "leotcede"
    }
}
