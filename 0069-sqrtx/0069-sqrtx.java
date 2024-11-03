class Solution {
    public int mySqrt(int x) {
        int s=1;
        int e=x;
        int store = 0;
        while(s<=e){
            int mid = s+(e-s)/2;
            int t = x/mid;
            if(t==mid)return mid;
            else if(t>mid){
                store = mid;
                s = mid+1;
            }
            else e = mid-1;
        }
        return store;
    }
}