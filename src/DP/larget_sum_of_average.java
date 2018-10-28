package DP;



/*
The solution idea is similar with Largest Increasing Sequence
dp[k][i] = Math.max(dp[k - 1][i], dp[k - 1][j] + (sum[j + 1, i] / (i - j));
(k > = 1, sum[j + 1, i] is the sum from A[j+1] to A[i])
the basic idea is dp[k][i] = dp[k-1][x] + average(x+1,x+2,...i); maybe dp[k][i] = dp[k-1][i], eg: dp[4][1] = dp[3][1] = dp[2][1]...
 */
class largest_sum_of_average {
    public double largestSumOfAverages(int[] A, int K) {
        int n = A.length;
        double[][] dp = new double[K][n];
        int[] sum = new int[n];
        sum[0] = A[0];
        for(int i = 1;i<n;i++){
            sum[i] = sum[i-1]+A[i];
        }
        for(int i = 0;i<K;i++){
            dp[i][0] = A[0];
        }
        for(int i = 0;i<n;i++){
            dp[0][i] = sum[i]/(double)(i+1);
        }
        for(int k = 1;k<K;k++){
            for(int i = 1;i<n;i++){
                double max = dp[k-1][i];
                for(int j = 0;j<i;j++){
                    max = Math.max(max, dp[k-1][j]+(sum[i]-sum[j])/(double)(i-j));
                }
                dp[k][i] = max;
            }
        }
        return dp[K-1][n-1];
    }
}
