class Solution {
    public boolean isPalindrome(int x) {
        // String s = Integer.toString(x);
        // int i=0;
        // int j=s.length()-1;
        // while(i<j){
        //     if(s.charAt(i)!=s.charAt(j))return false;
        //     i++;j--;
        // }
        // return true;

        // StringBuilder s = new StringBuilder(Integer.toString(x));
        // if(s.toString().equals(new StringBuilder(s).reverse().toString()))return true;
        // return false;
        int sum=0,r,temp=x;
        while(x>0){
            r=x%10;
            x=x/10;
            sum=sum*10+r;
        }
        if(temp==sum){
            return true;
        }
        else{
            return false;
        }
    }
}