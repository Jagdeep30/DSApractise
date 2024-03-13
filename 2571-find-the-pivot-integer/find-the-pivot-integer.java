class Solution {
    public int pivotInteger(int n) {
        int[] prefix = new int[n+1];
        int[] suffix = new int[n+1];

        for(int i=1;i<=n;i++){
            prefix[i] = prefix[i-1]+i;
        }

        suffix[n] = n;
        for(int i=n-1;i>0;i--){
            suffix[i] = suffix[i+1]+i;
        }

        // System.out.println(Arrays.toString(prefix));
        // System.out.println(Arrays.toString(suffix));

        for(int i=1;i<=n;i++){
            if(prefix[i]==suffix[i])return i;
        }

        return -1;
    }
}