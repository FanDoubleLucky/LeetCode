package Array;

class rotate_image {
    public void rotate(int[][] matrix) {
        // 顺时针旋转
        // 首先上下翻转，然后按对称元素交换即可
        // 1 2 3       7 8 9       7 4 1
        // 4 5 6  =>   4 5 6  =>   8 5 2
        // 7 8 9       1 2 3       9 6 3
        // 反时针旋转
        // 首先左右翻转，接着按对称元素交换即可
        // 1 2 3       3 2 1       3 6 9
        // 4 5 6  =>   6 5 4  =>   2 5 8
        // 7 8 9       9 8 7       1 4 7

        if(matrix==null || matrix.length==0){
            return;
        }
        int n = matrix.length;
        for (int i=0;i<n/2;i++){
            for(int j=0;j<n;j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n-1-i][j];
                matrix[n-1-i][j] = temp;
            }
        }
        for (int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if (j>i){
                    int temp = matrix[i][j];
                    matrix[i][j] = matrix[j][i];
                    matrix[j][i] = temp;
                }
            }
        }
    }
}
