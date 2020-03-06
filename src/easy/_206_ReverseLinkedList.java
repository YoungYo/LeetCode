package easy;

import util.ListNode;

public class _206_ReverseLinkedList {
    public static ListNode reverseList(ListNode head) {
        ListNode p = head;
        ListNode q = head.next;
        head.next = null;
        while(q != null){
            ListNode temp = q.next;
            q.next = p;
            p = q;
            q = temp;
        }
        return p;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2); node1.next = node2;
        ListNode node3 = new ListNode(3); node2.next = node3;
        ListNode node4 = new ListNode(4); node3.next = node4;
        ListNode node5 = new ListNode(5); node4.next = node5;

        ListNode head = reverseList(node1);
        ListNode p = head;
        while (p != null){
            System.out.println(p.val);
            p = p.next;
        }
    }
}

