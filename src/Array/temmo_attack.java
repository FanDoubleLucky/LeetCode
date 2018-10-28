package Array;

class temmo_attack {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        int res = 0;
        int n = timeSeries.length;
        if(n==0){
            return 0;
        }
        for(int i=0;i<n-1;i++){
            if(timeSeries[i]+duration>=timeSeries[i+1]){
                res+=timeSeries[i+1]-timeSeries[i];
            }
            else{
                res+=duration;
            }
        }
        res+=duration;
        return res;
    }
}
