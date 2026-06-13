// 30. Substring with Concatenation of All Words

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Concatenation_of_All_Words {
    public static List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        int wordCount = words.length;
        int wordLen = words[0].length();

        Map<String, Integer> wordMap = new HashMap<>();

        for (String word : words) {
            wordMap.put(word,wordMap.getOrDefault(word, 0)+1);
        }

        // Try all possible offset
        for(int offset = 0; offset < wordLen; offset++) {
            int left = offset;
            int count = 0;
            Map<String, Integer> seen = new HashMap<>();

            for(int right = offset; right + wordLen <= s.length(); right += wordLen) {
                String word = s.substring(right, right + wordLen);

                // Check if word exists in dictionary
                if(wordMap.containsKey(word)) {
                    seen.put(word, seen.getOrDefault(word, 0)+1);
                    count++;

                    // Remove too many occurences
                    while (seen.get(word) > wordMap.get(word)) {
                        String leftWord = s.substring(left, left + wordLen);
                        seen.put(leftWord, seen.get(leftWord) - 1);
                        left += wordLen;
                        count--;
                    }

                    // Valid Window Found
                    if (count == wordCount) {
                        result.add(left);
                        String leftWord = s.substring(left, left + wordLen);
                        seen.put(leftWord, seen.get(leftWord) - 1);
                        left += wordLen;
                        count--;
                    }
                }
                else {
                    seen.clear();
                    left = right + wordLen;
                    count = 0;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        // Test Case - 1
        String s1 = "barfoothefoobarman";
        String[] words1 = {"foo","bar"};
        System.out.println(findSubstring(s1, words1)); // Output: [0, 9]

        // Test Case - 2
        String s2 = "wordgoodgoodgoodbestword";
        String[] words2 = {"word","good","best","word"};
        System.out.println(findSubstring(s2, words2)); // Output: []

        // Test Case - 3
        String s3 = "barfoofoobarthefoobarman";
        String[] words3 = {"bar","foo","the"};
        System.out.println(findSubstring(s3, words3)); // Output: [6, 9, 12]
    }
}
