public class sildingWindowBestTime {
    public int maxProfit(int[] prices) {
        int maxP = 0;
        int buy = 0; 
        int sell = 0;
        while (sell<prices.length){
            maxP = Math.max(maxP, prices[sell]-prices[buy]);
            if(prices[sell]<prices[buy]){
                buy = sell;
            }
            sell++;
        }
        return maxP;
    }

    //Problem you can confuse yourself with - So the idea here is not to find the days of buy and sell and then find the max profit
    //Better way to tackle this problem will be that you keep finding the buy day and the max profit on each day after it. 
    //The maxP will hold the maxP till now without considering when you bought or sold.

    public static void main(String[] args) {
        // 7,1,5,3,6,4
        sildingWindowBestTime s = new sildingWindowBestTime();
        int[] prices = {7,1,5,3,6,4};
        System.out.println(s.maxProfit(prices));
    }
}
