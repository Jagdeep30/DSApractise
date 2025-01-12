class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> ls = new ArrayList<>();
        int ind = binaryS(arr, x);
        int l = ind-1;
        int r = ind;
        int c = 0;

        while(l>=0 && r<arr.length && c<k){
            int d1 = Math.abs(arr[l]-x);
            int d2 = Math.abs(arr[r]-x);
            if(d1<=d2){
                ls.add(arr[l]);
                l--;
                c++;
            }
            else{
                ls.add(arr[r]);
                c++;
                r++;
            }
        }
        while(c<k && l>=0){
            ls.add(arr[l]);
            c++;l--;
        }
        while(c<k && r<arr.length){
            ls.add(arr[r]);
            c++;r++;
        }

        Collections.sort(ls);
        return ls;
    }

    static int binaryS(int[] arr, int target){
        int s = 0;
        int e = arr.length-1;
        while(s<e){
            int mid = s+(e-s)/2;
            if(arr[mid]>=target)e = mid;
            else s = mid + 1;
        }
        return e;
    }
    
}