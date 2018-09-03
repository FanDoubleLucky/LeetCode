package K_Sum;


import java.util.Arrays;

class sum_closest_3 {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int N = nums.length;
        int closest = nums[0] + nums[1] +nums[N-1];
        for(int i = 0;i<N-2;i++){
            if(i==0||(i>0&&nums[i]!=nums[i-1])){
                int lo = i+1, hi = N-1;
                while(lo<hi){
                    int sum = nums[i]+nums[lo]+nums[hi];
                    if(Math.abs(target-sum)<Math.abs(target-closest)){
                        closest = sum;
                    }
                    if(sum>target){
                        hi--;
                    }
                    else if(sum<target){
                        lo++;
                    }
                    else{
                        return sum;
                    }

                }

            }
        }
        return closest;
    }
}
