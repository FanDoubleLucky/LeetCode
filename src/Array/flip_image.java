package Array;

class flip_image {
    public int[][] flipAndInvertImage(int[][] A) {
        int m = A.length;
        if(m==0){
            return null;
        }
        int n = A[0].length;
        if(n==0){
            return null;
        }
        for(int i = 0;i<m;i++){
            int left = 0,right = n-1;
            for(int j=0;j<n;j++){
                A[i][j] = (A[i][j]+1)%2;
            }
            while(left<right){
                int temp = A[i][left];
                A[i][left++] = A[i][right];
                A[i][right--] = temp;
            }
        }
        return A;
    }
}
