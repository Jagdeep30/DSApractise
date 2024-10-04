class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> ans = new ArrayList<>();
        int n = nums.length;
        if(n==0)return ans;
        int i=1;
        int start = 0;
        int end = 0;
        String temp = "";
        while(i<n){
            if(nums[i]!=nums[i-1]+1){
                temp = "";
                end = i-1;
                temp+=Integer.valueOf(nums[start]);
                if(start != end){
                    temp += "->"+Integer.valueOf(nums[end]);
                }
                start = i;
                ans.add(temp);
            }
            i++;
        }
        temp = "";
        end = n-1;
        temp += Integer.valueOf(nums[start]);
        if(start != end){
            temp += "->"+Integer.valueOf(nums[end]);
        }
        ans.add(temp);
        return ans;
    }
}