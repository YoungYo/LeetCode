//Given a linked list, return the node where the cycle begins. If there is no cy
//cle, return null. 
//
// There is a cycle in a linked list if there is some node in the list that can 
//be reached again by continuously following the next pointer. Internally, pos is 
//used to denote the index of the node that tail's next pointer is connected to. N
//ote that pos is not passed as a parameter. 
//
// Notice that you should not modify the linked list. 
//
// 
// Example 1: 
//
// 
//Input: head = [3,2,0,-4], pos = 1
//Output: tail connects to node index 1
//Explanation: There is a cycle in the linked list, where tail connects to the s
//econd node.
// 
//
// Example 2: 
//
// 
//Input: head = [1,2], pos = 0
//Output: tail connects to node index 0
//Explanation: There is a cycle in the linked list, where tail connects to the f
//irst node.
// 
//
// Example 3: 
//
// 
//Input: head = [1], pos = -1
//Output: no cycle
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
// 👍 4303 👎 314

  
package leetcode.editor.en;

import util.ListNode;

import java.util.Objects;

public class LinkedListCycleIi {
    public static void main(String[] args) {
         Solution solution = new LinkedListCycleIi().new Solution();
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
        public ListNode detectCycle(ListNode head) {
            if (Objects.isNull(head) || Objects.isNull(head.next)) {
                return null;
            }
            ListNode slower = head.next;
            ListNode faster = head.next.next;
            while (slower != faster) {
                slower = slower.next;
                if (Objects.isNull(slower)) {
                    return null;
                }
                if (Objects.isNull(faster) || Objects.isNull(faster.next)) {
                    return null;
                }
                faster = faster.next.next;
                if (Objects.isNull(faster)) {
                    return null;
                }
            }
            ListNode temp = slower.next;
            int cycleLength = 1;
            while (temp != slower) {
                temp = temp.next;
                cycleLength++;
            }
            ListNode startNode = head, endNode = head;
            for (int i = 1; i < cycleLength; i++) {
                endNode = endNode.next;
            }
            while (endNode.next != startNode) {
                startNode = startNode.next;
                endNode = endNode.next;
            }
            return startNode;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)
}