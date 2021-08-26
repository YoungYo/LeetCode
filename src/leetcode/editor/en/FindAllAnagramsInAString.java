//Given two strings s and p, return an array of all the start indices of p's 
//anagrams in s. You may return the answer in any order. 
//
// An Anagram is a word or phrase formed by rearranging the letters of a 
//different word or phrase, typically using all the original letters exactly once. 
//
// 
// Example 1: 
//
// 
//Input: s = "cbaebabacd", p = "abc"
//Output: [0,6]
//Explanation:
//The substring with start index = 0 is "cba", which is an anagram of "abc".
//The substring with start index = 6 is "bac", which is an anagram of "abc".
// 
//
// Example 2: 
//
// 
//Input: s = "abab", p = "ab"
//Output: [0,1,2]
//Explanation:
//The substring with start index = 0 is "ab", which is an anagram of "ab".
//The substring with start index = 1 is "ba", which is an anagram of "ab".
//The substring with start index = 2 is "ab", which is an anagram of "ab".
// 
//
// 
// Constraints: 
//
// 
// 1 <= s.length, p.length <= 3 * 10⁴ 
// s and p consist of lowercase English letters. 
// 
// Related Topics Hash Table String Sliding Window 👍 4760 👎 211

  
package leetcode.editor.en;

import java.util.*;

public class FindAllAnagramsInAString {
    public static void main(String[] args) {
         Solution solution = new FindAllAnagramsInAString().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> findAnagrams(String s, String p) {
            int left = 0, right = 0, valid = 0, pLength = p.length();
            Map<Character, Integer> windows = new HashMap<>(pLength), need = new HashMap<>(pLength);
            List<Integer> res = new ArrayList<>(s.length());
            for (int i = 0; i < pLength; i++) {
                char c = p.charAt(i);
                need.put(c, need.getOrDefault(c, 0) + 1);
            }
            while (right < s.length()) {
                char c = s.charAt(right);
                right++;
                int cCount = need.getOrDefault(c, 0);
                if (cCount > 0) {
                    windows.put(c, windows.getOrDefault(c, 0) + 1);
                    if (Objects.equals(windows.get(c), cCount)) {
                        valid++;
                    }
                }
                while (right - left >= pLength) {
                    if (valid == need.size()) {
                        res.add(left);
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
            return res;
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}