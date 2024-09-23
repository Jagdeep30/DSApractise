class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        int sum = 0;
        int i=0;
        Arrays.sort(nums);
        // System.out.println(Arrays.toString(nums));
        while(i<nums.length-2){
            int j=i+1;
            int k=nums.length-1;
            while(j<k){
                sum = nums[i]+nums[j]+nums[k];
                if(sum==0){
                    List<Integer> o = new ArrayList<>();
                    o.add(nums[i]);
                    o.add(nums[j]);
                    o.add(nums[k]);
                    ans.add(o);
                    j++;
                    k--;
                    while(j<nums.length-1 && nums[j]==nums[j-1])j++;
                    while(k>=0 && nums[k]==nums[k+1])k--;
                }
                else if(sum<0){
                    j++;
                    while(j<nums.length-1 && nums[j]==nums[j-1])j++;
                }
                else{
                    k--;
                    while(k>=0 && nums[k]==nums[k+1])k--;
                }
            // System.out.println(j);
            }
            i++;
            while(i<nums.length-2 && nums[i]==nums[i-1])i++;
        }
        return ans;
    }
}