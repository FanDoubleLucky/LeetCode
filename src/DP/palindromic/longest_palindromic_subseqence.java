package DP.palindromic;

public class longest_palindromic_subseqence {
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            dp[i][i]=1;
            for (int j = i-1; j >= 0; j--) {
                if(s.charAt(i)==s.charAt(j)){
                    dp[i][j] = dp[i-1][j+1]+2;
                }
                else{
                    dp[i][j] = Math.max(dp[i][j+1],dp[i-1][j]);
                }
            }
        }

        return dp[n-1][0];
    }
}
