class Solution {
    public int[] numsSameConsecDiff(int n, int k) {
        List<Integer> ls = new ArrayList<>();
        for(int i=1;i<10;i++){
            solve(i,n-1,k,ls);
        }
        int[] ans = new int[ls.size()];
        for(int i=0;i<ans.length;i++){
            ans[i] = ls.get(i);
        }
        return ans;
    }

    static void solve(int num, int n, int k, List<Integer> ls){
        if(n==0){
            ls.add(num);
            return;
        }

        for(int i=0;i<10;i++){
            if(Math.abs(num%10 - i)==k){
                solve(num*10+i,n-1,k,ls);
            }
        }
        return;
    }
}