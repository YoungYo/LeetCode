package easy;

public class _122_BestTimetoBuyandSellStockII {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]){
                maxProfit += prices[i] - prices[i - 1];
            }
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        _122_BestTimetoBuyandSellStockII btbss2 = new _122_BestTimetoBuyandSellStockII();
        int[] prices1 = {7,1,5,3,6,4};
        int[] prices2 = {1,2,3,4,5};
        int[] prices3 = {7,6,4,3,1};
        System.out.println(btbss2.maxProfit(prices3));
    }
}
