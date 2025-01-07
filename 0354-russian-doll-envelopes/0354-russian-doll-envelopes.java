class Solution {
    public int maxEnvelopes(int[][] arr) {
        Arrays.sort(arr, (a,b)->{
            return a[0]!=b[0]?a[0]-b[0]:a[1]-b[1];
        });

        int ans = 1;
        int max = arr[0][1];
        int max2 = arr[0][0];
        for(int i=1;i<arr.length;i++){
            System.out.println(i);
            System.out.println("before max1: "+max+"  max2: "+max2);
            if(arr[i][1]>max && arr[i][0]!=max2){
                max = arr[i][1];
                max2 = arr[i][0];
                ans++;
            }
            // else if(arr[i][1]<=max){
            //     max = arr[i][1];
            //     // max2 = arr[i][0];
            // }
            System.out.println("before max1: "+max+"  max2: "+max2);
        }
        return ans;
    }
}