package DP.stock;

class best_time_BS_stock_fee {
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        int cash =0,hold = -prices[0];
        for(int i=0;i<n;i++){
            int pre_cash = cash;
            cash = Math.max(pre_cash,hold+prices[i]-fee);
            hold = Math.max(hold,pre_cash-prices[i]);
        }
        return cash;
    }
}
