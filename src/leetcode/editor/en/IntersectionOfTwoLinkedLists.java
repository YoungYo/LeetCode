//Given the heads of two singly linked-lists headA and headB, return the node at
// which the two lists intersect. If the two linked lists have no intersection at 
//all, return null. 
//
// For example, the following two linked lists begin to intersect at node c1: 
//
// It is guaranteed that there are no cycles anywhere in the entire linked struc
//ture. 
//
// Note that the linked lists must retain their original structure after the fun
//ction returns. 
//
// 
// Example 1: 
//
// 
//Input: intersectVal = 8, listA = [4,1,8,4,5], listB = [5,6,1,8,4,5], skipA = 2
//, skipB = 3
//Output: Intersected at '8'
//Explanation: The intersected node's value is 8 (note that this must not be 0 i
//f the two lists intersect).
//From the head of A, it reads as [4,1,8,4,5]. From the head of B, it reads as [
//5,6,1,8,4,5]. There are 2 nodes before the intersected node in A; There are 3 no
//des before the intersected node in B.
// 
//
// Example 2: 
//
// 
//Input: intersectVal = 2, listA = [1,9,1,2,4], listB = [3,2,4], skipA = 3, skip
//B = 1
//Output: Intersected at '2'
//Explanation: The intersected node's value is 2 (note that this must not be 0 i
//f the two lists intersect).
//From the head of A, it reads as [1,9,1,2,4]. From the head of B, it reads as [
//3,2,4]. There are 3 nodes before the intersected node in A; There are 1 node bef
//ore the intersected node in B.
// 
//
// Example 3: 
//
// 
//Input: intersectVal = 0, listA = [2,6,4], listB = [1,5], skipA = 3, skipB = 2
//Output: No intersection
//Explanation: From the head of A, it reads as [2,6,4]. From the head of B, it r
//eads as [1,5]. Since the two lists do not intersect, intersectVal must be 0, whi
//le skipA and skipB can be arbitrary values.
//Explanation: The two lists do not intersect, so return null.
// 
//
// 
// Constraints: 
//
// 
// The number of nodes of listA is in the m. 
// The number of nodes of listB is in the n. 
// 0 <= m, n <= 3 * 104 
// 1 <= Node.val <= 105 
// 0 <= skipA <= m 
// 0 <= skipB <= n 
// intersectVal is 0 if listA and listB do not intersect. 
// intersectVal == listA[skipA + 1] == listB[skipB + 1] if listA and listB inter
//sect. 
// 
//
// 
//Follow up: Could you write a solution that runs in O(n) time and use only O(1)
// memory? Related Topics Hash Table Linked List Two Pointers 
// 👍 5963 👎 668

  
package leetcode.editor.en;

import util.ListNode;

public class IntersectionOfTwoLinkedLists {
    public static void main(String[] args) {
         Solution solution = new IntersectionOfTwoLinkedLists().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) {
     *         val = x;
     *         next = null;
     *     }
     * }
     */
    public class Solution {
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            ListNode p = headA, q = headB;
            while (p != q) {
                if (p == null) {
                    p = headB;
                } else {
                    p = p.next;
                }

                if (q == null) {
                    q = headA;
                } else {
                    q = q.next;
                }
            }
            return p;
        }
/*
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            int lengthA = 0, lengthB = 0;
            ListNode p = headA, q = headB;
            while (Objects.nonNull(p)) {
                lengthA++;
                p = p.next;
            }
            while (Objects.nonNull(q)) {
                lengthB++;
                q = q.next;
            }
            p = headA;
            q = headB;
            int diff = Math.abs(lengthA - lengthB);
            if (lengthA > lengthB) {
                for (int i = 0; i < diff; i++) {
                    p = p.next;
                }
            }
            if (lengthB > lengthA) {
                for (int i = 0; i < diff; i++) {
                    q = q.next;
                }
            }
            while (!Objects.equals(p, q)) {
                p = p.next;
                q = q.next;
            }
            return p;
        }
*/
    }
    //leetcode submit region end(Prohibit modification and deletion)

}