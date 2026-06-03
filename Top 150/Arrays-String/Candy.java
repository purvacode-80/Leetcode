// 135. Candy

public class Candy {
    public static int candy(int[] ratings) {
        int n = ratings.length;
        // Create an array candies to keep record of candies
        int[] candies = new int[n];
        int totalCandies = 0;

        // Initialize each student with at least 1 candy
        for (int i = 0; i < n; i++) candies[i] = 1;

        // Left - Traverse from start to end
        for (int i = 1; i < n; i++) {
            // If the current rating is greater than the previous rating
            // Give one more candy than the previous student
            if(ratings[i-1] < ratings[i])   candies[i] = candies[i-1] + 1;
        }

        // Right - Traverse from end to start
        for (int i = n - 1; i > 0; i--) {
            // If the previous rating is greater than the current rating
            // Give one more candy than the current student, but also ensure that the previous student has at least as many candies as the current student
            if (ratings[i-1] > ratings[i])
                candies[i-1] = Math.max(candies[i] + 1, candies[i-1]);
            totalCandies += candies[i-1];   // Add the candies for the previous student to the total count
        }

        // Add the candies for the last student to the total count and return the result
        return totalCandies + candies[n-1];
    }

    public static void main(String[] args) {
        // Test Case - 1
        int[] ratings1 = {1, 0, 2};
        System.out.println(candy(ratings1)); // Output: 5

        // Test Case - 2
        int[] ratings2 = {1, 2, 2};
        System.out.println(candy(ratings2)); // Output: 4
    }
}
