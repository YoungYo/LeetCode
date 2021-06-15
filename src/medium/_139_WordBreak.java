package medium;

import java.util.List;

/**
 * @author 王浩
 * @date 2021/6/3 2:59 下午
 */
public class _139_WordBreak {
    public static boolean wordBreak(String s, List<String> wordDict) {
        for (String word : wordDict) {
            if (s.startsWith(word)) {
                s = s.substring(word.length());
                if (s.length() == 0) {
                    return true;
                }
                return wordBreak(s, wordDict);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String[] s_arr = {"leetcode", "applepenapple", "catsandog"};
        List<List<String>> wordDictList = List.of(List.of("leet", "code"), List.of("apple","pen"),
                List.of("cats","dog","sand","and","cat"));
        int n = 2;
        System.out.println(wordBreak(s_arr[n], wordDictList.get(n)));
    }
}
