package Array;

class game_of_life {
    public void gameOfLife(int[][] board) {
        int m = board.length;
        int n = board[0].length;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                int count = count(m,n,i,j,board);
                if(board[i][j]==1){
                    if(count<2){
                        board[i][j] = 3;
                    }
                    else if(count>3){
                        board[i][j] = 3;
                    }
                }
                else{
                    if(count==3){
                        board[i][j] = 2;
                    }
                }
            }
        }

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(board[i][j]==2){
                    board[i][j]=1;
                }
                else if(board[i][j]==3){
                    board[i][j]=0;
                }
            }
        }
    }


    private int count(int m,int n,int r,int c,int[][] board){
        int count=0;
        for(int i = -1;i<=1;i++){
            for(int j=-1;j<=1;j++){
                if(r+i>=0&&r+i<m&&c+j>=0&&c+j<n&&(i!=0||j!=0)&&board[r+i][c+j]%2==1){
                    count++;
                }
            }
        }
        return count;
    }
}
