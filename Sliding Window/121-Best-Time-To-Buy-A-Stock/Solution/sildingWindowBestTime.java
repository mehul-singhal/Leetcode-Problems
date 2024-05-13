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

    public static void main(String[] args) {
        // 7,1,5,3,6,4
        sildingWindowBestTime s = new sildingWindowBestTime();
        int[] prices = {7,1,5,3,6,4};
        System.out.println(s.maxProfit(prices));
    }
}
