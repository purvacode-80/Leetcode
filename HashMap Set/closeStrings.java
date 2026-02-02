import java.util.Arrays;

public class closeStrings {
    public static boolean close_Strings(String word1, String word2) {
        
        // Check if length of both the string is equal
        if(word1.length() != word2.length()) {
            return false;
        }

        // Create 2 frequency arrays for storing frequencies of each alphabets from a to z
        int[] freq1 = new int[26];
        int[] freq2 = new int[26];

        // Store frequencies of each character in the string
        for (char c : word1.toCharArray()) {    // Word 1
            freq1[c - 'a']++;
        }
        for (char c : word2.toCharArray()) {    // Word 2
            freq2[c - 'a']++;
        }

        //Both must contain same set of characters
        for(int i=0; i<26; i++) {
            if((freq1[i] == 0 && freq2[i] != 0) || (freq1[i] != 0 && freq2[i] == 0)) {
                return false;
            }
        }

        //Sort the array to check if the frequency counts are matching
        Arrays.sort(freq1);
        Arrays.sort(freq2);

        return Arrays.equals(freq1, freq2);
    }

    public static void main(String[] args) {
        // Test Case - 1
        String word1 = "abc";
        String word2 = "bca";
        close_Strings(word1, word2);    // true

        // Test Case - 1
        String word3 = "a";
        String word4 = "aa";
        close_Strings(word3, word4);    // false

        // Test Case - 1
        String word5 = "cabbba";
        String word6 = "abbccc";
        close_Strings(word5, word6);    // true
    }
}
