// 2196. Create Binary Tree From Descriptions

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

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

public class Binary_Tree_From_Descriptions {
    public static TreeNode createBinaryTree(int[][] descriptions) {
        Map<Integer,TreeNode> map = new HashMap<>();
        Set<Integer> children = new HashSet<>();

        for (int[] desc : descriptions) {
            int parent = desc[0];
            int child = desc[1];
            int isLeft = desc[2];

            map.putIfAbsent(parent, new TreeNode(parent));
            map.putIfAbsent(child, new TreeNode(child));

            TreeNode parentNode = map.get(parent);
            TreeNode childNode = map.get(child);

            if (isLeft == 1)
                parentNode.left = childNode;
            else
                parentNode.right = childNode;

            children.add(child);
        }

        for (int val : map.keySet()) {
                if (!children.contains(val))
                    return map.get(val);
        }
        return null;
    }

    public static void main(String[] args) {
        // Test Case - 1
        int[][] descriptions1 = {{20,15,1},{20,17,0},{50,20,1},{50,80,0},{80,19,1}};
        TreeNode root1 = createBinaryTree(descriptions1);
        System.out.println("Root of Test Case 1: " + root1.val); // Should print 50
        // Test Case - 2
        int[][] descriptions2 = {{1,2,1},{2,3,0},{3,4,1}};
        TreeNode root2 = createBinaryTree(descriptions2);
        System.out.println("Root of Test Case 2: " + root2.val); // Should print 1
    }
}
