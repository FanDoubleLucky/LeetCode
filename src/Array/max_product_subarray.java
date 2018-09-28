package Array;

class max_product_subarray {
    public int maxProduct(int[] nums) {
        int n =nums.length;
        int maxherepre=nums[0],minherepre=nums[0];
        int max = nums[0];
        int maxhere,minhere;
        for(int i=1;i<n;i++){
            maxhere =Math.max(Math.max(maxherepre*nums[i],minherepre*nums[i]),nums[i]);
            minhere =Math.min(Math.min(maxherepre*nums[i],minherepre*nums[i]),nums[i]);
            max = Math.max(max,maxhere);
            maxherepre = maxhere;
            minherepre = minhere;
        }
        return max;
    }
}
