/*
121. Best Time to Buy and Sell Stock
Easy

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

public int maxProfit(int[] prices) {
    int min=prices[0]; //the minimum price seen so far
    int pr=0; //the maximum profit seen so far
    for(int i=1;i<prices.length;i++){ //iterate through the array
        if(prices[i]<min){ //if the current price is less than the minimum price seen so far, then update the minimum price and reset the maximum profit
            min=prices[i];
        }
        else{ //otherwise, update the maximum profit
            pr=Math.max(pr,prices[i]-min);
        }
    }
    return pr;
}
void main() {
    //Example 1:
    int[] ex1Nums = {7,1,5,3,6,4};
    System.out.println(Arrays.toString(ex1Nums));
    int ex1Expected = 5;
    int ex1Actual = maxProfit(ex1Nums);
    System.out.println(ex1Actual);
    assert ex1Actual == ex1Expected;

    //Example 2:
    int[] ex2Nums = {7,6,4,3,1};
    int ex2Expected = 0;
    int ex2Actual = maxProfit(ex2Nums);
    assert ex2Actual == ex2Expected;
}