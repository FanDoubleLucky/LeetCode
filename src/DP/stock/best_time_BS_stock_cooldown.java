package DP.stock;

class best_time_BS_stock_cooldown {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if(n==0||n==1){return 0;}
        int pre_sell = 0, sell =0, buy = -prices[0], pre_buy=0;
        for(int i=1;i<n;i++){
            pre_buy = buy;
            buy = Math.max(pre_sell-prices[i],pre_buy);
            pre_sell = sell;
            sell = Math.max(pre_buy+prices[i],sell);

        }

        return sell;
    }
}