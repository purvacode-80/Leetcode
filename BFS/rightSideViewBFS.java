// 199. Binary Tree Right Side View

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
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

public class rightSideViewBFS {
    public static List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        if (root == null) return result;

        // Create a queue to store values of nodes at each level
        Queue<TreeNode> queue = new LinkedList<>();
        // Insert root into queue
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i=0; i < size; i++) {
                TreeNode node = queue.poll();
                // If it's the last node of the level, add it to result
                if (i == size - 1) {
                    result.add(node.val);
                }

                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        // Test Cse - 1
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(4);

        List<Integer> result = rightSideView(root);
        System.out.println(result); // Output: [1, 3, 4]

        // Test Case - 2
        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(2);
        root2.right = new TreeNode(3);
        root2.left.left = new TreeNode(4);
        root2.left.right = new TreeNode(5);

        List<Integer> result2 = rightSideView(root2);
        System.out.println(result2); // Output: [1, 3, 5]
    }
}
