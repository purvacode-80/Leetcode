// 202. Happy Number

import java.util.HashSet;

public class Happy_Number {
    public static boolean isHappy(int n) {
        // Use a HashSet to keep track of numbers we've seen
        HashSet<Integer> seen = new HashSet<>();
        
        // Continue the process until we either reach 1 (happy number) or enter a loop (not happy number)
        while (n != 1 && !seen.contains(n)) {
            seen.add(n);
            n = getSumOfSquares(n);
        }
        
        return n == 1;
    }
    
    private static int getSumOfSquares(int n) {
        int sum = 0;
        while (n > 0) {
            // Get the last digit of n
            int digit = n % 10;
            // Add the square of the digit to the sum
            sum += digit * digit;
            // Remove the last digit from n
            n /= 10;
        }
        return sum;
    }

    public static void main(String[] args) {
        // Test Case - 1
        int n1 = 19;
        boolean result1 = isHappy(n1);
        System.out.println("Input: " + n1 + " | Output: " + result1); // Output: true

        // Test Case - 2
        int n2 = 2;
        boolean result2 = isHappy(n2);
        System.out.println("Input: " + n2 + " | Output: " + result2); // Output: false
    }
}
