package practice;
import java.util.HashMap;
import java.util.Map;

public class InterviewTry {
    public static void main(String[] args) {
        int[] prices = {100, 180, 260, 310, 40, 535, 695};
        Map<String, Integer> result = findBuySellDays(prices);
        
        System.out.println("Buy on day " + result.get("BuyDay") + " at price $" + prices[result.get("BuyDay")]);
        System.out.println("Sell on day " + result.get("SellDay") + " at price $" + prices[result.get("SellDay")]);
    }
    
    public static Map<String, Integer> findBuySellDays(int[] prices) {
        int buyDay = 0; // Initialize buyDay with the first day
        int sellDay = 0; // Initialize sellDay with the first day
        int maxProfit = 0; // Initialize maxProfit

        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < prices[buyDay]) {
                buyDay = i; // Update buyDay if current price is lower
            } else if (prices[i] - prices[buyDay] > maxProfit) {
                sellDay = i; // Update sellDay if selling at this day gives more profit
                maxProfit = prices[i] - prices[buyDay]; // Update maxProfit
            }
        }
        
        Map<String, Integer> result = new HashMap<>();
        result.put("BuyDay", buyDay);
        result.put("SellDay", sellDay);
        return result;
    }
}
