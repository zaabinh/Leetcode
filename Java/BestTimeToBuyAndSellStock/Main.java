class Solution {
    public int maxProfit(int[] prices) {
        int profit = 0;
        for(int i = 1; i < prices.length; i++) {
            int sub = prices[i] - prices[i - 1];
            profit += (sub > 0) ? sub : 0;
        }
        return profit;
    }
}

public class Main {
    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
        Solution solve = new Solution();
        System.out.print(solve.maxProfit(prices));
}
}
