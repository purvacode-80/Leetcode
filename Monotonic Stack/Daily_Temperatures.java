// 739. Daily Temperatures

import java.util.Stack;

class Daily_Temperatures {
    public static int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        Stack<Integer> stack = new Stack<>();
        int[] results = new int[n];

        // For each temperature, we check if it's warmer than the temperature at the index on top of the stack.
        for(int i = 0; i < n; i++) {
            // If the current temperature is warmer than the temperature at the index on top of the stack, we pop from the stack and calculate the number of days until a warmer temperature.
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                results[stack.peek()] = i - stack.pop();
            }
            // Push the current index onto the stack.
            stack.push(i);
        }
        return results;
    }

    public static void main(String[] args) {
        // Test Case - 1
        int[] temperatures1 = {73, 74, 75, 71, 69, 72, 76, 73};
        int[] result1 = dailyTemperatures(temperatures1);
        System.out.println(java.util.Arrays.toString(result1));   // Output: [1, 1, 4, 2, 1, 1, 0, 0]

        // Test Case - 2
        int[] temperatures2 = {30, 40, 50, 60};
        int[] result2 = dailyTemperatures(temperatures2);
        System.out.println(java.util.Arrays.toString(result2)); // Output: [1, 1, 1, 0]

        // Test Case - 3
        int[] temperatures3 = {30, 60, 90};
        int[] result3 = dailyTemperatures(temperatures3);
        System.out.println(java.util.Arrays.toString(result3)); // Output: [1, 1, 0]
    }
}