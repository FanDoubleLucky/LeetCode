package Array.permutation;

import java.util.ArrayList;
import java.util.List;

class combinationIII {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        dfs(res, new ArrayList<Integer>(),k,n,1);
        return res;
    }

    private void dfs(List<List<Integer>> res, List<Integer> temp,int k,int n,int I){
        if(temp.size()==k&&n==0){
            res.add(new ArrayList<Integer>(temp));
            return;
        }
        else if(temp.size()==k&&n>0){
            return;
        }
        else{
            for(int i = I;i<=9;i++){
                if(n-i<0){return;}
                temp.add(i);
                dfs(res,temp,k,n-i,i+1);
                temp.remove(temp.size()-1);
            }
        }
    }
}
