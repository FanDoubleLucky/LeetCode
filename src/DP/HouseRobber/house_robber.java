package DP.HouseRobber;

class house_robber {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n==0){return 0;}
        int R = nums[0],H=0;
        int pre_R = nums[0];
        for(int i = 1;i<n;i++){
            R = H+nums[i];
            H = Math.max(H, pre_R);
            pre_R = R;
        }
        return Math.max(H, R);
    }
}
