package Array;

class set_matrix_zeros {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        boolean colF = false, rowF = false;
        for(int i=0;i<m;i++){
            if(matrix[i][0]==0){
                colF = true;
                break;
            }
        }
        for(int i=0;i<n;i++){
            if(matrix[0][i]==0){
                rowF = true;
                break;
            }
        }
        /*the first row and the first column record which row and column should be zeros*/
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                if(matrix[i][j]==0){
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        /*the step must avoid to set the first row and column*/
        for(int i =1;i<m;i++){
            if(matrix[i][0]==0){
                matrix = setRow(matrix,i,n);
            }
        }

        for(int i=1;i<n;i++){
            if(matrix[0][i]==0){
                matrix = setCol(matrix,i,m);
            }
        }

        if (rowF) {
            for (int i = 0; i < n; ++i){matrix[0][i] = 0;}
        }
        if (colF) {
            for (int i = 0; i < m; ++i){matrix[i][0] = 0;}
        }
    }

    private int[][] setRow(int[][] matrix,int row,int n){
        for(int i=0;i<n;i++){
            matrix[row][i] = 0;
        }
        return matrix;
    }

    private int[][] setCol(int[][] matrix,int col,int m){
        for(int i=0;i<m;i++){
            matrix[i][col] = 0;
        }
        return matrix;
    }
}