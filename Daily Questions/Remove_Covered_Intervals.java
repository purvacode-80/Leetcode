// 1288. Remove Covered Intervals

import java.util.Arrays;

public class Remove_Covered_Intervals {
    public static int removeCoveredIntervals(int[][] intervals) {
        // Intervals are ordered by ascending start point.
        // If two intervals have the same start point, place the one with the larger end point first (descending end point).
        Arrays.sort(intervals,(a,b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);
        int result = 0;
        int maxEnd = 0;

        for (int[] i : intervals) {
            // If the endpoint is greater than maxEnd, it is not covered by any previous interval.
            if (i[1] > maxEnd) {
                result++;
                maxEnd = i[1];
            }
        }
        return result;
    }

    public static void main (String[] args) {
        // Test Case - 1
        int[][] intervals1 = {{1,4},{3,6},{2,8}};
        System.out.println(removeCoveredIntervals(intervals1));     // Output: 2

        // Test Case - 2
        int[][] intervals2 = {{1,4},{2,3}};
        System.out.println(removeCoveredIntervals(intervals2));     // Output: 1
    }
}
