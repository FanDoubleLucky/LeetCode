package Array;

class max_chunks_to_make_sorted {
    public int maxChunksToSorted(int[] arr) {
        int n = arr.length;
        int max = arr[0];
        int count = 0;
        for(int i=0;i<n;i++){
            if(max<arr[i]){
                max = arr[i];
            }
            if(max==i){
                count++;
            }
        }
        return count;
    }
}