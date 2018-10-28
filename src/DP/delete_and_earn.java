package DP;

/*
the problem is similar with Rob House. But in this problem if you take one element A[i], the deleted elements (will be invalid after one taking)
are not location adjacent elements, A[i+1] and A[i-1], but are value adjacent elements, A[i]-1 and A[i]+1. Eg: [3,6,5,2] if I take 6,
as there isn't 4, the deleted number is only 5, [3,6,5,2]-->[3,2], and if the array is [2,2,3,3,3,3,4,4,4,4,4,5], if I want take all 3,
I only need 1 times not 4 times operation to take all 3, and the array will be [5]
 */
class delete_and_earn {
    public int deleteAndEarn(int[] nums) {
        int n = 10001;
        int[] nd =new int[10001];//As the deleted numbers are value adjacent, I must enumerate all numbers from 1 to 10000
        for (int num : nums){
            nd[num] += num;//the operation is similar with using a map recording the times of nums[i]
        }

        //So the problem is converted to Rob House totally.
        int pre_earn=nd[0], earn=nd[0], hold=0;
        for(int i=1;i<n;i++){
            earn = hold+nd[i];
            hold = Math.max(hold,pre_earn);
            pre_earn = earn;
        }
        return Math.max(earn,hold);
    }
}
