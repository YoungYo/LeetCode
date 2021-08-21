//There is a car with capacity empty seats. The vehicle only drives east (i.e., 
//it cannot turn around and drive west). 
//
// You are given the integer capacity and an array trips where trip[i] = [numPas
//sengersi, fromi, toi] indicates that the ith trip has numPassengersi passengers 
//and the locations to pick them up and drop them off are fromi and toi respective
//ly. The locations are given as the number of kilometers due east from the car's 
//initial location. 
//
// Return true if it is possible to pick up and drop off all passengers for all 
//the given trips, or false otherwise. 
//
// 
// Example 1: 
//
// 
//Input: trips = [[2,1,5],[3,3,7]], capacity = 4
//Output: false
// 
//
// Example 2: 
//
// 
//Input: trips = [[2,1,5],[3,3,7]], capacity = 5
//Output: true
// 
//
// Example 3: 
//
// 
//Input: trips = [[2,1,5],[3,5,7]], capacity = 3
//Output: true
// 
//
// Example 4: 
//
// 
//Input: trips = [[3,2,7],[3,7,9],[8,3,9]], capacity = 11
//Output: true
// 
//
// 
// Constraints: 
//
// 
// 1 <= trips.length <= 1000 
// trips[i].length == 3 
// 1 <= numPassengersi <= 100 
// 0 <= fromi < toi <= 1000 
// 1 <= capacity <= 105 
// 
// Related Topics Array Sorting Heap (Priority Queue) Simulation Prefix Sum 
// 👍 1477 👎 44

  
package leetcode.editor.en;
public class CarPooling {
    public static void main(String[] args) {
         Solution solution = new CarPooling().new Solution();
         int[][][] trips = {
                 {
                         {2, 1, 5},
                         {3, 3, 7}
                 },
                 {
                         {2, 1, 5},
                         {3, 3, 7}
                 },
                 {
                         {2, 1, 5},
                         {3, 5, 7}
                 },
                 {
                         {3, 2, 7},
                         {3, 7, 9},
                         {8, 3, 9}
                 }
         };
         int[] capacity = {4, 5, 3, 11};
        for (int i = 0; i < capacity.length; i++) {
            System.out.println(solution.carPooling(trips[i], capacity[i]));
        }
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean carPooling(int[][] trips, int capacity) {
            int maxDistance = 0;
            for (int[] trip : trips) {
                maxDistance = Math.max(trip[1], maxDistance);
                maxDistance = Math.max(trip[2], maxDistance);
            }
            int[] road = new int[maxDistance + 1];
            for (int[] trip : trips) {
                int numPassengers = trip[0];
                int startLocation = trip[1];
                int endLocation = trip[2];
                road[startLocation] += numPassengers;
                road[endLocation] -= numPassengers;
            }
            int sum = 0;
            for (int i = 0; i <= maxDistance; i++) {
                sum += road[i];
                if (sum > capacity) {
                    return false;
                }
            }
            return true;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}