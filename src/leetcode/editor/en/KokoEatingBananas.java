//Koko loves to eat bananas. There are n piles of bananas, the ith pile has pile
//s[i] bananas. The guards have gone and will come back in h hours. 
//
// Koko can decide her bananas-per-hour eating speed of k. Each hour, she choose
//s some pile of bananas and eats k bananas from that pile. If the pile has less t
//han k bananas, she eats all of them instead and will not eat any more bananas du
//ring this hour. 
//
// Koko likes to eat slowly but still wants to finish eating all the bananas bef
//ore the guards return. 
//
// Return the minimum integer k such that she can eat all the bananas within h h
//ours. 
//
// 
// Example 1: 
//
// 
//Input: piles = [3,6,7,11], h = 8
//Output: 4
// 
//
// Example 2: 
//
// 
//Input: piles = [30,11,23,4,20], h = 5
//Output: 30
// 
//
// Example 3: 
//
// 
//Input: piles = [30,11,23,4,20], h = 6
//Output: 23
// 
//
// 
// Constraints: 
//
// 
// 1 <= piles.length <= 104 
// piles.length <= h <= 109 
// 1 <= piles[i] <= 109 
// 
// Related Topics Array Binary Search 
// 👍 1926 👎 110

  
package leetcode.editor.en;
public class KokoEatingBananas {
    public static void main(String[] args) {
         Solution solution = new KokoEatingBananas().new Solution();
         int[][] piles = {
                 {3,6,7,11},
                 {30,11,23,4,20},
                 {30,11,23,4,20}
         };
         int[] h = {8,5,6};
        for (int i = 0; i < piles.length; i++) {
            System.out.println(solution.minEatingSpeed(piles[i], h[i]));
        }
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minEatingSpeed(int[] piles, int h) {
            // x的取值范围是[1, max(piles_i)]（max(piles_i)是对piles的所有元素中的最大值）或者[1, 10^9]
            int low = 1, high = 1000000001;
            while (low < high) {
                int mid = low + (high - low) / 2;
                if (f(mid, piles) <= h) {
                    high = mid;
                } else if (f(mid, piles) > h) {
                    low = mid + 1;
                }
            }
            return low;
        }

        /**
         * 当他吃香蕉的速度是x根/小时时，该函数返回吃掉所有香蕉所需的小时数
         * @param x 吃香蕉的速度，单位：根/小时
         * @param piles piles中每个元素代表一堆香蕉，每个元素的值代表这堆香蕉的数量
         * @return 吃掉所有香蕉所需的小时数
         */
        private int f(int x, int[] piles) {
            int lasting = 0;
            for (int pile : piles) {
                lasting += pile / x;
                if (pile % x > 0) {
                    lasting++;
                }
            }
            return lasting;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}