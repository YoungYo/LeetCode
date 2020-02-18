public class _344_ReverseString {
    public static void reverseString_bitoperation(char[] s) {
        int i = 0, j, a, b, len = s.length;
        for (; i < len / 2; i++) {
            j = len - i - 1;
            if (s[i] == s[j]) continue;
            a = s[i];
            b = s[j];
            a = a ^ b;
            b = a ^ b;
            a = a ^ b;
            s[i] = (char)a;
            s[j] = (char)b;
        }
    }

    public static void reverseString_swap(char[] s) {
        int i = 0, j = s.length - 1;
        char temp;
        while (i < j) {
            if (s[i] == s[j]){
                i++;
                j--;
                continue;
            }
            temp = s[i];
            s[i++] = s[j];
            s[j--] = temp;
        }
    }

    public static void main(String[] args) {
        char[] input = new char[]{'h', 'e', 'l', 'l', 'o'};
        reverseString_bitoperation(input);
        for (char c: input) {
            System.out.print(c + ", ");
        }
        System.out.println();
        reverseString_swap(input);
        for (char c: input) {
            System.out.print(c + ", ");
        }
    }
}
