package Array.permutation;


import java.util.ArrayList;
import java.util.List;

class permutation {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();

        dfs(nums,result,new ArrayList<Integer>());
        return result;
    }

    public void dfs(int[] nums, List<List<Integer>> result,List<Integer> tempList){
        if(tempList.size()==nums.length){
            result.add(new ArrayList<>(tempList));
        }
        else{
            int n = nums.length;
            for(int i=0;i<n;i++){
                if(tempList.contains(nums[i])){continue;}
                tempList.add(nums[i]);
                dfs(nums,result,tempList);
                tempList.remove(tempList.size()-1);
            }
        }

    }
}
