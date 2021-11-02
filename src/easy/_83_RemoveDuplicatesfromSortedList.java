package easy;

import util.Array2List;
import util.ListNode;
import util.ListNodeUtil;

import java.util.Objects;

/**
 * @author 王浩
 * @date 2021-11-02 13:23:44
 * Title: 83. Remove Duplicates from Sorted List
 * 中国站链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list/
 * 美国站链接：https://leetcode.com/problems/remove-duplicates-from-sorted-list/
 */
public class _83_RemoveDuplicatesfromSortedList {
	public static void main(String[] args) {
		int[][] inputs = {
				{1,1,2,3,3},
				{0, 0, 1, 1, 1, 2, 2, 3, 3, 4},
				{1, 1, 2},
		};
        Solution solution = new _83_RemoveDuplicatesfromSortedList().new Solution();
        for (int[] input: inputs) {
        	ListNode head = Array2List.buildList(input)[0];
			solution.deleteDuplicates(head);
			System.out.println(ListNodeUtil.listToString(head));
		}
    }
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
	    	if (Objects.isNull(head)) {
	    		return null;
			}
	    	ListNode slow = head, fast = head.next;
	    	while (Objects.nonNull(fast)) {
	    		if (fast.val != slow.val) {
	    			slow.next = fast;
	    			slow = slow.next;
				}
	    		fast = fast.next;
			}
	    	slow.next = null;
	    	return head;
	    }
	}
}
