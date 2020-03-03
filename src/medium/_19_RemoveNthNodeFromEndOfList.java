package medium;

import util.ListNode;

import java.util.HashMap;

public class _19_RemoveNthNodeFromEndOfList {
    public static ListNode removeNthFromEnd_HashMap(ListNode head, int n) {
        HashMap<Integer, ListNode> map = new HashMap<>();
        ListNode p = head;
        int index = 1;
        while (p != null){
            map.put(index++, p);
            p = p.next;
        }
        if (n == map.size()){
            p = head.next;
            head.next = null;
            head = p;
        }else {
            p = map.get(map.size()-n);
            p.next = p.next.next;
        }
        return head;
    }

    /**
     * 遍历两次链表，不用HashMap，删除倒数第n个节点，就是删除正数第len-n+1个节点，其中len是链表的长度
     * @param head
     * @param n
     * @return
     */
    public static ListNode removeNthFromEnd_two_pass(ListNode head, int n) {
        int len = 0;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode p = head;
        while (p != null){
            p = p.next;
            len++;
        }
        p = dummy;
        for (int i = 0; i < len-n; i++){
            p = p.next;
        }
        p.next = p.next.next;
        return dummy.next;
    }

    /**
     * 遍历一次链表
     * @param head
     * @param n
     * @return
     */
    public static ListNode removeNthFromEnd_one_pass(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode first = dummy;
        ListNode second = dummy;

        int index = 0;
        while(first != null){
            first = first.next;
            if(index > n)
                second = second.next;
            index++;
        }
        second.next = second.next.next;
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2); node1.next = node2;
        ListNode node3 = new ListNode(3); node2.next = node3;
        ListNode node4 = new ListNode(4); node3.next = node4;
        ListNode node5 = new ListNode(5); node4.next = node5;

        ListNode head = removeNthFromEnd_one_pass(node1, 4);
        ListNode p = head;
        while (p != null){
            System.out.println(p.val);
            p = p.next;
        }
    }
}
