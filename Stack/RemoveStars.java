// 2390. Removing Stars From a String

import java.util.Stack;

public class RemoveStars {

    public static String removeStars(String s) {
        // Create a stack to hold characters encountered so far without stars
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (c == '*') {
                stack.pop();    // Remove the last character added before the star
            } else {
                stack.push(c);  // Add the current character to the stack
            }
        }

        // Create string from stack
        StringBuilder result = new StringBuilder();
        for (char c : stack) {
            result.append(c);
        }
        return result.toString();
    }

    public static void main(String[] args) {
        // Test Case - 1
        String input1 = "leet**cod*e";
        String output1 = removeStars(input1);
        System.out.println("Input: " + input1);
        System.out.println("Output: " + output1); // Expected Output: "lecoe"

        // Test Case - 2
        String input2 = "erase*****";
        String output2 = removeStars(input2);
        System.out.println("Input: " + input2);
        System.out.println("Output: " + output2); // Expected Output: ""
    }
}