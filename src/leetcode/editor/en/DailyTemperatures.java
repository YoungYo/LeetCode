//Given an array of integers temperatures represents the daily temperatures, 
//return an array answer such that answer[i] is the number of days you have to wait 
//after the iᵗʰ day to get a warmer temperature. If there is no future day for 
//which this is possible, keep answer[i] == 0 instead. 
//
// 
// Example 1: 
// Input: temperatures = [73,74,75,71,69,72,76,73]
//Output: [1,1,4,2,1,1,0,0]
// Example 2: 
// Input: temperatures = [30,40,50,60]
//Output: [1,1,1,0]
// Example 3: 
// Input: temperatures = [30,60,90]
//Output: [1,1,0]
// 
// 
// Constraints: 
//
// 
// 1 <= temperatures.length <= 10⁵ 
// 30 <= temperatures[i] <= 100 
// 
// Related Topics Array Stack Monotonic Stack 👍 4913 👎 139

  
package leetcode.editor.en;

import java.util.Arrays;
import java.util.Stack;

public class DailyTemperatures {
    public static void main(String[] args) {
         Solution solution = new DailyTemperatures().new Solution();
         int[][] inputs = {
                 {89,62,70,58,47,47,46,76,100,70},
                 {73,74,75,71,69,72,76,73},
                 {30,40,50,60},
                 {30,60,90}
         };
         for (int[] temperatures: inputs) {
             System.out.println(Arrays.toString(solution.dailyTemperatures(temperatures)));
/*
             for (int i = 0; i < temperatures.length; i++) {
                 System.out.print(i + "\t");
             }
             System.out.println();
             for (int i = 0; i < temperatures.length; i++) {
                 System.out.print(temperatures[i] + "\t");
             }
*/
         }
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] dailyTemperatures(int[] temperatures) {
            int length = temperatures.length;
            Stack<Integer> stack = new Stack<>();
            int[] res = new int[length];
            for (int i = length - 1; i >= 0; i--) {
                while (!stack.empty() && temperatures[stack.peek()] <= temperatures[i]) {
                    stack.pop();
                }
                if (!stack.empty()) {
                    res[i] = stack.peek() - i;
                } else {
                    res[i] = 0;
                }
                stack.push(i);
            }
            return res;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}