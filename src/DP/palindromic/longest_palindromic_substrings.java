package DP.palindromic;

class longest_palindromic_substrings {
    public String longestPalindrome(String s) {
        if(s==null||s.length()==0){return s;}
        StringBuffer sb=new StringBuffer();
        for(int i=0;i<s.length();i++)
        {
            sb.append("#");
            sb.append(s.charAt(i));
        }
        sb.append("#");

        s = sb.toString();
        int n = s.length();
        int[] dp = new int[n];
        int max = 0,centre = 0;
        int P =0;
        int Po =0;
        for(int i = 0;i<n;i++){
            if(i<P){
                int j = (P+Po)-i;
                if(j-dp[j]+1>Po){
                    dp[i] = dp[j];
                }
                else{
                    dp[i] = P-i;
                    int start = 2*i-P,end = P;
                    while(start>=0&&end<n&&s.charAt(start)==s.charAt(end)){
                        dp[i]++;
                        start--;
                        P=end;
                        Po=2*i-P;
                        end++;
                    }
                }
            }
            else{
                int start = i, end =i;
                while(start>=0&&end<n&&s.charAt(start)==s.charAt(end)){
                    dp[i]++;
                    start--;
                    P=end;
                    Po=2*i-P;
                    end++;
                }
            }
            if(dp[i]>=max){
                max = dp[i];
                centre = i;
            }
        }
        String out = "";
        String res = s.substring(centre-max+1,centre+max);
        for(int i=0;i<res.length();i++){
            if(res.charAt(i)!='#'){
                out += res.charAt(i);
            }
        }
        return out;
    }

}
