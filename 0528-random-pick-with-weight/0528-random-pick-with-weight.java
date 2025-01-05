class Solution {
    int[] sums;
    int total = 0;
    public Solution(int[] w) {
        sums = new int[w.length];
        sums[0] = w[0];
        for(int i=1;i<w.length;i++){
            sums[i] = sums[i-1] + w[i];
            total+=w[i];
        }
        total+=w[0];
    }
    
    public int pickIndex() {
        Random r = new Random();
        int target = r.nextInt(total) + 1;
        int s = 0;
        int e = sums.length-1;
        while(s<e){
            int mid = s+(e-s)/2;
            if(sums[mid]>=target){
                e = mid;
            }
            else{
                s = mid + 1;
            }
        }
        return e;

    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */