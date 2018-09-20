package Array;

import java.util.ArrayList;
import java.util.List;

class find_all_duplicate {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> res = new ArrayList<Integer>();
        int n = nums.length;
        for(int i=0;i<n;i++){
            int index = Math.abs(nums[i])-1;
            if(nums[index]<0){
                res.add(Math.abs(nums[i]));
            }
            nums[index] = -nums[index];
        }
        return res;
    }
}