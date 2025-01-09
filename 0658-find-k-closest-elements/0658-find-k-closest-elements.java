class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int n = arr.length;
        int s = 0;
        int e = n-1;
        int temp = -1;
        if(x<arr[0])temp = 0;
        else if(x>arr[n-1])temp = n-k;
        else {    
            while(s<e){
                int mid = s+(e-s)/2;
                if(arr[mid]<x)s = mid + 1;
                else e = mid;
            }

            temp = Math.max(0,e-(k/2));
        }

        List<Integer> ls = new ArrayList<>();
        for(int i=0;i<k;i++){
            ls.add(arr[temp++]);
        }
        return ls;

    }
}