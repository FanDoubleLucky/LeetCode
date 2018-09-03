package K_Sum;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class sum_4_II {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        int count = 0;
        HashMap<Integer,Integer> ABMap = new HashMap<Integer,Integer>();
        for(int i=0;i<A.length;i++){
            for(int j=0;j<B.length;j++){
                int sum = A[i]+B[j];
                if(ABMap.containsKey(sum)){
                    ABMap.put(sum,ABMap.get(sum)+1);
                }
                else{
                    ABMap.put(sum,1);
                }
            }
        }
        for(int i = 0;i<C.length;i++){
            for(int j = 0;j<D.length;j++){
                int sum = -C[i]-D[j];
                if(ABMap.containsKey(sum)){
                    count+=ABMap.get(sum);
                }
            }
        }
        return count;
    }


    public int fourSumCountII(int[] A, int[] B, int[] C, int[] D) {
        Arrays.sort(A);
        Arrays.sort(B);
        Arrays.sort(C);
        Arrays.sort(D);
        Map<Integer,Integer> AMap = new HashMap<Integer,Integer>();
        Map<Integer,Integer> BMap = new HashMap<Integer,Integer>();
        Map<Integer,Integer> CMap = new HashMap<Integer,Integer>();
        Map<Integer,Integer> DMap = new HashMap<Integer,Integer>();
        for(int i = 0;i<D.length;i++){
            if(AMap.containsKey(A[i])){
                AMap.put(A[i],AMap.get(A[i])+1);
            }
            else{
                AMap.put(A[i],1);
            }
            if(BMap.containsKey(B[i])){
                BMap.put(B[i],BMap.get(B[i])+1);
            }
            else{
                BMap.put(B[i],1);
            }
            if(CMap.containsKey(C[i])){
                CMap.put(C[i],CMap.get(C[i])+1);
            }
            else{
                CMap.put(C[i],1);
            }
            if(DMap.containsKey(D[i])){
                DMap.put(D[i],DMap.get(D[i])+1);
            }
            else{
                DMap.put(D[i],1);
            }
        }
        int count = 0;
        for(int i = 0;i<A.length;i++){
            if(i>0&&A[i]==A[i-1]){continue;}
            if(A[i]+B[B.length-1]+C[B.length-1]+D[B.length-1]<0){continue;}
            if(A[i]+B[0]+C[0]+D[0]>0){break;}
            for(int j = 0;j<B.length;j++){
                if(j>0&&B[j]==B[j-1]){continue;}
                if(A[i]+B[j]+C[B.length-1]+D[B.length-1]<0){continue;}
                if(A[i]+B[j]+C[0]+D[0]>0){break;}
                for(int k = 0;k<C.length;k++){
                    if(k>0&&C[k]==C[k-1]){continue;}
                    if(A[i]+B[j]+C[k]+D[B.length-1]<0){continue;}
                    if(A[i]+B[j]+C[k]+D[0]>0){break;}
                    int index = binarySearch(-A[i]-B[j]-C[k],D);
                    if(index>=0){
                        count+=AMap.get(A[i])*BMap.get(B[j])*CMap.get(C[k])*DMap.get(D[index]);
                    }
                }
            }
        }
        return count;
    }

    private int binarySearch(int target, int[] nums){
        int lo=0,hi=nums.length-1;
        while(lo<=hi){
            int med = lo+(hi-lo)/2;
            if(nums[med]>target){
                hi = med-1;
            }
            else if(nums[med]<target){
                lo = med+ 1;
            }
            else{
                return med;
            }
        }
        return -1;
    }

}