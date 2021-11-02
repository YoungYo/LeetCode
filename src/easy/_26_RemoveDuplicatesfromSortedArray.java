package easy;

import java.util.Objects;

/**
 * @author 王浩
 * @date 2021-11-02 09:48:06
 * Title: 26. Remove Duplicates from Sorted Array
 * 中国站链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/
 * 美国站链接：https://leetcode.com/problems/remove-duplicates-from-sorted-array/
 */
public class _26_RemoveDuplicatesfromSortedArray {
    public static void main(String[] args) {
    	int[][] inputs = {
				{0,0,1,1,1,2,2,3,3,4},
				{1, 1, 2},
		};
        Solution solution = new _26_RemoveDuplicatesfromSortedArray().new Solution();
        for (int[] input: inputs) {
			System.out.println(solution.removeDuplicates(input));
		}
    }
	class Solution {
	    public int removeDuplicates(int[] nums) {
	    	if (Objects.isNull(nums)) {
	    		return 0;
			}
			int length = nums.length;
			if (length <= 1) {
	    		return length;
			}
	    	int slow = 0;
			for (int i = 1; i < length; i++) {
				if (nums[i] == nums[slow]) {
					continue;
				}
				slow++;
				if (i != slow) {
					nums[slow] = nums[i];
				}
			}
			return slow + 1;
	    }
	}
}
