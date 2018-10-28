package DP;

/*
the basic idea is same as that of stone game. If the length is even, the first player must be winner. If not, dp can solve it.
 */
class predict_winner {
    public boolean PredictTheWinner(int[] nums) {
        int n = nums.length;
        if(n%2==0){
            return true;
        }
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) dp[i][i] = nums[i];
        for (int len = 1; len < n; len++) {
            for (int i = 0; i < n - len; i++) {
                int j = i + len;
                //Assume the last number(number[i]) left and player 2 take it,  dp[i][i]=number[i], so for player 1, dp[i][i+1] = nums[i+1]-dp[i][i]
                dp[i][j] = Math.max(nums[i] - dp[i + 1][j], nums[j] - dp[i][j - 1]);
            }
        }
        return dp[0][n-1]>=0;
    }
}