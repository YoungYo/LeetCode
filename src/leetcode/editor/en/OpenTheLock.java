//You have a lock in front of you with 4 circular wheels. Each wheel has 10 
//slots: '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'. The wheels can rotate 
//freely and wrap around: for example we can turn '9' to be '0', or '0' to be '9'. 
//Each move consists of turning one wheel one slot. 
//
// The lock initially starts at '0000', a string representing the state of the 4
// wheels. 
//
// You are given a list of deadends dead ends, meaning if the lock displays any 
//of these codes, the wheels of the lock will stop turning and you will be unable 
//to open it. 
//
// Given a target representing the value of the wheels that will unlock the 
//lock, return the minimum total number of turns required to open the lock, or -1 if 
//it is impossible. 
//
// 
// Example 1: 
//
// 
//Input: deadends = ["0201","0101","0102","1212","2002"], target = "0202"
//Output: 6
//Explanation:
//A sequence of valid moves would be "0000" -> "1000" -> "1100" -> "1200" -> "12
//01" -> "1202" -> "0202".
//Note that a sequence like "0000" -> "0001" -> "0002" -> "0102" -> "0202" 
//would be invalid,
//because the wheels of the lock become stuck after the display becomes the 
//dead end "0102".
// 
//
// Example 2: 
//
// 
//Input: deadends = ["8888"], target = "0009"
//Output: 1
//Explanation:
//We can turn the last wheel in reverse to move from "0000" -> "0009".
// 
//
// Example 3: 
//
// 
//Input: deadends = ["8887","8889","8878","8898","8788","8988","7888","9888"], 
//target = "8888"
//Output: -1
//Explanation:
//We can't reach the target without getting stuck.
// 
//
// Example 4: 
//
// 
//Input: deadends = ["0000"], target = "8888"
//Output: -1
// 
//
// 
// Constraints: 
//
// 
// 1 <= deadends.length <= 500 
// deadends[i].length == 4 
// target.length == 4 
// target will not be in the list deadends. 
// target and deadends[i] consist of digits only. 
// 
// Related Topics Array Hash Table String Breadth-First Search 👍 2204 👎 76

  
package leetcode.editor.en;

import java.util.*;

public class OpenTheLock {
    public static void main(String[] args) {
         Solution solution = new OpenTheLock().new Solution();
         String[][][] inputs = {
                 {{"8887","8889","8878","8898","8788","8988","7888","9888"}, {"8888"}},
                 {{"0201","0101","0102","1212","2002"}, {"0202"}},
                 {{"8888"}, {"0009"}},
         };
         for (String[][] input: inputs) {
             System.out.println(solution.openLock(input[0], input[1][0]));
         }
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private Set<String> deadendSet;
        public int openLock(String[] deadends, String target) {
            String initDigital = "0000";
            if (initDigital.equals(target)) {
                return 0;
            }
            Set<String> visited = new HashSet<>();
            deadendSet = new HashSet<>();
            deadendSet.addAll(Arrays.asList(deadends));
            int minimumTurn = -1;
            if (deadendSet.contains(initDigital)) {
                return minimumTurn;
            }
            Queue<String> queue = new LinkedList<>();
            Queue<String> levelQueue = new LinkedList<>();
            queue.offer(initDigital);
            visited.add(initDigital);
            while (!queue.isEmpty()) {
                minimumTurn++;
                while (!queue.isEmpty()) {
                    String digital = queue.poll();
                    if (target.equals(digital)) {
                        return minimumTurn;
                    }
                    addNextDigital(levelQueue, digital, visited);
                }
                Queue<String> temp = queue;
                queue = levelQueue;
                levelQueue = temp;
            }
            return -1;
        }

        private void addNextDigital(Queue<String> levelQueue, String currentDigital, Set<String> visited) {
            List<String> nextDigitalList = new ArrayList<>(8);
            char[] charArray = currentDigital.toCharArray();
            for (int i = 0; i < currentDigital.length(); i++) {
                char num = charArray[i];
                charArray[i] = num == '0' ? '9' : (char) (num - 1);
                nextDigitalList.add(new String(charArray));
                charArray[i] = num == '9' ? '0' : (char) (num + 1);
                nextDigitalList.add(new String(charArray));
                charArray[i] = num;
            }
            for (String nextDigital: nextDigitalList) {
                if (!visited.contains(nextDigital) && !deadendSet.contains(nextDigital)) {
                    visited.add(nextDigital);
                    levelQueue.offer(nextDigital);
                }
            }
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}