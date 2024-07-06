class Solution {
    public int passThePillow(int n, int time) {
        if(time<n)return time+1;

        boolean right = true;
        int q = time/(n-1);
        int rem = time%(n-1);

        if((q&1)==1)right = false;
        // System.out.println(q+"  "+rem);
        if(right){
            return rem+1;
        }
        else return n-rem;
    }
}