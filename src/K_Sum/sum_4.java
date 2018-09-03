package K_Sum;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class sum_4 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        int N = nums.length;
        for(int i = 0;i<N-3;i++){
            if(i>0&&nums[i]==nums[i-1]) {continue;}
            if(nums[i]+3*nums[N-1]<target){continue;}//too small, skip
            if(4*nums[i]>target){break;}//too big, needn't to continue
            for(int j = i+1;j<N-2;j++){
                if(j>i+1&&nums[j]==nums[j-1]) {continue;}
                if(nums[j]+2*nums[N-1]<target-nums[i]){continue;}
                if(3*nums[j]>target-nums[i]){break;}
                int com = target-nums[i]-nums[j];
                int lo = j+1, hi = N-1;
                while(lo<hi){
                    int sum = nums[lo]+nums[hi];
                    if(sum<com){
                        lo++;
                    }
                    else if(sum>com){
                        hi--;
                    }
                    else{
                        List<Integer> ele = Arrays.asList(nums[i],nums[j],nums[lo],nums[hi]);
                        res.add(ele);
                        while(lo<hi&&nums[hi-1]==nums[hi]){hi--;}
                        while(lo<hi&&nums[lo]==nums[lo+1]){lo++;}
                        hi--;
                        lo++;
                    }
                }
            }
        }
        return res;
    }
}