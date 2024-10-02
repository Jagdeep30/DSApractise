class Solution {
    public int longestConsecutive(int[] nums) {
        Map<Integer,Boolean> mp = new HashMap<>();
        int min = Integer.MAX_VALUE; 
        int max = Integer.MIN_VALUE; 
        for(int i=0;i<nums.length;i++){
            max = Math.max(max,nums[i]);
            min = Math.min(min,nums[i]);
            mp.put(nums[i],true);
        }
        // System.out.println(mp+"  "+max+"   "+min);
        int ans = Integer.MIN_VALUE;
        int len = 0;
        Map<Integer,Boolean> visited = new HashMap<>();
        for(Map.Entry<Integer,Boolean> e:mp.entrySet()){
            if(visited.getOrDefault(e.getKey(),false))continue;
            int i=e.getKey();
            len=0;
            while(i<=max){
                if(mp.getOrDefault(i,false)){
                    visited.put(i,true);
                    len++;
                }
                else{
                    ans = Math.max(ans,len);
                    len=0;
                    break;
                }
                i++;
            }
            ans = Math.max(ans,len);
        }
        ans = Math.max(ans,len);
        return ans;
    }
}