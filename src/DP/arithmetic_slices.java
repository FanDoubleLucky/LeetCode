package DP;

class arithmetic_slices {
    public int numberOfArithmeticSlices(int[] A) {
        int n = A.length;
        int[] dp = new int[n];
        int count = 0;
        for(int i =2;i<n;i++){
            if(A[i]-A[i-1]==A[i-1]-A[i-2]){
                dp[i] = dp[i-1]+1;
            }
            count+=dp[i];
        }
        return count;
    }
}