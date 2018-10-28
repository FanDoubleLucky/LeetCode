package DP;

class count_numbers_unique_digits {
    public int countNumbersWithUniqueDigits(int n) {
        if(n==0){return 1;}
        if(n==1){return 10;}
        int total=9;
        int base = 9;
        int i=1;
        while(n>i){
            base*=10-i;
            total+=base;
            i++;
        }
        return total+1;
    }
}