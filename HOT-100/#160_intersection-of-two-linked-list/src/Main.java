import java.util.Stack;

/**
 * #160. 相交链表：
 * 编写一个程序，找到两个单链表相交的起始节点。*/

// Definition for singly-linked list
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}

class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        ListNode l1 = headA, l2 = headB;
        while (l1 != l2) {
            l1 = l1==null ? headB : l1.next;
            l2 = l2==null ? headA : l2.next;
        }

        return l1;
    }

}

public class Main {
    public static void main(String[] args) {

    }
}
