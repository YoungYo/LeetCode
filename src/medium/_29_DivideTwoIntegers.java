package medium;


public class _29_DivideTwoIntegers {
    public int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1){
            return Integer.MAX_VALUE;
        }else if (divisor == -1){
            return -dividend;
        } else if (divisor == 1){
            return dividend;
        }
        boolean positiveResult = true;
        if (dividend < 0 && divisor > 0 || dividend > 0 && divisor < 0){
            positiveResult = false;
        }
        if (dividend > 0){
            dividend = -dividend;
        }
        if (divisor > 0){
            divisor = - divisor;
        }
        int res = recursiveDivide(dividend, divisor);
        if (!positiveResult){
            res = -res;
        }
        return res;
    }

    private int recursiveDivide(int dividend, int divisor){
        if (dividend == divisor){
            return 1;
        }else if (dividend > divisor){
            return 0;
        }else if (divisor < Integer.MIN_VALUE >> 1 && dividend > Integer.MIN_VALUE){
            return 1;
        }
        int res = 0, i = 0;
        while (true){
            if (dividend > divisor << i || divisor << i > divisor) {
                i--;
                break;
            }
            res = 1 << i;
            i++;
        }
        dividend -= (divisor << i);
        if (dividend < 0){
            res += recursiveDivide(dividend, divisor);
        }
        return res;
    }

    public static void main(String[] args) {
        _29_DivideTwoIntegers divideTwoIntegers = new _29_DivideTwoIntegers();
        int[] dividends = {5, 10, 7, Integer.MIN_VALUE, Integer.MIN_VALUE, 11, Integer.MAX_VALUE, 1100540749,  4, 100, 1262439062};
        int[] divisors =  {2, 3, -3, -1,                -3,                -3, 1,                 -1090366779, 6, 99,  -629703411};

        for (int i = 0; i < dividends.length; i++) {
            int dividend = dividends[i], divisor = divisors[i];
            System.out.println("dividend = " + dividend + ", divisor = " + divisor);
            System.out.println(divideTwoIntegers.divide(dividend, divisor));
            System.out.println(dividend / divisor);
//            System.out.println(divisor * 2);
            System.out.println();
        }
//        System.out.println(Integer.MIN_VALUE / 2);
//        System.out.println(-1090366779 * 2);
    }
}
