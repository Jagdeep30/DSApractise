class Solution {
    public int compareVersion(String version1, String version2) {
        String[] arr1 = version1.split("\\.");
        String[] arr2 = version2.split("\\.");

        System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.toString(arr2));

        int n = arr1.length;
        int m = arr2.length;
        int i=0;
        while(i<n && i<m){
            int t1 = Integer.parseInt(arr1[i]);
            int t2 = Integer.parseInt(arr2[i]);

            if(t1<t2)return -1;
            else if(t2<t1)return 1;

            i++;
        }

        while(i<n){
            int t1 = Integer.parseInt(arr1[i]);
            if(t1!=0)return 1;
            i++;
        }
        while(i<m){
            int t2 = Integer.parseInt(arr2[i]);
            if(t2!=0)return -1;
            i++;
        }

        return 0;
    }
}