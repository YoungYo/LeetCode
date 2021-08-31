//Given a circular integer array nums (i.e., the next element of nums[nums.
//length - 1] is nums[0]), return the next greater number for every element in nums. 
//
// The next greater number of a number x is the first greater number to its 
//traversing-order next in the array, which means you could search circularly to find 
//its next greater number. If it doesn't exist, return -1 for this number. 
//
// 
// Example 1: 
//
// 
//Input: nums = [1,2,1]
//Output: [2,-1,2]
//Explanation: The first 1's next greater number is 2; 
//The number 2 can't find next greater number. 
//The second 1's next greater number needs to search circularly, which is also 2
//.
// 
//
// Example 2: 
//
// 
//Input: nums = [1,2,3,4,3]
//Output: [2,3,4,-1,4]
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 10⁴ 
// -10⁹ <= nums[i] <= 10⁹ 
// 
// Related Topics Array Stack Monotonic Stack 👍 3152 👎 108

  
package leetcode.editor.en;

import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElementIi {
    public static void main(String[] args) {
         Solution solution = new NextGreaterElementIi().new Solution();
         int[][] inputs = {
                 {1,2,1},
                 {1,2,3,4,3},
                 {5,4,3,2,1}
         };
         for (int[] nums: inputs) {
             System.out.println(Arrays.toString(solution.nextGreaterElements(nums)));
         }
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] nextGreaterElements(int[] nums) {
            int length = nums.length;
            Stack<Integer> stack = new Stack<>();
            int[] res = new int[length];
            for (int i = 2 * length - 1; i >= 1; i--) {
                int index = i % length;
                int num = nums[index];
                while (!stack.empty() && stack.peek() <= num) {
                    stack.pop();
                }
                if (!stack.empty()) {
                    res[index] = stack.peek();
                } else {
                    res[index] = -1;
                }
                stack.push(num);
            }
            return res;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}