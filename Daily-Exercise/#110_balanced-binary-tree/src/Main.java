/**
 * #110. 平衡二叉树
 * 给定一个二叉树，判断它是否是高度平衡的二叉树。
 * 本题中，一棵高度平衡二叉树定义为：
 * 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过1。
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
    private boolean balanced = true;
    public boolean isBalanced(TreeNode root) {
        if (root == null) return balanced;
        if (Math.abs(getDepth(root.right) - getDepth(root.left)) > 1) {
            balanced = false;
            return false;
        }
        balanced = isBalanced(root.left);
        balanced = isBalanced(root.right);
        return balanced;
    }

    public int getDepth(TreeNode root) {
        return root==null ? 0 : Math.max(getDepth(root.left), getDepth((root.right))) + 1;
    }
}

public class Main {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(3);
        TreeNode node5 = new TreeNode(4);
        TreeNode node6 = new TreeNode(4);

        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node1.right = node4;
        node3.left = node5;
        node3.right = node6;

        Solution solution = new Solution();
        System.out.println(solution.isBalanced(root));
    }
}
