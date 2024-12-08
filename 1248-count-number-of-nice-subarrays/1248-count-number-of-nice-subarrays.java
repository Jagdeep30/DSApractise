class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        int n = nums.length;
        for(int i=0;i<n;i++){
            if((nums[i]&1)==0){
                nums[i]=0;
            }
            else{
                nums[i]=1;
            }
        }
        Map<Integer,Integer> mp = new HashMap<>();
        mp.put(0,1);
        int[] ps = new int[n+1];

        for(int i=0;i<n;i++){
            ps[i+1] = ps[i] + nums[i];
            mp.put(ps[i+1],mp.getOrDefault(ps[i+1],0)+1);
        }

        int ans = 0;
        for(int i=0;i<=n;i++){
            int req = ps[i]+k;
            ans+=mp.getOrDefault(req,0);
        }

        return ans;
    }
}