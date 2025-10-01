/*
122. Best Time to Buy and Sell Stock II
Medium

You are given an integer array prices where prices[i] is the price of a given stock on the ith day.

On each day, you may decide to buy and/or sell the stock. You can only hold at most one share of the stock at any time. However, you can sell and buy the stock multiple times on the same day, ensuring you never hold than one share of the stock.

Find and return the maximum profit you can achieve.



Example 1:

Input: prices = [7,1,5,3,6,4]
Output: 7
Explanation: Buy on day 2 (price = 1) and sell on day 3 (price = 5), profit = 5-1 = 4.
Then buy on day 4 (price = 3) and sell on day 5 (price = 6), profit = 6-3 = 3.
Total profit is 4 + 3 = 7.
Example 2:

Input: prices = [1,2,3,4,5]
Output: 4
Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 5-1 = 4.
Total profit is 4.
Example 3:

Input: prices = [7,6,4,3,1]
Output: 0
Explanation: There is no way to make a positive profit, so we never buy the stock to achieve the maximum profit of 0.


Constraints:

1 <= prices.length <= 3 * 104
0 <= prices[i] <= 104
 */

public int maxProfit(int[] prices) {
    //handle edge cases
    if (prices == null || prices.length < 2) {
        return 0;
    }
    //iterate through the array and calculate the total profit
    int total = 0;
    for (int i = 1; i < prices.length; i++) {
        if (prices[i] > prices[i-1]) {
            total += prices[i] - prices[i-1];
        }
    }
    return total;
}

void main() {
    //Example 1:
    int[] ex1Nums = {7,1,5,3,6,4};
    int ex1Expected = 7;
    int ex1Actual = maxProfit(ex1Nums);
    assert ex1Actual == ex1Expected;
    System.out.println( "Example 1: Expected " + ex1Expected + " Actual " + ex1Actual);

}