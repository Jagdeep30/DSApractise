class Solution {
public:
    int subarraySum(vector<int>& nums, int k) {
        int i=0;
        int count=0;
        int sum=0;
        int j=0;
        int n=nums.size();
        while(j<n && i<n){
            sum+=nums[i];
            if(sum == k){
                count++;
                j++;
                i=j;
                sum=0;
            }
            else if(sum > k){
                j++;
                i=j;
                sum=0;
            }
            else{
                i++;
            }
        }
        return count;
    }
};