// 1268. Search Suggestions System

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Suggestion_System_Brute {
    public static List<List<String>> suggestedProducts(String[] products, String searchWord) {
        // Sort the products array to ensure lexicographical order
        Arrays.sort(products);  
        List<List<String>> result = new ArrayList<>();

        // For each prefix of the searchWord, find up to 3 products that start with that prefix
        for (int i = 0; i < searchWord.length(); i++) {
            List<String> suggestions = new LinkedList<>();

            // Find prefix by taking substring of searchWord from index 0 to i+1
            // Substring begins at index 0 and extends to index i (inclusive), hence i+1
            // Does not include the character at index i+1
            String prefix = searchWord.substring(0,i+1);

            for (String prod : products) {
                // Check if the product starts with the current prefix and add it to suggestions if it does
                if (prod.startsWith(prefix))    suggestions.add(prod);
                // Already have 3 suggestions - Break the loop
                if (suggestions.size() == 3)    break;
            }
            result.add(suggestions);
        }
        return result;
    }

    // Time Complexity: O(n log n + m * n) where n is the number of products and m is the length of searchWord
    // Space Complexity: O(m * k) where m is the length of searchWord and k is the number of suggestions (up to 3)

    public static void main(String[] args) {
        // Test Case - 1
        String[] products1 = {"mobile","mouse","moneypot","monitor","mousepad"};
        String searchWord1 = "mouse";

        List<List<String>> result1 = suggestedProducts(products1, searchWord1);
        System.out.println(result1);  
        // Output: [["mobile","moneypot","monitor"],
        // ["mobile","moneypot","monitor"],
        // ["mouse","mousepad"],
        // ["mouse","mousepad"],
        // ["mouse","mousepad"]]

        // Test Case - 2
        String[] products2 = {"havana"};
        String searchWord2 = "havana";
        List<List<String>> result2 = suggestedProducts(products2, searchWord2);
        System.out.println(result2);
        // Output: [["havana"], ["havana"], ["havana"], ["havana"], ["havana"], ["havana"]]
    }
}
