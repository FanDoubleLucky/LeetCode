package BinarySearch;

import java.util.Arrays;

class longest_increasing_subsequence {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        int len = 0;
        for(int i=0;i<n;i++){
            int loc = Arrays.binarySearch(dp,0,len,nums[i]);
            if(loc <0){
                loc = -(loc+1);
            }
            dp[loc] = nums[i];
            if(loc == len){
                len++;
            }
        }
        return len;
    }
}