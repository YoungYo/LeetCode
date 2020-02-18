import java.util.HashMap;

public class _28_Implement_strStr {
    public int strStr(String haystack, String needle) {
        if ("".equals(needle) || needle == null)
            return 0;
        return match(haystack.toCharArray(), needle.toCharArray());
    }

    /**
     * @param pattern 模式串
     * @return 模式串中每个字符在模式串中的下标，如果有重复字符，则记录最靠后的那个
     */
    private HashMap<Character, Integer> generateBC(char[] pattern){
        HashMap<Character, Integer> bc = new HashMap<>();
        for (int i = 0; i < pattern.length; i++) {
            bc.put(pattern[i], i);
        }
        return bc;
    }

    /**
     * @param pattern 模式串
     * @param suffix suffix[i] 中记录的是长度为 i 的公共后缀子串的起始下标
     * @param prefix 如果 prefix[i] 为 true，则说明长度为 i 的后缀也是模式串的前缀
     */
    private void generateGS(char[] pattern, int[] suffix, boolean[] prefix){
        for (int i = 0; i < suffix.length; i++) {
            suffix[i] = -1;
        }

        int pattern_len = pattern.length;
        for (int i = 0; i < pattern_len - 1; i++) {
            int j = i;
            int k = 0;
            while (j >= 0 && pattern[j] == pattern[pattern_len - 1 - k]){
                suffix[++k] = j--;
            }
            if (j == -1)
                prefix[k] = true;
        }
    }

    /**
     * @param main 主串
     * @param pattern 模式串
     * @return 若匹配成功，返回模式串的第一个字符在主串中的位置；若匹配失败，返回 -1
     */
    private int match(char[] main, char[] pattern){
        int main_len = main.length;
        int pattern_len = pattern.length;

        HashMap<Character, Integer> bc = generateBC(pattern);

        int[] suffix = new int[pattern_len];
        boolean[] prefix = new boolean[pattern_len];
        generateGS(pattern, suffix, prefix);

        for (int i = 0; i <= main_len - pattern_len;){
            int j = i + pattern_len - 1;
            int j_original = j; //对 j 的值做一个备份
            for (; j >= i; --j) {
                if (main[j] != pattern[j - i])
                    break;
            }
            if (j < i)
                return i;

            int x = 0, y = 0;
            if (bc.get(main[j]) == null)
                x = j + 1;
            else
                x = j - bc.get(main[j]);

            if (j < j_original) { //如果j的值变小了，即说明有好后缀
                y = moveByGS(j, j_original, suffix, prefix);
            }

            i = Math.max(x, y);
        }
        return -1;
    }

    private int moveByGS(int j, int j_original, int[] suffix, boolean[] prefix){
        int k = j_original - j; //好后缀的长度
        if (suffix[k] != -1)
            return j - suffix[k] + 1;
        else{
            for (int r = k - 1; r > 0; r--) {
                if (prefix[r] == true){
                    return j + k - r + 1;
                }
            }
        }
        return j_original + 1;
    }

    public static void main(String[] args) {
        _28_Implement_strStr implement_strStr = new _28_Implement_strStr();
        System.out.println(implement_strStr.strStr("aaaaa", "bba"));
        System.out.println("aaaaa".indexOf(null));
    }
}
