class Solution {
    public boolean isHappy(int n) {
        int slow = n;
        int fast = n;
        while(fast != 1){
            slow = next(slow);
            fast = next(next(fast));
            if(slow==fast && fast != 1)return false;
        }
        // if(slow==fast)return false;
        // else if(fast == 1)return true;
        return true;
    }

    static int next(int n){
        int s = 0;
        while(n!=0){
            s+=Math.pow(n%10,2);
            n/=10;
        }
        return s;
    }
}