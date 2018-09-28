package Array;

import java.util.HashMap;
import java.util.Map;

class toeplitz_matrix {
    public boolean isToeplitzMatrix(int[][] matrix) {
        Map<Integer, Integer> groups = new HashMap();
        int m = matrix.length;
        int n = matrix[0].length;
        for(int i=0;i<m;i++){
            for(int j =0;j<n;j++){
                if(!groups.containsKey(i-j)){
                    groups.put(i-j,matrix[i][j]);
                }
                else if(groups.get(i-j)!=matrix[i][j]){
                    return false;
                }
            }
        }
        return true;
    }
}