//Given two strings s1 and s2, return true if s2 contains a permutation of s1, o
//r false otherwise. 
//
// In other words, return true if one of s1's permutations is the substring of s
//2. 
//
// 
// Example 1: 
//
// 
//Input: s1 = "ab", s2 = "eidbaooo"
//Output: true
//Explanation: s2 contains one permutation of s1 ("ba").
// 
//
// Example 2: 
//
// 
//Input: s1 = "ab", s2 = "eidboaoo"
//Output: false
// 
//
// 
// Constraints: 
//
// 
// 1 <= s1.length, s2.length <= 104 
// s1 and s2 consist of lowercase English letters. 
// 
// Related Topics Hash Table Two Pointers String Sliding Window 
// 👍 2868 👎 84

  
package leetcode.editor.en;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class PermutationInString {
    public static void main(String[] args) {
         Solution solution = new PermutationInString().new Solution();
         String[][] inputs = {
                 {"ab", "eidboaoo"},
                 {"ab", "eidbaooo"},
         };
         for (String[] input: inputs) {
             System.out.println(solution.checkInclusion(input[0], input[1]));
         }
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean checkInclusion(String s1, String s2) {
            int left = 0, right = 0, valid = 0, s1Length = s1.length();
            Map<Character, Integer> windows = new HashMap<>(s1Length), need = new HashMap<>(s1Length);
            for (int i = 0; i < s1Length; i++) {
                char c = s1.charAt(i);
                need.put(c, need.getOrDefault(c, 0) + 1);
            }
            while (right < s2.length()) {
                char c = s2.charAt(right);
                right++;
                int cCount = need.getOrDefault(c, 0);
                if (cCount > 0) {
                    windows.put(c, windows.getOrDefault(c, 0) + 1);
                    if (Objects.equals(windows.get(c), cCount)) {
                        valid++;
                    }
                }
                while (right - left >= s1Length) {
                    if (valid == need.size()) {
                        return true;
                    }
                    char d = s2.charAt(left);
                    Integer dCount = need.getOrDefault(d, 0);
                    if (dCount > 0) {
                        if (Objects.equals(windows.get(d), dCount)) {
                            valid--;
                        }
                        windows.put(d, windows.getOrDefault(d, 0) - 1);
                    }
                    left++;
                }
            }
            return false;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}