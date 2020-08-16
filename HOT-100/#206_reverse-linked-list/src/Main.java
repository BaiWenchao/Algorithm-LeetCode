import java.util.Stack;

/**
 * #206. 反转链表
 * 反转一个单链表。
 * 例：
 * 输入：0 --> 1 --> 2 --> NULL
 * 输出：2 --> 1 --> 0 --> NULL
 */

// Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

class Solution {
    public ListNode reverseList(ListNode head) {
        // 1. 栈
//        if (head == null || head.next == null) return head;
//        Stack<ListNode[]> stack = new Stack<>();
//        while (head.next != null) {
//            stack.push(new ListNode[]{head, head.next});
//            head = head.next;
//        }
//        while (!stack.isEmpty()) {
//            ListNode[] tmp = stack.pop();
//            tmp[1].next = tmp[0];
//            tmp[0].next = null;
//        }
//        return head;

        // 2. 迭代
//        ListNode prev = null;
//        ListNode curr = head;
//
//        while (curr != null) {
//            ListNode tmpNode = curr.next;
//            curr.next = prev;
//            prev = curr;
//            curr = tmpNode;
//        }
//
//        return prev;

        // 3. 递归：本质上和法一一样，一个是显式栈，一个是隐式栈
        if (head == null || head.next == null) return head;

        ListNode n = reverseList(head.next);
        head.next.next = head;
        head.next = null;

        return n;

    }
}

public class Main {
    public static void main(String[] args) {
        ListNode node0 = new ListNode(0);
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);

        node0.next = node1;
        node1.next = node2;
        node2.next = node3;

        Solution s = new Solution();

        ListNode node = s.reverseList(node0);

        if (node != null) {
            System.out.println(node.val);
            while (node.next != null) {
                node = node.next;
                System.out.println(node.val);
            }
        } else {
            System.out.println(node);
        }
    }
}
