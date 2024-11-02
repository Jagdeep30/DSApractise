class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        if(n1>n2)return findMedianSortedArrays(nums2,nums1);

        int ele = (n1+n2+1)/2;
        int s = 0;
        int e = n1;

        while(s<=e){
            int mid = s+(e-s)/2;
            int l1 = mid-1>=0?nums1[mid-1]:Integer.MIN_VALUE;
            int l2 = ele-mid-1>=0?nums2[ele-mid-1]:Integer.MIN_VALUE;
            int r1 = mid<n1?nums1[mid]:Integer.MAX_VALUE;
            int r2 = ele-mid<n2?nums2[ele-mid]:Integer.MAX_VALUE;

            int check = eval(l1,l2,r1,r2);
            if(check==0){//case if conditions are true
                //ans
                double ans = (double)Math.max(l1,l2);
                if((n1+n2)%2==0){
                    ans += (double)Math.min(r1,r2);
                    ans/=2;
                }
                return ans;
            }
            else if(check==1){
                e = mid-1;
            }
            else{
                s = mid+1;
            }
        }
        return -1.0;
    }

    static int eval(int l1, int l2, int r1, int r2){
        if(l1>r2)return 1;
        else if(l2>r1)return 2;
        return 0;
    }
}