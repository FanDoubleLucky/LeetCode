package DP.stock;

class best_time_BS_stock_II {
    public int maxProfit(int[] prices) {
        int profit = 0;
        for(int i=1;i<prices.length;i++){
            if(prices[i-1]<prices[i]){
                profit+=prices[i]-prices[i-1];
            }
        }
        return profit;
    }
}