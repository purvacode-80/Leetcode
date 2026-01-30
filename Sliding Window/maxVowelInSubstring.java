public class maxVowelInSubstring {
    public static int maxVowels(String s, int k) {
        int maxVowelsCount = 0;
        int currentVowels = 0;

        // First count vowels in the first k characters
        for(int i=0; i<k; i++) {
            if(isVowel(s.charAt(i))) {
                currentVowels++;
            }
        }
        maxVowelsCount = currentVowels;

        // Now slide the window across the string
        for(int i=k; i<s.length(); i++) {
            // Remove the character going out of the window
            if(isVowel(s.charAt(i - k))) {
                currentVowels--;
            }
            // Add the new character coming into the window
            if(isVowel(s.charAt(i))) {
                currentVowels++;
            }
            // Update maxVowelsCount if needed
            maxVowelsCount = Math.max(maxVowelsCount, currentVowels);
        }
        return maxVowelsCount;
    }

    private static boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }

    public static void main(String[] args) {
        // Test Case - 1
        String s = "abciiidef";
        int k = 3;
        System.out.println("Maximum number of vowels in a substring of length " + k + " : " + maxVowels(s, k)); // Output: 3

        // Test Case - 2
        s = "aeiou";
        k = 2;
        System.out.println("Maximum number of vowels in a substring of length " + k + " : " + maxVowels(s, k)); // Output: 2

        // Test Case - 3
        s = "leetcode";
        k = 3;
        System.out.println("Maximum number of vowels in a substring of length " + k + " : " + maxVowels(s, k)); // Output: 2
    }
}
