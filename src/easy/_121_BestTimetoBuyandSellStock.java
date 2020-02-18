package easy;

public class _121_BestTimetoBuyandSellStock {
    public static int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 1){
            return 0;
        }
        int min = prices[0], maxprofit = 0, profit, currentprice;
        for (int i = 1; i < prices.length; i++) {
            currentprice = prices[i];
            if (currentprice < min)
                min = currentprice;
            else {
                profit = currentprice - min;
                if (profit > maxprofit)
                    maxprofit = profit;
            }
        }
        return maxprofit;
    }

    public static void main(String[] args) {
        int[] prices1 = {7,1,5,3,6,4};
        int[] prices2 = {7,6,4,3,1};
        int[] prices3 = {1,2};
        System.out.println(maxProfit(prices1));
    }
}
