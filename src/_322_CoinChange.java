import java.util.HashMap;

public class _322_CoinChange {

    public static int[] globalcoins;
    public static HashMap<Integer, Integer> memo = new HashMap<>();
    public static int coinChange_recursive(int[] coins, int amount) {
        globalcoins = coins;
        return helper(amount, 0);
    }

    public static int helper(int amount, int coincount){
        if (amount == 0){
            return coincount;
        }else if (amount < 0){
            return -1;
        }else{
            Integer cur = memo.get(amount);
            if (cur != null && cur <= coincount){
                return cur;
            }
            int res = -1;
            for (int j = 0; j < globalcoins.length; j++) {
                int temp = helper(amount - globalcoins[j], coincount + 1);
                if (amount >= globalcoins[j] && temp != -1){
                    if (res == -1) {
                        res = temp;
                    }else{
                        res = Math.min(res, temp);
                    }
                }
            }
            memo.put(amount, res);
            return res;
        }
    }

    public static int coinChange_dp(int[] coins, int amount) {
        if (coins == null || coins.length == 0){
            return -1;
        }
        if (amount == 0){
            return 0;
        }
        int[] res = new int[amount + 1];
        for (int i = 1; i <= amount; i++) {
            res[i] = -1;
            for (int j = 0; j < coins.length; j++) {
                if (i >= coins[j] && res[i - coins[j]] != -1){
                    if (res[i] == -1) {
                        res[i] = res[i - coins[j]] + 1;
                    }else{
                        res[i] = Math.min(res[i], res[i - coins[j]] + 1);
                    }
                }
            }
        }
        return res[amount];
    }

    public static void main(String[] args) {
        int[] coins1 = {1,2,5};
        int amount1 = 11;

        int[] coins2 = {2};
        int amount2 = 3;

        int[] coins3 = {1,2,5};
        int amount3 = 100;

        System.out.println(coinChange_recursive(coins3, amount3));
        System.out.println(coinChange_dp(coins3, amount3));
    }
}
