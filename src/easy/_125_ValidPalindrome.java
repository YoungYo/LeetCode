package easy;

import java.util.Objects;

public class _125_ValidPalindrome {
    public boolean isPalindrome(String s) {
        if (Objects.isNull(s) || s.isBlank()) {
            return true;
        }
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            while (nonAlphaNumeric(s.charAt(i)) && i < j) {
                i++;
            }
            while (nonAlphaNumeric(s.charAt(j)) && i < j) {
                j--;
            }
            if (!equals(s.charAt(i), s.charAt(j))) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    private boolean nonAlphaNumeric(char c) {
        return !Character.isDigit(c) && !Character.isAlphabetic(c);
    }

    private boolean equals(char a, char b) {
        if (a == b) {
            return true;
        } else if (Character.isAlphabetic(a) && Character.isAlphabetic(b)) {
            return Character.toLowerCase(a) == Character.toLowerCase(b);
        }
        return false;
    }

    public static void main(String[] args) {
        _125_ValidPalindrome validPalindrome = new _125_ValidPalindrome();
        String[] test = {
                "A man, a plan, a canal: Panama",
                ".,"
        };
        for (String str: test) {
            System.out.println(validPalindrome.isPalindrome(str));
        }
    }
}
