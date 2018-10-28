package DP;


/*
(n / x) x's,  its derivative gives us n * x^n/x-2 * (1 - ln(x)). The derivative is positive when 0 < x < e, 2 < e < 3
 */
class integer_break {
    public int integerBreak(int n) {
        if(n==2){
            return 1;
        }
        if(n==3){
            return 2;
        }
        if(n==4){
            return 4;
        }
        int pro = 1;
        while(n>4){
            n-=3;
            pro*=3;
        }
        pro*=n;
        return pro;
    }


    public int integerBreak_DP(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        for(int i = 2; i <= n; i ++) {
            for(int j = 1; j < i; j ++) {
                dp[i] = Math.max(dp[i], (Math.max(j,dp[j])) * (Math.max(i - j, dp[i - j])));
            }
        }
        return dp[n];
    }
}
