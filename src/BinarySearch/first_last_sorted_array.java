package BinarySearch;
class first_last_sorted_array {

    public int[] searchRange(int[] nums, int target) {
        int[] res = {-1,-1};
        int n = nums.length;
        int lo = 0;
        int hi = n;
        while(lo<hi){
            int mid = lo+(hi-lo)/2;
            if(nums[mid]>=target){
                hi = mid;
            }
            else{
                lo = mid +1;
            }
        }
        if(lo==n||nums[lo]!=target){
            return res;
        }
        res[0] = lo;
        lo = 0;
        hi = n;
        target++;
        while(lo<hi){
            int mid = lo+(hi-lo)/2;
            if(nums[mid]>=target){
                hi = mid;
            }
            else{
                lo = mid +1;
            }
        }
        res[1] = lo-1;

        return res;
    }


}
