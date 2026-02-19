// 1161. Maximum Level Sum of a Binary Tree

import java.util.LinkedList;
import java.util.Queue;

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

public class maximalSumLevel {
    public static int maxLevelSum(TreeNode root) {
        if (root == null) return 0; // There is no level 0, tree starts at level 1

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);  // insert level 1 node - root

        int level = 1;
        int maxLevel = 1;
        int maxSum = Integer.MIN_VALUE;

        while (!queue.isEmpty()) {
            int size = queue.size();
            int levelSum = 0;

            // For each level, calculate the sum of node values at that level
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                levelSum += node.val;

                if (node.left != null)  queue.offer(node.left);
                if (node.right != null)  queue.offer(node.right);
            }

            if (levelSum > maxSum) {
                maxSum = levelSum;
                maxLevel = level;
            }

            level++;
        }

        return maxLevel;
    }

    public static void main(String[] args) {
        // Test Case - 1
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(7);
        root.right = new TreeNode(0);
        root.left.left = new TreeNode(7);
        root.left.right = new TreeNode(-8);

        int result = maxLevelSum(root);
        System.out.println(result); // Output: 2

        // Test Case - 2
        TreeNode root2 = new TreeNode(989);
        root2.right = new TreeNode(10250);
        root2.right.left = new TreeNode(98693);
        root2.right.right = new TreeNode(-89388);

        int result2 = maxLevelSum(root2);
        System.out.println(result2); // Output: 2
    }
}
