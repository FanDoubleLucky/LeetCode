package BinarySearch;

class search_rotated_array {
    public int search(int[] nums,int target) {
        int lo = 0;
        int hi = nums.length-1;
        int n = nums.length;
        if(nums==null||n==0){
            return -1;
        }
        while(lo<=hi){
            int mid = lo+(hi-lo)/2;
            if(nums[mid]==target){
                return mid;
            }

            if(nums[mid]>=nums[0]){
                if(nums[mid]>target&&target>=nums[0]){
                    hi = mid-1;
                }
                else{
                    lo = mid+1;
                }
            }
            else{
                if(target>nums[mid]&&target<nums[0]){
                    lo = mid +1;
                }
                else{
                    hi = mid - 1;
                }
            }
        }
        return -1;
    }
}
