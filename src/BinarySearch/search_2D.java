package BinarySearch;

class search_2D {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        if(m == 0){
            return false;
        }
        int n = matrix[0].length;
        int lo = 0, hi = m*n-1;
        while(lo<=hi){
            int mid = lo+(hi-lo)/2;
            if(matrix[mid/n][mid%n]==target){
                return true;
            }
            else if(matrix[mid/n][mid%n]>target){
                hi = mid -1;
            }
            else{
                lo = mid+1;
            }
        }
        return false;
    }
}