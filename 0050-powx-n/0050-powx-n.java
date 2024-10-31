class Solution {
    public double myPow(double x, int n) {
        if(x==1)return 1.0;
        if(n==1)return x;
        if(n==-1)return 1/x;
        if(n==0)return 1.0;
        if(x==0)return 0;

        if(n%2==0){
            double res = myPow(x,n/2);
            // if(n<0){
            //     return (res*res);
            // }
            return res*res;
        }
        else{
            double res = myPow(x,n/2)*myPow(x,(n/2)<0?(n/2)-1:(n/2)+1);
            // if(n<0)return 1/res;
            return res;
        }
    }
}