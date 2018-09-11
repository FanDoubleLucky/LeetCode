package BinarySearch;
class peak {
    public int peakIndexInMountainArray(int[] A) {
        int N = A.length;
        int lo = 0,hi = N-1;
        while(true){
            if(hi-lo<2){return lo+(hi-lo)/2;}
            int mid = lo+(hi-lo)/2;
            if(A[mid-1]<A[mid]&&A[mid]<A[mid+1]){
                lo = mid;
            }
            else if(A[mid-1]>A[mid]&&A[mid]>A[mid+1]){
                hi = mid;
            }
            else{
                return mid;
            }
        }
    }
}