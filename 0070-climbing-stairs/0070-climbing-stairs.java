class Solution {
    Map<Integer,Integer> mp = new HashMap<>();
    public int climbStairs(int n) {
        if(n<0)return 0;
        if(n==0)return 1;
        if(mp.getOrDefault(n,-1)!=-1)return mp.get(n);
        int ans = climbStairs(n-1)+climbStairs(n-2);
        mp.put(n,ans);
        return ans;
    }
}