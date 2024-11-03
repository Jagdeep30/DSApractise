class Solution {
    public int[] plusOne(int[] digits) {
        int n = digits.length;
        if(digits[n-1]!=9){
            digits[n-1]+=1;
            return digits;
        }
        int[] ans = new int[n+1];
        int i=n-1;
        while(i>=0 && digits[i]==9){
            ans[i+1]=0;
            digits[i]=0;
            i--;
        }
        if(i==-1){
            ans[0] = 1;
            return ans;
        }
        if(i>=0){
            // ans[i] = digits[i]+1;
            digits[i]+=1;
            i--;
        }
        // while(i>=0){
        //     ans[i] = digits[i]
        // }
        return digits;
    }
}