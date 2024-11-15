class Solution {
    public int maxSum(int[] nums1, int[] nums2) {
        long res = 0;
        long s1 = 0;
        long s2 = 0;
        int i=0;
        int j=0;
        int n=nums1.length;
        int m=nums2.length;
        while(i<n && j<m){
            if(nums1[i]==nums2[j]){
                res += Math.max(s1,s2) + nums1[i];
                i++;
                j++;
                s1=0;
                s2=0;
            }
            else{
                if(nums1[i]<nums2[j]){
                    s1+=nums1[i];
                    i++;
                }
                else{
                    s2+=nums2[j];
                    j++;
                }
            }
        }

        while(i<n){
            s1+=nums1[i];
            i++;
        }
        while(j<m){
            s2+=nums2[j];
            j++;
        }
        res += Math.max(s1,s2);
        return (int)(res%(1000000007));
    }
}