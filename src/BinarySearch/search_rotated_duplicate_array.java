package BinarySearch;

class search_rotated_duplicate_array {
    public boolean search(int[] nums, int target) {
        int n = nums.length;
        int lo = 0;
        int hi = n-1;
        while(lo<=hi){
            int mid = lo+(hi-lo)/2;
            if(nums[mid]==target){
                return true;
            }
            if (nums[mid] > nums[lo] || nums[mid] > nums[hi]){
                if(target>=nums[lo]&&nums[mid]>target){
                    hi = mid -1;
                }
                else{
                    lo = mid +1;
                }
            }
            else if (nums[mid] < nums[hi] || nums[mid] < nums[lo]){
                if(nums[hi]>=target&&nums[mid]<target){
                    lo = mid +1;
                }
                else{
                    hi = mid -1;
                }
            }
            else{
                hi--;
            }
        }
        return false;
    }
}