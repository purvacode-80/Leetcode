// 933. Number of Recent Calls

import java.util.Queue;
import java.util.LinkedList;

public class RecentCounter {
    Queue<Integer> queue;
    public RecentCounter() {
        // Initialize your data structure here.
        queue = new LinkedList<>();
    }
    
    public int ping(int t) {
        // Add the new request to the queue
        queue.offer(t);

        // Remove requests that are outside the 3000ms window
        while (!queue.isEmpty() && queue.peek() < t - 3000) {
            queue.poll();
        }

        return queue.size();
    }

    public static void main(String[] args) {
        // Test Case - 1
        RecentCounter recentCounter = new RecentCounter();
        System.out.println(recentCounter.ping(1));     // return 1
        System.out.println(recentCounter.ping(100));   // return 2
        System.out.println(recentCounter.ping(3001));  // return 3  
        System.out.println(recentCounter.ping(3002));  // return 3
    }
    
}