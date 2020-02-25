package medium;

import java.util.LinkedList;
import java.util.List;

public class _22_GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        List<String> res = new LinkedList<>();
        if (n == 0){
            return res;
        }
        StringBuilder sb1 = new StringBuilder("(");
        helper('(', res, sb1, 1, 0, n);
        StringBuilder sb2 = new StringBuilder("(");
        helper(')', res, sb2, 1, 0, n);
        return res;
    }

    public void helper(char parentheses, List<String> res, StringBuilder sb,
                  int leftcount, int rightcount, int n){
        sb.append(parentheses);
        if (parentheses == '('){
            leftcount++;
        }else {
            rightcount++;
            if (sb.length() == 2 * n && leftcount == rightcount){
                res.add(sb.toString());
                return;
            }
        }
        StringBuilder sb1 = new StringBuilder(sb);
        if (leftcount < n && sb1.length() + 1 < 2 * n) {//如果左括号的数量小于n，并且最后一个字符不是“)”，再向下递归
            helper('(', res, sb1, leftcount, rightcount, n);
        }
        StringBuilder sb2 = new StringBuilder(sb);
        if (rightcount < n && leftcount > rightcount) {//如果右括号的数量小于n，并且前面的左括号的数量大于右括号的数量，再向下递归
            helper(')', res, sb2, leftcount, rightcount, n);
        }
    }

    public static void main(String[] args) {
        _22_GenerateParentheses gp = new _22_GenerateParentheses();
        List<String> list = gp.generateParenthesis(4);
        for (String str: list) {
            System.out.println(str);
        }
    }
}
