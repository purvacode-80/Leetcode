// 3838. Weighted Word Mapping

public class Weighted_Word_Mapping {
    public static String mapWordWeights(String[] words,  int[] weights) {
        StringBuilder result = new StringBuilder();

        for (String word : words) {
            int sum = 0;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                sum += weights[c - 'a'];
            }
            int remainder = sum % 26;
            result.append((char)('z' - remainder));
        }
        return result.toString();
    }

    public static void main(String[] args) {
        // Test Case - 1
        String[] words1 = {"abcd", "def", "xyz"};
        int[] weights1 = {5, 3, 12, 14, 1, 2, 3, 2, 10, 6, 6, 9, 7, 8, 7, 10, 8, 9, 6, 9, 9, 8, 3, 7, 7, 2};
        String result1 = mapWordWeights(words1,  weights1);
        System.out.println(result1); // Output: "rij"

        // Test Case - 2
        String[] words2 = {"a", "b", "c"};
        int[] weights2 = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
        String result2 = mapWordWeights(words2,  weights2);
        System.out.println(result2); // Output: "yyy"

        // Test Case - 3
        String[] words3 = {"abcd"};
        int[] weights3 = {7, 5, 3, 4, 3, 5, 4, 9, 4, 2, 2, 7, 10, 2, 5, 10, 6, 1, 2, 2, 4, 1, 3, 4, 4, 5};
        String result3 = mapWordWeights(words3,  weights3);  
        System.out.println(result3);    // Output: "g"
    }
}
