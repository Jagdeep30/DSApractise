class Solution {
    public int hIndex(int[] citations) {
        int s = 0;
        int e = citations.length-1;
        int n = citations.length;
        int temp = 0;
        while(s<=e){
            int mid = s+(e-s)/2;
            if(citations[mid]>=n-mid){
                temp = n-mid;
                e = mid-1;
            }
            else s = mid + 1;
        }
        return temp;
    }
}