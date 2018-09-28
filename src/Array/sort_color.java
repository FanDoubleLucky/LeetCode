package Array;

class sort_color {
    public void sortColors(int[] nums) {
        int n = nums.length;
        int left = 0,right = n-1;
        for(int i=0;i<n;i++){
            while(nums[i]==2&&i<right){
                nums[i] = nums[right];
                nums[right] = 2;
                right--;
            }
            while(nums[i]==0&&left<i){
                nums[i] = nums[left];
                nums[left] = 0;
                left++;
            }
        }
    }
}
