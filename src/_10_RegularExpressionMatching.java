public class _10_RegularExpressionMatching {
    public static boolean isMatch(String s, String p) {
        return s.matches(p);
    }

    public static boolean isMatch_dp(String s, String p) {
        if (s == null)
            return p == null;
        boolean[][] memo = new boolean[s.length() + 1][p.length() + 1];
        int s_len = s.length(), p_len = p.length();
        memo[s_len][p_len] = true;
        boolean first_match;
        for (int i = s_len; i >= 0; i--) {
            for (int j = p_len - 1; j >= 0; j--) {
                first_match = (i < s_len && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.'));
                if (j + 1 < p_len && p.charAt(j + 1) == '*'){
                    memo[i][j] = (memo[i][j+2]) || (first_match && memo[i + 1][j]);
                }else {
                    memo[i][j] = first_match && memo[i + 1][j + 1];
                }
            }
        }
        return memo[0][0];
    }

    public static void main(String[] args) {
        String s1 = "aa", p1 = "a";
        String s2 = "aa", p2 = "a*";
        String s3 = "ab", p3 = ".*";
        String s4 = "aab", p4 = "c*a*b";
        String s5 = "mississippi", p5 = "mis*is*p*.";

        System.out.println(isMatch(s5, p5));
        System.out.println(isMatch_dp(s5, p5));
    }
}
