package K_Sum;

import java.util.HashMap;
import java.util.Map;

class sum_2 {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        int[] res = new int[2];
        int N = nums.length;
        for(int i=0;i<N;i++){
            map.put(nums[i],i);
        }
        for(int i=0;i<N;i++){
            int component = target - nums[i];
            if(map.containsKey(component)&&map.get(component)!=i){
                res[0] = i;
                res[1] = map.get(component);
                return res;
            }
        }
        return res;
    }
}