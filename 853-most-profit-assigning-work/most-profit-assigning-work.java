class Solution {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        int[][] arr = new int[difficulty.length][2];
        int k = 0;
        for(int i=0;i<difficulty.length;i++){
            int[] temp = new int[2];
            temp[0] = difficulty[i];
            temp[1] = profit[i];
            arr[k++] = temp;
        }

        Arrays.sort(arr,(a,b) -> {
            return Integer.compare(a[0],b[0]);
        });

        // for(int i=0;i<arr.length;i++){
        //     System.out.println(Arrays.toString(arr[i]));
        // }

        int ans = 0;
        for(int i=0;i<worker.length;i++){
            int prof = binarySearch(worker[i],arr);
            
            if(prof>=0){
                int max = Integer.MIN_VALUE;
                for(int j=0;j<=prof;j++){
                    max = Math.max(max,arr[j][1]);
                }
                // System.out.println(prof+ " " +max);
                ans+=max;
            }
        }

        return ans;
    }

    static int binarySearch(int diff, int[][] arr){
        int mid = 0;
        int s = 0;
        int e = arr.length-1;
        int potAns = -1;

        while(s<=e){
            mid = s+(e-s)/2;

            if(arr[mid][0]==diff){
                potAns = mid;
                s = mid+1;
                // break;
            }
            else if(arr[mid][0]<diff){
                potAns = mid;
                s = mid+1;
            }
            else{
                e = mid-1;
            }
        }

        return potAns;
    }
}