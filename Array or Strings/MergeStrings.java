// 1768. Merge Strings Alternately

public class MergeStrings {
    public static String mergeAlternately(String word1, String word2) {
        StringBuilder merged = new StringBuilder();
        int i = 0;

        for (i = 0; i < word1.length() && i < word2.length(); i++) {
            merged.append(word1.charAt(i));
            merged.append(word2.charAt(i));
        }

        // Append the remaining characters from the longer string
        if (i < word1.length()) {
            merged.append(word1.substring(i));
        } else if (i < word2.length()) {
            merged.append(word2.substring(i));
        }
        return merged.toString();
}

public static void main(String[] args) {
        String word1 = "abc";
        String word2 = "pqr";
        System.out.println(mergeAlternately(word1, word2)); // Output: "apbqcr"
        
        word1 = "ab";
        word2 = "pqrs";
        System.out.println(mergeAlternately(word1, word2)); // Output: "apbqrs"
        
        word1 = "abcd";
        word2 = "pq";
        System.out.println(mergeAlternately(word1, word2)); // Output: "apbqcd"
    }
}