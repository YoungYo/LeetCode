package medium;

import java.util.HashMap;
import java.util.Map;

public class _3_LongestSubstringWithoutRepeatingCharacters {
    public static int lengthOfLongestSubstring(String s) {
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

    public static void main(String[] args) {
        String s1 = "abcabcbb";
        String s2 = "bbbbb";
        String s3 = "pwwkew";
        String s4 = "abba";
        System.out.println(lengthOfLongestSubstring(s1));
        System.out.println(lengthOfLongestSubstring(s2));
        System.out.println(lengthOfLongestSubstring(s3));
        System.out.println(lengthOfLongestSubstring(s4));
    }
}
