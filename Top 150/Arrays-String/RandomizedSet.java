// 380. Insert Delete GetRandom O(1)

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class RandomizedSet {

    private ArrayList<Integer> list;    // To store the elements of the set
    private HashMap<Integer, Integer> map;  // To store the index of each element in the list


    public RandomizedSet() {
        list = new ArrayList<>();
        map = new HashMap<>();
    }

    public boolean search(int val) {
        return map.containsKey(val);
    }
    
    public boolean insert(int val) {
        // If the value already exists in the set, we cannot insert it again
        if(search(val)) return false;

        list.add(val);  // Add the new element to the end of the list
        // Store the index of the newly added element in the map
        map.put(val, list.size() - 1);  
        return true;
    }
    
    public boolean remove(int val) {
        // If the value does not exist in the set, we cannot remove it
        if(!search(val)) return false;

        int index = map.get(val);   // Get the index of the element to be removed
        // Move the last element in the list to the position of the element to be removed
        list.set(index, list.get(list.size()-1));
        // Update the index of the last element in the map
        map.put(list.get(index), index);
        // Remove the last element from the list and map
        list.remove(list.size()-1);
        map.remove(val);

        return true;
    }
    
    public int getRandom() {
        // Generate a random index and return the element at that index from the list
        Random rand = new Random();
        int index = rand.nextInt(list.size());
        return list.get(index);
    }

    public static void main(String[] args) {
        // Test Case - 1
        RandomizedSet randomizedSet = new RandomizedSet();
        System.out.println(randomizedSet.insert(1)); // Output: true
        System.out.println(randomizedSet.remove(2)); // Output: false
        System.out.println(randomizedSet.insert(2)); // Output: true
        System.out.println(randomizedSet.getRandom()); // Output: 1 or 2
        System.out.println(randomizedSet.remove(1)); // Output: true
        System.out.println(randomizedSet.insert(2)); // Output: false
        System.out.println(randomizedSet.getRandom()); // Output: 1 or 2
    }
}