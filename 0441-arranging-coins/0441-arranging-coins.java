class Solution {
    public int arrangeCoins(int n) {
        long s = 0;
        long e = n;
        long ans = 0;
        while(s<=e){
            long mid = s+(e-s)/2;
            long val = mid*(mid+1)/2;
            if(val<=n){
                ans = mid;
                s = mid+1;
            }
            else e = mid - 1;
        }
        return (int)ans;
    }
}