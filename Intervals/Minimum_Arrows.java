// 452. Minimum Number of Arrows to Burst Balloons

import java.util.Arrays;

public class Minimum_Arrows {
    public static int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (a,b) -> Integer.compare(a[1], b[1]));
        int count = 1;
        int prevEnd = points[0][1];

        for (int i = 1; i < points.length; i++) {
            if (prevEnd < points[i][0]) {
                count++;
                prevEnd = points[i][1];
            }
        }
        return count;
    }

    public static void main(String[] args) {
        // Test Case - 1
        int[][] points = {{10,16}, {2,8}, {1,6}, {7,12}};
        System.out.println(findMinArrowShots(points));  
        // Output: 2 - (2,8) and (1,6) can be burst with one arrow each 
        // and (10,16) and (7,12) can be burst with one arrow each

        // Test Case - 2
        int[][] points2 = {{1,2}, {3,4}, {5,6}, {7,8}};
        System.out.println(findMinArrowShots(points2));
        // Output: 4 - Each balloon requires a separate arrow

        // Test Case - 3
        int[][] points3 = {{1,2}, {2,3}, {3,4}, {4,5}};
        System.out.println(findMinArrowShots(points3));
        // Output: 2 - (1,2) and (3,4) can be burst with one arrow each
        // and (2,3) and (4,5) can be burst with one arrow each
    }
}
