class Solution {
    public int heightChecker(int[] heights) {
        int[] arr =heights.clone();
        Arrays.sort(arr);
        int ans = 0;
        for(int i=0;i<heights.length;i++){
            if(arr[i]!=heights[i])ans++;
        }

        return ans;
    }
}