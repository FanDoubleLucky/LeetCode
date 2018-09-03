package K_Sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class sum_k {
    int len = 0;

    public List<List<Integer>> fourSum(int[] nums, int target){
        len = nums.length;
        Arrays.sort(nums);
        return KSum(nums,target,4,0);
    }

    public List<List<Integer>> KSum(int[] nums, int target, int k, int index){
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(index>=len){
            return res;
        }
        if(k>2){
            for(int i = index;i<len-k+1;i++){
                if(i>index&&nums[i]==nums[i-1]){continue;}
                List<List<Integer>> temp = KSum(nums, target-nums[i], k-1, i+1);
                for(List<Integer> t : temp){
                    t.add(0,nums[i]);
                }
                res.addAll(temp);
            }

        }
        else if(k==2){
            int lo = index, hi = len-1;
            while(lo<hi){
                int sum = nums[lo]+nums[hi];
                if(sum<target){
                    lo++;
                }
                else if(sum>target){
                    //there is no tuple added into result in this case, so while(...) lo--/hi++ is not necessary
                    hi--;
                }
                else{
                    List<Integer> temp = new ArrayList<>();
                    temp.add(nums[lo]);
                    temp.add(nums[hi]);
                    res.add(temp);
                    //skip duplication, avoid adding duplicate tuple into result
                    while(lo<hi && nums[lo]==nums[lo+1]) lo++;
                    while(lo<hi && nums[hi-1]==nums[hi]) hi--;
                    lo++;
                    hi--;
                }
            }
        }
        return res;
    }
}
