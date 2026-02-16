// 872. Leaf-Similar Trees

import java.util.ArrayList;
import java.util.List;

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

public class SimilarLeaves {
    public static boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> leaves1 = new ArrayList<>();
        List<Integer> leaves2 = new ArrayList<>();

        collectLeaves(root1, leaves1);
        collectLeaves(root2, leaves2);

        return leaves1.equals(leaves2);
    }

    public static void collectLeaves(TreeNode root, List<Integer> leaves) {
        if (root == null) return;

        if (root.left == null && root.right == null) {
            // Add the node to the list
            leaves.add(root.val);
            // Return so it will not call the collectLeaves function for left and right node because it is a leaf node
            return; 
        }

        collectLeaves(root.left, leaves);
        collectLeaves(root.right, leaves);
    }

    public static void main(String[] args) {
        // Test Case - 1
        TreeNode root1 = new TreeNode(3);
        root1.left = new TreeNode(5);
        root1.right = new TreeNode(1);
        root1.left.left = new TreeNode(6);
        root1.left.right = new TreeNode(2);
        root1.right.left = new TreeNode(9);
        root1.right.right = new TreeNode(8);
        root1.left.right.left = new TreeNode(7);
        root1.left.right.right = new TreeNode(4);

        TreeNode root2 = new TreeNode(3);
        root2.left = new TreeNode(5);
        root2.right = new TreeNode(1);
        root2.left.left = new TreeNode(6);
        root2.left.right = new TreeNode(7);
        root2.right.left = new TreeNode(4);
        root2.right.right = new TreeNode(2);
        root2.right.right.left = new TreeNode(9);
        root2.right.right.right = new TreeNode(8);

        boolean result1 = leafSimilar(root1, root2);
        System.out.println("Are the leaf sequences of the two trees similar? " + result1); // Output: true\

        // Test Case - 2
        TreeNode root3 = new TreeNode(1);
        root3.left = new TreeNode(2);
        root3.right = new TreeNode(3);

        TreeNode root4 = new TreeNode(1);
        root4.left = new TreeNode(3);
        root4.right = new TreeNode(2);

        boolean result2 = leafSimilar(root3, root4);
        System.out.println("Are the leaf sequences of the two trees similar? " + result2); // Output: false
    }
}
