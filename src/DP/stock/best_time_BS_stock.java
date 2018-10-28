package DP.stock;

class best_time_BS_stock {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if(n==0){return 0;}
        int min = prices[0];
        int profit = 0;
        for(int i=0;i<prices.length;i++){
            if(min<prices[i]){
                profit = Math.max(prices[i]-min,profit);
            }
            else{
                min = prices[i];
            }

        }
        return profit;
    }
}
