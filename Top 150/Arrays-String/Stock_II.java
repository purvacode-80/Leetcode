// 122. Best Time to Buy and Sell Stock II

public class Stock_II {
    public static int maxProfit(int[] prices) {
        int profit = 0;

        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i-1])
                profit += prices[i] - prices[i-1];
        }
        return profit;
    }

    public static void main(String[] args) {
        // Test Case - 1
        int[] prices1 = {7, 1, 5, 3, 6, 4};
        System.out.println("Maximum Profit: " + maxProfit(prices1)); // Output: 7

        // Test Case - 2
        int[] prices2 = {1, 2, 3, 4, 5};
        System.out.println("Maximum Profit: " + maxProfit(prices2)); // Output: 4

        // Test Case - 3    
        int[] prices3 = {7, 6, 4, 3, 1};
        System.out.println("Maximum Profit: " + maxProfit(prices3)); // Output: 0
    }
}
