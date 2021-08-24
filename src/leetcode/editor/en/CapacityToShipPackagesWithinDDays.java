//A conveyor belt has packages that must be shipped from one port to another wit
//hin days days. 
//
// The ith package on the conveyor belt has a weight of weights[i]. Each day, we
// load the ship with packages on the conveyor belt (in the order given by weights
//). We may not load more weight than the maximum weight capacity of the ship. 
//
// Return the least weight capacity of the ship that will result in all the pack
//ages on the conveyor belt being shipped within days days. 
//
// 
// Example 1: 
//
// 
//Input: weights = [1,2,3,4,5,6,7,8,9,10], days = 5
//Output: 15
//Explanation: A ship capacity of 15 is the minimum to ship all the packages in 
//5 days like this:
//1st day: 1, 2, 3, 4, 5
//2nd day: 6, 7
//3rd day: 8
//4th day: 9
//5th day: 10
//
//Note that the cargo must be shipped in the order given, so using a ship of cap
//acity 14 and splitting the packages into parts like (2, 3, 4, 5), (1, 6, 7), (8)
//, (9), (10) is not allowed.
// 
//
// Example 2: 
//
// 
//Input: weights = [3,2,2,4,1,4], days = 3
//Output: 6
//Explanation: A ship capacity of 6 is the minimum to ship all the packages in 3
// days like this:
//1st day: 3, 2
//2nd day: 2, 4
//3rd day: 1, 4
// 
//
// Example 3: 
//
// 
//Input: weights = [1,2,3,1,1], days = 4
//Output: 3
//Explanation:
//1st day: 1
//2nd day: 2
//3rd day: 3
//4th day: 1, 1
// 
//
// 
// Constraints: 
//
// 
// 1 <= days <= weights.length <= 5 * 104 
// 1 <= weights[i] <= 500 
// Related Topics Array Binary Search Greedy 
// 👍 2634 👎 63

  
package leetcode.editor.en;
public class CapacityToShipPackagesWithinDDays {
    public static void main(String[] args) {
        Solution solution = new CapacityToShipPackagesWithinDDays().new Solution();
        int[][] weights = {
                {1,2,3,4,5,6,7,8,9,10},
                {3,2,2,4,1,4},
                {1,2,3,1,1}
        };
        int[] days = {5, 3, 4};
        int[] x = {15, 6, 3};
        for (int i = 0; i < weights.length; i++) {
//            System.out.println(solution.f(x[i], weights[i]));
            System.out.println(solution.shipWithinDays(weights[i], days[i]));
        }
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int shipWithinDays(int[] weights, int days) {
            int totalWeight = 0;
            int maxWeight = 0;
            for (int weight: weights) {
                maxWeight = Math.max(maxWeight, weight);
                totalWeight += weight;
            }
            int low = maxWeight, high = totalWeight;
            while (low < high) {
                int mid = low + (high - low) / 2;
                if (f(mid, weights) <= days) {
                    high = mid;
                } else if (f(mid, weights) > days) {
                    low = mid + 1;
                }
            }
            return low;
        }

        /**
         * 当船的载重为x时，运完weights中的所有货物所需的天数
         * @param x 船的载重
         * @param weights 记录所有货物的重量
         * @return 运完所有货物所需的天数
         */
        private int f(int x, int[] weights) {
            int dayCount = 0;
            for (int i = 0; i < weights.length;) {
                int boatWeight = 0;
                while (i < weights.length && boatWeight + weights[i] <= x) {
                    boatWeight += weights[i++];
                }
                dayCount++;
            }
            return dayCount;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}