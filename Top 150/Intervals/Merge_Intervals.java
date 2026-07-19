// 56. Merge Intervals

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Merge_Intervals {
    public static int[][] merge(int[][] intervals) {
        List<int[]> merged = new ArrayList<>();
        
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0], b[0]));

        int[] prev = intervals[0];

        for (int i = 1; i < intervals.length; i++) {
            int[] interval = intervals[i];
            if (interval[0] <= prev[1]) {
                prev[1] = Math.max(prev[1], interval[1]);
            }
            else {
                merged.add(prev);
                prev = interval;
            }
        }
        merged.add(prev);
        return merged.toArray(new int[merged.size()][]);
    }

    public static void main(String[] args) {
        // Test Case - 1
        int[][] intervals1 = {{1,3},{2,6},{8,10},{15,18}};
        int[][] result1 = merge(intervals1);
        System.out.println("Merged Intervals for Test Case 1:");
        for (int[] interval : result1) {
            System.out.println(Arrays.toString(interval));
        }

        // Test Case - 2
        int[][] intervals2 = {{1,4},{4,5}};
        int[][] result2 = merge(intervals2);
        System.out.println("Merged Intervals for Test Case 2:");
        for (int[] interval : result2) {
            System.out.println(Arrays.toString(interval));
        }

        // Test Case - 3
        int[][] intervals3 = {{4,7},{1,4}};
        int[][] result3 = merge(intervals3);
        System.out.println("Merged Intervals for Test Case 3:");
        for (int[] interval : result3) {
            System.out.println(Arrays.toString(interval));
        }
    }
}
