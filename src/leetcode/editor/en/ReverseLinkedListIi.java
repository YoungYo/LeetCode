//Given the head of a singly linked list and two integers left and right where l
//eft <= right, reverse the nodes of the list from position left to position right
//, and return the reversed list. 
//
// 
// Example 1: 
//
// 
//Input: head = [1,2,3,4,5], left = 2, right = 4
//Output: [1,4,3,2,5]
// 
//
// Example 2: 
//
// 
//Input: head = [5], left = 1, right = 1
//Output: [5]
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the list is n. 
// 1 <= n <= 500 
// -500 <= Node.val <= 500 
// 1 <= left <= right <= n 
// 
//
// 
//Follow up: Could you do it in one pass? Related Topics Linked List 
// 👍 4203 👎 218

  
package leetcode.editor.en;

import util.ListNode;

import java.util.Objects;

public class ReverseLinkedListIi {
    public static void main(String[] args) {
        Solution solution = new ReverseLinkedListIi().new Solution();
        int[][][] params = {
                {{1,2,3,4,5}, {2}, {4}},
                {{3,5}, {1}, {2}},
                {{3,5}, {1}, {1}},
                {{5}, {1}, {1}}
        };
        int n = 0;
        ListNode headPre = new ListNode(-1);
        ListNode p = headPre;

        for (int i = 0; i < params[n][0].length; i++) {
            p.next = new ListNode(params[n][0][i]);
            p = p.next;
        }
        ListNode result = solution.reverseBetween(headPre.next, params[n][1][0], params[n][2][0]);
        p = result;
        while (Objects.nonNull(p)) {
            System.out.print(p.val);
            System.out.print(", ");
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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (left == right) {
            return head;
        }
        ListNode p = head, headPre = new ListNode(-1);
        headPre.next = head;
        ListNode leftPre = headPre;
        int i = 1;
        while (i < left && Objects.nonNull(p)) {
            p = p.next;
            leftPre = leftPre.next;
            i++;
        }
        if (Objects.isNull(p) || Objects.isNull(p.next)) {
            return head;
        }
        ListNode leftNode = p;
        ListNode q = p.next;
        ListNode t;
        while (true) {
            t = q.next;
            q.next = p;
            p = q;
            i++;
            if (Objects.isNull(t) || i == right) {
                break;
            }
            q = t;
        }
        leftPre.next = q;
        leftNode.next = t;
        return headPre.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}