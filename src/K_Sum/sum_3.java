package K_Sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class sum_3 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> answer = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        for(int i=0;i<nums.length;i++){
            if(i==0||(i>0&&nums[i]!=nums[i-1])){
                int lo = i+1,hi=nums.length-1;
                int target = -nums[i];
                while(lo<hi){
                    if(nums[lo]+nums[hi]<target){
                        lo++;
                    }
                    else if(nums[lo]+nums[hi]>target){
                        hi--;
                    }
                    else{
                        List<Integer> ele = Arrays.asList(nums[i],nums[lo],nums[hi]);
                        answer.add(ele);
                        while(lo<hi&&nums[lo]==nums[lo+1]){
                            lo++;
                        }
                        while(lo<hi&&nums[hi]==nums[hi-1]){
                            hi--;
                        }
                        lo++;
                        hi--;
                    }
                }
            }
        }
        return answer;
    }
}