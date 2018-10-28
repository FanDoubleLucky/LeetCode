package DP.stock;

class Solution {
    public int best_time_BS_stock_III(int[] prices) {
        int n = prices.length;
        if(n==0){return 0;}
        int dp01=-prices[0],dp10=0,dp11=-prices[0],dp00=0;
        for(int i=0;i<n;i++){
            dp10 = Math.max(dp10,dp11+prices[i]);
            dp11 = Math.max(dp11,dp00-prices[i]);
            dp00 = Math.max(dp00,dp01+prices[i]);
            dp01 = Math.max(dp01,-prices[i]);
        }
        return dp10;
    }
}
