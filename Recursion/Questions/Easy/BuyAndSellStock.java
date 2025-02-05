/*
L.C: 121. Best Time to Buy and Sell Stock

You are given an array prices where prices[i] is the price of a given stock on the ith day.
You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.
Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.

Example 1:
Input: prices = [7,1,5,3,6,4]
Output: 5
Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.

Example 2:
Input: prices = [7,6,4,3,1]
Output: 0
Explanation: In this case, no transactions are done and the max profit = 0.
 
Constraints:

1 <= prices.length <= 105
0 <= prices[i] <= 104
 */
public class BuyAndSellStock {
    public static int  profit(int prices[],int index,int mini,int maxi){
        if(index >= prices.length){
            return maxi;
        }
        if(prices[index]<mini){
            mini = prices[index];
        }
        int totalprofit = prices[index]-mini;
        if(totalprofit > maxi){
            maxi = totalprofit;
        }
        return profit(prices, index+1, mini, maxi);

    }
    public static int maxProfit(int prices[]){
        int mini = Integer.MAX_VALUE;
        int maxi = Integer.MIN_VALUE;
        return profit(prices, 0, mini, maxi);
    }
    public static void main(String[] args) {
        int prices[] = new int[]{7,1,5,3,6,4};
        System.out.println(maxProfit(prices));
    }
}