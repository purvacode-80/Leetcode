// 104. Maximum Depth of Binary Tree

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

public class MaximumDepth {
    public static int maxDepth(TreeNode root) {
        // Base case: if the current node is null, return 0
        if (root == null) {
            return 0;
        }
        // Recursive case: compute the depth of left and right subtrees
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        // Add 1 to account for the current node
        return Math.max(leftDepth, rightDepth) + 1;
    }

    public static void main(String[] args) {
        // Test Case 1
        TreeNode root1 = new TreeNode(3);
        root1.left = new TreeNode(9);
        root1.right = new TreeNode(20);
        root1.right.left = new TreeNode(15);
        root1.right.right = new TreeNode(7);

        int depth1 = maxDepth(root1);
        System.out.println("Maximum Depth of the Binary Tree: " + depth1); // Output: 3

        // Test Case 2
        TreeNode root2 = new TreeNode(1);
        root2.right = new TreeNode(2);

        int depth2 = maxDepth(root2);
        System.out.println("Maximum Depth of the Binary Tree: " + depth2); // Output: 2
    }
}
