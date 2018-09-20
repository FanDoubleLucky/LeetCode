package Array;


class sortByParity {
    public int[] sortArrayByParitySpace(int[] A) {
        int n = A.length;
        int left = 0;
        for(int i=0;i<n;i++){
            if(A[i]%2==0){
                int temp = A[left];
                A[left++] = A[i];
                A[i] = temp;
            }
        }
        return A;
    }


    public int[] sortArrayByParityTime(int[] A) {
        int n = A.length;
        int[] res = new int[n];
        int left = 0;
        int right = n-1;
        for(int i=0;i<n;i++){
            if(A[i]%2==0){
                res[left++] = A[i];
            }
            else{
                res[right--] = A[i];
            }
        }
        return res;
    }
}