// 2336. Smallest Number in Infinite Set

import java.util.*;

public class SmallestInfiniteSet {
    // Min-heap to store the smallest numbers - Actual positive integers stored
    Queue<Integer> minHeap; 
    // Set to keep track of numbers that have been added back to the set to avoid duplicates    
    Set<Integer> addedBack;  
    // Store the top (smallest) integer currently in the minHeap
    int current;
    // Stores the smallest element which has been popped out
    int smallest;   

    public SmallestInfiniteSet() {
        minHeap = new PriorityQueue<>();
        addedBack = new HashSet<>();
        current = 1;
    }
    
    public int popSmallest() {
        // Pop the smallest element
        if (!minHeap.isEmpty()) {
            // Remove the element from minHeap and also from addedBack
            smallest = minHeap.poll();
            addedBack.remove(current);
            // Now the next newly added integer will be the smallest one (top)
            return smallest;
        }
        return current++;
    }
    
    public void addBack(int num) {
        // If it is smaller and not already present in the minHeap
        if (num < current && !minHeap.contains(num)) {
            minHeap.offer(num);
            addedBack.add(num);
        }
    }

    public static void main(String[] args) {
        SmallestInfiniteSet smallestInfiniteSet = new SmallestInfiniteSet();
        System.out.println(smallestInfiniteSet.popSmallest()); // return 1, the smallest number in the set is 1.
        System.out.println(smallestInfiniteSet.popSmallest()); // return 2, the smallest number in the set is 2.
        smallestInfiniteSet.addBack(1); // 1 is added back to the set.
        System.out.println(smallestInfiniteSet.popSmallest()); // return 1, the smallest number in the set is 1.
        System.out.println(smallestInfiniteSet.popSmallest()); // return 3, the smallest number in the set is 3.
        System.out.println(smallestInfiniteSet.popSmallest()); // return 4, the smallest number in the set is 4.
        System.out.println(smallestInfiniteSet.popSmallest()); // return 5, the smallest number in the set is 5.
    }
}
