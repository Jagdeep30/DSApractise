class Solution {
    public List<String> letterCombinations(String digits) {
        Map<Character,String> mp = new HashMap<>();
        List<String> ans = new ArrayList<>();
        if(digits.isEmpty())return ans;
        mp.put('2',"abc");
        mp.put('3',"def");
        mp.put('4',"ghi");
        mp.put('5',"jkl");
        mp.put('6',"mno");
        mp.put('7',"pqrs");
        mp.put('8',"tuv");
        mp.put('9',"wxyz");

        solve(0,digits,mp,ans,"");
        return ans;
    }

    static void solve(int i, String d, Map<Character,String> mp, List<String> ans, String out){
        if(i>=d.length()){
            ans.add(new String(out));
            return;
        }

        char[] temp = mp.get(d.charAt(i)).toCharArray();
        for(int j=0;j<temp.length;j++){
            solve(i+1,d,mp,ans,out+temp[j]);
        }

        return;
    }
}