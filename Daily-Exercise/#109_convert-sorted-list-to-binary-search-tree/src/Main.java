import com.sun.org.apache.xerces.internal.xs.ShortList;

import java.util.ArrayList;
import java.util.List;

/**
 * #109. 有序链表转二叉搜索树
 * 给定一个单链表，其中的元素按升序排序，将其转换为高度平衡的二叉搜索树。
 * 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
 */

// Definition for singly-linked list
class ListNode {
    int val;
    ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

// Definition for a binary tree node
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {

    List<Integer> list = new ArrayList<>();

    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) return null;
        list.add(head.val);
        while(head.next != null) {
            list.add(head.next.val);
            head = head.next;
        }

        return treeConstructor(0, list.size(), null);
    }

    public TreeNode treeConstructor(int l, int r, TreeNode parent) {
        if (l == r) return null;

        int pos = (l+r-1)/2, pivot = list.get(pos);
        if (parent == null) parent = new TreeNode(pivot);


        if (l+1 == r) return parent;

        if (l+2 == r) {
            if (parent.val == list.get(l)) {
                parent.right = new TreeNode(list.get(r-1));
            } else {
                parent.left = new TreeNode(list.get(l));
            }

            return parent;
        }

        TreeNode lc = new TreeNode(list.get((l+pos-1)/2));
        TreeNode rc = new TreeNode(list.get((r+pos)/2));
        parent.left = lc;
        parent.right = rc;

        treeConstructor(l, pos, lc);
        treeConstructor(pos+1, r, rc);

        return parent;
    }
}

public class Main {
    public static void main(String[] args) {
        ListNode n0 = new ListNode(-10);
        ListNode n1 = new ListNode(-3);
        ListNode n2 = new ListNode(0);
        ListNode n3 = new ListNode(5);
        ListNode n4 = new ListNode(9);

        n0.next = n1;
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;

        Solution solution = new Solution();
        TreeNode tn = solution.sortedListToBST(n0);

        System.out.println(tn.val);
    }
}
