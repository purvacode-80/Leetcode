// 1431. Kids With the Greatest Number of Candies

import java.util.ArrayList;
import java.util.List;

class GreatestCandy {
    public static List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> result = new ArrayList<>();
        int maxCandies = 0;

        // Find the maximum number of candies any kid has
        for(int candy : candies) {
            maxCandies = Math.max(maxCandies, candy);
        }

        // Determine if each kid can have the greatest number of candies
        for(int candy : candies) {
            result.add(candy + extraCandies >= maxCandies);
        }

        return result;
    }

    public static void main(String[] args) {
        int [] candies = {2, 3, 5, 1, 3};
        int extraCandies = 3;

        List<Boolean> result = kidsWithCandies(candies, extraCandies);
        System.out.println(result); 
        // Output: [true, true, true, false, true]
    }
}