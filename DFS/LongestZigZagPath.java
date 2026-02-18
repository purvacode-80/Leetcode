// 1372. Longest ZigZag Path in a Binary Tree

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

public class LongestZigZagPath {
    static int maxLen = 0;
    public static int longestZigZag(TreeNode root) {
        maxLen = 0;  // Reset maxLen for each test case
        // Pretend we go to left first, then right separately to explore both starting paths
        dfs(root, true, 0);
        dfs(root, false, 0);
        return maxLen;
    }

    public static void dfs(TreeNode node, boolean goLeft, int currLen) {
        if (node == null) return;

        maxLen = Math.max(currLen, maxLen);

        if (goLeft) {
            // After going left, next we must go right (zigzag)
            dfs(node.left, false, currLen + 1);
            dfs(node.right, false, 0); // Reset length when we switch direction
        } else {
            // After going right, next we must go left (zigzag)
            dfs(node.right, true, currLen + 1);
            dfs(node.left, true, 0); // Reset length when we switch direction
        }
    }

    public static void main(String[] args) {
        // Test Case - 1
        // [1,null,1,1,1,null,null,1,1,null,1,null,null,null,1]

        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(1);
        root.right.left = new TreeNode(1);
        root.right.right = new TreeNode(1);
        root.right.right.left = new TreeNode(1);
        root.right.right.right = new TreeNode(1);
        root.right.right.left.right = new TreeNode(1);
        root.right.right.left.right.right = new TreeNode(1);

        int result = longestZigZag(root);
        System.out.println("Longest ZigZag Path Length: " + result);    // Output: 3

        // Test Case - 2
        // [1,1,1,null,1,null,null,1,1,null,1]

        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(1);
        root2.right = new TreeNode(1);
        root2.left.right = new TreeNode(1);
        root2.left.right.left = new TreeNode(1);
        root2.left.right.right = new TreeNode(1);
        root2.left.right.left.right = new TreeNode(1);

        int result2 = longestZigZag(root2);
        System.out.println("Longest ZigZag Path Length: " + result2);    // Output: 4
    }
}
