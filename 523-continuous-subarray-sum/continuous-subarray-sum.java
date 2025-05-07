class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        Map<Integer,Integer> mp = new HashMap<>();
        mp.put(0,-1);
        
        int sum = 0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            int temp = mp.getOrDefault(sum%k,100001);

            if(temp!=100001 && i-temp>1){
                return true;
            }

            if(temp==100001)mp.put(sum%k,i);
        }

        return false;
    }
}