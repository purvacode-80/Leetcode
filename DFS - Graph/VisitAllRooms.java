// 841. Keys and Rooms using Depth-First Search (DFS)

import java.util.*;

class Solution {
    public static boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        // Create a boolean array to track visited rooms
        boolean[] visited = new boolean[n];
        visited[0] = true;
        
        // Use a stack for DFS
        // Stack contains the indices of the rooms to be explored
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        // Continue exploring until there are no more rooms to visit
        while (!stack.isEmpty()) {
            int currentRoom = stack.pop();
            // Iterate through the keys in the current room
            for (int key : rooms.get(currentRoom)) {
                if (!visited[key]) {
                    visited[key] = true; // Mark the room as visited
                    stack.push(key); // Add the room to the stack for further exploration
                }
            }
        }
        // Check if all rooms have been visited
        for (boolean roomVisited : visited) {
            if (!roomVisited) {
                return false; // If any room is not visited, return false
            }
        }
        return true; // All rooms have been visited
    }

    public static void main(String[] args) {
        // Test case: rooms = [[1], [2], [3], []]
        List<List<Integer>> rooms = new ArrayList<>();
        rooms.add(Arrays.asList(1));
        rooms.add(Arrays.asList(2));
        rooms.add(Arrays.asList(3));
        rooms.add(new ArrayList<>());
        
        System.out.println(canVisitAllRooms(rooms)); // Output: true

        // Test case: rooms = [[1,3], [3,0,1], [2], [0]]    
        List<List<Integer>> rooms2 = new ArrayList<>();
        rooms2.add(Arrays.asList(1, 3));
        rooms2.add(Arrays.asList(3, 0, 1));
        rooms2.add(Arrays.asList(2));
        rooms2.add(Arrays.asList(0));

        System.out.println(canVisitAllRooms(rooms2)); // Output: false
    }
}