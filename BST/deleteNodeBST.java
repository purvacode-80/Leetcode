// 450. Delete Node in a BST

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

public class deleteNodeBST {
    public static TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null;

        if (root.val > key) {
            root.left = deleteNode(root.left, key);
        }
        else if (root.val < key) {
            root.right = deleteNode(root.right, key);
        }
        else {
            // Node is found

            // Case 1 : No left child
            if (root.left == null) {
                return root.right;
            }
            // Case 2 : No right child
            else if (root.right == null) {
                return root.left;
            }
            // Case 3 : Node has two children
            else {
                TreeNode successor = findMin(root.right);
                // Replace the value of the node to be deleted with the successor's value
                root.val = successor.val;
                // Delete the successor node from the right subtree
                root.right = deleteNode(root.right, successor.val);
            }
        }
        return root;
    }

    private static TreeNode findMin(TreeNode node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    public static void displayPreOrder(TreeNode root) {
        if (root != null) {
            System.out.print(root.val + " ");
            displayPreOrder(root.left);
            displayPreOrder(root.right);
        }
    }

    public static void main(String[] args) {
        // Test Case - 1
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(7);
        int key = 3;
        TreeNode result = deleteNode(root, key);
        System.out.println("Node with value " + key + " deleted.");
        System.out.print("Pre-order traversal of the updated BST: ");
        displayPreOrder(result);
        System.out.println();

        // Test Case - 2
        int key2 = 0;
        TreeNode result2 = deleteNode(root, key2);
        System.out.println("Node with value " + key2 + " not found, no deletion performed.");
        System.out.print("Pre-order traversal of the BST remains unchanged: ");
        displayPreOrder(result2);
        System.out.println();
    }
}
