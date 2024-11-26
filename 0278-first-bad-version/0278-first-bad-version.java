/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int s=1;
        int e=n;
        int mid = 0;
        int res = -1;
        while(s<=e){
            mid = s+(e-s)/2;
            boolean ans = isBadVersion(mid);
            if(ans){
                e = mid-1;
                res = mid;
            }
            else {
                s = mid+1;
            }
        }
        return res;
    }
}