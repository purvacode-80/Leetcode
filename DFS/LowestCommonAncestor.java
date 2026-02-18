// 236. Lowest Common Ancestor of a Binary Tree

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

public class LowestCommonAncestor {
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // Base Case : If root is null return null
        if (root == null) return null;

        // If either one of p or q is the root return root
        if (root == p || root == q) return root;

        // Recursively check for left and right subtree
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        // If both left and right are found then the current node is the LCA
        if (left != null && right != null) return root;
        // If lef is null return right else return left
        return left == null ? right : left;
    }

    public static void main(String[] args) {
        // Test Case - 1
        // [3,5,1,6,2,0,8,null,null,7,4]
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);

        TreeNode p = root.left; // Node with value 5
        TreeNode q = root.right; // Node with value 1

        TreeNode result = lowestCommonAncestor(root, p, q);
        System.out.println("Lowest Common Ancestor of " + p.val + " and " + q.val + " is: " + result.val);    // Output: 3

        // Test Case - 2
        TreeNode p2 = root.left; // Node with value 5
        TreeNode q2 = root.left.right.right; // Node with value 4
        TreeNode result2 = lowestCommonAncestor(root, p2, q2);
        System.out.println("Lowest Common Ancestor of " + p2.val + " and " + q2.val + " is: " + result2.val);    // Output: 5
    }
}
