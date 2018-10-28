package DP.HouseRobber;

class house_robber_II {
    public int rob(int[] nums) {
        int n=nums.length;
        if(n==0){return 0;}
        if(n==1){return nums[0];}
        int res = Math.max(helper(nums,0,n-2),helper(nums,1,n-1));
        return res;
    }

    private int helper(int[] nums,int s,int e){
        int[] R = new int[e-s+2];
        int[] H = new int[e-s+2];
        R[s] = nums[s];
        H[s] = 0;
        for(int i=s+1;i<=e;i++){
            R[i] = H[i-1]+nums[i];
            H[i] = Math.max(H[i-1],R[i-1]);
        }
        return Math.max(R[e],H[e]);
    }
}
