class Solution {
    public int findMaxK(int[] nums) {
        Map<Integer,Integer> mp = new HashMap<>();
        int ans = -1;

        for(int i=0;i<nums.length;i++){
            int num = Math.abs(nums[i]);
            int val = mp.getOrDefault(num,0);
            if(val==0){
                if(nums[i]<0){
                    mp.put(num,1);
                }
                else mp.put(num,2);
            }
            else if(val==1){
                if(nums[i]>0){
                    ans = Math.max(ans,num);
                }
            }
            else{
                if(nums[i]<0){
                    ans = Math.max(ans,num);
                }
            }
        }

        // System.out.println(mp);

        return ans;
    }
}