package hard;

import util.ListNode;

public class _23_MergeKSortedLists {

    public static ListNode mergeKLists(ListNode[] lists) {
        ListNode res = new ListNode(Integer.MIN_VALUE);
        ListNode p = res;
        boolean done = false;
        int minindex = -1;
        while (!done) {
            done = true;
            int minvalue = Integer.MAX_VALUE;
            for (int i = 0; i < lists.length; i++){
                ListNode node = lists[i];
                if (node != null){
                    done = false;
                    if (node.val < minvalue){
                        minvalue = node.val;
                        minindex = i;
                    }
                }
            }

            if (0 <= minindex && minindex < lists.length) {
                p.next = lists[minindex];
                p = p.next;
                if (lists[minindex] != null) {
                    lists[minindex] = lists[minindex].next;
                }
            }
        }
        return res.next;
    }

    public static void main(String[] args) {
        ListNode a1 = new ListNode(1);
        ListNode b1 = new ListNode(4); a1.next = b1;
        ListNode c1 = new ListNode(5); b1.next = c1;

        ListNode a2 = new ListNode(1);
        ListNode b2 = new ListNode(3); a2.next = b2;
        ListNode c2 = new ListNode(4); b2.next = c2;

        ListNode a3 = new ListNode(2);
        ListNode b3 = new ListNode(6); a3.next = b3;

//        util.ListNode[] lists = {a1, a2, a3};
        ListNode[] lists = {};
        ListNode res = mergeKLists(lists);
        while (res != null){
            System.out.print(res.val + "->");
            res = res.next;
        }
    }
}
