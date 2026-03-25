public class Buy_Sell_Stocks {
    public static int maxProfit(int[] prices, int fee) {
        int hold = -prices[0];
        int cash = 0;

        for (int i = 1; i < prices.length; i++) {
            int prevCash = cash;

            cash = Math.max(cash, hold + prices[i] - fee);
            hold = Math.max(hold, prevCash - prices[i]);
        }

        return cash;
    }

    public static void main(String[] args) {
        // Test Case - 1
        int[] prices = {1,3,2,8,4,9};
        System.out.println(maxProfit(prices, 2));  // Output : 8

        // Test Case - 2
        prices = new int[]{1,3,7,5,10,3};
        System.out.println(maxProfit(prices, 3));  // Output : 6
    }
}