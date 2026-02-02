import java.util.Stack;

public class AsteroidCollision {
    public static int[] asteroidCollision(int[] asteroids) {
        // Use a stack to keep track of the surviving asteroids
        Stack<Integer> stack = new Stack<>();

        boolean destroyed = false;

        // For each asteriod check if there's a possibility of collision
        for (int a : asteroids) {
            // Collision occurs only when a right-moving asteroid meets a left-moving one
            // i.e., when the top of the stack is positive and the current asteroid is negative
            // Negative asteroid moving left and checking for collision
            while (!stack.isEmpty() && stack.peek() > 0 && a < 0) {
                int top = stack.pop();
                if (top > Math.abs(a)) {
                    stack.push(top);
                    destroyed = true;
                    break;
                } else if (top == Math.abs(a)) {
                    destroyed = true;
                    break;
                }
            }
            if (!destroyed) {
                stack.push(a);
            }
            destroyed = false;
        }
        int[] result = new int[stack.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = stack.get(i);
        }
        return result;
    }

    public static void main(String[] args) {
        // Test Case - 1
        int[] asteroids1 = {5, 10, -5};
        int[] result1 = asteroidCollision(asteroids1);
        System.out.print("Output: ");
        for (int r : result1) {
            System.out.print(r + " ");
        }
        System.out.println(); // Expected Output: [5, 10]

        // Test Case - 2
        int[] asteroids2 = {8, -8};
        int[] result2 = asteroidCollision(asteroids2);
        System.out.print("Output: ");
        for (int r : result2) {
            System.out.print(r + " ");
        }

        System.out.println(); // Expected Output: []
        // Test Case - 3
        int[] asteroids3 = {10, 2, -5};
        int[] result3 = asteroidCollision(asteroids3);
        System.out.print("Output: ");
        for (int r : result3) {
            System.out.print(r + " ");  
        }
        System.out.println(); // Expected Output: [10]

        // Test Case - 4
        int[] asteroids4 = {3,5,-6,2,-1,4};
        int[] result4 = asteroidCollision(asteroids4);
        System.out.print("Output: ");
        for (int r : result4) {
            System.out.print(r + " ");
        }
        System.out.println(); // Expected Output: [-2, -1, 1, 2]
    }
}
