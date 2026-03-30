// 435. Non-overlapping Intervals

import java.util.Arrays;

public class Non_Overlapping_Intervals {
    public static int eraseOverlapIntervals(int[][] intervals) {
        // Sort intervals based on their end times
        Arrays.sort(intervals, (a,b) -> a[1] - b[1]);

        int count = 0;
        int prevEnd = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {
            if (prevEnd > intervals[i][0])  count++;
            else prevEnd = intervals[i][1];
        }
        return count;
    }

    public static void main(String[] args) {
        // Test Case - 1
        int[][] intervals = {{1, 2}, {2, 3}, {3, 4}, {1, 3}};
        System.out.println(eraseOverlapIntervals(intervals));   // Output: 1 - (1,3) removed

        // Test Case - 2
        int[][] intervals2 = {{1, 2}, {1, 2}, {1, 2}};
        System.out.println(eraseOverlapIntervals(intervals2));  // Output: 2 - (1,2) removed twice

        // Test Case - 3
        int[][] intervals3 = {{1, 2}, {2, 3}};
        System.out.println(eraseOverlapIntervals(intervals3));  // Output: 0 - no intervals removed
    }
}