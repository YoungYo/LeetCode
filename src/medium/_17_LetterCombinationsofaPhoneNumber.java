package medium;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class _17_LetterCombinationsofaPhoneNumber {
    private static char[][] dmap = {
            {'a','b','c'},
            {'d','e','f'},
            {'g','h','i'},
            {'j','k','l'},
            {'m','n','o'},
            {'p','q','r','s'},
            {'t','u','v'},
            {'w','x','y','z'}
    };

    public static List<String> letterCombinations(String digits) {
        List<String> list = new LinkedList<>();
        if (digits == null || digits.length() == 0){
            return list;
        }
        int len = digits.length(), rescount = 1;
        char[][] tempmap = new char[len][];
        for (int i = 0; i < len; i++) {
            tempmap[i] = dmap[digits.charAt(i) - '2'];
            rescount *= tempmap[i].length;
        }

        StringBuilder sb = new StringBuilder();
        Stack<Integer> row_stack = new Stack<>();
        Stack<Integer> col_stack = new Stack<>();
        int row = 0, col = 0;
        while (list.size() < rescount){
            while (row < len) {
                sb.append(tempmap[row][col]);
                row_stack.push(row);
                col_stack.push(col);
                row++;
            }
            list.add(sb.toString());
            sb.deleteCharAt(len - 1);
            row = row_stack.pop();
            col = col_stack.pop() + 1;
            while (col >= tempmap[row].length && !row_stack.isEmpty()){
                col = col_stack.pop() + 1;
                row = row_stack.pop();
                sb.deleteCharAt(row_stack.size());
                if (col < tempmap[row].length){
                    sb.append(tempmap[row][col]);
                    row_stack.push(row);
                    col_stack.push(col);
                    row++;
                    col = 0;
                }
            }
        }
        return list;
    }

    public static List<String> letterCombinations_recursive(String digits){
        List<String> res = new LinkedList<>();
        if (digits == null || digits.length() == 0){
            return res;
        }

        int len = digits.length(), rescount = 1;
        char[][] tempmap = new char[len][];
        for (int i = 0; i < len; i++) {
            tempmap[i] = dmap[digits.charAt(i) - '2'];
            rescount *= tempmap[i].length;
        }

        StringBuilder sb = new StringBuilder();
        helper(tempmap, sb, 0, res);
        return res;
    }

    private static void helper(char[][] tempmap, StringBuilder sb, int row, List<String> res){
        if (row >= tempmap.length){
            res.add(sb.toString());
            sb.delete(sb.length() - 1, sb.length());
            return;
        }
        int col = tempmap[row].length;
        for (int i = 0; i < col; i++) {
            sb.append(tempmap[row][i]);
            helper(tempmap, sb, row + 1, res);
            int sb_len = sb.length();
            if (i + 1 == col && sb_len > 0){
                sb.delete(sb_len - 1, sb_len);
            }
        }
    }

    public static void main(String[] args) {
        String digits1 = "239";
        String digits2 = "29";

        String digits = digits1;
        List<String> list = letterCombinations(digits);
        for (String str: list) {
            System.out.printf("%s, ", str);
        }
        System.out.println();
        List<String> list1 = letterCombinations_recursive(digits);
        for (String str: list1) {
            System.out.printf("%s, ", str);
        }
        System.out.println();
    }
}
