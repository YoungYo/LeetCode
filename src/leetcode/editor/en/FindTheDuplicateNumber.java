//Given an array of integers nums containing n + 1 integers where each integer i
//s in the range [1, n] inclusive. 
//
// There is only one repeated number in nums, return this repeated number. 
//
// You must solve the problem without modifying the array nums and uses only con
//stant extra space. 
//
// 
// Example 1: 
// Input: nums = [1,3,4,2,2]
//Output: 2
// Example 2: 
// Input: nums = [3,1,3,4,2]
//Output: 3
// Example 3: 
// Input: nums = [1,1]
//Output: 1
// Example 4: 
// Input: nums = [1,1,2]
//Output: 1
// 
// 
// Constraints: 
//
// 
// 1 <= n <= 105 
// nums.length == n + 1 
// 1 <= nums[i] <= n 
// All the integers in nums appear only once except for precisely one integer wh
//ich appears two or more times. 
// 
//
// 
// Follow up: 
//
// 
// How can we prove that at least one duplicate number must exist in nums? 
// Can you solve the problem in linear runtime complexity? 
// 
// Related Topics Array Two Pointers Binary Search Bit Manipulation 
// 👍 8615 👎 902

  
package leetcode.editor.en;
public class FindTheDuplicateNumber {
    public static void main(String[] args) {
        Solution solution = new FindTheDuplicateNumber().new Solution();
        int[][] inputs = {
                {1,3,4,2,2},
                {2,2,2,2,2},
                {3,1,3,4,2},
                {1,1},
                {1,1,2}
        };
        for (int[] input: inputs) {
            System.out.println(solution.findDuplicate(input));
        }
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findDuplicate(int[] nums) {
            int p = nums[0], q = nums[nums[0]];
            while (p != q) {
                p = nums[p];
                q = nums[nums[q]];
            }
            int cycleLength = 1;
            p = nums[p];
            while (p != q) {
                p = nums[p];
                cycleLength++;
            }
            int start = nums[0], end = 0;
            for (int i = 0; i < cycleLength; i++) {
                end = nums[end];
            }
            while (nums[end] != start) {
                start = nums[start];
                end = nums[end];
            }
            return start;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}