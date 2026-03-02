// 700. Search in a Binary Search Tree

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

public class searchInBST {
    public static TreeNode searchBST(TreeNode root, int val) {
        if (root == null) return null;

        // Base Case : If value is found return the node
        if (root.val == val) return root;
        // If target value is less than current node, the value will be in left subtree 
        else if (root.val > val) return searchBST(root.left, val);
        // If target value is less than current node, the value will be in left subtree 
        else return searchBST(root.right, val);
    }

    public static void main(String[] args) {
        // Test Case - 1
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        int val = 2;
        TreeNode result = searchBST(root, val);
        if (result != null) {
            System.out.println("Node found with value: " + result.val);
        } else {
            System.out.println("Node not found.");
        }

        // Test Case - 2
        int val2 = 5;
        TreeNode result2 = searchBST(root, val2);
        if (result2 != null) {
            System.out.println("Node found with value: " + result2.val);
        } else {
            System.out.println("Node not found.");
        }
    }
}
