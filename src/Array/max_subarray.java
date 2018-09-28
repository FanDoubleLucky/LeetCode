package Array;

class max_subarray {
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int max = nums[0];
        int sumpre = nums[0];
        for(int i =1;i<n;i++){
            if(sumpre<0){
                sumpre=nums[i];
            }
            else{
                sumpre+=nums[i];
            }
            max=Math.max(sumpre,max);
        }
        return max;
    }
}
