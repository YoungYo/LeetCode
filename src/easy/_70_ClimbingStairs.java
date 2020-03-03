package easy;

public class _70_ClimbingStairs {

    public static int climbStairs(int n) {
        if (n <= 0) return 0;
        if (n == 1) return 1;
        if (n == 2) return 2;
        int res = 0, f1 = 1, f2 = 2;
        for (int i = 3; i <= n; i++){
            res = f1 + f2;
            f1 = f2;
            f2 = res;
        }
        return res;
    }

    public static int climbStairs1(int n) {
        double sqrt5=Math.sqrt(5);
        double fibn=Math.pow((1+sqrt5)/2,n+1)-Math.pow((1-sqrt5)/2,n+1);
        return (int)(fibn/sqrt5);
    }

    public static void main(String[] args) {
        System.out.println(climbStairs1(6));
        System.out.println(climbStairs(6));
    }
}
