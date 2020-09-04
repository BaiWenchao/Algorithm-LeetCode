import java.util.ArrayList;
import java.util.List;

/**
 * #257 二叉树的所有路径：
 * 给定一个二叉树，返回所有从根节点到叶子节点的路径*/

// Definition for a binary tree node
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) {
        val = x;
    }
}

class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> paths = new ArrayList<String>();
        constructPaths(root, "", paths);
        return paths;
    }

    public void constructPaths(TreeNode root, String path, List<String> paths) {
        if (root != null) {
            StringBuffer pathSB = new StringBuffer(path);
            pathSB.append(Integer.toString(root.val));
            if (root.left == null && root.right == null) {  // 当前节点是叶子节点
                paths.add(pathSB.toString());  // 把路径加入到答案中
            } else {
                pathSB.append("->");  // 当前节点不是叶子节点，继续递归遍历
                constructPaths(root.left, pathSB.toString(), paths);
                constructPaths(root.right, pathSB.toString(), paths);
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
        TreeNode ro = new TreeNode(1);
        TreeNode l = new TreeNode(2);
        TreeNode r = new TreeNode(3);
        TreeNode ll = new TreeNode(4);

        ro.left = l;
        ro.right = r;
        l.left = ll;

        Solution solution = new Solution();
        List<String> ans = solution.binaryTreePaths(ro);

        for (String path : ans) {
            System.out.println(path);
        }
    }
}
