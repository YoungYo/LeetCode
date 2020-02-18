package medium;

import util.ListNode;

public class _2_AddTwoNumbers {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode ans = new ListNode(0);
        ListNode p = ans;
        int carry = 0;
        while (l1 != null || l2 != null){
            int v1 = l1 == null ? 0 : l1.val;
            int v2 = l2 == null ? 0 : l2.val;
            int cur_sum = v1 + v2 + carry;
            p.next = new ListNode(cur_sum % 10);
            p = p.next;
            carry = cur_sum / 10;
            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;
        }
        if (carry > 0)
            p.next = new ListNode(carry);
        return ans.next;
    }

    public static void main(String[] args) {
        ListNode l11 = new ListNode(2);
        ListNode l12 = new ListNode(4);l11.next = l12;
        ListNode l13 = new ListNode(3);l12.next = l13;

        ListNode l21 = new ListNode(5);
        ListNode l22 = new ListNode(6);l21.next = l22;
        ListNode l23 = new ListNode(4);l22.next = l23;

        ListNode l31 = new ListNode(5);
        ListNode l32 = new ListNode(6);l31.next = l32;
        ListNode l33 = new ListNode(4);l32.next = l33;
        ListNode l34 = new ListNode(7);l33.next = l34;

        ListNode l41 = new ListNode(5);

        ListNode l51 = new ListNode(5);

        ListNode l61 = new ListNode(9);
        ListNode l62 = new ListNode(9);l61.next = l62;
        ListNode l63 = new ListNode(9);l62.next = l63;
        ListNode l64 = new ListNode(9);l63.next = l64;

        ListNode l71 = new ListNode(1);
        ListNode ans = addTwoNumbers(l61, l71);
        while (ans != null){
            System.out.print(ans.val);
            ans = ans.next;
        }
    }
}
