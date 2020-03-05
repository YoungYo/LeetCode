package easy;

import util.ListNode;

import java.util.HashMap;

public class _141_LinkedListCycle {
    /**
     * 哈希法
     * @param head
     * @return
     */
    public static boolean hasCycle(ListNode head) {
        if (head == null)
            return false;
        HashMap<ListNode, Integer> map = new HashMap<>();
        ListNode p = head;
        int index = 0;
        while (p != null){
            map.put(p, index++);
            if (map.get(p.next) != null){
                return true;
            }
            p = p.next;
        }

        return false;
    }

    /**
     * 双指针法
     * @param head
     * @return
     */
    public static boolean hasCycle_two_pointers(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null){
            slow = slow.next;
            if(fast.next == null){
                return false;
            }else {
                fast = fast.next.next;
            }

            if (slow == fast)
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2); node1.next = node1;
        ListNode node3 = new ListNode(3); node2.next = node3;
        ListNode node4 = new ListNode(4); node3.next = node4;
        ListNode node5 = new ListNode(5); node4.next = node5;
        node5.next = node2;

        boolean cycle = hasCycle_two_pointers(node2);
        System.out.println(cycle);
    }
}
