import java.util.Stack;

/**
 * #617. 合并二叉树
 * 给定两个二叉树，想像当你将它们中的一个覆盖到另一个上时，两个二叉树的一些节点
 * 便会重叠。
 * 你需要将它们合并为一个新的二叉树。合并的规则是如果两个节点重叠，那么将它们的
 * 值相加作为节点合并后的新值，否则不为NULL的节点将直接作为新二叉树的节点。*/

// Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class Solution {
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        // 递归求解：
//        if (t1 == null) return t2;
//        if (t2 == null) return t1;
//
//        t1.val += t2.val;
//
//        t1.left = mergeTrees(t1.left, t2.left);
//        t1.right = mergeTrees(t1.right, t2.right);
//
//        return t1;

        // 迭代求解：
        if (t1 == null) return t2;
        Stack<TreeNode[]> stack = new Stack<>();
        stack.push(new TreeNode[] {t1, t2});

        while (!stack.isEmpty()) {
            TreeNode[] t = stack.pop();
            if (t[0] == null || t[1] == null) continue;
            t[0].val += t[1].val;

            if (t[0].left == null) {
                t[0].left = t[1].left;
            } else {
                stack.push(new TreeNode[] {t[0].left, t[1].left});
            }

            if (t[0].right == null) {
                t[0].right = t[1].right;
            } else {
                stack.push(new TreeNode[] {t[0].right, t[1].right});
            }
        }

        return t1;
    }
}

public class Main {
    public static void main(String[] args) {
        TreeNode root_1 = new TreeNode(1);
        TreeNode node1_1 = new TreeNode(3);
        TreeNode node2_1 = new TreeNode(2);
        TreeNode node3_1 = new TreeNode(5);

        TreeNode root_2 = new TreeNode(2);
        TreeNode node1_2 = new TreeNode(1);
        TreeNode node2_2 = new TreeNode(3);
        TreeNode node3_2 = new TreeNode(4);
        TreeNode node4_4 = new TreeNode(7);

        root_1.left = node1_1;
        root_1.right = node2_1;
        node1_1.left = node3_1;

        root_2.left = node1_2;
        root_2.right = node2_2;
        node1_2.right = node3_2;
        node2_2.right = node4_4;

        Solution solution = new Solution();
        TreeNode node = solution.mergeTrees(root_1, root_2);

        System.out.println(node.left.val);

    }
}
