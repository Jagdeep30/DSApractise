class Solution {
public:
    double findMedianSortedArrays(vector<int>& nums1, vector<int>& nums2) {
        int m = nums1.size();
        int n = nums2.size();
        vector<int> res;
        int i=0,j=0;
        while(i<m and j<n){
            if(nums1[i]<nums2[j]){
                res.push_back(nums1[i]);
                i++;
            }
            else if(nums2[j]<nums1[i]){
                res.push_back(nums2[j]);
                j++;
            }
            else{
                res.push_back(nums1[i]);
                i++;
            }
        }
        while(i<m){
            res.push_back(nums1[i]);
            i++;
        }
        while(j<n){
            res.push_back(nums2[j]);
            j++;
        }
        int s = res.size();
        if(s%2 != 0 ){
            return res[((s+1)/2)-1];
        }
        else{
            return (res[(s/2)] + res[(s/2)-1])/2;
        }
        
        }
    
};