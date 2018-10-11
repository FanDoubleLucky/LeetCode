package Array.permutation;

class next_permutation {
    public void nextPermutation(int[] nums) {
        if(nums == null || nums.length <= 1) return;
        int n = nums.length;
        int j=n-1;
        int i=n-2;
        for(;i>=0;i--){
            if(nums[i]<nums[i+1]){
                break;
            }
        }
        j=i+1;
        if(i>=0){
            for(int k = n-1;k>i;k--){
                if(nums[k]>nums[i]){
                    int temp = nums[k];
                    nums[k] = nums[i];
                    nums[i] = temp;
                    break;
                }
            }
        }

        reverse(nums,i+1);
    }
    private void reverse(int[] a,int i){//reverse the number after the number we have found
        int first = i;
        int last = a.length-1;
        while(first<last){
            int t = a[first];
            a[first] = a[last];
            a[last] = t;
            first ++;
            last --;
        }
    }
}