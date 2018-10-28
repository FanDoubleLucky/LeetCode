package DP;

class count_bits {
    public int[] countBits(int num) {
        int[] res = new int[num+1];
        for(int i =0;i<=num;i++){
            count(res,i);
        }
        return res;
    }

    private int count(int[] res, int i){
        if(i%2!=0){
            res[i] = res[i-1]+1;
        }
        else{
            int n1 = 0;
            int I = i;
            while(I!=0){
                I = I&(I-1);//a&a-1 can eliminate the right endpoint 1
                n1++;
            }
            res[i] = n1;
        }
        return res[i];
    }

}

class DP_Solution {
    public int[] countBits(int num) {
        int[] res = new int[num+1];
        for(int i =0;i<=num;i++){
            res[i] = res[i/2]+i%2;
        }
        return res;
    }

}