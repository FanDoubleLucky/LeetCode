package DP;

import java.util.Arrays;

public class max_len_pair_chain {
}


class Solution {
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, (a, b) -> (a[0] - b[0]));
        if (pairs == null || pairs.length == 0) return 0;
        int n= pairs.length;
        int[] dp = new int[n];
        int res = 1;
        for(int i =0;i<n;i++){
            int max = 1;
            for(int j=0;j<i;j++){
                if(pairs[i][0]>pairs[j][1]){
                    max = Math.max(max, dp[j]+1);
                }
            }
            dp[i] = max;
            res =Math.max(res,dp[i]);
        }
        return res;
    }
}
