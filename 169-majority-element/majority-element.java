class Solution {
    public int majorityElement(int[] arr) {
        int ele=arr[0];
        int count=0;
        for(int i=0;i<arr.length;i++){
            if(count==0)ele=arr[i];
            count+=(ele==arr[i])?1:-1;
        }
        return ele;
    }
}