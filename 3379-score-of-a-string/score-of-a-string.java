class Solution {
    public int scoreOfString(String s) {
        char[] arr = s.toCharArray();
        int ans = 0;
        for(int i=0;i<arr.length-1;i++)ans += Math.abs(arr[i] - arr[i+1]);
        return ans;
    }
}