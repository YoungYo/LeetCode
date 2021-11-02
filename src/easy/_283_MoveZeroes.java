package easy;

import java.util.Arrays;
import java.util.Objects;

/**
 * @author 王浩
 * @date 2021-11-02 13:01:43
 * Title: 283. Move Zeroes
 * 中国站链接：https://leetcode-cn.com/problems/move-zeroes/
 * 美国站链接：https://leetcode.com/problems/move-zeroes/
 */
public class _283_MoveZeroes {
    public static void main(String[] args) {
		int[][] inputs = {
				{0,1,0,3,12},
				{0},
				{0, 0, 1, 1, 1, 2, 2, 3, 3, 4},
				{1, 1, 2},
		};
		Solution solution = new _283_MoveZeroes().new Solution();
		for (int[] input: inputs) {
			solution.moveZeroes(input);
			System.out.println(Arrays.toString(input));
		}
	}
	class Solution {
	    public void moveZeroes(int[] nums) {
	    	if (Objects.isNull(nums) || nums.length == 0) {
	    		return;
			}
	    	int slow = 0;
			for (int i = 0; i < nums.length; i++) {
				if (nums[i] != 0) {
					if (i != slow) {
						nums[slow] = nums[i];
					}
					slow++;
				}
			}
			for (int i = slow; i < nums.length; i++) {
				nums[i] = 0;
			}
	    }
	}
}
