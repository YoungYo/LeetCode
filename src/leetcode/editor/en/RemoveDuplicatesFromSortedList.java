//Given the head of a sorted linked list, delete all duplicates such that each e
//lement appears only once. Return the linked list sorted as well. 
//
// 
// Example 1: 
//
// 
//Input: head = [1,1,2]
//Output: [1,2]
// 
//
// Example 2: 
//
// 
//Input: head = [1,1,2,3,3]
//Output: [1,2,3]
// 
//
// 
// Constraints: 
//
// 
// The number of nodes in the list is in the range [0, 300]. 
// -100 <= Node.val <= 100 
// The list is guaranteed to be sorted in ascending order. 
// 
// Related Topics Linked List 
// 👍 3066 👎 155

  
package leetcode.editor.en;

import util.ListNode;

import java.util.Objects;

public class RemoveDuplicatesFromSortedList {
    public static void main(String[] args) {
         Solution solution = new RemoveDuplicatesFromSortedList().new Solution();
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
        public ListNode deleteDuplicates(ListNode head) {
            ListNode slow = head, fast = head;
            if (Objects.isNull(slow)) {
                return slow;
            }
            while (Objects.nonNull(fast)) {
                while (Objects.nonNull(fast.next) && fast.next.val == slow.val) {
                    fast = fast.next;
                }
                if (!Objects.equals(slow.next, fast.next)) {
                    slow.next = fast.next;
                    fast.next = null;
                }
                slow = slow.next;
                fast = slow;
            }
            return head;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}