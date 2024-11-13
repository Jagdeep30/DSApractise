class Solution {
    public int[] evenOddBit(int n) {
        int e = 0;
        int o = 0;
        String s = Integer.toBinaryString(n);
        for(int i=s.length()-1;i>=0;i--){
            int ind = s.length()-i-1;
            if(ind%2==0){
                if(s.charAt(i)=='1')e++;
            }
            else {
                if(s.charAt(i)=='1')o++;
            }
        }
        return new int[]{e,o};
    }
}