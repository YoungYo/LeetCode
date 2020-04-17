package hard;

import java.util.Arrays;

public class _123_BestTimetoBuyandSellStockIII {
    //时间复杂度：O(kn^2)，空间复杂度：O(kn)
    public int maxProfit1(int[] prices) {
        int dayCount = prices.length;
        int[][] state = new int[3][dayCount];
        for (int k = 1; k <= 2; k++) {
            for (int i = 1; i < dayCount; i++) {
                int minPrice = prices[0];
                for (int j = 1; j <= i; j++) {
                    minPrice = Math.min(minPrice, prices[j] - state[k - 1][j - 1]);
                    state[k][i] = Math.max(state[k][i - 1], prices[i] - minPrice);
                }
            }
        }
        return state[2][dayCount - 1];
    }

    //时间复杂度：O(kn), 空间复杂度：O(kn)
    public int maxProfit2(int[] prices) {
        int dayCount = prices.length;
        int[][] state = new int[3][dayCount];
        for (int k = 1; k <= 2; k++) {
            int minPrice = prices[0];
            for (int i = 1; i < dayCount; i++) {
                minPrice = Math.min(minPrice, prices[i] - state[k - 1][i - 1]);
                state[k][i] = Math.max(state[k][i - 1], prices[i] - minPrice);
            }
        }
        return state[2][dayCount - 1];
    }

    //时间复杂度：O(kn), 空间复杂度：O(kn+k)
    public int maxProfit3(int[] prices) {
        int dayCount = prices.length;
        int[][] state = new int[3][dayCount];
        int[] min = new int[3];
        Arrays.fill(min, prices[0]);
        for (int i = 1; i < dayCount; i++) {
            for (int k = 1; k <= 2; k++) {
                min[k] = Math.min(min[k], prices[i] - state[k - 1][i - 1]);
                state[k][i] = Math.max(state[k][i - 1], prices[i] - min[k]);
            }
        }
        return state[2][dayCount - 1];
    }

    //时间复杂度：O(kn), 空间复杂度：O(k)
    public int maxProfit4(int[] prices) {
        if (prices.length == 0){
            return 0;
        }
        int[] state = new int[3];
        int[] min = new int[3];
        Arrays.fill(min, prices[0]);
        for (int i = 1; i < prices.length; i++) {
            for (int k = 1; k <= 2; k++) {
                min[k] = Math.min(min[k], prices[i] - state[k - 1]);
                state[k] = Math.max(state[k], prices[i] - min[k]);
            }
        }
        return state[2];
    }

    //时间复杂度：O(kn), 空间复杂度：O(k)
    public int maxProfit5(int[] prices) {
        int buy1 = Integer.MAX_VALUE, buy2 = Integer.MAX_VALUE;
        int sell1 = 0, sell2 = 0;
        for (int i = 0; i < prices.length; i++) {
            buy1 = Math.min(buy1, prices[i]);
            sell1 = Math.max(sell1, prices[i] - buy1);
            buy2 = Math.min(buy2, prices[i] - sell1);
            sell2 = Math.max(sell2, prices[i] - buy2);
        }
        return sell2;
    }

    public static void main(String[] args) {
        _123_BestTimetoBuyandSellStockIII btbss3 = new _123_BestTimetoBuyandSellStockIII();
        int[] prices1 = {3,3,5,0,0,3,1,4};
        int[] prices2 = {1,2,3,4,5};
        int[] prices3 = {7,6,4,3,1};

        int[] prices = prices3;
        System.out.println(btbss3.maxProfit1(prices));
        System.out.println(btbss3.maxProfit2(prices));
        System.out.println(btbss3.maxProfit3(prices));
        System.out.println(btbss3.maxProfit4(prices));
        System.out.println(btbss3.maxProfit5(prices));
    }
}
