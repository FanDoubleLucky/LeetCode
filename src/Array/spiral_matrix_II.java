package Array;

class spiral_matrix_II {
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];

        int sR = 0, sC = 0;
        int eR = n-1, eC = n-1;
        int count = 1;
        while(sR<=eR&&sC<=eC){
            for(int i = sC;i<=eC;i++){
                matrix[sR][i] = count++;
            }
            sR++;
            for(int i = sR;i<=eR;i++){
                matrix[i][eC] = count++;
            }
            eC--;
            if(eC>=sC){
                for(int i = eC;i>=sC;i--){
                    matrix[eR][i] = count++;
                }
            }
            eR--;
            if(eR>=sR){
                for(int i = eR;i>=sR;i--){
                    matrix[i][sC] = count++;
                }
            }
            sC++;
        }
        return matrix;
    }
}