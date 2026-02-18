// 437. Path Sum III

import java.util.HashMap;
import java.util.Map;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class Path_III {
    public static int pathSum(TreeNode root, int targetSum) {
        Map<Long, Integer> prefixSumCount = new HashMap<>();
        prefixSumCount.put(0L, 1); // Base case: one way to have a prefix sum of 0
        return dfs(root, 0, targetSum, prefixSumCount);
    }

    public static int dfs(TreeNode node, long currentSum, int targetSum, Map<Long, Integer> prefixSumCount) {
        if (node == null) return 0;

        currentSum += node.val;
        int count = prefixSumCount.getOrDefault(currentSum - targetSum, 0);
        prefixSumCount.put(currentSum, (prefixSumCount.getOrDefault(currentSum, 0) + 1));

        // Recurse on left and right subtrees
        count += dfs(node.left, currentSum, targetSum, prefixSumCount);
        count += dfs(node.right, currentSum, targetSum, prefixSumCount);

        // Backtrack: remove the current prefix sum count before returning to the parent node
        prefixSumCount.put(currentSum, prefixSumCount.get(currentSum) - 1);
        return count;
    }

    public static void main(String[] args) {
        // Test Case - 1
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(-3);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(2);
        root.right.right = new TreeNode(11);
        root.left.left.left = new TreeNode(3);
        root.left.left.right = new TreeNode(-2);
        root.left.right.right = new TreeNode(1);

        int targetSum = 8;
        int result = pathSum(root, targetSum);
        System.out.println("Number of paths that sum to " + targetSum + " : " + result);    // Output: 3

        // Test Case - 2
        TreeNode root2 = new TreeNode(5);
        root2.left = new TreeNode(4);
        root2.right = new TreeNode(8);
        root2.left.left = new TreeNode(11);
        root2.right.left = new TreeNode(13);
        root2.right.right = new TreeNode(4);
        root2.left.left.left = new TreeNode(7);
        root2.left.left.right = new TreeNode(2);
        root2.right.right.left = new TreeNode(5);
        root2.right.right.right = new TreeNode(1);

        targetSum = 22;
        result = pathSum(root2, targetSum);
        System.out.println("Number of paths that sum to " + targetSum + " : " + result);    // Output: 3
    }
}
