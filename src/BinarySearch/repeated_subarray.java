package BinarySearch;

class repeated_subarray {


    class Solution {
        public int findLength(int[] A, int[] B) {
            int Na = A.length;
            int Nb = B.length;
            int max=0;
            int[][] dp = new int[Na][Nb];
            for(int i=0;i<Na;i++){
                for(int j=0;j<Nb;j++){
                    if(i==0||j==0){
                        if(A[i]==B[j]){
                            dp[i][j] = 1;
                        }
                    }
                    else{
                        if(A[i]==B[j]){
                            dp[i][j] = dp[i-1][j-1]+1;
                            max = Math.max(max,dp[i][j]);
                        }
                    }
                }
            }
            return max;
        }
    }

    //Raw Version
    public int findLength(int[] A, int[] B) {
        int Na = A.length;
        int Nb = B.length;
        int len = 0,head=0;
        int max=0;
        int[][] dp = new int[Na][Nb];
        for(int i =0;i<Na;i++){
            for(int j =0;j<Nb;j++){
                dp[i][j] = -1;
            }
        }
        while(head<Na-1&&head+max<Na){
            for(int headB=0;headB<Nb-1&&headB+max<Nb;headB++){
                int count = 0;
                int i = head,j = headB;

                if(dp[head][headB]<0){
                    for(j=headB;j<Nb&&i<Na&&A[i]==B[j];){
                        count++;
                        i++;
                        j++;
                    }
                    dp[head][headB] = count;
                    for(int k = 1;k<count;k++){
                        dp[head+k][headB+k] = dp[head+k-1][headB+k-1]-1;
                    }
                }
                if(dp[head][headB]>max){max = dp[head][headB];}
            }
            head++;
        }
        return max;
    }
}