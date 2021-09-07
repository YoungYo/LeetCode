//Given an integer array nums, find the contiguous subarray (containing at 
//least one number) which has the largest sum and return its sum. 
//
// A subarray is a contiguous part of an array. 
//
// 
// Example 1: 
//
// 
//Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
//Output: 6
//Explanation: [4,-1,2,1] has the largest sum = 6.
// 
//
// Example 2: 
//
// 
//Input: nums = [1]
//Output: 1
// 
//
// Example 3: 
//
// 
//Input: nums = [5,4,-1,7,8]
//Output: 23
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 3 * 10⁴ 
// -10⁵ <= nums[i] <= 10⁵ 
// 
//
// 
// Follow up: If you have figured out the O(n) solution, try coding another 
//solution using the divide and conquer approach, which is more subtle. 
// Related Topics Array Divide and Conquer Dynamic Programming 👍 14230 👎 675

  
package leetcode.editor.en;
public class MaximumSubarray {
    public static void main(String[] args) {
         Solution solution = new MaximumSubarray().new Solution();
         int[][] inputs = {
                 {-2,1,-3,4,-1,2,1,-5,4},
                 {5,4,-1,7,8}
         };
         for (int[] input: inputs) {
             System.out.println(solution.maxSubArray(input));
         }
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxSubArray(int[] nums) {
            int preSum = nums[0];
            int result = preSum;
            for (int i = 1; i < nums.length; i++) {
                int currentMaxSum = Math.max(nums[i], preSum + nums[i]);
                result = Math.max(result, currentMaxSum);
                preSum = currentMaxSum;
            }
            return result;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}