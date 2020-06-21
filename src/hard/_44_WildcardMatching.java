package hard;

public class _44_WildcardMatching {
    public boolean isMatch(String s, String p) {
        boolean hasSuffixStar = false;
        boolean hasPrefixStar = false;
        int i = 0, j = p.length() - 1;
        while (i < p.length() && p.charAt(i) == '*') {
            i++;
            hasPrefixStar = true;
        }
        while (j >= 0 && p.charAt(j) == '*'){
            j--;
            hasSuffixStar = true;
        }
        if (i > j){
            p = "";
        }else if (hasPrefixStar || hasSuffixStar)
            p = p.substring(i, j + 1);

        String[] wildCards = p.split("\\*");
        if (wildCards.length == 1){
            if (!hasSuffixStar && !hasPrefixStar){
                return matchWithoutStar(s, p);
            }
        }
        if (!hasPrefixStar && !startWith(s, wildCards[0])){
            return false;
        }
        if (!hasSuffixStar && !endWith(s, wildCards[wildCards.length - 1])){
            return false;
        }
        int startIndex = 0;
        for (String wildCard : wildCards) {
            if (!wildCard.isEmpty()) {
                startIndex = indexOf(s, wildCard, startIndex);
                if (startIndex == -1) {
                    return false;
                }
            }
        }
        return true;
    }

    private int indexOf(String str, String pattern, int fromIndex){
        int i = fromIndex;
        for (; i <= str.length() - pattern.length(); i++) {
            int j = 0;
            for (; j < pattern.length(); j++) {
                if (pattern.charAt(j) != str.charAt(i + j) && pattern.charAt(j) != '?'){
                    break;
                }
            }
            if (j == pattern.length()){
                return i + pattern.length();
            }
        }
        return -1;
    }

    private boolean matchWithoutStar(String s, String p){
        if (p.length() != s.length()){
            return false;
        }
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != p.charAt(i) && p.charAt(i) != '?'){
                return false;
            }
        }
        return true;
    }

    private boolean startWith(String s, String p){
        if (p.length() > s.length()){
            return false;
        }
        for (int i = 0; i < p.length(); i++) {
            if (s.charAt(i) != p.charAt(i) && p.charAt(i) != '?'){
                return false;
            }
        }
        return true;
    }

    private boolean endWith(String s, String p){
        if (p.length() > s.length()){
            return false;
        }
        for (int i = 0; i < p.length(); i++) {
            int sPos = s.length() - i - 1;
            int pPos = p.length() - i - 1;
            if (s.charAt(sPos) != p.charAt(pPos) && p.charAt(pPos) != '?'){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        _44_WildcardMatching wildcardMatching = new _44_WildcardMatching();
        String[][] test = {
                {"b", "?"}, //true
                {"abefcdgiescdfimde", "ab*cd?i*de"}, //true
                {"adceb", "*a*b"}, //true
                {"acdcb", "a*c?b"}, //false
                {"aa", "*a"}, //true
                {"aa", "a*"}, //true
                {"aa", "a"}, //false
                {"aa", "*"}, //true
                {"cb", "?a"}, //false
        };

        for (String[] sp : test){
            System.out.println(wildcardMatching.isMatch(sp[0], sp[1]));
        }
    }
}
