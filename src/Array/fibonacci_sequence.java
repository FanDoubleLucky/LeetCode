package Array;

import java.util.Arrays;

class fibonacci_sequence {
    public int lenLongestFibSubseq(int[] A) {
        int n =A.length;
        int max = 0;
        for(int i=0;i<n-2;i++){
            for(int j=i+1;j<n-1;j++){
                int[] dp = new int[2];
                dp[0]=A[i];
                dp[1]=A[j];
                int len = 2;
                int k = Arrays.binarySearch(A,j+1,n,dp[0]+dp[1]);
                while(k>0){
                    dp[0] = dp[1];
                    dp[1] = A[k];
                    len++;
                    k = Arrays.binarySearch(A,k+1,n,dp[0]+dp[1]);
                }
                if(max<len&&len!=2){
                    max=len;
                }
            }
        }
        return max;
    }
}
