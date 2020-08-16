import sun.reflect.generics.tree.Tree;

/**
 * #226. 翻转二叉树
 * [[4],[2,7],[1,3,6,9]] --> [[4],[7,2],[9,6,3,1]]]
 */

// Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

class Solution {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;

        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        invertTree(root.left);
        invertTree(root.right);

        return root;
    }
}

public class Main {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right = new TreeNode(7);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(9);

        Solution solution = new Solution();
        root = solution.invertTree(root);

        dfs(root);
    }

    public static void dfs(TreeNode node) {
        System.out.println(node.val);
        if (node.left != null) dfs(node.left);
        if (node.right != null) dfs(node.right);
    }
}
