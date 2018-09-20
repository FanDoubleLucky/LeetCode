package Array;

class beautiful_arrangement_II_UNFINISHED {
    public int[] constructArray(int n, int k) {
        int[] res = new int[n];
        int c=0;
        for(int i=0;i<n-k-1;i++){
            res[c++] = i+1;
        }
        int base = res[n-k-1];
        res[n-k-1] = 1;
        for(int i =0;i<=k;i++){
            res[c++] = (i%2 == 0) ? (n-k + i/2) : (n - i/2);
        }
        return res;
    }
}