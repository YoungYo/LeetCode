//Given an integer array nums, find a contiguous non-empty subarray within the a
//rray that has the largest product, and return the product. 
//
// It is guaranteed that the answer will fit in a 32-bit integer. 
//
// A subarray is a contiguous subsequence of the array. 
//
// 
// Example 1: 
//
// 
//Input: nums = [2,3,-2,4]
//Output: 6
//Explanation: [2,3] has the largest product 6.
// 
//
// Example 2: 
//
// 
//Input: nums = [-2,0,-1]
//Output: 0
//Explanation: The result cannot be 2, because [-2,-1] is not a subarray.
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 2 * 104 
// -10 <= nums[i] <= 10 
// The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit 
//integer. 
// 
// Related Topics Array Dynamic Programming 
// 👍 7235 👎 237

  
package leetcode.editor.en;
public class MaximumProductSubarray {
    public static void main(String[] args) {
         Solution solution = new MaximumProductSubarray().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxProduct(int[] nums) {
            int max = nums[0];
            int imin = max, imax = max;
            int length = nums.length;
            for (int i = 1; i < length; i++) {
                if (nums[i] < 0) {
                    imin = imin ^ imax;
                    imax = imin ^ imax;
                    imin = imin ^ imax;
                }
                imax = Math.max(imax * nums[i], nums[i]);
                imin = Math.min(imin * nums[i], nums[i]);
                max = Math.max(imax, max);
            }
            return max;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)
}