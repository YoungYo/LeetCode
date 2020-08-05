package dailyCodingChallenge.aug2020;

public class PowerOfFour {
    public boolean isPowerOfFour(int num) {
        if (num == 1) {
            return true;
        }
        if (num < 4) {
            return false;
        }
        while (true) {
            if ((num & 3) != 0) {
                return false;
            }
            num >>= 2;
            if(1 < num && num < 4 ) {
                return false;
            } else if (num == 1) {
                return true;
            }
        }
    }

    public static void main(String[] args) {
        PowerOfFour powerOfFour = new PowerOfFour();
        for (int i = 0; i <= 100; i++) {
            System.out.printf("%d, %s\n", i, powerOfFour.isPowerOfFour(i));
        }
    }
}
