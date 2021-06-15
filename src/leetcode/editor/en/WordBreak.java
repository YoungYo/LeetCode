//Given a string s and a dictionary of strings wordDict, return true if s can be
// segmented into a space-separated sequence of one or more dictionary words. 
//
// Note that the same word in the dictionary may be reused multiple times in the
// segmentation. 
//
// 
// Example 1: 
//
// 
//Input: s = "leetcode", wordDict = ["leet","code"]
//Output: true
//Explanation: Return true because "leetcode" can be segmented as "leet code".
// 
//
// Example 2: 
//
// 
//Input: s = "applepenapple", wordDict = ["apple","pen"]
//Output: true
//Explanation: Return true because "applepenapple" can be segmented as "apple pe
//n apple".
//Note that you are allowed to reuse a dictionary word.
// 
//
// Example 3: 
//
// 
//Input: s = "catsandog", wordDict = ["cats","dog","sand","and","cat"]
//Output: false
// 
//
// 
// Constraints: 
//
// 
// 1 <= s.length <= 300 
// 1 <= wordDict.length <= 1000 
// 1 <= wordDict[i].length <= 20 
// s and wordDict[i] consist of only lowercase English letters. 
// All the strings of wordDict are unique. 
// 
// Related Topics Dynamic Programming 
// 👍 6775 👎 322

  
package leetcode.editor.en;

import java.util.*;

public class WordBreak {
    public static void main(String[] args) {
        String[] sArr = {
                "leetcode",
                "applepenapple",
                "catsandog",
                "cars",
                "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab"
        };
        List<List<String>> wordDictList = List.of(
                List.of("leet", "code"),
                List.of("apple","pen"),
                List.of("cats","dog","sand","and","cat"),
                List.of("car","ca","rs"),
                List.of("a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa"));

        for (int n = 0; n < wordDictList.size(); n++) {
            Solution solution = new WordBreak().new Solution();
            System.out.println(solution.wordBreak(sArr[n], wordDictList.get(n)));
        }
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 广度优先搜索
/*
        public boolean wordBreak(String s, List<String> wordDict) {
            LinkedList<Integer> indexQueue = new LinkedList<>();
            Set<String> wordSet = new HashSet<>(wordDict);
            boolean[] visited = new boolean[s.length()];
            indexQueue.add(0);
            while (!indexQueue.isEmpty()) {
                Integer start = indexQueue.pop();
                if (visited[start]) {
                    continue;
                }
                for (int end = start + 1; end <= s.length(); end++) {
                    if (wordSet.contains(s.substring(start, end))) {
                        if (s.length() == end) {
                            return true;
                        } else {
                            indexQueue.add(end);
                        }
                    }
                }
                visited[start] = true;
            }
            return false;
        }
*/
        // 动态规划
        public boolean wordBreak(String s, List<String> wordDict) {
            Set<String> wordSet = new HashSet<>(wordDict);
            boolean[] dp = new boolean[s.length() + 1];
            dp[0] = true;
            for (int i = 1; i < dp.length; i++) {
                for (int j = 0; j < i; j++) {
                    if (!dp[j]) {
                        dp[j] = wordSet.contains(s.substring(0, j));
                    }
                    if (dp[j] && wordSet.contains(s.substring(j, i))) {
                        dp[i] = true;
                        break;
                    }
                }
            }
            return dp[s.length()];
        }
    }
    //leetcode submit region end(Prohibit modification and deletion)
}