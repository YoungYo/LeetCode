package medium;

import java.util.HashMap;

public class _322_CoinChange {

    public static int coinChange_recursive(int[] coins, int amount) {
        HashMap<Integer, Integer> memo = new HashMap<>();
        return helper(coins, amount, memo);
    }

    public static int helper(int[] coins, int amount, HashMap<Integer, Integer> memo){
        if (amount == 0){
            return 0;
        }else if (amount < 0){
            return -1;
        }else{
            Integer cur = memo.get(amount);
            if (cur != null){
                return cur;
            }
            int minCost = Integer.MAX_VALUE;
            for (int j = 0; j < coins.length; j++) {
                if (amount > coins[j]){
                    int res = helper(coins, amount - coins[j], memo);
                    if (res != -1) {
                        minCost = Math.min(res + 1, minCost);
                    }
                }else if (amount == coins[j]){
                    minCost = 1;
                    break;
                }
            }
            if (minCost == Integer.MAX_VALUE){
                minCost = -1;
            }
            memo.put(amount, minCost);
            return minCost;
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

    public int coinChange_backTrack(int[] coins, int amount){
        if (coins == null || coins.length == 0) {
            return -1;
        }
        return coinChange(0, coins, amount);
    }

    public int coinChange(int i, int[] coins, int amount){
        if (i <= coins.length && amount == 0){
            return 0;
        }
        if (i < coins.length && amount > 0){
            int maxVal = amount / coins[i];
            int minCost = Integer.MAX_VALUE;
            for (int j = 0; j <= maxVal; j++) {
                int res = coinChange(i + 1, coins, amount - j * coins[i]);
                if (res != -1){
                    minCost = Math.min(minCost, res + j);
                }
            }
            return minCost == Integer.MAX_VALUE ? -1 : minCost;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] coins1 = {1,2,5};
        int amount1 = 11;

        int[] coins2 = {2};
        int amount2 = 3;

        int[] coins3 = {1,2,5};
        int amount3 = 100;

        int[] coins = coins1;
        int amount = amount1;
        _322_CoinChange cc = new _322_CoinChange();
        System.out.println(coinChange_recursive(coins, amount));
        System.out.println(coinChange_dp(coins, amount));
        System.out.println(cc.coinChange_backTrack(coins, amount));
    }
}
