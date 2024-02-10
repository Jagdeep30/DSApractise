class Solution {
    public boolean canPlaceFlowers(int[] arr, int n) {
        if(n==0)return true;
        if(arr.length==1){
            if(n==1 && arr[0]==0)return true;
            else return false;
        }
        if(n>arr.length)return false;
        for(int i=0;i<arr.length;i++){
            if(arr[i]==0){
                if((i==0 && (i+1<arr.length && arr[i+1]==0)) || (i==arr.length-1 && (i-1>=0 && arr[i-1]==0)) || ((i-1>=0 && arr[i-1]==0) && (i+1<arr.length && arr[i+1]==0))){
                    arr[i]=1;
                    n--;
                    if(n==0)return true;
                }
            }
        }

        return n==0;
    }
}