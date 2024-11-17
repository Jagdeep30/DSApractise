class Solution {
    public int calculate(String s) {
        int[] res = solve(0,s);
        return res[1];
    }

    static int[] solve( int i, String s){
        int res = 0;
        int num = 0;
        int sign = 1;
        while(i<s.length()){
            char c = s.charAt(i);
            if(c>='0' && c<='9'){
                num = (num * 10) + (c-'0');
            }
            else if(c=='('){
                int[] ans = solve(i+1,s);
                // System.out.println(Arrays.toString(ans));
                i = ans[0];
                i--;
                res += (ans[1]*sign);
            }
            else if(c==')'){
                //return the result
                res += (num*sign);
                return new int[]{i+1,res};
            }
            else if(c=='+' || c=='-'){
                res += (sign*num);
                num = 0;
                if(c=='+')sign = 1;
                else if(c=='-')sign = -1;
            }
            i++;
        }
        res += (num*sign);
        return new int[]{i+1,res};
    }
}