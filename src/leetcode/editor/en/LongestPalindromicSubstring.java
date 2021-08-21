//Given a string s, return the longest palindromic substring in s. 
//
// 
// Example 1: 
//
// 
//Input: s = "babad"
//Output: "bab"
//Note: "aba" is also a valid answer.
// 
//
// Example 2: 
//
// 
//Input: s = "cbbd"
//Output: "bb"
// 
//
// Example 3: 
//
// 
//Input: s = "a"
//Output: "a"
// 
//
// Example 4: 
//
// 
//Input: s = "ac"
//Output: "a"
// 
//
// 
// Constraints: 
//
// 
// 1 <= s.length <= 1000 
// s consist of only digits and English letters. 
// 
// Related Topics String Dynamic Programming 
// 👍 12820 👎 772

  
package leetcode.editor.en;
public class LongestPalindromicSubstring {
    public static void main(String[] args) {
         Solution solution = new LongestPalindromicSubstring().new Solution();
         String[] inputs = {
                 "babad",
                 "cbbd",
                 "a",
                 "ac"
         };
         for (String str: inputs) {
             System.out.println(solution.longestPalindrome(str));
         }
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String longestPalindrome(String s) {
            String result = "";
            for (int i = 0; i < s.length(); i++) {
                String palin1 = palindrome(i, i, s);
                String palin2 = palindrome(i, i + 1, s);
                if (result.length() < palin1.length()) {
                    result = palin1;
                }
                if (result.length() < palin2.length()) {
                    result = palin2;
                }
            }
            return result;
        }

        private String palindrome(int l, int r, String s) {
            while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
                l--;
                r++;
            }
            return s.substring(l + 1, r);
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)

}