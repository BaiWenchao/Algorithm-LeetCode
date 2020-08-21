/**
 * #2. 两数相加：
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照逆序的方式存储的，
 * 并且它们的每个节点只能存储一位数字。
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * 您可以假设除了数字0之外，这两个数都不会以0开头。
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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode p = l1, q = l2, dummyHead = new ListNode(0), crt = dummyHead;
        int carry = 0;

        while (p != null || q != null) {
            int x = (p == null) ? 0 : p.val;
            int y = (q == null) ? 0 : q.val;

            int sum = x + y + carry;
            carry = sum / 10;
            crt.next = new ListNode(sum%10);
            crt = crt.next;

            if (p != null) p = p.next;
            if (q != null) q = q.next;
        }

        if (carry != 0) crt.next = new ListNode(carry);

        return dummyHead.next;
    }
}



//class Solution {
//    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
//        return adder(null, l1, l2, 0);
//    }
//    public ListNode adder(ListNode preNode, ListNode l1, ListNode l2, int carry) {
//        if (l1 == null && l2 == null) {
//            if (carry==0) {
//                return null;
//            } else {
//                preNode.next = new ListNode(carry);
//                return preNode.next;
//            }
//        }
//        int ans = carry;
//        if (l1 == null) {
//            int tmp = carry+l2.val;
//            int newCarry = tmp/10;
//            l2.val = tmp%10;
//            preNode.next = l2;
//            if (tmp>9) {
//                while (newCarry != 0) {
//                    if (l2.next == null) {
//                        l2.next = new ListNode(newCarry);
//                        newCarry = 0;
//                    } else {
//                        l2.next.val += newCarry;
//                        newCarry = l2.next.val/10;
//                        l2.next.val %= 10;
//                        l2 = l2.next;
//                    }
//                }
//            }
//            return l2.next;
//        } else {
//            ans += l1.val;
//        }
//
//        if (l2 == null) {
//            l1.val = ans%10;
//            int newCarry = ans/10;
//            if (ans>9) {
//                while (newCarry != 0) {
//                    if (l1.next == null) {
//                        l1.next = new ListNode(newCarry);
//                        newCarry = 0;
//                    } else {
//                        l1.next.val += newCarry;
//                        newCarry = l1.next.val/10;
//                        l1.next.val %= 10;
//                        l1 = l1.next;
//                    }
//                }
//            }
//            return l1;
//        } else {
//            ans += l2.val;
//        }
//        int newCarry = ans/10;
//        l1.val = ans%10;
//        adder(l1, l1.next, l2.next, newCarry);
//        return l1;
//    }
//}




public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode l1 = new ListNode(2);
        ListNode l2 = new ListNode(8);
        ListNode l21 = new ListNode(9);
        ListNode l22 = new ListNode(9);

        l2.next = l21;
        l21.next = l22;

        ListNode lAns = solution.addTwoNumbers(l2, l1);

        if (lAns != null) {
            System.out.print(lAns.val+"\t");
            while (lAns.next!=null) {
                System.out.print(lAns.next.val+"\t");
                lAns = lAns.next;
            }
        } else {
            System.out.println(lAns);
        }
    }
}
