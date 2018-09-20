package Array;

class array_nesting {
    public int arrayNesting(int[] nums) {
        int n = nums.length;
        int res = 0;
        for(int i = 0;i<n;i++){
            if(nums[i]<0){
                continue;
            }
            nums[i] = - nums[i];
            int slow = Math.abs(nums[i]);
            int fast = Math.abs(nums[i]);
            fast = Math.abs(nums[fast]);
            int len = 1;
            while(slow!=fast){
                len++;
                nums[slow] = -nums[slow];
                slow = Math.abs(nums[slow]);
                fast = Math.abs(nums[fast]);
                fast = Math.abs(nums[fast]);
            }
            if(len>res){
                res = len;
            }
        }

        return res;
    }
}
