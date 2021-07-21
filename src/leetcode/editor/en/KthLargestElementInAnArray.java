//Given an integer array nums and an integer k, return the kth largest element i
//n the array. 
//
// Note that it is the kth largest element in the sorted order, not the kth dist
//inct element. 
//
// 
// Example 1: 
// Input: nums = [3,2,1,5,6,4], k = 2
//Output: 5
// Example 2: 
// Input: nums = [3,2,3,1,2,4,5,5,6], k = 4
//Output: 4
// 
// 
// Constraints: 
//
// 
// 1 <= k <= nums.length <= 104 
// -104 <= nums[i] <= 104 
// 
// Related Topics Array Divide and Conquer Sorting Heap (Priority Queue) Quickse
//lect 
// 👍 6159 👎 379

  
package leetcode.editor.en;
public class KthLargestElementInAnArray {
    public static void main(String[] args) {
        Solution solution = new KthLargestElementInAnArray().new Solution();
        int[][] nums = {
                {1,2,3,4,5,6,7,8,9},
                {9,8,8,7,6,5,4},
                {3,2,1,5,6,4},
                {3,2,3,1,2,4,5,5,6}
        };
        int[] k = {4, 3, 2, 4};
        int n = 3;
        System.out.println(solution.findKthLargest(nums[n], k[n]));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findKthLargest(int[] nums, int k) {
            return findKthLargest(nums, 0, nums.length - 1, k - 1);
        }
        private int findKthLargest(int[] nums, int p, int r, int k) {
            if (p >= r) {
                return nums[k];
            }
            int pivot = nums[p + (r - p) / 2];
            int left = p, right = r;
            while (left <= right) {
                while (left <= right && nums[left] > pivot) {
                    left++;
                }
                while (left <= right && nums[right] < pivot) {
                    right--;
                }
                if (left <= right) {
                    swap(nums, left, right);
                    left++;
                    right--;
                }
            }
            if (right < k) {
                return findKthLargest(nums, left, r, k);
            } else {
                return findKthLargest(nums, p, right, k);
            }
        }

        private void swap(int[] nums, int i, int j) {
            if (i == j) {
                return;
            }
            nums[j] = nums[j] ^ nums[i];
            nums[i] = nums[j] ^ nums[i];
            nums[j] = nums[j] ^ nums[i];
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}