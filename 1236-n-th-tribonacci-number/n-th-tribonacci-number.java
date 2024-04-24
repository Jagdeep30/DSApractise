class Solution {
    static int[] memo = new int[40];
    public int tribonacci(int n) {
        memo = new int[40];
        return tri(n);
    }

    static int tri(int n){
        if(n==0)return 0;
        if(n==1 || n==2)return 1;

        if(memo[n]!=0)return memo[n];

        return memo[n]=tri(n-1)+tri(n-2)+tri(n-3);
    }
}