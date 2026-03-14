// 994. Rotting Oranges

import java.util.LinkedList;
import java.util.Queue;

public class RottenOranges {
    public static int orangesRotting(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int fresh = 0;
        // Add all rotten oranges to the queue for BFS traversal
        Queue<int[]> queue = new LinkedList<>();
        // Count total number of fresh and add rotten oranges to the queue
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 2) queue.add(new int[]{i,j});
                if (grid[i][j] == 1) fresh++;
            }
        }

        if (fresh == 0) return 0;   // No fresh oranges, so return 0 minutes

        int minutes = 0;
        int[][] directions = new int[][] {
            {1,0},  // down
            {-1,0}, // top
            {0,1},  // right
            {0,-1}  // left
        };

        // BFS Traversal
        // Continue BFS until no rotten oranges left to process or no fresh oranges left
        while (!queue.isEmpty() && fresh > 0) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] curr = queue.poll();
                int r = curr[0];
                int c = curr[1];
                for (int[] dir : directions) {
                    int new_R = r + dir[0];
                    int new_C = c + dir[1];

                    // Check if the new cell is within boundaries and is a fresh orange
                    if (new_R >= 0 && new_R < rows && new_C >= 0 && new_C < cols && grid[new_R][new_C] == 1) {
                        // Rot it
                        grid[new_R][new_C] = 2;
                        fresh--;
                        // Add the newly rotten orange to the queue for further processing
                        queue.offer(new int[]{new_R, new_C});
                    }
                }
            }
            // Increment minutes after processing all nodes at the current level
            minutes++;
        }

        return fresh == 0 ? minutes : -1;
    }

    public static void main(String[] args) {
        // Test Case - 1
        int[][] grid = {
            {2,1,1},
            {1,1,0},
            {0,1,1}
        };
        System.out.println(orangesRotting(grid));   // Output: 4

        // Test Case - 2
        int[][] grid2 = {
            {2,1,1},
            {0,1,1},
            {1,0,1}
        };
        System.out.println(orangesRotting(grid2));  // Output: -1

        // Test Case - 3
        int[][] grid3 = {
            {0,2}
        };
        System.out.println(orangesRotting(grid3));  // Output: 0
    }
}
