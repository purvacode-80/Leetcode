// 16. Combination Sum III

import java.util.ArrayList;
import java.util.List;

public class Combination_Sum {
    public static List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        // Call the backtracking function from number 1
        backtrack(1, k, n, new ArrayList<>(), result);
        return result;
    }

    public static void backtrack(int start, int k, int target, List<Integer> current, List<List<Integer>> result) {
        // Base Condition : Valid condition
        if (current.size() == k && target == 0) {
            result.add(new ArrayList<>(current));
            return;
        }

        // Invalid condition - Backtrack
        if(current.size() > k || target < 0)    return;

        for(int i = start; i <= 9; i++) {
            current.add(i);
            backtrack(i + 1, k, target - i, current, result);
            current.remove(current.size()-1);
        }
    }

    public static void main(String[] args) {
        // Test Case - 1
        int k1 = 3, n1 = 7;
        List<List<Integer>> result1 = combinationSum3(k1, n1);
        System.out.println(result1);    // Expected Output: [[1,2,4]]

        // Test Case - 2
        int k2 = 3, n2 = 9;
        List<List<Integer>> result2 = combinationSum3(k2, n2);
        System.out.println(result2);    // Expected Output: [[1,2,6], [1,3,5], [2,3,4]]

        // Test Case - 3
        int k3 = 4, n3 = 1;
        List<List<Integer>> result3 = combinationSum3(k3, n3);
        System.out.println(result3);    // Expected Output: []
    }
}