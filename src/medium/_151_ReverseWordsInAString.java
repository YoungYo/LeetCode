package medium;

public class _151_ReverseWordsInAString {
    public static String reverseWords(String s) {
        String[] sa = s.trim().split(" +");
        int i = 0, j = sa.length - 1;
        String temp;
        while (i < j){
            if (sa[i].equals(sa[j])){
                i++;
                j--;
            }else {
                temp = sa[i];
                sa[i++] = sa[j];
                sa[j--] = temp;
            }
        }
        String res = "";
        for(int k = 0; k < sa.length; k++){
            res += sa[k];
            if (k != sa.length - 1){
                res += " ";
            }
        }
        return res;
    }

    public static String reverseWords_stringbuilder(String s) {
        StringBuilder sb = new StringBuilder(s.length());
        int end = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) != ' ' && (i + 1 == s.length() || s.charAt(i + 1) == ' ')){
                end = i;
            }
            if (s.charAt(i) != ' ' && (i == 0 || s.charAt(i - 1) == ' ')){
                sb.append(s.substring(i, end + 1));
                sb.append(' ');
            }
        }
        return sb.toString().trim();
    }

    public static String reverseWords_stringbuilder_advance(String s) {
        StringBuilder sb = new StringBuilder(s.length());
        int start, i = s.length() - 1;
        while (i >= 0) {
            if (s.charAt(i) == ' '){
                i--;
                continue;
            }
            start = s.lastIndexOf(' ', i);
            sb.append(s.substring(start + 1, i + 1));
            sb.append(' ');
            i = start - 1;
        }
        return sb.toString().trim();
    }
    public static void main(String[] args) {
        String s = "  hello    world!   a example jjjj ";
        String res = reverseWords(s);
        System.out.println(res + "---");
        res = reverseWords_stringbuilder(s);
        System.out.println(res + "---");
        res = reverseWords_stringbuilder_advance(s);
        System.out.println(res + "---");
    }
}
