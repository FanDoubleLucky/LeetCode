package BinarySearch;

class pow_x_n {
    public double myPow(double x, int n) {
        double res = 0.0;
        if(x==1||n==0){
            return 1;
        }
        if(n==1){
            return x;
        }
        if(n%2==0){
            double tem = myPow(x,n/2);
            res = tem*tem;
        }
        else{
            if(n>0){
                double tem = myPow(x,(n-1)/2);
                res = tem*tem*x;
            }
            else{
                double tem = myPow(x,(n+1)/2);
                res = tem*tem*(1/x);
            }
        }
        return res;
    }
}