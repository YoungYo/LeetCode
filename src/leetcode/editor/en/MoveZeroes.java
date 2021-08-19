//Given an integer array nums, move all 0's to the end of it while maintaining t
//he relative order of the non-zero elements. 
//
// Note that you must do this in-place without making a copy of the array. 
//
// 
// Example 1: 
// Input: nums = [0,1,0,3,12]
//Output: [1,3,12,0,0]
// Example 2: 
// Input: nums = [0]
//Output: [0]
// 
// 
// Constraints: 
//
// 
// 1 <= nums.length <= 104 
// -231 <= nums[i] <= 231 - 1 
// 
//
// 
//Follow up: Could you minimize the total number of operations done? Related Top
//ics Array Two Pointers 
// 👍 6153 👎 177

  
package leetcode.editor.en;

import java.util.Arrays;

public class MoveZeroes {
    public static void main(String[] args) {
        Solution solution = new MoveZeroes().new Solution();
        int[][] inputs = {
                {0, 1, 0, 3, 12},
                {0},
                {1},
                {1, 0},
                {0, 1},
                {1, 0, 0, 0, 2},
                {1, 3, 0, 0, 0},
                {0, 0, 0, 1, 3},
        };
        for (int[] input: inputs) {
            solution.moveZeroes(input);
            System.out.println(Arrays.toString(input));
        }
    }
    //leetcode submit region begin(Prohibit modification and deletion)
/*
    class Solution {
        public void moveZeroes(int[] nums) {
            int nextNonZero = 0, len = nums.length;
            for (int i = 0; i < len; i++) {
                if (nums[i] != 0) {
                    if (i != nextNonZero) {
                        nums[nextNonZero] = nums[nextNonZero] ^ nums[i];
                        nums[i] = nums[nextNonZero] ^ nums[i];
                        nums[nextNonZero] = nums[nextNonZero] ^ nums[i];
                    }
                    nextNonZero++;
                }
            }
        }
    }
*/
    class Solution {
        public void moveZeroes(int[] nums) {
            int length = nums.length;
            if (length == 0) {
                return;
            }
            int slow = 0;
            for (int fast = 0; fast < length; fast++) {
                if (nums[fast] != 0) {
                    if (slow != fast) {
                        nums[slow] = nums[slow] ^ nums[fast];
                        nums[fast] = nums[slow] ^ nums[fast];
                        nums[slow] = nums[slow] ^ nums[fast];
                    }
                    slow++;
                }
            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}