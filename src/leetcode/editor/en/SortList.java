//Given the head of a linked list, return the list after sorting it in ascending
// order. 
//
// Follow up: Can you sort the linked list in O(n logn) time and O(1) memory (i.
//e. constant space)? 
//
// 
// Example 1: 
//
// 
//Input: head = [4,2,1,3]
//Output: [1,2,3,4]
// 
//
// Example 2: 
//
// 
//Input: head = [-1,5,3,4,0]
//Output: [-1,0,3,4,5]
// 
//
// Example 3: 
//
// 
//Input: head = []
//Output: []
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the list is in the range [0, 5 * 104]. 
// -105 <= Node.val <= 105 
// 
// Related Topics Linked List Sort 
// 👍 4455 👎 179

  
package leetcode.editor.en;

import util.ListNode;

public class SortList {
    public static void main(String[] args) {
        int[][] inputs = {
                {4, 2, 1, 3},
                {-1, 5, 3, 4, 0},
                {}
        };
        ListNode head = new ListNode(-1);
        ListNode p = head;
        int[] input = inputs[2];
        for (int i = 0; i < input.length; i++) {
            p.next = new ListNode(input[i]);
            p = p.next;
        }
        Solution solution = new SortList().new Solution();
        p = solution.sortList(head.next);
        for (int i = 0; i < input.length; i++) {
            System.out.print(p.val);
            if (i < input.length - 1) {
                System.out.print(',');
            }
            p = p.next;
        }
    }
    //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode sortList(ListNode head) {
        ListNode p = head;
        int length = 0;
        while (p != null) {
            length++;
            p = p.next;
        }
        return sortList(head, length);
    }

    private ListNode sortList(ListNode head, int length) {
        if (length <= 1) {
            return head;
        }
        int len1 = length >> 1;
        ListNode p = head;
        for (int i = 0; i < len1; i++) {
            p = p.next;
        }
        int len2 = length - len1;
        ListNode head1 = sortList(head, len1);
        ListNode head2 = sortList(p, len2);
        return merge(head1, len1, head2, len2);
    }

    private ListNode merge(ListNode head1, int len1, ListNode head2, int len2) {
        ListNode t1 = head1, t2 = head2, result = new ListNode(-1);
        ListNode p = result;
        int i = 0, j = 0;
        for (; i < len1 && j < len2;) {
            if (t1.val <= t2.val) {
//                p.next = new ListNode(t1.val);
                p.next = t1;
                t1 = t1.next;
                i++;
            } else {
//                p.next = new ListNode(t2.val);
                p.next = t2;
                t2 = t2.next;
                j++;
            }
            p = p.next;
        }
        while (i < len1) {
//            p.next = new ListNode(t1.val);
            p.next = t1;
            p = p.next;
            t1 = t1.next;
            i++;
        }
        while (j < len2) {
//            p.next = new ListNode(t2.val);
            p.next = t2;
            p = p.next;
            t2 = t2.next;
            j++;
        }
        p.next = null;
        return result.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}