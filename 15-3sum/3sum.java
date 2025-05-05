class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> st = new HashSet<>();
        Arrays.sort(nums);
        for(int i=0;i<nums.length;i++){
            int j=i+1;
            int k=nums.length-1;
            while(j<k){
                int sum = nums[i]+nums[j]+nums[k];
                if(sum == 0){
                    List<Integer> temp = new ArrayList<Integer>();
                    temp.add(nums[i]);
                    temp.add(nums[j]);
                    temp.add(nums[k]);
                    st.add(temp);
                }

                if(sum<0){
                    while(j<k && nums[j]==nums[j+1])j++;
                    j++;
                }
                else{
                    while(j<k && nums[k]==nums[k-1])k--;
                    k--;
                }
            }

            while(i+1<nums.length && nums[i]==nums[i+1])i++;
        }

        return new ArrayList<>(st);
    }
}