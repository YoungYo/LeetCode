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
                {3,2,1,5,6,4}
        };
        int[] k = {4, 3, 2};
        int n = 2;
        System.out.println(solution.findKthLargest(nums[n], k[n]));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findKthLargest(int[] nums, int k) {
            return findKthLargest(nums, 0, nums.length - 1, k);
        }
        private int findKthLargest(int[] nums, int p, int r, int k) {
            int partition = partition(nums, p, r);
            if (partition == k - 1) {
                return nums[partition];
            } else if (partition < k - 1) {
                return findKthLargest(nums, partition + 1, r, k);
            } else {
                return findKthLargest(nums, p, partition - 1, k);
            }
        }
        private int partition(int[] nums, int p, int r) {
            int pivot = nums[r];
            int i = p;
            for (int j = p; j < r; j++) {
                if (nums[j] > pivot) {
                    swap(nums, i, j);
                    i++;
                }
            }
            swap(nums, i, r);
            return i;
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