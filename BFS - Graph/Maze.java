// 1926. Nearest Exit from Entrance in Maze

import java.util.LinkedList;
import java.util.Queue;

public class Maze {
    public static int nearestExit(char[][] maze, int[] entrance) {
        int rows = maze.length;
        int cols = maze[0].length;

        // Create a queue for BFS traversal
        Queue<int[]> queue = new LinkedList<>();

        // Mark entrance as visited 
        // "." --> "+"
        // Because entrance cannot be an exit
        maze[entrance[0]][entrance[1]] = '+';   // Make wall
        // Add entrance to queue
        queue.offer(new int[]{entrance[0], entrance[1]});

        int steps = 0;

        int[][] directions = new int[][] {
            {1,0},  // down
            {-1,0}, // top
            {0,1},  // right
            {0,-1}  // left
        };

        // BFS Traversal

        while (!queue.isEmpty()) {
            int size = queue.size();

            // Process all nodes at the current level
            for (int i = 0; i < size; i++) {
                int[] current = queue.poll();
                int r = current[0];
                int c = current[1];

                // Explore all 4 directions
                for (int[] dir : directions) {
                    int new_R = r + dir[0];
                    int new_C = c + dir[1];

                    // Check if the new cell is within boundaries and is an open path
                    if (new_R >= 0 && new_R < rows && new_C >= 0 && new_C < cols && maze[new_R][new_C] == '.') {
                        // Check if it is an exit (boundary)
                        if (new_R == 0 || new_R == rows - 1 || new_C == 0 || new_C == cols - 1) {
                            // We found the exit, so no more traversal return steps + 1
                            return steps + 1;
                        }
                        // Mark visited
                        maze[new_R][new_C] = '+';
                        // Add the new cell to the queue for further exploration
                        queue.offer(new int[]{new_R, new_C});
                    }
                }
            }
            // Increment steps after processing all nodes at the current level
            steps++;
        }
        return -1;
    }

    public static void main(String[] args) {
        // Test Case - 1
        char[][] maze = {
            {'+','+','.','+'},
            {'.','.','.','+'},
            {'+','+','+','.'}
        };
        int[] entrance = {1, 2};
        int result = nearestExit(maze, entrance);
        System.out.println(result); // Output: 1

        // Test Case - 2
        char[][] maze2 = {
            {'+','+','+'},
            {'.','.','.'},
            {'+','+','+'}
        };
        int[] entrance2 = {1, 0};
        int result2 = nearestExit(maze2, entrance2);
        System.out.println(result2); // Output: 2

        // Test Case - 3
        char[][] maze3 = {
            {'.','+'}
        };
        int[] entrance3 = {0, 0};
        int result3 = nearestExit(maze3, entrance3);
        System.out.println(result3); // Output: -1
    }
}