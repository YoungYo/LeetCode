//Given an array of integers nums and an integer k, return the total number of c
//ontinuous subarrays whose sum equals to k. 
//
// 
// Example 1: 
// Input: nums = [1,1,1], k = 2
//Output: 2
// Example 2: 
// Input: nums = [1,2,3], k = 3
//Output: 2
// 
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 2 * 104 
// -1000 <= nums[i] <= 1000 
// -107 <= k <= 107 
// 
// Related Topics Array Hash Table Prefix Sum 
// 👍 8629 👎 291

  
package leetcode.editor.en;

import java.util.HashMap;

public class SubarraySumEqualsK {
    public static void main(String[] args) {
        Solution solution = new SubarraySumEqualsK().new Solution();
        int[][] inputs = {
                {1,1,1},
                {1,2,3}
        };
        int[] k = {1, 2};
        int n = 0;
        System.out.println(solution.subarraySum(inputs[n], k[n]));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int subarraySum(int[] nums, int k) {
            int length = nums.length;
            if (length == 1) {
                return k == nums[0] ? 1 : 0;
            }
            int result = 0;
            HashMap<Integer, Integer> map = new HashMap<>(length);
            map.put(0, 1);
            for (int i = 1; i < length; i++) {
                nums[i] = nums[i - 1] + nums[i];
            }
            for (int i = 0; i < length; i++) {
                Integer sumOccurTimes = map.getOrDefault(nums[i], 0);
                Integer sumMinusKOccurTimes = map.getOrDefault(nums[i] - k, 0);
                result += sumMinusKOccurTimes;
                map.put(nums[i], sumOccurTimes + 1);
            }
            return result;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}