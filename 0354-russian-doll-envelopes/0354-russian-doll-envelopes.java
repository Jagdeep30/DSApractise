class Solution {
    public int maxEnvelopes(int[][] arr) {
        Arrays.sort(arr, (a,b)->{
            return a[0]!=b[0]?a[0]-b[0]:b[1]-a[1];
        });

        int size = 0;
        int[] arr2 = new int[arr.length];
        for(int i=0;i<arr.length;i++){
            int ind = binarySearch(arr2,size,arr[i][1]);
            if(ind==size)size++;
        }
        return size;
    }
    static int binarySearch(int[] arr, int e, int ele){
        int s = 0;
        while(s<e){
            int mid = s+(e-s)/2;
            if(arr[mid]>=ele)e=mid;
            else s=mid+1;
        }
        arr[e] = ele;
        return e;
    }
}