//Given the head of a singly linked list, return true if it is a palindrome. 
//
// 
// Example 1: 
//
// 
//Input: head = [1,2,2,1]
//Output: true
// 
//
// Example 2: 
//
// 
//Input: head = [1,2]
//Output: false
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the list is in the range [1, 105]. 
// 0 <= Node.val <= 9 
// 
//
// 
//Follow up: Could you do it in O(n) time and O(1) space? Related Topics Linked 
//List Two Pointers Stack Recursion 
// 👍 5897 👎 460

  
package leetcode.editor.en;

import util.ListNode;

import java.util.Objects;

public class PalindromeLinkedList {
    public static void main(String[] args) {
        Solution solution = new PalindromeLinkedList().new Solution();
        int[][] listNodesArray = {
                {1, 2, 2, 1},
                {1, 2},
                {1, 2, 3, 3, 3},
                {1, 2, 3, 2, 1}
        };
        ListNode headPre = new ListNode(-1);
        ListNode p = headPre;
        int[] listNodes = listNodesArray[3];
        for (int i = 0; i < listNodes.length; i++) {
            p.next = new ListNode(listNodes[i]);
            p = p.next;
        }
        System.out.println(solution.isPalindrome(headPre.next));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isPalindrome(ListNode head) {
            if (Objects.isNull(head.next)) {
                return true;
            }
            ListNode p = head, q = head;
            while (Objects.nonNull(q.next) && Objects.nonNull(q.next.next)) {
                p = p.next;
                q = q.next.next;
            }
            ListNode rightHead = p.next, t;
            p.next = null;
            p = rightHead;
            q = p.next;
            p.next = null;
            while (Objects.nonNull(q)) {
                t = q.next;
                q.next = p;
                p = q;
                q = t;
            }
            q = head;
            while (Objects.nonNull(p)) {
                if (p.val != q.val) {
                    return false;
                }
                p = p.next;
                q = q.next;
            }
            return true;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}