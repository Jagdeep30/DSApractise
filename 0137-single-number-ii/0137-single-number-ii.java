class Solution {
    public int singleNumber(int[] nums) {
        String[] ls = new String[nums.length];
        for(int i=0;i<nums.length;i++){
            ls[i] = Integer.toBinaryString(nums[i]);
        }

        String ans = "";
        for(int i=0;i<32;i++){
            int c = 0;
            for(int j=0;j<ls.length;j++){
                int ind = ls[j].length()-i-1;
                if(ind>=0 && ls[j].charAt(ind)=='1'){
                    c++;
                }
            }
            if(c%3!=0)ans = "1"+ans;
            else ans = "0" + ans;
        }
        return Integer.parseInt(ans,2);
    }
}