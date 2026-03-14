// 875. Koko Eating Bananas

import java.util.Arrays;

public class Koko_Bananas {
    public static int minEatingSpeed(int[] piles, int h) {
        // Min speed can be 1 banana per hour
        int left =  1;
        // Max speed can be size of largest pile
        int right = Arrays.stream(piles).max().getAsInt();
        int ans = right;

        // Binary search
        while (left <= right) {
            int mid = left + ((right - left) / 2);
            // Check if Koko can finish eating all bananas at speed mid within h hours
            if (canFinish(piles, h, mid)) {
                // If Koko can finish, try to find a smaller speed
                ans = mid;
                right = mid - 1;
            }
            // If Koko cannot finish, try to find a larger speed
            else {
                left = mid + 1;
            }
        }
        return ans;
    }

    // Function to check if Koko can finish eating all bananas at speed k within h hours
    public static boolean canFinish(int[] piles, int h, int k) {
        long hours = 0;
        for (int pile : piles) {
            // Calculate hours needed to eat current pile at speed k
            // Even if there are less bananas than k, Koko will still take 1 hour to eat that pile
            hours += Math.ceilDiv(pile, k);
        }
        return hours <= h;
    }

    public static void main(String[] args) {
        // Test Case - 1
        int[] piles = {3, 6, 7, 11};
        int h = 8;
        int minSpeed = minEatingSpeed(piles, h);
        System.out.println("Minimum Eating Speed = " + minSpeed); // Output: 4

        // Test Case - 2
        piles = new int[]{30, 11, 23, 4, 20};
        h = 6;
        minSpeed = minEatingSpeed(piles, h);
        System.out.println("Minimum Eating Speed = " + minSpeed); // Output: 23

        // Failed Test Case - 3
        // piles = new int[]{805306368, 805306368, 805306368};
        // h = 1000000000;
        // minSpeed = minEatingSpeed(piles, h);
        // System.out.println("Minimum Eating Speed = " + minSpeed); // Output: 3
        // Showing output 1 instead of 3 because of integer overflow in hours calculation. To fix this, we can use long data type for hours variable in canFinish function.
    }
}
