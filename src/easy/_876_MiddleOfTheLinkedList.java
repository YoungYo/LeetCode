package easy;

import util.ListNode;

public class _876_MiddleOfTheLinkedList {
    public static ListNode middleNode(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while(slow.next != null && (fast.next != null && fast.next.next != null)){
            slow = slow.next;
            fast = fast.next.next;
        }
        if (fast.next != null)
            slow = slow.next;
        return slow;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2); node1.next = node2;
        ListNode node3 = new ListNode(3); node2.next = node3;
        ListNode node4 = new ListNode(4); node3.next = node4;
        ListNode node5 = new ListNode(5); node4.next = node5;

        ListNode head = middleNode(node5);
        ListNode p = head;
        while (p != null){
            System.out.println(p.val);
            p = p.next;
        }
    }
}
