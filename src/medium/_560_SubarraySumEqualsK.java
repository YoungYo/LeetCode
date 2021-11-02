package medium;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @author 王浩
 * @date 2021-11-02 20:45:47
 * Title: 560. Subarray Sum Equals K
 * 中国站链接：https://leetcode-cn.com/problems/subarray-sum-equals-k/
 * 美国站链接：https://leetcode.com/problems/subarray-sum-equals-k/
 */
public class _560_SubarraySumEqualsK {
    public static void main(String[] args) {
        int[][][] inputs = {
				{{1,1,1}, {2}},
				{{1,2,3}, {3}}
		};
        Solution solution = new _560_SubarraySumEqualsK().new Solution();
        for (int[][] input: inputs) {
			System.out.println(solution.subarraySum(input[0], input[1][0]));
		}
    }
	class Solution {
	    public int subarraySum(int[] nums, int k) {
	    	if (Objects.isNull(nums)) {
	    		return 0;
			}
			int length = nums.length;
			if (length == 1) {
	    		return nums[0] == k ? 1 : 0;
			}
			for (int i = 1; i < length; i++) {
				nums[i] = nums[i - 1] + nums[i];
			}
			int result = 0;
			Map<Integer, Integer> sumOccurTimes = new HashMap<>(length);
			sumOccurTimes.put(0, 1);
			for (int num : nums) {
				int sumOccurTime = sumOccurTimes.getOrDefault(num, 0);
				int sumMinusOccurTime = sumOccurTimes.getOrDefault(num - k, 0);
				result += sumMinusOccurTime;
				sumOccurTimes.put(num, sumOccurTime + 1);
			}
			return result;
	    }
	}
}
