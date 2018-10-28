package DP.palindromic;

class palindromic_substrings {
    public int countSubstrings(String s) {
        if (s == null || s.length() == 0) return 0;
        int n = s.length();
        int count = 0;

        for(int i=0;i<n;i++){
            int right = i,left = i;
            count = helper(s,right,left,count);
            right = i+1;
            left = i;
            count = helper(s,right,left,count);
        }
        return count;
    }

    private int helper(String s, int right, int left,int count){
        while(left>=0&&right<s.length()&&s.charAt(right)==s.charAt(left)){
            right++;
            left--;
            count++;
        }
        return count;
    }
}