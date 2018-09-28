package Array;

class global_local_inversion {
    public boolean isIdealPermutation(int[] A) {
        int n = A.length;
        for(int i=0;i<n;i++){
            if(Math.abs(A[i]-i)>1){
                return false;
            }
        }
        return true;
    }
}