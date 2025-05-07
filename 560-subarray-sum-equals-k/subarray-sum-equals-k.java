class Solution {
    public int subarraySum(int[] nums, int k) {
        Map<Integer,Integer> mp = new HashMap<>();
        // int[] ps = new int[nums.length];
        int sum = 0;
        // for(int i=0;i<nums.length;i++){
        //     sum+=nums[i];
        //     ps[i] = sum;
        //     mp.put(sum,i);
        // }
        mp.put(0,1);
        int ans = 0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            int temp = mp.getOrDefault(sum-k,0);
            if(temp>0){
                ans+=temp;
            }
            mp.put(sum,mp.getOrDefault(sum,0)+1);
        }

        return ans;
    }
}