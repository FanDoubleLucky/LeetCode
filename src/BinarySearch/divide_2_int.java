package BinarySearch;

class divide_2_int {
    public int divide(int dividend, int divisor) {
        int sign = 1;
        if ((dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0)){
            sign = -1;
        }
        long a = Math.abs((long)dividend);
        long b = Math.abs((long)divisor);
        long lans = help(a,b);
        int ans;
        if (lans > Integer.MAX_VALUE){ //Handle overflow.
            ans = (sign == 1)? Integer.MAX_VALUE : Integer.MIN_VALUE;
        } else {
            ans = (int) (sign * lans);
        }
        return ans;
    }

    private long help(long a, long b){
        if(a<b){
            return 0;
        }
        else {
            long res = 1;
            long sub = b;
            while(sub+sub<a){
                sub+=sub;
                res+=res;
            }
            return (res + help(a-sub, b));
        }
    }
}
