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

// 链表转列表法
//class Solution {
//
//    private List<Integer> list = new ArrayList<>();
//
//    public TreeNode sortedListToBST(ListNode head) {
//        // deal with the null LinkedList
//        if (head == null) return null;
//        // construct the ArrayList
//        list.add(head.val);
//        while (head.next != null) {
//            head = head.next;
//            list.add(head.val);
//        }
//        // do the job recursively
//        return treeConstructor(0, list.size());
//    }
//
//    public TreeNode treeConstructor(int left, int right) {
//        // base case:
//        if (left == right) return null;
//
//        int pos = (left+right-1)/2;
//        TreeNode parent = new TreeNode(list.get(pos));
//
//        parent.left = treeConstructor(left,pos);
//        parent.right = treeConstructor(pos+1, right);
//
//        return parent;
//    }
//}

// 快慢指针法
//class Solution {
//    public TreeNode sortedListToBST(ListNode head) {
//        return treeConstructor(head, null);
//    }
//
//    public TreeNode treeConstructor(ListNode left, ListNode right) {
//        if (left == right) return null;
//        ListNode mid = findListNode(left, right);
//        TreeNode parent = new TreeNode(mid.val);
//
//        parent.left = treeConstructor(left, mid);
//        parent.right = treeConstructor(mid.next, right);
//
//        return parent;
//    }
//
//    public ListNode findListNode(ListNode left, ListNode right) {
//        ListNode fast = left;
//        ListNode slow = left;
//
//        while (fast != right && fast.next != right) {
//            fast = fast.next.next;
//            slow = slow.next;
//        }
//
//        return slow;
//    }
//}


// 中序遍历法：
class  Solution {
    private ListNode globalHead;
    public TreeNode sortedListToBST(ListNode head) {
        globalHead = head;
        int length = getListLength(head);
        TreeNode root = treeConstructor(0, length);

        inOrder(root);
        return root;
    }
    public TreeNode treeConstructor(int left, int right) {
        if (left == right) return null;
        TreeNode parent = new TreeNode();
        parent.left = treeConstructor(left, (left+right-1)/2);
        parent.right = treeConstructor((left+right-1)/2+1, right);
        return parent;
    }
    public void inOrder(TreeNode root) {
        if (root == null) return;

        inOrder(root.left);
        root.val = globalHead.val;
        globalHead = globalHead.next;
        inOrder(root.right);
    }
    public int getListLength(ListNode head) {
        if (head == null) return 0;
        int count = 1;
        while (head.next != null) {
            count++;
            head = head.next;
        }

        return count;
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
