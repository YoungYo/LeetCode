//Given head, the head of a linked list, determine if the linked list has a cycl
//e in it. 
//
// There is a cycle in a linked list if there is some node in the list that can 
//be reached again by continuously following the next pointer. Internally, pos is 
//used to denote the index of the node that tail's next pointer is connected to. N
//ote that pos is not passed as a parameter. 
//
// Return true if there is a cycle in the linked list. Otherwise, return false. 
//
//
// 
// Example 1: 
//
// 
//Input: head = [3,2,0,-4], pos = 1
//Output: true
//Explanation: There is a cycle in the linked list, where the tail connects to t
//he 1st node (0-indexed).
// 
//
// Example 2: 
//
// 
//Input: head = [1,2], pos = 0
//Output: true
//Explanation: There is a cycle in the linked list, where the tail connects to t
//he 0th node.
// 
//
// Example 3: 
//
// 
//Input: head = [1], pos = -1
//Output: false
//Explanation: There is no cycle in the linked list.
// 
//
// 
// Constraints: 
//
// 
// The number of the nodes in the list is in the range [0, 104]. 
// -105 <= Node.val <= 105 
// pos is -1 or a valid index in the linked-list. 
// 
//
// 
// Follow up: Can you solve it using O(1) (i.e. constant) memory? 
// Related Topics Linked List Two Pointers 
// 👍 4652 👎 625

  
package leetcode.editor.en;

import util.Array2List;
import util.ListNode;

import java.util.Objects;

public class LinkedListCycle {
    public static void main(String[] args) {
         Solution solution = new LinkedListCycle().new Solution();
         ListNode[] head = {
                 Array2List.buildCycleList(new int[]{3,2,0,-4}, 1),
                 Array2List.buildCycleList(new int[]{1,2}, 0),
                 Array2List.buildCycleList(new int[]{1}, -1)
         };
         for (ListNode p: head) {
             System.out.println(solution.hasCycle(p));
         }
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    /**
     * Definition for singly-linked list.
     * class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) {
     *         val = x;
     *         next = null;
     *     }
     * }
     */
    public class Solution {
        public boolean hasCycle(ListNode head) {
            if (Objects.isNull(head)) {
                return false;
            }
            ListNode p = head, q = head.next;
            while (Objects.nonNull(q) && !Objects.equals(p, q)) {
                p = p.next;
                if (Objects.nonNull(q.next)) {
                    q = q.next.next;
                } else {
                    return false;
                }
            }
            return Objects.equals(p, q);
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}