package hard;

public class _76_MinimumWindowSubstring {
    public String minWindow(String s, String t) {
        if (s == null || s.length() == 0){
            return "";
        }
        int[] primes = {
                2, 3, 5, 7, 11, 13, 17, 19, 23, 29,
                31, 37, 41, 43, 47, 53, 59, 61, 67,
                71, 73, 79, 83, 89, 97, 101, 103,
                107, 109, 113, 127, 131, 137, 139,
                149, 151, 157, 163, 167, 173, 179,
                181, 191, 193, 197, 199, 211, 223,
                227, 229, 233, 239
        };
        int[] tcount = new int[52];
        int[] instruct = new int[52];
        long flag = 1, product = 1;
        for (int i = 0; i < t.length(); i++) {
            int c = t.charAt(i);
            int idx = c - 'A';
            if (Character.isLowerCase(c)){
                idx = c - 'a' + 26;
            }
            flag *= primes[idx];
            tcount[idx]++;
        }
        int left = 0, right, j = 0;
        while (j < s.length()){
            int c = s.charAt(j);
            int idx = c - 'A';
            if (Character.isLowerCase(c)){
                idx = c - 'a' + 26;
            }
            if (tcount[idx] > 0) {
                instruct[idx]++;
                if (instruct[idx] <= tcount[idx]) {
                    product *= primes[idx];
                }
            }
            j++;
            if (product == flag) {
                break;
            }
        }
        if (product < flag) {
            return "";
        }
        right = j;
        for (int i = 0; i < s.length();) {
            while (i < j){
                int c = s.charAt(i);
                int idx = c - 'A';
                if (Character.isLowerCase(c)){
                    idx = c - 'a' + 26;
                }
                if (tcount[idx] > 0){
                    if (instruct[idx] > tcount[idx]){
                        instruct[idx]--;
                    }else {
                        break;
                    }
                }
                i++;
            }
            if (j - i < right - left){
                right = j;
                left = i;
            }
            if (j == s.length()){
                break;
            }
            while (j < s.length()){
                int c = s.charAt(j);
                int idx = c - 'A';
                if (Character.isLowerCase(c)){
                    idx = c - 'a' + 26;
                }
                if (tcount[idx] > 0){
                    instruct[idx]++;
                }
                if (s.charAt(j) == s.charAt(i)){
                    j++;
                    break;
                }
                j++;
            }
        }
        return s.substring(left, right);
    }

    public static void main(String[] args) {
        _76_MinimumWindowSubstring mws = new _76_MinimumWindowSubstring();
        String s1 = "ADOBECODEBANC", t1 = "ABC";
        String s2 = "ADOBECODEBANC", t2 = "A";
        String s3 = "ADOBECODEBANC", t3 = "XYZ";
        String s4 = "a", t4 = "a";
        String s = s4, t = t4;
        System.out.println(mws.minWindow(s, t));
    }
}
