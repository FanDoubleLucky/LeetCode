package BinarySearch;

import java.util.Arrays;

class koko_bananas {
    public int minEatingSpeed(int[] piles, int H) {

        int n = piles.length;
        int lo = 1;
        Arrays.sort(piles);
        int hi = piles[n-1];
        while(lo<hi){
            int mid = lo+(hi-lo)/2;
            if(possible(piles,mid,H)){
                hi = mid;
            }
            else{
                lo = mid + 1;
            }
        }
        return lo;

    }

    private boolean possible(int [] piles, int K, int H){
        int h = 0;
        for(int i=0;i<piles.length;i++){
            h+=Math.ceil((double)piles[i]/K);
        }
        if(h<=H){
            return true;
        }
        else{
            return false;
        }
    }


}
