class Solution {
    public int findMaxLength(int[] nums) {
        Map<Integer,Integer> mp = new HashMap<>();
        int max = 0;
        int sum = 0;
        int n = nums.length;

        for(int i=0;i<n;i++){
            sum += nums[i]==1?1:-1;

            if(sum==0){
                max = i+1;
            }
            else if(mp.containsKey(sum)){
                max = Math.max(max,i-mp.get(sum));
            }
            else{
                mp.put(sum,i);
            }
        }
        return max;
    }
}