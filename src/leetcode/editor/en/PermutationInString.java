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

public class PermutationInString {
    public static void main(String[] args) {
         Solution solution = new PermutationInString().new Solution();
         String[][] inputs = {
                 {"ab", "eidbaooo"},
                 {"ab", "eidboaoo"}
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
                Integer cCount = need.getOrDefault(c, 0);
                right++;
                if (cCount == 0) {
                    left = right + 1;
                    continue;
                } else {
                    windows.put(c, windows.getOrDefault(c, 0));
                    valid++;
                }
                int leftCharCount;
                char leftChar = s2.charAt(left);
                while ((leftCharCount = windows.getOrDefault(leftChar, 0)) > need.getOrDefault(leftChar, 0)) {
                    windows.put(s2.charAt(left), leftCharCount - 1);
                    left++;
                    valid--;
                }
                if (valid == s1Length) {
                    return true;
                }
            }
            return false;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}