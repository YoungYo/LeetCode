//Given two strings s and t of lengths m and n respectively, return the minimum 
//window substring of s such that every character in t (including duplicates) is 
//included in the window. If there is no such substring, return the empty string 
//"". 
//
// The testcases will be generated such that the answer is unique. 
//
// A substring is a contiguous sequence of characters within the string. 
//
// 
// Example 1: 
//
// 
//Input: s = "ADOBECODEBANC", t = "ABC"
//Output: "BANC"
//Explanation: The minimum window substring "BANC" includes 'A', 'B', and 'C' 
//from string t.
// 
//
// Example 2: 
//
// 
//Input: s = "a", t = "a"
//Output: "a"
//Explanation: The entire string s is the minimum window.
// 
//
// Example 3: 
//
// 
//Input: s = "a", t = "aa"
//Output: ""
//Explanation: Both 'a's from t must be included in the window.
//Since the largest window of s only has one 'a', return empty string.
// 
//
// 
// Constraints: 
//
// 
// m == s.length 
// n == t.length 
// 1 <= m, n <= 10⁵ 
// s and t consist of uppercase and lowercase English letters. 
// 
//
// 
//Follow up: Could you find an algorithm that runs in O(m + n) time? Related 
//Topics Hash Table String Sliding Window 👍 7844 👎 488

  
package leetcode.editor.en;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class MinimumWindowSubstring {
    public static void main(String[] args) {
         Solution solution = new MinimumWindowSubstring().new Solution();
         String[][] inputs = {
                 {"cabwefgewcwaefgcf", "cae"},
                 {"ADOBECODEBANC", "ABC"},
                 {"a", "a"},
                 {"a", "aa"}
         };
         for (String[] input: inputs) {
             System.out.println(solution.minWindow(input[0], input[1]));
         }
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String minWindow(String s, String t) {
            int left = 0, right = 0, valid = 0, tLength = t.length();
            Map<Character, Integer> windows = new HashMap<>(tLength), need = new HashMap<>(tLength);
            int start = 0, end = 0, minLength = Integer.MAX_VALUE;
            for (int i = 0; i < tLength; i++) {
                char c = t.charAt(i);
                need.put(c, need.getOrDefault(c, 0) + 1);
            }
            while (right < s.length()) {
                char c = s.charAt(right);
                int cCount = need.getOrDefault(c, 0);
                right++;
                if (cCount > 0) {
                    windows.put(c, windows.getOrDefault(c, 0) + 1);
                    if (Objects.equals(windows.get(c), cCount)) {
                        valid++;
                    }
                }
                while (valid == need.size()) {
                    if (right - left < minLength) {
                        minLength = right - left;
                        start = left;
                        end = right;
                    }
                    char d = s.charAt(left);
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
            return s.substring(start, end);
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}