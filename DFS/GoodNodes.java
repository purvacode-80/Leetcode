// 1448. Count Good Nodes in Binary Tree

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
 
public class GoodNodes {
    public static int goodNodes(TreeNode root) {
        return dfs(root, root.val);
    }

    public static int dfs(TreeNode node, int maxSoFar) {
        // Base Case
        if (node == null) return 0;

        int count = 0;
        // Root Node is always a good node
        if (node.val >= maxSoFar) count = 1;

        // Update the max set so far
        maxSoFar = Math.max(maxSoFar, node.val);

        // Recursively call for left and right subtree
        count += dfs(node.left, maxSoFar);
        count += dfs(node.right, maxSoFar);

        return count;
    }

    public static void main(String[] args) {
        // Test Case - 1
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.left.left = new TreeNode(3);
        root.right.left = new TreeNode(1);
        root.right.right = new TreeNode(5);

        System.out.println(goodNodes(root)); // Output: 4

        // Test Case - 2
        TreeNode root2 = new TreeNode(3);
        root2.left = new TreeNode(3);
        root2.left.left = new TreeNode(4);
        root2.left.right = new TreeNode(2);

        System.out.println(goodNodes(root2)); // Output: 3
    }
}
