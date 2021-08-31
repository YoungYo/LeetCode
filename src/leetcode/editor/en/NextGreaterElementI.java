//The next greater element of some element x in an array is the first greater 
//element that is to the right of x in the same array. 
//
// You are given two distinct 0-indexed integer arrays nums1 and nums2, where 
//nums1 is a subset of nums2. 
//
// For each 0 <= i < nums1.length, find the index j such that nums1[i] == nums2[
//j] and determine the next greater element of nums2[j] in nums2. If there is no 
//next greater element, then the answer for this query is -1. 
//
// Return an array ans of length nums1.length such that ans[i] is the next 
//greater element as described above. 
//
// 
// Example 1: 
//
// 
//Input: nums1 = [4,1,2], nums2 = [1,3,4,2]
//Output: [-1,3,-1]
//Explanation: The next greater element for each value of nums1 is as follows:
//- 4 is underlined in nums2 = [1,3,4,2]. There is no next greater element, so 
//the answer is -1.
//- 1 is underlined in nums2 = [1,3,4,2]. The next greater element is 3.
//- 2 is underlined in nums2 = [1,3,4,2]. There is no next greater element, so 
//the answer is -1.
// 
//
// Example 2: 
//
// 
//Input: nums1 = [2,4], nums2 = [1,2,3,4]
//Output: [3,-1]
//Explanation: The next greater element for each value of nums1 is as follows:
//- 2 is underlined in nums2 = [1,2,3,4]. The next greater element is 3.
//- 4 is underlined in nums2 = [1,2,3,4]. There is no next greater element, so 
//the answer is -1.
// 
//
// 
// Constraints: 
//
// 
// 1 <= nums1.length <= nums2.length <= 1000 
// 0 <= nums1[i], nums2[i] <= 10⁴ 
// All integers in nums1 and nums2 are unique. 
// All the integers of nums1 also appear in nums2. 
// 
//
// 
//Follow up: Could you find an O(nums1.length + nums2.length) solution? Related 
//Topics Array Hash Table Stack Monotonic Stack 👍 517 👎 36

  
package leetcode.editor.en;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class NextGreaterElementI {
    public static void main(String[] args) {
         Solution solution = new NextGreaterElementI().new Solution();
         int[][][] nums = {
                 {{2,1,3}, {2,3,1}}
         };
         for (int[][] num: nums) {
             System.out.println(Arrays.toString(solution.nextGreaterElement(num[0], num[1])));
         }
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] nextGreaterElement(int[] nums1, int[] nums2) {
            int nums2Length = nums2.length;
            Map<Integer, Integer> map = new HashMap<>(nums2Length);
            Stack<Integer> stack = new Stack<>();
            for (int i = nums2Length - 1; i >= 0; i--) {
                int num = nums2[i];
                while (!stack.empty() && stack.peek() < num) {
                    stack.pop();
                }
                if (!stack.empty()) {
                    map.put(num, stack.peek());
                }
                stack.push(num);
            }
            int[] res = new int[nums1.length];
            for (int i = 0; i < nums1.length; i++) {
                res[i] = map.getOrDefault(nums1[i], -1);
            }
            return res;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}