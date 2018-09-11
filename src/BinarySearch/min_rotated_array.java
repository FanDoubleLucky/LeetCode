package BinarySearch;
class min_rotated_array {
    public int findMin(int[] nums) {
        int lo = 0;
        int hi = nums.length-1;
        if(nums[lo]<=nums[hi]){
            return nums[lo];
        }
        while(lo<hi){
            int mid = lo+(hi-lo)/2;
            if(nums[mid]>nums[mid+1]){
                return nums[mid+1];
            }
            if(nums[mid]>nums[lo]){
                lo = mid+1;
            }
            else if(nums[mid]<nums[lo]){
                hi = mid;
            }
        }
        return nums[lo];
    }
}
