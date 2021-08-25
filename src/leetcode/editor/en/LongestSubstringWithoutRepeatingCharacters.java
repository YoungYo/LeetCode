//Given a string s, find the length of the longest substring without repeating c
//haracters. 
//
// 
// Example 1: 
//
// 
//Input: s = "abcabcbb"
//Output: 3
//Explanation: The answer is "abc", with the length of 3.
// 
//
// Example 2: 
//
// 
//Input: s = "bbbbb"
//Output: 1
//Explanation: The answer is "b", with the length of 1.
// 
//
// Example 3: 
//
// 
//Input: s = "pwwkew"
//Output: 3
//Explanation: The answer is "wke", with the length of 3.
//Notice that the answer must be a substring, "pwke" is a subsequence and not a 
//substring.
// 
//
// Example 4: 
//
// 
//Input: s = ""
//Output: 0
// 
//
// 
// Constraints: 
//
// 
// 0 <= s.length <= 5 * 104 
// s consists of English letters, digits, symbols and spaces. 
// 
// Related Topics Hash Table String Sliding Window 
// 👍 16833 👎 809

  
package leetcode.editor.en;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
         Solution solution = new LongestSubstringWithoutRepeatingCharacters().new Solution();
         String[] inputs = {
                 "tmmzuxt",
                 "abcabcbb",
                 "bbbbb",
                 "pwwkew",
                 ""
         };
         for (String str: inputs) {
             System.out.println(solution.lengthOfLongestSubstring(str));
         }
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
/*
        public int lengthOfLongestSubstring(String s) {
            if (s == null || s.equals(""))
                return 0;
            if (s.length() == 1)
                return 1;
            int res = Integer.MIN_VALUE, start = -1; //start指的是不重复的子串的起始位置的前一个位置
            Map<Character, Integer> map = new HashMap<>(); //存储字符及其索引
            for (int i = 0; i < s.length(); i++) {
                Character c = s.charAt(i);
                Integer idx = map.get(c);
                if (idx != null){
                    start = Math.max(idx, start);
                }
                map.put(c, i);
                res = Math.max(res, i - start);
            }
            return res;
        }
*/
        // 滑动窗口解法
        public int lengthOfLongestSubstring(String s) {
            int left = 0, right = 0, res = 0, windowLength = 0;
            Map<Character, Integer> map = new HashMap<>(s.length());
            while (right < s.length()) {
                char c = s.charAt(right);
                int cCount = map.getOrDefault(c, 0);
                if (cCount == 0) {
                    windowLength++;
                    res = Math.max(res, windowLength);
                    map.put(c, 1);
                } else {
                    char c1;
                    while ((c1 = s.charAt(left)) != c) {
                        map.put(c1, 0);
                        left++;
                    }
                    windowLength = right - left;
                    res = Math.max(res, windowLength);
                    left++;
                }
                right++;
            }
            return res;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}