// 17. Letter Combinations of a Phone Number

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Phone_Number {
    public static List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();

        if (digits == null || digits.length() == 0) return res;

        Map<Character,String> digitToLetters = new HashMap<>();
        digitToLetters.put('2', "abc");
        digitToLetters.put('3', "def");
        digitToLetters.put('4', "ghi");
        digitToLetters.put('5', "jkl");
        digitToLetters.put('6', "mno");
        digitToLetters.put('7', "pqrs");
        digitToLetters.put('8', "tuv");
        digitToLetters.put('9', "wxyz");

        backtrack(digits, 0, new StringBuilder(), res, digitToLetters);

        return res;
    }

    private static void backtrack(String digits, int index, StringBuilder comb, List<String> res, Map<Character,String> digitToLetters) {
        if(index == digits.length()) {
            res.add(comb.toString());
            return;
        }

        String letters = digitToLetters.get(digits.charAt(index));
        for (char letter : letters.toCharArray()) {
            comb.append(letter);
            backtrack(digits, index + 1, comb, res, digitToLetters);
            comb.deleteCharAt(comb.length() - 1);
        }
    }

    public static void main(String[] args) {
        // Test Case - 1 
        String digits1 = "23";
        List<String> result1 = letterCombinations(digits1);
        System.out.println("Test Case - 1: " + result1); // Expected Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]

        // Test Case - 2
        String digits2 = "2";
        List<String> result2 = letterCombinations(digits2);
        System.out.println("Test Case - 2: " + result2); // Expected Output: ["a","b","c"]
    }
}