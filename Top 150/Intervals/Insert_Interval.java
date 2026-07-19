// 57. Insert Interval

import java.util.ArrayList;
import java.util.List;

public class Insert_Interval {
    public static int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> result = new ArrayList<>();
        int i = 0;

        // Add all intervals that come before the new interval
        while (i < intervals.length && intervals[i][1] < newInterval[0]) {
            result.add(intervals[i]);
            i++;
        }

        // Merge overlapping intervals with the new interval
        // Check if the start of the current interval is less than or equal to the end of the new interval
        // If they overlap, update the new interval to be the merged interval
        while (i < intervals.length && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(intervals[i][0], newInterval[0]);
            newInterval[1] = Math.max(intervals[i][1], newInterval[1]);
            i++;
        }

        // Add the merged new interval to the result
        result.add(newInterval);

        // Add all intervals that come after the new interval
        while (i < intervals.length) {
            result.add(intervals[i]);
            i++;
        }

        return result.toArray(new int[result.size()][]);
    }

    public static void main(String[] args) {
        // Test Case - 1
        int[][] intervals1 = {{1, 3}, {6, 9}};
        int[] newInterval1 = {2, 5};
        int[][] result1 = insert(intervals1, newInterval1);

        for (int[] interval : result1) {
            System.out.print("[" + interval[0] + ", " + interval[1] + "] ");
        }

        // Test Case - 2
        System.out.println();
        int[][] intervals2 = {{1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}};
        int[] newInterval2 = {4, 8};
        int[][] result2 = insert(intervals2, newInterval2);

        for (int[] interval : result2) {
            System.out.print("[" + interval[0] + ", " + interval[1] + "] ");
        }
    }
}