import java.math.BigDecimal;

public class _8_StringToInteger_atoi {
    public static int myAtoi(String str) {
        int i = 0, j, len = str.length();
        boolean negtive = false;
        for (; i < len; i++) {
            if (str.charAt(i) != ' ')
                break;
        }

        if (i == len || (str.charAt(i) != '+' && str.charAt(i) != '-' && (str.charAt(i) < '0' || str.charAt(i) > '9')))
            return 0;
        if (str.charAt(i) == '-' || str.charAt(i) == '+'){
            if (i + 1 == len || str.charAt(i + 1) < '0' || str.charAt(i + 1) > '9')
                return 0;
            else
               j = i + 1;
        }else
            j = i;
        while ( j < len && '0' == str.charAt(j)) {
            j++;
        }
        int k = j--;
        while ( k < len && ('0' <= str.charAt(k) && str.charAt(k) <= '9')) {
            k++;
            if (k - j == 12)
                break;
        }
        long res = Long.parseLong(str.substring(i, k));
        if (res < Integer.MIN_VALUE)
            return Integer.MIN_VALUE;
        if (res > Integer.MAX_VALUE)
            return Integer.MAX_VALUE;
        return (int)res;
    }

    public static int myAtoi2(String str) {
        int i = 0, len = str.length();
        for (; i < len; i++) {
            if (str.charAt(i) != ' ')
                break;
        }

        if (i == len)
            return 0;
        int res = 0, max = Integer.MAX_VALUE / 10, min = Integer.MIN_VALUE / 10;
        boolean negtive = false;
        if (str.charAt(i) == '+') {
            i++;
        }else if (str.charAt(i) == '-'){
            negtive = true;
            i++;
        }
        while (i < len && str.charAt(i) == '0'){
            i++;
        }
        while (i < len && Character.isDigit(str.charAt(i))){
            int currentnum = str.charAt(i) - '0'; //当前数字
            if (res == 0){
                res += currentnum;
                if (negtive)
                    res = -res;
            }else if (negtive){
                if (res < min || (res == min && currentnum > 8)) return Integer.MIN_VALUE;
                res *= 10;
                res -= currentnum;
            }else{
                if (res > max || (res == max && currentnum > 7)) return Integer.MAX_VALUE;
                res *= 10;
                res += currentnum;
            }
            i++;
        }
        return res;
    }

    public static int myAtoi3(String str) {
        int i = 0, len = str.length();
        for (; i < len; i++) {
            if (str.charAt(i) != ' ')
                break;
        }

        if (i == len)
            return 0;
        int res = 0;
        boolean negtive = false;
        if (str.charAt(i) == '+') {
            i++;
        }else if (str.charAt(i) == '-'){
            negtive = true;
            i++;
        }
        while (i < len && str.charAt(i) == '0'){
            i++;
        }
        while (i < len && Character.isDigit(str.charAt(i))){
            int currentnum = str.charAt(i) - '0'; //当前数字
            if (res > Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE / 10 && currentnum > Integer.MAX_VALUE % 10)){
                return negtive ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
            res = res * 10 + currentnum;
            i++;
        }
        return negtive ? -res : res;
    }
    public static void main(String[] args) {
        String str = "42";
//        String str = "+";
//        String str = "   -42";
//        String str = "4193 with words";
//        String str = "words and 987";
//        String str = "20000000000000000000";
//        String str = "  -0000000000012345678";
        System.out.println(myAtoi(str));
        System.out.println(myAtoi2(str));
        System.out.println(myAtoi3(str));
//        System.out.println(Long.MAX_VALUE);
//        long a = Long.parseLong("20000000000000000000");
//        System.out.println(a);
    }
}
