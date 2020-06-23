package medium;

import java.util.Arrays;

public class _91_DecodeWays {
    int[] memo;
    public int numDecodings(String s) {
        int sLen = s.length();
        memo = new int[sLen];
        Arrays.fill(memo, -1);
        int[] digits = new int[sLen];
        for (int i = 0; i < sLen; i++) {
            digits[i] = s.charAt(i) - '0';
        }
        return numDecodings(digits, 0);
    }

    private int numDecodings(int[] digits, int startIdx) {
        if (startIdx == digits.length) {
            return 1;
        }
        if (memo[startIdx] != -1) {
            return memo[startIdx];
        }
        if (digits[startIdx] == 0) {
            return 0;
        }
        int res = 0;
        if (startIdx < digits.length - 1) {
            int decimal = digits[startIdx] * 10 + digits[startIdx + 1];
            if (0 < decimal && decimal <= 26) {
                res += (numDecodings(digits, startIdx + 2));
            }
            if (decimal % 10 == 0) {
                return res;
            }
        }
        if (digits[startIdx] > 0){
            res += numDecodings(digits, startIdx + 1);
        }
        memo[startIdx] = res;
        return res;
    }

    public int numDecodingsDp(String s) {
        if (s.charAt(0) == '0')
            return 0;
        int sLen = s.length();
        int[] res = new int[sLen];
        res[0] = 1;
        for (int i = 1; i < sLen; i++) {
            int curDigit = s.charAt(i) - '0';
            int preDigit = s.charAt(i - 1) - '0';
            if (curDigit == 0) {
                if (preDigit == 1 || preDigit == 2){
                    if (i >= 2) {
                        res[i - 1] = res[i - 2];
                    }
                    res[i] = res[i - 1];
                } else {
                    return 0;
                }
            } else {
                int decimal = preDigit * 10 + curDigit;
                if (decimal < 10 || decimal > 26) {
                    res[i] = res[i - 1];
                } else {
                    if (i >= 2)
                        res[i] = res[i - 1] + res[i - 2];
                    else
                        res[i] = res[i - 1] + 1;
                }
            }
        }
        return res[sLen - 1];
    }

    public static void main(String[] args) {
        _91_DecodeWays decodeWays = new _91_DecodeWays();
        String[] digitsArr = {
                "1212",
                "1101",
                "226",
                "110",
                "12",
                "50",
                "0",
                "01",
                "101",
                "1001",
                "123456",
                "100012345",
        };
        for (String digits : digitsArr) {
            System.out.println(decodeWays.numDecodings(digits) + "\t" + decodeWays.numDecodingsDp(digits));
        }
    }
}
