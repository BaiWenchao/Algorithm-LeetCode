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

    ListNode ans = null;

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Stack<ListNode> s1 = new Stack<>();
        Stack<ListNode> s2 = new Stack<>();
        if (headA == null || headB == null) return null;
        s1.push(headA); s2.push(headB);
        while (headA.next != null) {
            s1.push(headA.next);
            headA = headA.next;
        }
        while (headB.next != null) {
            s2.push(headB.next);
            headB = headB.next;
        }

        while (!s1.isEmpty() && !s2.isEmpty()) {
            ListNode n1 = s1.pop();
            ListNode n2 = s2.pop();
            if (n1.val == n2.val) {
                ans = n1;
                if (s1.pop().val != s2.pop().val) {
                    return n1;
                } else {
                    ans = null;
                }
            }
        }

        return ans;
    }
}

public class Main {
    public static void main(String[] args) {

    }
}
