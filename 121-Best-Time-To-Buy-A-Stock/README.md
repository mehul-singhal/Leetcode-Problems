# Question 121: Best Time to Buy and Sell Stock
Problem Description
Say you have an array for which the i<sup>th</sup> element is the price of a given stock on day i.

If you were only permitted to complete at most one transaction (i.e., buy one and sell one share of the stock), design an algorithm to find the maximum profit.

Note that you cannot sell a stock before buying one.

## Example:
Input: [7,1,5,3,6,4]

Output: 5

Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5. Not 7-1 = 6, as selling price needs to be larger than buying price.

Constraints:
1 <= prices.length <= 10<sup>5</sup>
0 <= prices[i] <= 10<sup>4</sup>
