// 121. Best Time to Buy and Sell Stock

public class Max_Profit_Stock {
    // Kadane's Algorithm
    public static int maxProfit(int[] prices) {
        int buy = prices[0];    // Initialize buy to the first price
        int profit = 0;         // Initialize profit to 0, as we can't have negative profit

        for (int i = 1; i < prices.length; i++) {
            // If the prices of current stock is less than the buy price, update the buy price
            if (prices[i] < buy )   
                buy = prices[i];
            // If the current price is greater than the buy price
            // Calculate the profit and update it if it's greater than the current profit
            else if (prices[i] - buy > profit)
                profit = prices[i] - buy;
        }
        return profit;
    }

    public static void main(String[] args) {
        // Test Case - 1
        int[] prices1 = {7, 1, 5, 3, 6, 4};
        System.out.println("Maximum Profit: " + maxProfit(prices1)); // Output: 5

        // Test Case - 2
        int[] prices2 = {7, 6, 4, 3, 1};
        System.out.println("Maximum Profit: " + maxProfit(prices2)); // Output: 0
    }
}
