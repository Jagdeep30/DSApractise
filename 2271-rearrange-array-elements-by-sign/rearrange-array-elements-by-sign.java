class Solution {
    public int[] rearrangeArray(int[] nums) {
        List<Integer> pos = new ArrayList<>();
        List<Integer> neg = new ArrayList<>();

        for(int i=0;i<nums.length;i++){
            if(nums[i]>=0)pos.add(nums[i]);
            else neg.add(nums[i]);
        }

        int j=0;
        int k=0;
        for(int i=0;i<nums.length;i++){
            if((i&1)==0){
                nums[i] = pos.get(j++);
            }
            else{
                nums[i] = neg.get(k++);
            }
        }

        return nums;
    }
}