package medium;

import java.util.HashMap;
import java.util.Map;

public class _5_LongestPalindromicSubstring {
    public static Map<String, String> memo = new HashMap<>();
    public static String longestPalindrome(String s) {
        if (s == null || s.length() == 0){
            return s;
        }
        int begin = 0, end = s.length();
        return helper(s, begin, end);
    }

    public static String helper(String s, int begin ,int end){
        String res = memo.get(s);
        if (res != null)
            return res;
        if (begin + 1 == end || (begin + 2 == end && s.charAt(begin) == s.charAt(end - 1))){
            memo.put(s, s);
            return s;
        } else {
            String str1 = "", str2 = "", str3 = "";
            if (s.charAt(begin) == s.charAt(end - 1)){
                str1 =  helper(s, begin + 1, end - 1);
            }
            String substr2 = s.substring(begin, end - 1);
            str2 = memo.get(substr2);
            if (str2 == null) {
                str2 = helper(substr2, 0, end - 1 - begin);
                memo.put(substr2, str2);
            }
            String substr3 = s.substring(begin + 1, end);
            str3 = memo.get(substr3);
            if (str3 == null) {
                str3 = helper(substr3, 0, end - 1 - begin);
                memo.put(substr3, str3);
            }
            if (str1.length() >= str2.length()){
                if (str1.length() >= str3.length())
                    return str1;
                else
                    return str3;
            } else {
                if (str2.length() >= str3.length())
                    return str2;
                else
                    return str3;
            }
        }
    }

    /** 在原字符串的每一个字符之间都加上#，并在开头结尾分别加上“^”、“$”，例如原来是“abc”，处理完就是“^#a#b#c#$” */
    public static String proProcess(String s){
        int s_len = s.length();
        if (s_len == 0)
            return "^$";
        char[] char_array = new char[2 * s_len + 3];
        char_array[0] = '^';
        char_array[1] = '#';
        for (int i = 0; i < s_len; i++) {
            char_array[(i << 1) + 2] = s.charAt(i);
            char_array[(i << 1) + 3] = '#';
        }
        char_array[char_array.length - 1] = '$';
        return new String(char_array);
    }

    public static String longestPalindrome_ManachersAlgorithm(String s){
        String newstr = proProcess(s);
        int newstr_len = newstr.length();
        int[] p = new int[newstr_len];
        int c = 0, r = 0;
        for (int i = 1; i < newstr_len - 1; i++) {
            int i_mirror = (c << 1) - i;
            p[i] = (r > i) ? Math.min(r - i, p[i_mirror]) : 0;

            // Attempt to expand palindrome centered at i
            while (newstr.charAt(i + 1 + p[i]) == newstr.charAt(i - 1 - p[i]))
                p[i]++;

            // If palindrome centered at i expand past R,
            // adjust center based on expanded palindrome.
            if (i + p[i] > r) {
                c = i;
                r = i + p[i];
            }
        }

        // Find the maximum element in P.
        int maxLen = 0;
        int centerIndex = 0;
        for (int i = 1; i < newstr_len - 1; i++) {
            if (p[i] > maxLen) {
                maxLen = p[i];
                centerIndex = i;
            }
        }

        int begin = (centerIndex - 1 - maxLen) / 2;
        return s.substring(begin, begin + maxLen);
    }

    public static String longestPalindrome_fatest(String s) {
        if (s == null || s.length() < 2)
            return s;
        int [] p = {0, 0};
        char[] sa = s.toCharArray();
        int len = sa.length;
        for (int i = 0; i < sa.length; i ++ ) {
            int j = i--;
            while (j < len - 1 && sa[j] == sa[j + 1])
                j++;
            int next = j++;
            while (i >= 0 && j < len && sa[i] == sa[j]) {
                i--;
                j++;
            }
            if (j - i > p[1]) {
                p[1] = j - i - 1;
                p[0] = i + 1;
            }
            i = next;
        }
        return s.substring(p[0], p[0] + p[1]);
    }

    private static int manacher(char[] sa, int i, int [] p) {
        int len = sa.length, j = i --;
        while (j < len - 1 && sa[j] == sa[j + 1])
            j++;
        int next = j++;
        while (i >= 0 && j < len && sa[i] == sa[j]) {
            i --;
            j ++;
        }
        if (j - i > p[1]) {
            p[1] = j - i - 1;
            p[0] = i + 1;
        }
        return next;
    }

    public static void main(String[] args) {
        String str = "abcd";
        String str1 = "babad";
        String str2 = "babadada";
        String str3 = "babaddtattarrattatddetartrateedredividerb";
        String str4 = "ibvjkmpyzsifuxcabqqpahjdeuzaybqsrsmbfplxycsafogotliyvhxjtkrbzqxlyfwujzhkdafhebvsdhkkdbhlhmaoxmbkqiwiusngkbdhlvxdyvnjrzvxmukvdfobzlmvnbnilnsyrgoygfdzjlymhprcpxsnxpcafctikxxybcusgjwmfklkffehbvlhvxfiddznwumxosomfbgxoruoqrhezgsgidgcfzbtdftjxeahriirqgxbhicoxavquhbkaomrroghdnfkknyigsluqebaqrtcwgmlnvmxoagisdmsokeznjsnwpxygjjptvyjjkbmkxvlivinmpnpxgmmorkasebngirckqcawgevljplkkgextudqaodwqmfljljhrujoerycoojwwgtklypicgkyaboqjfivbeqdlonxeidgxsyzugkntoevwfuxovazcyayvwbcqswzhytlmtmrtwpikgacnpkbwgfmpavzyjoxughwhvlsxsgttbcyrlkaarngeoaldsdtjncivhcfsaohmdhgbwkuemcembmlwbwquxfaiukoqvzmgoeppieztdacvwngbkcxknbytvztodbfnjhbtwpjlzuajnlzfmmujhcggpdcwdquutdiubgcvnxvgspmfumeqrofewynizvynavjzkbpkuxxvkjujectdyfwygnfsukvzflcuxxzvxzravzznpxttduajhbsyiywpqunnarabcroljwcbdydagachbobkcvudkoddldaucwruobfylfhyvjuynjrosxczgjwudpxaqwnboxgxybnngxxhibesiaxkicinikzzmonftqkcudlzfzutplbycejmkpxcygsafzkgudy";
//        System.out.println(longestPalindrome(str4));
//        System.out.println(longestPalindrome_ManachersAlgorithm(str4));
        System.out.println(longestPalindrome_fatest(str4));
    }
}
