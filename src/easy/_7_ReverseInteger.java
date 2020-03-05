package easy;

public class _7_ReverseInteger {
    public int reverse(int x) {
        if (-x == x){
            return 0;
        }
        boolean negative = false;
        if (x < 0){
            negative = true;
            x = -x;
        }
        int res = 0;
        while (x > 0){
            if (x < 10 && res > Integer.MAX_VALUE / 10){
                return 0;
            }
            res = (res * 10) + (x % 10);
            x /= 10;
        }
        return negative ? -res : res;
    }

    public static void main(String[] args) {
        _7_ReverseInteger ri = new _7_ReverseInteger();
        System.out.println(ri.reverse(1563847412));
    }
}
