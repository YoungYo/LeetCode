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
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    // 根据异或的两个特点，任何两个相同的数异或的结果都为0，任何数与0异或都为这个数，
    // 因此将所有的数依次异或得到的结果就是除了两个重复数的所有数的异或结果，假设为T。
    // 而将1到n依次异或的结果为T^重复数。因此，重复数=T^T^重复数。
    // 即:所有数异或的结果再异或1到n所有数异或的结果
    class Solution {
        public int findDuplicate(int[] nums) {
            int t = 0;
            for (int i : nums) {
                t ^= i;
            }
            for (int i = 0; i < nums.length; i++) {
                t ^= i;
            }
            return t;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}