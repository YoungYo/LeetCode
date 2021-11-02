package easy;

import java.util.Objects;

/**
 * @author 王浩
 * @date 2021-11-02 12:48:40
 * Title: 27. Remove Element
 * 中国站链接：https://leetcode-cn.com/problems/remove-element/
 * 美国站链接：https://leetcode.com/problems/remove-element/
 */
public class _27_RemoveElement {
    public static void main(String[] args) {
		int[][][] inputs = {
				{{0,1,2,2,3,0,4,2}, {2}},
				{{3,2,2,3}, {3}},
				{{0, 0, 1, 1, 1, 2, 2, 3, 3, 4}, {0}}
		};
		Solution solution = new _27_RemoveElement().new Solution();
		for (int[][] input: inputs) {
			System.out.println(solution.removeElement(input[0], input[1][0]));
		}
    }
	class Solution {
	    public int removeElement(int[] nums, int val) {
	    	if (Objects.isNull(nums) || nums.length == 0) {
	    		return 0;
			}
	    	int slow = 0;
			for (int i = 0; i < nums.length; i++) {
				if (nums[i] != val) {
					if (i != slow) {
						nums[slow] = nums[i];
					}
					slow++;
				}
			}
			return slow;
	    }
	}
}
