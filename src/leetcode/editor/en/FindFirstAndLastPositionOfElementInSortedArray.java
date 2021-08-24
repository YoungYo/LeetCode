//Given an array of integers nums sorted in ascending order, find the starting a
//nd ending position of a given target value. 
//
// If target is not found in the array, return [-1, -1]. 
//
// You must write an algorithm with O(log n) runtime complexity. 
//
// 
// Example 1: 
// Input: nums = [5,7,7,8,8,10], target = 8
//Output: [3,4]
// Example 2: 
// Input: nums = [5,7,7,8,8,10], target = 6
//Output: [-1,-1]
// Example 3: 
// Input: nums = [], target = 0
//Output: [-1,-1]
// 
// 
// Constraints: 
//
// 
// 0 <= nums.length <= 105 
// -109 <= nums[i] <= 109 
// nums is a non-decreasing array. 
// -109 <= target <= 109 
// 
// Related Topics Array Binary Search 
// 👍 6844 👎 228

  
package leetcode.editor.en;

import java.util.Arrays;

public class FindFirstAndLastPositionOfElementInSortedArray {
    public static void main(String[] args) {
         Solution solution = new FindFirstAndLastPositionOfElementInSortedArray().new Solution();
        int[][] nums = {
                {2,2},
                {5,7,7,8,8,10},
                {5,7,7,8,8,10},
                {},
        };
        int[] target = {3, 8,6,0};
        for (int i = 0; i < nums.length; i++) {
            System.out.println(Arrays.toString(solution.searchRange(nums[i], target[i])));
        }
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] searchRange(int[] nums, int target) {
            int left = 0, right = nums.length;
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (nums[mid] >= target) {
                    right = mid;
                } else if (nums[mid] < target) {
                    left = mid + 1;
                }
            }
            if (nums.length == 0 || left == nums.length || nums[left] != target) {
                return new int[]{-1, -1};
            }
            int leftBound = left;
            left = 0;
            right = nums.length;
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (nums[mid] <= target) {
                    left = mid + 1;
                } else if (nums[mid] > target) {
                    right = mid;
                }
            }
            int rightBound = right - 1;
            return new int[]{leftBound, rightBound};
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}